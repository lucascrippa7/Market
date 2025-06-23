package br.com.LucasCrippa.Market.services;

import br.com.LucasCrippa.Market.entities.OrdemSe;
import br.com.LucasCrippa.Market.repositories.OrdemSeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemSeService {

    @Autowired
    private OrdemSeRepository repository;

    public List<OrdemSe> findAll(){
        return repository.findAll();
    }


    public OrdemSe findById(Long id){
        Optional<OrdemSe> obj = repository.findById(id);
        return  obj.get();
    }

}
