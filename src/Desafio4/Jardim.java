package Desafio4;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Jardim {
    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintStream saida = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        AtomicInteger vermelhas = new AtomicInteger(0);
        AtomicInteger amarelas = new AtomicInteger(0);
        AtomicInteger azules = new AtomicInteger(0);



        Stream<Integer> vermelhos = IntStream.range(0,100)
                .map(i -> 1)
                .boxed();

        Stream<Integer> amarelos = IntStream.range(0,50)
                .map(i -> 2)
                .boxed();

        Stream<Integer> azuis = IntStream.range(0,25)
                        .map(i->3)
                        .boxed();

        List jardim = Stream
                            .concat(Stream
                            .concat(vermelhos, amarelos), azuis)
                            .filter(x -> x<3)
                            .peek(flor -> {
                                if (flor.equals(1)) vermelhas.getAndIncrement();
                                if(flor.equals(2)) amarelas.getAndIncrement();})
                            .sorted((a, b) -> (int) Math.signum(Math.random() - 0.5))
                            .collect(Collectors.toList());




        jardim.stream()
                .limit((long)((vermelhas.get()+amarelas.get())*0.75))
                .forEach(e ->{
                    if(e.equals(1)) saida.print("\uD83C\uDF39");
                    if(e.equals(2)) saida.print("\uD83C\uDF37");

                });

        System.out.println("\n Temos " + (long)((vermelhas.get()+amarelas.get())*0.75) + " flores no nosso jardim :)");

















    }
}
