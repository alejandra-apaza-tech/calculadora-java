package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Programa principal: menu interativo no terminal.
 */
public class Main {

    private static final String LINHA = "==================================================";

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pt", "BR"));
        boolean executando = true;

        System.out.println(LINHA);
        System.out.println("            CALCULADORA JAVA");
        System.out.println(LINHA);

        while (executando) {
            exibirMenu();
            int opcao = lerInteiro("Escolha uma opção: ");
            System.out.println();
            try {
                switch (opcao) {
                    case 1 -> calcularMedia();
                    case 2 -> calcularArea();
                    case 3 -> calcularJurosSimples();
                    case 4 -> calcularJurosCompostos();
                    case 0 -> executando = false;
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            System.out.println();
        }
        System.out.println("Até logo!");
    }

    private static void exibirMenu() {
        System.out.println("1 - Média de notas");
        System.out.println("2 - Área de figuras geométricas");
        System.out.println("3 - Juros simples");
        System.out.println("4 - Juros compostos");
        System.out.println("0 - Sair");
    }

    // ---------- Opções do menu ----------

    private static void calcularMedia() {
        String nome = lerTexto("Nome do aluno(a): ");
        int quantidade = lerInteiro("Quantas notas? ");
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de notas deve ser maior que zero.");
        }
        List<Double> notas = new ArrayList<>();
        for (int i = 1; i <= quantidade; i++) {
            notas.add(lerDecimal("Nota " + i + ": "));
        }
        double[] vetor = notas.stream().mapToDouble(Double::doubleValue).toArray();
        double media = Notas.media(vetor);

        System.out.printf("%nMédia de %s: %.2f%n", nome, media);
        System.out.println("Situação: " + Notas.situacao(media));
    }

    private static void calcularArea() {
        System.out.println("1 - Quadrado");
        System.out.println("2 - Retângulo");
        System.out.println("3 - Círculo");
        System.out.println("4 - Triângulo");
        System.out.println("5 - Losango");
        System.out.println("6 - Trapézio");
        int figura = lerInteiro("Escolha a figura: ");

        double area;
        switch (figura) {
            case 1 -> area = Geometria.areaQuadrado(lerDecimal("Lado: "));
            case 2 -> area = Geometria.areaRetangulo(lerDecimal("Base: "), lerDecimal("Altura: "));
            case 3 -> area = Geometria.areaCirculo(lerDecimal("Raio: "));
            case 4 -> area = Geometria.areaTriangulo(lerDecimal("Base: "), lerDecimal("Altura: "));
            case 5 -> area = Geometria.areaLosango(
                    lerDecimal("Diagonal maior: "), lerDecimal("Diagonal menor: "));
            case 6 -> area = Geometria.areaTrapezio(
                    lerDecimal("Base maior: "), lerDecimal("Base menor: "), lerDecimal("Altura: "));
            default -> {
                System.out.println("Figura inválida.");
                return;
            }
        }
        System.out.printf("%nÁrea = %.2f%n", area);
    }

    private static void calcularJurosSimples() {
        double capital = lerDecimal("Capital (R$): ");
        double taxa = lerDecimal("Taxa por período (%): ");
        double periodos = lerDecimal("Número de períodos: ");

        System.out.printf("%nJuros: R$ %.2f%n", Financeiro.jurosSimples(capital, taxa, periodos));
        System.out.printf("Montante: R$ %.2f%n", Financeiro.montanteSimples(capital, taxa, periodos));
    }

    private static void calcularJurosCompostos() {
        double capital = lerDecimal("Capital (R$): ");
        double taxa = lerDecimal("Taxa por período (%): ");
        double periodos = lerDecimal("Número de períodos: ");

        System.out.printf("%nJuros: R$ %.2f%n", Financeiro.jurosCompostos(capital, taxa, periodos));
        System.out.printf("Montante: R$ %.2f%n", Financeiro.montanteComposto(capital, taxa, periodos));
    }

    // ---------- Leitura segura de dados ----------

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine().trim();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDecimal(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido (ex.: 8,5).");
            }
        }
    }
}
