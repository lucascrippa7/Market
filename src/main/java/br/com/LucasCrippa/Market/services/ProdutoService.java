package br.com.LucasCrippa.Market.services;

import br.com.LucasCrippa.Market.entities.Produto;
import br.com.LucasCrippa.Market.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> prod = repository.findById(id);
        return prod.get();
    }

}
