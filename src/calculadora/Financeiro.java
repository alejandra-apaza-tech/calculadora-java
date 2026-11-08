package calculadora;

/**
 * Cálculos de juros simples e compostos.
 * A taxa deve ser informada em porcentagem (ex.: 5 para 5%).
 */
public final class Financeiro {

    private Financeiro() {
    }

    /** Juros simples: J = C × i × t. */
    public static double jurosSimples(double capital, double taxaPercentual, double periodos) {
        validar(capital, taxaPercentual, periodos);
        return capital * (taxaPercentual / 100) * periodos;
    }

    /** Montante com juros simples: M = C + J. */
    public static double montanteSimples(double capital, double taxaPercentual, double periodos) {
        return capital + jurosSimples(capital, taxaPercentual, periodos);
    }

    /** Montante com juros compostos: M = C × (1 + i)^t. */
    public static double montanteComposto(double capital, double taxaPercentual, double periodos) {
        validar(capital, taxaPercentual, periodos);
        return capital * Math.pow(1 + taxaPercentual / 100, periodos);
    }

    /** Apenas os juros compostos: J = M − C. */
    public static double jurosCompostos(double capital, double taxaPercentual, double periodos) {
        return montanteComposto(capital, taxaPercentual, periodos) - capital;
    }

    private static void validar(double capital, double taxa, double periodos) {
        if (capital <= 0 || taxa < 0 || periodos <= 0) {
            throw new IllegalArgumentException(
                    "Capital e períodos devem ser maiores que zero e a taxa não pode ser negativa.");
        }
    }
}
