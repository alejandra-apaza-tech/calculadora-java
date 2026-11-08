package calculadora;

/**
 * Cálculos relacionados a notas de alunos.
 */
public final class Notas {

    /** Média mínima para ser aprovado. */
    public static final double MEDIA_APROVACAO = 7.0;

    /** Média mínima para ficar de recuperação. */
    public static final double MEDIA_RECUPERACAO = 5.0;

    private Notas() {
        // Classe utilitária: não deve ser instanciada.
    }

    /** Média aritmética de uma ou mais notas. */
    public static double media(double... notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("Informe ao menos uma nota.");
        }
        double soma = 0;
        for (double nota : notas) {
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("As notas devem estar entre 0 e 10.");
            }
            soma += nota;
        }
        return soma / notas.length;
    }

    /** Situação do aluno de acordo com a média. */
    public static String situacao(double media) {
        if (media >= MEDIA_APROVACAO) {
            return "Aprovado(a)";
        } else if (media >= MEDIA_RECUPERACAO) {
            return "Recuperação";
        }
        return "Reprovado(a)";
    }
}
