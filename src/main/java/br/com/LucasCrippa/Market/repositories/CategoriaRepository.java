package br.com.LucasCrippa.Market.repositories;

import br.com.LucasCrippa.Market.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
