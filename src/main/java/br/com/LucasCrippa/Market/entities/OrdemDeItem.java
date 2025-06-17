package br.com.LucasCrippa.Market.entities;


import br.com.LucasCrippa.Market.entities.PK.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_ordem_item")

public class OrdemDeItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantidade;
    private Double preco;

    public Double getSubTotal(){
        return preco * quantidade;
    }

    public OrdemDeItem(){
    }

    public OrdemDeItem(OrdemSe ordem, Produto produto, Integer quantidade, Double preco){
        super();
        id.setOrdem(ordem);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public OrdemSe getOrdem() {
        return id.getOrdem();
    }

    public void setOrdem(OrdemSe ordem){
        id.setOrdem(ordem);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public Integer getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrdemDeItem other = (OrdemDeItem) obj;
        return Objects.equals(id, other.id);
    }

}
