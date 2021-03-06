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
public class RungeKutta {
    
    Function testFunction = (double x, double y) -> y - x * x +1;
    Function simplePendulumFunction = (double x, double y) -> (-9.8/2)*Math.sin(y);
    

    
    public double rk4(Function f, double x, double y, double h) {
        double k1 = h*f.apply(x, y);
        double k2 = h*f.apply(x+(h/2), y+(k1/2));
        double k3 = h*f.apply(x+(h/2), y+(k2/2));
        double k4 = h*f.apply(x+h, y+k3);
        return y+(k1+2*k2+2*k3+k4)/6;
        
    }
    
    Function stage1 = new Function() {
    
    	/**
    	 * physical specs of the trebuchet
    	 * 
    	 **/
    	private double l1=15,l2=72,l3=48,l4=9, s=65, h=50; //lengths (in inches)
    	private double x1=0,x2=5,x3=10; // x coordinates of certains points
        private double y1=3,y2=6,y3=4; // y coordinates of certain points
        private double m1=12,m2=3,m3=5; // the masses
        private double I=4; //Moment of inertia
        private double angle1=3, angle2=4; //angles on trebuchet
        
        private double X1=0, X2=0, X3=0, X4=0, X5=0, X6=0; //these are the change per time, pretty much derivative
        
        private double g = 9.81; //gravity
        
        private double k1,k2,k3,k4,k5,k6,k7,k8,k9,k10; //thingsn to calculate
        
        private double findK1() {
            return m2*l1*l1 + m1*((l2-s)*(l2-s)) + I;
        }
        
        private double findK2() {
            return m2*l1*l4*Math.sin(angle2-angle1);
        }
        
        private double findK3() {
            return (m3*l2*(x3*Math.sin(angle1) + h*Math.cos(angle1)))/(x3+l2*Math.cos(angle1));
        }
        
        private double findK4() {
            return -m2*l1*l4*X4*X4+Math.cos(angle2-angle1) - g*(m2*l1-m1*(l2-s))*Math.cos(angle1);
        }
        
        private double findK5() {
            return l1*Math.sin(angle2-angle1);
        }
        
        private double findK6() {
            return l4;
        }
        
        private double findK7() {
            return l1*X2*X2*Math.cos(angle2-angle1) - g*Math.sin(angle2);
        }
        
        private double findK8() {
            return -h*l2*Math.cos(angle1)-l2*x3*Math.sin(angle1);
        }
        
        private double findK9() {
            return l2*Math.cos(angle1) + x3;
        }
        
        private double findK10() {
            return -X6*X6*x3+2*l2*X2*X6*Math.sin(angle1)+l2*X2*X2*(x3*Math.cos(angle1)-h*Math.sin(angle1));
        }
        
        private double find2DevAngle1() {
            return (k10*k3*k6-k4*k6*k9+k7*k9)/(-k1*k6*k9+k2*k5*k9+k3*k6*k8);
        }
        
        private double find2DevAngle2() {
            return (k3*(k7*k8-k10*k5)+k4*k5*k9-k1*k7*k9)/(-k1*k6*k9+k2*k5*k9+k3*k6*k8);
        }
        
        private double find2Devx3() {
            return (-k1*k10*k6+k4*k6*k8+k2*(k10*k5-k7*k8))/(-k1*k6*k9+k2*k5*k9+k3*k6*k8);
        }
        
        @Override
        public double apply(double t, double y) {
            return m3*g+((m3*(h-l2*Math.sin(angle1))/(x3+l2*Math.cos(angle1))))*find2Devx3();
        }
        
    };
    
}