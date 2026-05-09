
package examensim;

public class ExamenSim {
    //Cuadrado Medio
   public static double[] generarSecuencia(long semilla, int cantidad) {

        double[] secuencia = new double[cantidad];

        // Detectar cantidad de dígitos
        int r = String.valueOf(semilla).length();

        for (int i = 0; i < cantidad; i++) {

            // Semilla al Cuadrado
            long cuadrado = semilla * semilla;

            // Completar con ceros
            String numero = String.format("%0" + (r * 2) + "d", cuadrado);

            // Extraer centro
            int inicio = (numero.length() - r) / 2;

            String centro = numero.substring(inicio, inicio + r);

            // Nueva semilla
            semilla = Long.parseLong(centro);

            // Numero pseudoaleatorio
            secuencia[i] = semilla / Math.pow(10, r);
        }

        return secuencia;
    }

    // Chi-Cuadrado
    
    public static void realizarPruebaChi(double[] secuencia,
            int intervalos,
            double valorCritico) {

        int n = secuencia.length;

        int[] observados = new int[intervalos];

        // Contar frecuencias observadas
        for (double num : secuencia) {

            int posicion = (int) (num * intervalos);

            if (posicion == intervalos) {
                posicion--;
            }

            observados[posicion]++;
        }

        // Frecuencia esperada
        double esperado = (double) n / intervalos;

        double chi = 0;
        System.out.println("----------");
        System.out.println("Chi-Cuadrado");
        System.out.println("Intervalo\tOi\tEi");

        for (int i = 0; i < intervalos; i++) {

            chi += Math.pow(observados[i] - esperado, 2) / esperado;

            System.out.println(i + "\t\t" +observados[i] + "\t" +esperado);
        }

        System.out.println("\nChi Calculado = " + chi);
        System.out.println("Valor Critico = " + valorCritico);

        // Decision final
        if (chi <= valorCritico) {

            System.out.println("\nH0 Aceptada:");
            System.out.println("Distribucion uniforme");

        } else {

            System.out.println("\nH0 Rechazada:");
            System.out.println("Distribucion no uniforme");
        }
    }

    public static void main(String[] args) {

        // Semilla
        long semilla = 21435;

        // n
        double[] secuencia = generarSecuencia(semilla, 50);

        // Mostrar valores R
        System.out.println("Cuadrado Medio");
        System.out.println("----------");
        System.out.println("Valores R");

        for (int i = 0; i < 5; i++) {

            System.out.println("R" + (i + 1) +
                               " = " + secuencia[i]);
        }

        // Prueba Chi-Cuadrado
        realizarPruebaChi(secuencia, 5, 9.488);
        
    }
}