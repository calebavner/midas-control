package app.domain;

public record NovoRegistro(
        Double valor,
        TipoDivida tipoDivida,
        int numParcelas
) {
}
