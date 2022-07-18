package Desafio1;

import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CalculaIdade {
    public static void main(String[] args) {

        List<Pessoa> Pessoas = List.of(
                new Pessoa("Gabriel", "01-10-94"),
                new Pessoa("Junior", "25-12-99"),
                new Pessoa("Rose", "13-05-15"),
                new Pessoa("Marilia", "02-06-03"),
                new Pessoa("Bruna", "27-08-10"),
                new Pessoa("Marcos", "19-12-02"),
                new Pessoa("Alfred", "17-01-65"),
                new Pessoa("Thiago", "12-01-73"),
                new Pessoa("Renan", "25-03-69"),
                new Pessoa("Otávio", "01-05-84"),
                new Pessoa("Jéssica", "22-03-91"),
                new Pessoa("Maria", "18-09-01"),
                new Pessoa("Cristina", "05-01-98"),
                new Pessoa("José", "19-02-79"),
                new Pessoa("Matheus", "01-02-86"),
                new Pessoa("Guilherme", "15-05-70"),
                new Pessoa("Daniel", "31-10-90"),
                new Pessoa("Leticia", "30-11-95"),
                new Pessoa("Valesca", "25-05-97"),
                new Pessoa("Teresa", "03-12-09"),
                new Pessoa("Manuela", "16-03-05"),
                new Pessoa("Andréa", "14-07-99"),
                new Pessoa("Hans", "04-06-55"),
                new Pessoa("Juan", "31-06-67"),
                new Pessoa("Elisa", "25-07-85"),
                new Pessoa("Victor", "11-09-93"),
                new Pessoa("Victor", "11-06-23")
                );


        Calculo calcular = (p) -> {

            LocalDate dataNasc = LocalDate.parse(p.getDataNascimento(), DateTimeFormatter.ofPattern("dd-MM-yy"));
            if(Math.abs(LocalDate.now().until(dataNasc).getYears()) >= 100 ){
                throw new RuntimeException("Idade acima dos 99 anos!");
            }
            return dataNasc.until(LocalDate.now()).getYears();

        };

        Pessoas.forEach(pessoa -> System.out.println(pessoa.getNome() + " tem " + Math.abs(calcular.calculaIdade(pessoa)) + " anos"));

        //System.out.println(ZoneId.getAvailableZoneIds());
    }
}

