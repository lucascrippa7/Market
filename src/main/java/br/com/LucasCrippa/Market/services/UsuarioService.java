package br.com.LucasCrippa.Market.services;

import br.com.LucasCrippa.Market.entities.Usuario;
import br.com.LucasCrippa.Market.repositories.UsuarioRepository;
import br.com.LucasCrippa.Market.services.exceptions.DatabaseException;
import br.com.LucasCrippa.Market.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){

        return repository.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            if(repository.existsById(id)){
                repository.deleteById(id);
            }
            else {
                System.out.println("Deu ruim");
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario obj){
        try{
            Usuario entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setEmail(obj.getEmail());
        entity.setEndereco(obj.getEndereco());
        entity.setPassword(obj.getPassword());
        entity.setNome(obj.getNome());
        entity.setSobreNome(obj.getSobreNome());
    }

}
