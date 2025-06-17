package br.com.LucasCrippa.Market.entities;

import br.com.LucasCrippa.Market.entities.enums.OrdemStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_ordem")
public class OrdemSe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer ordemStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.ordemSe")
    private Set<OrdemDeItem> items = new HashSet<>();


    @OneToOne(mappedBy = "ordemSe", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public OrdemSe() {
    }

    public OrdemSe(Long id, Instant momento, OrdemStatus ordemStatus, Usuario cliente) {
        this.id = id;
        this.momento = momento;
        setOrdemStatus(ordemStatus);
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
        return OrdemStatus.valueOf(ordemStatus);
    }

    public void setOrdemStatus(OrdemStatus ordemStatus) {
        if(ordemStatus !=null){
            this.ordemStatus = ordemStatus.getCode();
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }


    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<OrdemDeItem> getItems() {
        return items;
    }

   public Double getTotal(){
        double sum = 0.0;
        for(OrdemDeItem x : items){
            sum += x.getSubTotal();
        }
        return sum;
   }

   @Override
    public int hashCode(){
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
        OrdemSe other = (OrdemSe) obj;
        return Objects.equals(id, other.id);
    }


}
