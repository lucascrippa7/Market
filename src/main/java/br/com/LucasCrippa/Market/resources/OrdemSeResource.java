package br.com.LucasCrippa.Market.resources;

import br.com.LucasCrippa.Market.entities.OrdemSe;
import br.com.LucasCrippa.Market.services.OrdemSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ordens")
public class OrdemSeResource {

    @Autowired
    private OrdemSeService service;

    @GetMapping
    public ResponseEntity<List<OrdemSe>> findAll() {
       List<OrdemSe> list =service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemSe> findById (@PathVariable Long id){
        OrdemSe obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}