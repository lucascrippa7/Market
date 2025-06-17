package br.com.LucasCrippa.Market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant data;

    @JsonIgnore
    @OneToOne
    @MapsId
    private OrdemSe ordemSe;

    public Pagamento() {
    }

    public Pagamento(Long id, Instant data, OrdemSe ordemSe) {
        this.id = id;
        this.data = data;
        this.ordemSe = ordemSe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public OrdemSe getOrdemSe() {
        return ordemSe;
    }

    public void setOrdemSe(OrdemSe ordemSe) {
        this.ordemSe = ordemSe;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        return Objects.equals(id, other.id);
    }
}
