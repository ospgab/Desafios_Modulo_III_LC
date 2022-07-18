package Desafio3;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CriaAgenda {

    ArrayList<Sessao> agenda = new ArrayList<>();

    public ArrayList<Sessao> criaAgenda(String inicio, String fim, int frequencia, int offsetHorario){
        LocalDateTime inicioSessao = LocalDateTime.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss"));
        LocalDateTime fimSessao = LocalDateTime.parse(fim, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss"));
        int inicioAnual = inicioSessao.getDayOfYear();
        int fimAnual = fimSessao.getDayOfYear();
        int quantidadeSessoes = (fimAnual - inicioAnual)/frequencia;

        agenda.add(criaSessao(inicioSessao,inicioSessao.plusHours(6), inicioSessao.hashCode()));
        for(int contador = 1; contador <= quantidadeSessoes; contador++){
            LocalDateTime proximaData = agenda.get(contador-1).getFim().plusDays(10);
            agenda.add(new Sessao(proximaData.plusHours(2), proximaData.plusHours(8), agenda.get(contador-1).hashCode() ));
        }



        return agenda;
    }

    public Sessao criaSessao(LocalDateTime inicio, LocalDateTime fim, int ID){
        return new Sessao(inicio, fim, ID);
    }

    public void printaAgenda(){
        for(Sessao sessao : agenda){
            System.out.println(sessao.toString());
        }
    }



}
