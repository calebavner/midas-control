package app.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DividaParcelada implements Divida {

    List<Parcela> parcelas;

    public DividaParcelada(Double valor, int numParcelas) {
        this.parcelas = gerarLista(valor, numParcelas);
    }

    public List<Parcela> gerarLista(Double valor, int numParcelas) {

        List<Parcela> parcelas = new ArrayList<>();
        Double valorParcela = valor / numParcelas;

        for(long i = 0; i < numParcelas; i++) {
            Parcela p = setParcela(valorParcela);

            p.setVencimento(p.getVencimento()
                    .plusMonths(i)
                    .minusDays(LocalDate.now()
                            .getDayOfMonth() - 1));

            parcelas.add(p);
        }

        return parcelas;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("DividaParcelada{\n");
        parcelas.forEach(x -> s.append("    " + x));
        s.append("}");

        return s.toString();
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }
}
