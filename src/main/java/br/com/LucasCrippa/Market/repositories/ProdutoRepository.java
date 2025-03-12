package br.com.LucasCrippa.Market.repositories;

import br.com.LucasCrippa.Market.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
