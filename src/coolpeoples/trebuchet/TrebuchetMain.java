/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolpeoples.trebuchet;

/**
 *
 * @author s355569
 */
public class TrebuchetMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RungeKutta rg = new RungeKutta();

        System.out.println(rg.rk4(rg.testFunction, 0.0, 0.5, 0.5));
        double stepper = 0.2;
        double ti = 0;
        double w = 0.5;
        while (ti <= 2 ) {
            w = rg.rk4(rg.testFunction, ti, w, stepper);
            System.out.println(w);
            ti += stepper;
        }
    }
    
}
