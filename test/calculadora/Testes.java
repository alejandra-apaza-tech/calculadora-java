package calculadora;

/**
 * Testes simples, sem bibliotecas externas.
 * Se algum teste falhar, o programa termina com código 1.
 */
public class Testes {

    private static int total = 0;
    private static int falhas = 0;

    public static void main(String[] args) {
        // Notas
        igual("média 10,8,9,8", 8.75, Notas.media(10, 8, 9, 8));
        igual("média de uma nota", 6.5, Notas.media(6.5));
        texto("situação aprovado", "Aprovado(a)", Notas.situacao(7.0));
        texto("situação recuperação", "Recuperação", Notas.situacao(5.0));
        texto("situação reprovado", "Reprovado(a)", Notas.situacao(4.9));
        erro("média sem notas", () -> Notas.media());
        erro("nota acima de 10", () -> Notas.media(11));

        // Geometria
        igual("quadrado", 100, Geometria.areaQuadrado(10));
        igual("retângulo", 50, Geometria.areaRetangulo(10, 5));
        igual("círculo", 50.2655, Geometria.areaCirculo(4));
        igual("triângulo", 100, Geometria.areaTriangulo(20, 10));
        igual("losango", 25, Geometria.areaLosango(10, 5));
        igual("trapézio", 105, Geometria.areaTrapezio(20, 10, 7));
        erro("lado negativo", () -> Geometria.areaQuadrado(-1));

        // Financeiro
        igual("juros simples", 400, Financeiro.jurosSimples(1000, 5, 8));
        igual("montante simples", 1400, Financeiro.montanteSimples(1000, 5, 8));
        igual("montante composto", 1477.4554, Financeiro.montanteComposto(1000, 5, 8));
        igual("juros compostos", 477.4554, Financeiro.jurosCompostos(1000, 5, 8));
        erro("capital zero", () -> Financeiro.jurosSimples(0, 5, 8));

        System.out.println();
        System.out.println(total + " testes, " + falhas + " falha(s).");
        if (falhas > 0) {
            System.exit(1);
        }
    }

    private static void igual(String nome, double esperado, double obtido) {
        total++;
        if (Math.abs(esperado - obtido) < 0.001) {
            System.out.println("OK    " + nome);
        } else {
            falhas++;
            System.out.println("FALHA " + nome + " (esperado " + esperado + ", obtido " + obtido + ")");
        }
    }

    private static void texto(String nome, String esperado, String obtido) {
        total++;
        if (esperado.equals(obtido)) {
            System.out.println("OK    " + nome);
        } else {
            falhas++;
            System.out.println("FALHA " + nome + " (esperado " + esperado + ", obtido " + obtido + ")");
        }
    }

    private static void erro(String nome, Runnable acao) {
        total++;
        try {
            acao.run();
            falhas++;
            System.out.println("FALHA " + nome + " (deveria lançar exceção)");
        } catch (IllegalArgumentException e) {
            System.out.println("OK    " + nome);
        }
    }
}
