/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p2_mcg_lcg;


public class P2_MCG_LCG {

    public static void main(String[] args) {
        
        long m =65536;
        long a =22695477;
        long c =1;
        long x =3;
        
        for(int i=1;i<=10;i++){
            x = (a*x+c)%m;
            System.out.println(" X " +i + " = "+x);
        }
        
                
       
    }
    
}
