package br.com.LucasCrippa.Market.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import br.com.LucasCrippa.Market.entities.OrdemSe;
import br.com.LucasCrippa.Market.entities.Produto;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class OrderItemPK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrdemSe ordem;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	public OrdemSe getOrdem() {
		return ordem;
	}
	public void setOrdem(OrdemSe ordem) {
		this.ordem = ordem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(ordem, other.ordem) && Objects.equals(produto, other.produto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ordem, produto);
	}
}
