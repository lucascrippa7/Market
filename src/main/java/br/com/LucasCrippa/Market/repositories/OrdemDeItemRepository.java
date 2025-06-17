package br.com.LucasCrippa.Market.repositories;

import br.com.LucasCrippa.Market.entities.OrdemDeItem;
import br.com.LucasCrippa.Market.entities.PK.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdemDeItemRepository extends JpaRepository<OrdemDeItem, OrderItemPK> {

}
