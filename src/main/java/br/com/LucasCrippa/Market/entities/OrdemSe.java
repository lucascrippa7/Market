package br.com.LucasCrippa.Market.entities;

import br.com.LucasCrippa.Market.entities.enums.OrdemStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class OrdemSe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private OrdemStatus ordemStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.order")
    private Set<OrdeDeItem> items = new HashSet<>();


    @OneToOne(mappedBy = "ordemSe", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public OrdemSe() {
    }

    public OrdemSe(Long id, Instant momento, OrdemStatus ordemStatus, Usuario cliente) {
        this.id = id;
        this.momento = momento;
        this.ordemStatus = ordemStatus;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public OrdemStatus getOrdemStatus() {
        return ordemStatus;
    }

    public void setOrdemStatus(OrdemStatus ordemStatus) {
        this.ordemStatus = ordemStatus;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Set<OrdeDeItem> getItems() {
        return items;
    }

    public void setItems(Set<OrdeDeItem> items) {
        this.items = items;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
