
package controlador;

import graficos.Ventana;
import graficos.PanelModulo1;
import graficos.PanelModulo2;
import graficos.PanelModulo3;

public class Driver {
    
    public static Ventana juego;
    public static PanelModulo1 Pm1;
    public static PanelModulo2 Pm2;
    public static PanelModulo3 Pm3;
    public static Escuchador escuchador = new Escuchador();
    
    public static void inicializar(){
        juego = new Ventana();
    }
}
