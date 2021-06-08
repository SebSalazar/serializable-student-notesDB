
package Serializar;

import java.io.Serializable;

public class Estudiante implements Serializable{
    public long codigo;
    public String nombre;
    public double nota1;
    public double nota2;
    public double nota3;
    public double promedio;

    @Override
    public String toString() {
        String cadena= "Codigo: "+this.codigo+"\nNombre: "+this.nombre+"\nNota 1: "+this.nota1+
                "\nNota 2: "+this.nota2+"\nNota 3: "+this.nota3+"\nPromedio: "+this.promedio;
        return cadena;
    }
}
//Esta es mi clase que implemente 'Serializable' donde se Serializa cada objeto 
//para posteriormente guardarlo en un ArrayList 
