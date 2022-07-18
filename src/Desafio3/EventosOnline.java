package Desafio3;

import java.util.ArrayList;

public class EventosOnline {
    public static void main(String[] args) {
        CriaAgenda agenda = new CriaAgenda();

        ArrayList<Sessao> sessoes = new ArrayList<>();

        sessoes = agenda.criaAgenda("20/07/22 10:00:00", "31/10/22 23:59:59", 10, 2);

        agenda.printaAgenda();

    }
}
