package br.com.LucasCrippa.Market.entities.enums;

public enum TipoProduto {

    PERFUME(1),
    PRODUTOSCAPILARES(2),
    HIDRATANTES(3);

    private int codigo;

    TipoProduto(int codigo) {
        this.codigo = codigo;
    }

}
