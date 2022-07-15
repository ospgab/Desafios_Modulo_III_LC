package Desafio2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Funcionario {
    private String nome;
    private Year entradaEmpresa;
    private BigDecimal salario;
    private Integer[] bancoHoras = new Integer[12];

    public Funcionario(String nome, String data, double salario) {
        this.entradaEmpresa = Year.parse(data);
        this.nome = nome;
        this.salario = BigDecimal.valueOf(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setBancoHoras(Integer[] bancoHoras) {
        this.bancoHoras = bancoHoras;
    }

    public Integer[] getBancoHoras() {
        return bancoHoras;
    }

    public Year getEntradaEmpresa() {
        return entradaEmpresa;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
