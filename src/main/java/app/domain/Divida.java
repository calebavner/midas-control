package app.domain;

public interface Divida {

    default Parcela setParcela(Double valor) {
        return new Parcela(valor);
    };
}
