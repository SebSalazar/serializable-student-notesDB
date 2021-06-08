package Serializar;

public class Promedio {

    //Metodo al cual le llegan las tres notas y me retorna un double con el promedio o acumulado 
    public double calculoProm(double not1, double not2, double not3) {
        double prom;
        
        prom= (not1*0.35)+(not2*0.35)+(not3*0.30);
        return prom;        
    }
}
