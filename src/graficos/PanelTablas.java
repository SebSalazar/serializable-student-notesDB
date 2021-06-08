package graficos;

import Serializar.Estudiante;
import controlador.Driver;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Sebastian S
 */
public class PanelTablas extends JPanel {

    public static JTextField insertar;
    private JButton info;
    private JButton info1;

    public PanelTablas() {
        this.setPreferredSize(new Dimension(250, 250));
        this.setSize(new Dimension(250, 250));
        this.setBackground(Color.DARK_GRAY);
        Border borde1 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(126, 134, 143));
        Font fuente3 = new Font("Microsoft Sans Serif", Font.PLAIN, 14);
        Cursor mano = new Cursor(HAND_CURSOR);
        //---------------------------
        insertar = new JTextField(12);
        insertar.setForeground(new Color(126, 134, 143));
        insertar.setFont(fuente3);
        insertar.setBorder(borde1);
        insertar.setToolTipText("Digite el nombre del estudiante a borrar");
        insertar.setOpaque(false);

        info = new JButton("Borrar Estudiante");
        info.setForeground(new Color(187, 197, 210));
        info.setFont(fuente3);
        info.setCursor(mano);
        info.setBackground(new Color(15, 100, 167));
        info.setFocusable(false);
        info.addActionListener(Driver.escuchador);

        info1 = new JButton("Informacion");
        info1.setForeground(new Color(187, 197, 210));
        info1.setFont(fuente3);
        info1.setCursor(mano);
        info1.setBackground(new Color(15, 100, 167));
        info1.setFocusable(false);
        info1.addActionListener(Driver.escuchador);

        this.add(insertar);
        this.add(info);
        this.add(info1);
        this.setVisible(true);
    }

    public JTextField getInsertar() {
        return insertar;
    }

    public void setInsertar(JTextField insertar) {
        this.insertar = insertar;
    }

    public JButton getInfo() {
        return info;
    }

    public JButton getInfo1() {
        return info1;
    }

    public static void borrarEstudiante(String codigoo) {
        ArrayList<Estudiante> ms = new ArrayList<>();
        try {
            FileInputStream os = new FileInputStream("estudiantes.txt");
            //ms = (ArrayList<Estudiante>) input.readObject();
            //Iterator i = ms.iterator();
            Estudiante e = new Estudiante();
            while (e != null) {
                try {
                    ObjectInputStream input = new ObjectInputStream(os);
                    e = (Estudiante) input.readObject();
                    if (!Long.toString(e.codigo).equals(insertar.getText())) {
                        ms.add(e);
                    }
                    //e = (Estudiante) input.readObject();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            }
            os.close();
        } catch (IOException ex) {

        }
        try {

            File f = new File("estudiantes.txt");
            f.delete();
            
            for (Estudiante e : ms) {
                FileOutputStream os = new FileOutputStream("estudiantes.txt", true); //Es el archivo donde se van a guardar los datos
                ObjectOutput output = new ObjectOutputStream(os);
                output.writeObject(e); //Escribo los datos de la lista en el archivo
                output.close();// Cierro el archivo
                os.close();
            }
            JOptionPane.showMessageDialog(null, "Estudiante eliminado!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
