/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trebuchet;

/**
 *
 * @author s355569
 */
public class RungeKutta {
    
    
    
    Function stage1 = new Function() {
        
        private double m1,m2,m3;
        private double l1 ,l2,l3,l4, s;
        private double I; 
        private double g = 9.81;
        private double angle1, angle2;
        private double k1,k2,k3,k4,k5,k6,k7,k8,k9,k10;
        
        private double findK1() {
            return m2*l1*l1 + m1*((l2-s)*(l2-s)) + I;
        }
        
        private double findK2() {
            return m2*l1*l4*Math.sin(angle2-angle1);
        }
        
        
        
        @Override
        public double apply(double t, double y) {
            return 10;
        }
        
    };
    
}