package br.com.LucasCrippa.Market.entities;

import br.com.LucasCrippa.Market.entities.enums.TipoProduto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "produto_market")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private Integer tipo;
    private Double preco;


    @ManyToMany
    @JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<OrdemDeItem> items = new HashSet<>();

    public Produto() {
    }

    public Produto(Long id, String produto, TipoProduto tipo, Double preco) {
        this.id = id;
        this.produto = produto;
        setTipo(tipo);
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = (tipo != null) ? tipo.getCodigo() : null;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
