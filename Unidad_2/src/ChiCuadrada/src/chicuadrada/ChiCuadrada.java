package chicuadrada;

public class ChiCuadrada {

    public static void main(String[] args) {
        
        // Muestra de 30 números pseudoaleatorios
//            double[] muestra = {
//            0.15, 0.22, 0.89, 0.45, 0.56,
//            0.78, 0.12, 0.34, 0.67, 0.91,
//            0.05, 0.48, 0.73, 0.27, 0.39,
//            0.81, 0.14, 0.62, 0.53, 0.96,
//            0.31, 0.44, 0.69, 0.25, 0.58,
//            0.84, 0.17, 0.71, 0.36, 0.99
//            };
        
        // Cambio 1 Muestra sesgada
//        double[] muestra = {
//            0.01, 0.02, 0.03, 0.04, 0.05,
//            0.06, 0.07, 0.08, 0.09, 0.10,
//            0.11, 0.12, 0.13, 0.14, 0.15,
//            0.16, 0.17, 0.18, 0.19, 0.20,
//            0.21, 0.22, 0.23, 0.24, 0.25,
//            0.26, 0.27, 0.28, 0.29, 0.30
//        };

              // Muestra Personalizada
              double[] muestra = {
              0.01, 0.02, 0.03, 0.04, 0.05,
              0.06, 0.07, 0.08, 0.09, 0.10,
              0.11, 0.12, 0.13, 0.14, 0.15,
              0.16, 0.17, 0.18, 0.19, 0.05,
              0.07, 0.08, 0.09, 0.10, 0.11,
              0.12, 0.13, 0.14, 0.15, 0.16
           };


        
        //Tamaño de la muestra
        int n = muestra.length;
        
        //Intervalos
        int k = 5;

        double frecuenciaEsperada = (double) n / k;

        // Límites de los intervalos
        double amplitud = 1.0 / k;

        // Arreglo para frecuencias observadas
        int[] fo = new int[k];

        // Contar frecuencias observadas
        for (double num : muestra) {

            int intervalo = (int) (num / amplitud);

            // Corrección para el valor 1.0
            if (intervalo == k) {
                intervalo = k - 1;
            }

            fo[intervalo]++;
        }

        // Mostrar los intervalos y frecuencias
        System.out.println("PRUEBA CHI-CUADRADA");
        System.out.println("-----------------------------");
        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println("Frecuencia Esperada = " + frecuenciaEsperada);
        System.out.println();

        double chiCuadrada = 0;

        System.out.println("Intervalo\tFO\tFE\t(FO-FE)^2/FE");

        for (int i = 0; i < k; i++) {

            double li = i * amplitud;
            double ls = li + amplitud;

            double calculo = Math.pow((fo[i] - frecuenciaEsperada), 2)
                    / frecuenciaEsperada;

            chiCuadrada += calculo;

            System.out.printf("[%.1f - %.1f)\t%d\t%.2f\t%.4f%n",
                    li, ls, fo[i], frecuenciaEsperada, calculo);
        }

        // Valor crítico para 95% y 4 grados de libertad
        double valorCritico = 9.4877;

        System.out.println("\nChi-Cuadrada Calculada = " + chiCuadrada);
        System.out.println("Valor Crítico = " + valorCritico);

        // Decisión
        if (chiCuadrada < valorCritico) {
            System.out.println("Resultado: Se acepta la hipótesis.");
            System.out.println("Los números siguen una distribución uniforme.");
        } else {
            System.out.println("Resultado: Se rechaza la hipótesis.");
            System.out.println("Los números NO siguen una distribución uniforme.");
        }
    }
}