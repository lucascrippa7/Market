package br.com.LucasCrippa.Market.services;

import br.com.LucasCrippa.Market.entities.Usuario;
import br.com.LucasCrippa.Market.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }
}
