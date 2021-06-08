package graficos;

import Serializar.Estudiante;
import Serializar.Promedio;
import controlador.Driver;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class PanelModulo2 extends JFrame implements ActionListener, MouseListener {

    private JButton atras;
    private JLabel texto;
    String nombret;
    Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(24, 100, 167));
    Border borde1 = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(187, 197, 210));

    public PanelModulo2() {

        this.setSize(750, 500);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);

        //----LISTAR LOS DATOS DE LA TABLA----
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Nota 1 (35%)");
        model.addColumn("Nota 2 (35%)");
        model.addColumn("Nota 3 (30%)");
        model.addColumn("Promedio");

        JTable tabla = new JTable(model);
        tabla.setBorder(borde);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 40, 700, 300);
        this.add(scroll);

        String[] dato = new String[6];

        try {
            Promedio p = new Promedio();
            FileInputStream os = new FileInputStream("estudiantes.txt");
            Estudiante e = new Estudiante();

            while (e != null) {
                try {
                    ObjectInputStream input = new ObjectInputStream(os);
                    e = (Estudiante) input.readObject();
                    dato[0] = Long.toString(e.codigo);
                    dato[1] = e.nombre;
                    dato[2] = Double.toString(e.nota1);
                    dato[3] = Double.toString(e.nota2);
                    dato[4] = Double.toString(e.nota3);
                    dato[5] = Double.toString(p.calculoProm(e.nota1, e.nota2, e.nota3));
                    model.addRow(dato);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            }
            os.close();
        } catch (Exception ex) {
        }
        //-----------
        Font fuente = new Font("Comic Sans MS", Font.BOLD, 18);
        atras = new JButton("Volver");
        atras.setContentAreaFilled(false);
        atras.setFont(fuente);
        atras.setBorder(borde);
        atras.setBounds(0, 470, 750, 30);
        atras.setFocusable(false);
        atras.addActionListener(this);
        atras.addMouseListener(this);
        this.add(atras);

        texto = new JLabel(" Tablas de Notas 'Serializar'");
        texto.setForeground(Color.BLACK);
        texto.setFont(fuente);
        texto.setBorder(borde1);
        texto.setBounds(250, 10, 280, 25);//toca cambiarle la fuente para que se vea mas cool
        this.add(texto);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == atras) {
            this.dispose();
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
        if (me.getSource() == atras) {
            atras.setOpaque(true);
            atras.setBackground(Driver.juego.getColorTinto());
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == atras) {
            atras.setOpaque(false);
        }
    }
}
