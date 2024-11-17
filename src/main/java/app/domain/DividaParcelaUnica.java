package app.domain;

public class DividaParcelaUnica implements Divida {

    private final Parcela parcela;

    public DividaParcelaUnica(Double valor) {
        this.parcela = setParcela(valor);
    }

    public Parcela getParcela() {
        return parcela;
    }

    @Override
    public String toString() {
        return "DividaParcelaUnica{\n" +
                "   " + parcela +
                "}";
    }

}
