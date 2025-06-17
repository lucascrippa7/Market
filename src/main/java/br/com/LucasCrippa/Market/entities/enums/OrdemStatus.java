package br.com.LucasCrippa.Market.entities.enums;

public enum OrdemStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrdemStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrdemStatus valueOf(int code){
        for(OrdemStatus value : OrdemStatus.values()){
            if(value.getCode()==code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");

    }
}
