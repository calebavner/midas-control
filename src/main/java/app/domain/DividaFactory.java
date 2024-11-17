package app.domain;

public class DividaFactory {

    public static Divida gerarDivida(NovoRegistro novoRegistro) {

        return switch (novoRegistro.tipoDivida()) {
            case TipoDivida.PARCELA_UNICA -> new DividaParcelaUnica(novoRegistro.valor());
            case TipoDivida.PARCELADA -> new DividaParcelada(novoRegistro.valor(), novoRegistro.numParcelas());
        };
    }
}
