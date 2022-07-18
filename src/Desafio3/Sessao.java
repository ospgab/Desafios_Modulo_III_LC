package Desafio3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Sessao {

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private int ID;
    Fuso fuso;
    Sessao sessaoParis;

    enum Fuso {
            SaoPaulo("America/Sao_Paulo"),
            Paris("Europe/Paris");


        Fuso(String s) {

        }
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public Sessao(LocalDateTime inicio, LocalDateTime fim, int ID) {
        this.inicio = inicio;
        this.fim = fim;
        this.ID = ID;
    }

    @Override
    public String toString() {
        Locale BRAZIL = new Locale("pt","BR");
        ZonedDateTime iniParis = ZonedDateTime.of(inicio, ZoneId.of("America/Sao_Paulo")).withZoneSameInstant(ZoneId.of("Europe/Paris"));
        ZonedDateTime fimParis = ZonedDateTime.of(fim, ZoneId.of("America/Sao_Paulo")).withZoneSameInstant(ZoneId.of("Europe/Paris"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yy");
        return "####################################\n" + "Sessao: " + ID +
                 " " +inicio.format(dtf2) +
                "\n\nInicio: " +
                inicio.getDayOfWeek().getDisplayName(TextStyle.SHORT, BRAZIL) + " " +
                inicio.format(dtf) + " (SP)\n" +

                "     \t" +
                iniParis.getDayOfWeek().getDisplayName(TextStyle.SHORT, BRAZIL) + " " +
                iniParis.format(dtf) + " (Paris)\n" +
                "\nFim: \t" +
                fim.getDayOfWeek().getDisplayName(TextStyle.SHORT, BRAZIL) + " " +
                fim.format(dtf) +" (SP)\n" +
                "     \t" +
                fimParis.getDayOfWeek().getDisplayName(TextStyle.SHORT, BRAZIL) + " " +
                fimParis.format(dtf) +" (Paris)\n" +
                "####################################\n"
                ;
    }
}

