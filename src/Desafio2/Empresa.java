package Desafio2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Empresa {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = List.of(
                new Funcionario("Breno", "2022", 6500),
                new Funcionario("Lucas", "2019", 4000),
                new Funcionario("Carla", "2020", 6500),
                new Funcionario("Jéssika", "2020", 2000),
                new Funcionario("Thayane", "2019", 2000),
                new Funcionario("Fabricio", "2021", 8000)
        );

        CalculoComissao calculoComissao = (funcionario)->{
            long anosDeServico = funcionario.getEntradaEmpresa().until(LocalDate.now(), ChronoUnit.YEARS);
            Year anoEntrada = funcionario.getEntradaEmpresa();

            for(int contadorAnos = 0; contadorAnos < anosDeServico; contadorAnos++ ){
                Year anoCalculo = anoEntrada.plusYears(contadorAnos);

                for(int contadorMeses = 1; contadorMeses <= 12; contadorMeses++){
                    YearMonth mesCalculo = anoCalculo.atMonth(contadorMeses);
                    int diasTrabalhados = 0;
                    int diasFolga = 0;
                    for(int contadorDias = 1; contadorDias <= mesCalculo.lengthOfMonth(); contadorDias++){
                        LocalDate diaCalculo = mesCalculo.atDay(contadorDias);
                        if(diaCalculo.getDayOfWeek().equals(DayOfWeek.SATURDAY) || diaCalculo.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                            diasFolga++;
                        } else {
                            diasTrabalhados++;
                        }
                    }
                    double calculoDiaria = funcionario.getSalario().doubleValue() / mesCalculo.lengthOfMonth();
                    BigDecimal salarioMes = BigDecimal.valueOf(calculoDiaria*diasTrabalhados);
                    StringBuilder str = new StringBuilder();
                    str.append("-----------------------------\n");
                    str.append("Mês: ").append(mesCalculo).append("   ").append(mesCalculo.getMonth()).append("\n");
                    str.append("Dias trabalhados: ").append(diasTrabalhados).append("\n");
                    str.append("Dias de folda: ").append(diasFolga).append("\n");
                    str.append("Salário do mês: ").append(salarioMes.round(MathContext.DECIMAL32)).append("\n");
                    str.append("-----------------------------\n");

                    System.out.println(str);
                }
            }

        };

        for(Funcionario funcionario : funcionarios){
            System.out.println("##### Folha de pagamento ####");
            System.out.println("Funcionário: " + funcionario.getNome() + "\nEntrada: " + funcionario.getEntradaEmpresa());
            System.out.println("Salário: " + funcionario.getSalario().round(MathContext.DECIMAL32));
            System.out.println("#############################");
            calculoComissao.calculaComissao(funcionario);
        }
    }
}
