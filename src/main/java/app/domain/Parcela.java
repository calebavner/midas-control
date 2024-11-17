package app.domain;

import java.time.LocalDate;

public class Parcela {

    private Double valor;
    private LocalDate vencimento;
    private StatusPagamento status;

    public Parcela(Double valor) {
        this.valor = valor;
        this.vencimento = LocalDate.now().plusMonths(1L);
        this.status = StatusPagamento.EM_ABERTO;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "valor=" + valor +
                ", vencimento=" + vencimento +
                ", status=" + status +
                "}\n";
    }
}
