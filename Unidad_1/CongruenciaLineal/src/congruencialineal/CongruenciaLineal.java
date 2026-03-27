
package congruencialineal;


   public class CongruenciaLineal {

    public static void main(String[] args) {

        int a = 22695477;
        int c = 1;
        int m = 65536;
        int xn = 7;

        for (int i = 1; i <= 7; i++) {

            int operacion = (a * xn) + c;
            int mod = operacion % m;
            double un = (double) mod / m;

            System.out.println("Iteracion: " + i);
            System.out.println("Xn = " + xn);
            System.out.println("(5Xn + 3) = " + operacion);
            System.out.println("mod 16 = " + mod);
            System.out.println("Un+1 = " + un);
            System.out.println("- - - - - - - - - -");

            xn = mod;
        }
    }
}


    
    
 