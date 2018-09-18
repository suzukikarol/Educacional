/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodolinear;

import java.util.Scanner;

/**
 *
 * @author suzukiKarol
 */
public class MetodoLinear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] vetX = new double[6];
        double[] vetY = new double[6];
        
        int n;
        
        double sx=0, sy=0, sxy=0, sx2=0, delta=0, deltaA=0, deltaB=0, a=0,b=0;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite n: ");n=sc.nextInt();
        
        for (int i=1; i<=n; i++){
            System.out.println("Digite x["+1+"]: "); vetX[1]=sc.nextDouble();
            }
        
        for (int i=1; i<=n; i++){
            System.out.println("Digite y["+1+"]: "); vetY[1]=sc.nextDouble();
            }
        
        for(int i=1; i<=n; i++){
            sx += vetX[i];
            sy += vetY[i];
            sxy += vetX[i]*vetY[i];
            sx2 += vetX[i]*vetY[i];
        }
        
        delta = sx2*n-sx*sx;
        deltaA = sxy*n-sx*sy;
        deltaB = sx2*sy-sxy*sx;
        
        a = deltaA/delta;
        b = deltaB/delta;
        
        System.out.println("\n\nf(x)= "+a+" x + (" +b+ ")");
        
         
    }
    
}
