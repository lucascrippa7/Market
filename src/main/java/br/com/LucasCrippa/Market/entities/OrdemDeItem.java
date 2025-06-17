package br.com.LucasCrippa.Market.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_ordem_item")

public class OrdeDeItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();

}
