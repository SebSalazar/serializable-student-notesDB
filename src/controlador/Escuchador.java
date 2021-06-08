package controlador;

import graficos.PanelModulo1;
import graficos.PanelModulo2;
import graficos.PanelModulo3;
import graficos.PanelTablas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Escuchador implements ActionListener, MouseListener {

    PanelModulo1 pm1;
    String codigo;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Driver.juego.getSalir())) {
            System.exit(0);
        }
        if (e.getSource().equals(Driver.juego.getMol2())) {
            Driver.Pm2 = new PanelModulo2();
        }
        if (e.getSource().equals(Driver.juego.getPc().getInfo())) {

        }
        if (e.getSource().equals(Driver.juego.getPc().getInfo1())) {
            JOptionPane.showMessageDialog(Driver.juego, "Para eliminar un estudiante digite su codigo", "☢ Advertencia ☢", 2);
        }
        if (e.getActionCommand().equals("Borrar Estudiante")) {
            //codigo = Driver.juego.getPc().getInsertar().getText();
            PanelTablas.borrarEstudiante("");
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource().equals(Driver.juego.getInicio())) {
            Driver.juego.getInicio().setOpaque(true);
            Driver.juego.getInicio().setBackground(Driver.juego.getColorGris());
        }
        if (me.getSource().equals(Driver.juego.getMol2())) {
            Driver.juego.getMol2().setOpaque(true);
            Driver.juego.getMol2().setBackground(Driver.juego.getColorGris());
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource().equals(Driver.juego.getInicio())) {
            Driver.juego.getInicio().setOpaque(false);
        }
        if (me.getSource().equals(Driver.juego.getMol2())) {
            Driver.juego.getMol2().setOpaque(false);
        }
    }
}
