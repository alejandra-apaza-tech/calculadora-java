package calculadora;

/**
 * Cálculo de áreas de figuras geométricas planas.
 */
public final class Geometria {

    private Geometria() {
    }

    /** Área do quadrado: lado². */
    public static double areaQuadrado(double lado) {
        validar(lado);
        return lado * lado;
    }

    /** Área do retângulo: base × altura. */
    public static double areaRetangulo(double base, double altura) {
        validar(base, altura);
        return base * altura;
    }

    /** Área do círculo: π × raio². */
    public static double areaCirculo(double raio) {
        validar(raio);
        return Math.PI * raio * raio;
    }

    /** Área do triângulo: (base × altura) / 2. */
    public static double areaTriangulo(double base, double altura) {
        validar(base, altura);
        return (base * altura) / 2;
    }

    /** Área do losango: (diagonal maior × diagonal menor) / 2. */
    public static double areaLosango(double diagonalMaior, double diagonalMenor) {
        validar(diagonalMaior, diagonalMenor);
        return (diagonalMaior * diagonalMenor) / 2;
    }

    /** Área do trapézio: ((base maior + base menor) × altura) / 2. */
    public static double areaTrapezio(double baseMaior, double baseMenor, double altura) {
        validar(baseMaior, baseMenor, altura);
        return ((baseMaior + baseMenor) * altura) / 2;
    }

    private static void validar(double... medidas) {
        for (double medida : medidas) {
            if (medida <= 0) {
                throw new IllegalArgumentException("As medidas devem ser maiores que zero.");
            }
        }
    }
}
