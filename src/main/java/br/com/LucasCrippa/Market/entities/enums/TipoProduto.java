package br.com.LucasCrippa.Market.entities.enums;

public enum TipoProduto {
    PERFUME(1),
    PRODUTOSCAPILARES(2),
    HIDRATANTES(3);

    private int codigo;

    TipoProduto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoProduto valueOf(int codigo) {
        for (TipoProduto tipo : TipoProduto.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
