
package sim250402;

public class Sim250402 {

    public static void main(String[] args) {
        
        int semilla = 1001;
        int d = 4;
        int iteraciones = 15;
        
        long x = semilla;
        
            long divisorCentro = (long)Math.pow(10,d/2);
            long moduloCentro = (long)Math.pow(10, d);
           
            for (int i=0; i<iteraciones;i++){
                long cua = x*x;
                
                x = Math.floorDiv(cua, divisorCentro)% moduloCentro;
                
                 double u = x/Math.pow(10, d);
                
                System.out.println("Numero u : "+u);

            
        }
    }
}