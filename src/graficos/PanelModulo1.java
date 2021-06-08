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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelModulo1 extends JPanel implements ActionListener, MouseListener {

    private JButton atras;
    JLabel titu;
    private JTextField[] datos = new JTextField[5];
    private JLabel[] textos = new JLabel[5];
    private String code;
    private String nombre;
    private double[] notas = new double[3];
    String nombret;
    ArrayList al = new ArrayList();

    public PanelModulo1() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        //-----------
        Font fuente = new Font("Comic Sans MS", Font.BOLD, 14);
        Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(24, 100, 167));
        //-----------
        atras = new JButton("Guardar Datos");
        atras.setContentAreaFilled(false);
        atras.setFont(fuente);
        atras.setBorder(borde);
        atras.setFocusable(false);
        atras.addActionListener(this);
        atras.addMouseListener(this);
        atras.setBounds(1, 347, 485, 20);
        this.add(atras);

        titu = new JLabel("Añadir Estudiante");
        titu.setFont(fuente);
        titu.setFocusable(false);
        titu.setBounds(170, 5, 180, 20);
        this.add(titu);

        for (int i = 0; i < 5; i++) {
            datos[i] = new JTextField();
            textos[i] = new JLabel();
            datos[i].setBorder(borde);
            datos[i].setBounds(210, 40 + (i * 50), 100, 25);
            textos[i].setBounds(100, 40 + (i * 50), 100, 15);
            textos[i].setFont(fuente);
            this.add(datos[i]);
            this.add(textos[i]);
        }
        this.setVisible(true);
        textos[0].setText("Codigo:");
        textos[1].setText("Nombre:");
        textos[2].setText("Nota 1 (35%):");
        textos[3].setText("Nota 2 (35%):");
        textos[4].setText("Nota 3 (30%):");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == atras) {
            try {
                code = datos[0].getText();
                nombre = datos[1].getText();
                notas[0] = Double.parseDouble(datos[2].getText());
                notas[1] = Double.parseDouble(datos[3].getText());
                notas[2] = Double.parseDouble(datos[4].getText());
                Promedio p = new Promedio(); //Instancio mi clase Promedio a la cual le paso como parametros las notas y me devuelve el promedio 
                double prom = p.calculoProm(notas[0], notas[1], notas[2]);
                ArrayList<Estudiante> ms = new ArrayList<>();

                try {
                    FileInputStream os = new FileInputStream("estudiantes.txt");
                    Estudiante e = new Estudiante();
                    while (e != null) {
                        try {
                            ObjectInputStream input = new ObjectInputStream(os);
                            e = (Estudiante) input.readObject();
                            while (Long.toString(e.codigo).equals(code)) {
                                code = JOptionPane.showInputDialog("Codigo repetido, ingresa otro codigo");
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                    }
                    os.close();
                } catch (IOException ex) {
                }
                Estudiante e = new Estudiante(); //Instancio la clase para y luego pasos los atributos que voy a serializar
                e.codigo = Long.parseLong(code);
                e.nombre = nombre;
                e.nota1 = notas[0];
                e.nota2 = notas[1];
                e.nota3 = notas[2];
                e.promedio = prom;

                FileOutputStream os = new FileOutputStream("estudiantes.txt", true); //Es el archivo donde se van a guardar los datos
                ObjectOutput output = new ObjectOutputStream(os);
                al.add(e); // Al ArrayList le paso el Objeto 'Estudiante'
                output.writeObject(e); //Escribo los datos de la lista en el archivo
                output.close();// Cierro el archivo
                os.close();
                JOptionPane.showMessageDialog(null, "Estudiante con codigo: "+code+" agregado!");
                System.out.println("\n" + e.toString());

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
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
