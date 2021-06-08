/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import Serializar.Estudiante;
import Serializar.Promedio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Mini
 */
public class PanelEditar extends JPanel implements ActionListener {

    private Border borde1;
    private Font fuente, fuente1, fuente2;
    private JLabel serie;
    private JButton editar;
    private JButton guardar;
    private JButton consu;
    private JTextField insertar;
    private JTextField[] datos = new JTextField[5];
    private JLabel[] textos = new JLabel[5];
    private double[] notas = new double[3];
    String nombre;
    static String code;

    public PanelEditar() {
        this.setSize(750, 500);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        //-------------------
        borde1 = BorderFactory.createLineBorder(new Color(187, 197, 210), 3);
        fuente = new Font("Comic Sans MS", Font.BOLD, 14);
        fuente1 = new Font("Berlin Sans FB", Font.BOLD, 15);
        fuente2 = new Font("Comic Sans MS", Font.BOLD, 10);

        Serie();
        Botones();
    }

    private void Serie() {
        this.setLayout(null);

        serie = new JLabel("Editar estudiante (Digite el codigo)");
        serie.setForeground(Color.WHITE);
        serie.setHorizontalAlignment(JLabel.CENTER);
        serie.setFont(fuente1);
        serie.setBounds(120, 10, 260, 23);
        this.add(serie);

        insertar = new JTextField(12);
        insertar.setForeground(Color.BLACK);
        insertar.setBackground(Color.WHITE);
        insertar.setFont(fuente);
        insertar.setBorder(borde1);
        insertar.setBounds(155, 36, 160, 25);
        this.add(insertar);

    }

    private void Botones() {
        editar = new JButton("Editar estudiante");
        editar.setBounds(70, 63, 150, 30);
        editar.setBorder(borde1);
        editar.setFont(fuente);
        editar.setBackground(Color.yellow);
        editar.setFocusable(false);
        editar.addActionListener(this);
        this.add(editar);

        consu = new JButton("Consultar estudiante");
        consu.setBounds(235, 63, 170, 30);
        consu.setBorder(borde1);
        consu.setFont(fuente);
        consu.setBackground(Color.cyan);
        consu.setFocusable(false);
        consu.addActionListener(this);
        this.add(consu);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == editar) {
            code = insertar.getText();
            if (code != null) {
                File fichero = new File("estudiantes.txt");
                if (fichero.exists()) {
                    try {
                        try {
                            ArrayList<Estudiante> ms = new ArrayList<>();
                            FileInputStream os = new FileInputStream("estudiantes.txt");

                            //ms = (ArrayList<Estudiante>) input.readObject();
                            //Iterator i = ms.iterator();
                            Estudiante e = new Estudiante();
                            while (e != null) {
                                try {
                                    ObjectInputStream input = new ObjectInputStream(os);
                                    e = (Estudiante) input.readObject();
                                    if (Long.toString(e.codigo).equals(code)) {
                                        for (int i = 0; i < 5; i++) {
                                            datos[i] = new JTextField();
                                            textos[i] = new JLabel();
                                            textos[i].setForeground(Color.WHITE);
                                            datos[i].setBorder(borde1);
                                            datos[i].setBounds(105, 98 + (i * 50), 100, 25);
                                            textos[i].setBounds(15, 98 + (i * 50), 90, 15);
                                            textos[i].setFont(fuente);
                                            this.add(datos[i]);
                                            this.add(textos[i]);
                                        }
                                        textos[0].setText("Codigo:");
                                        textos[1].setText("Nombre:");
                                        textos[2].setText("Nota (35%):");
                                        textos[3].setText("Nota (35%):");
                                        textos[4].setText("Nota (30%):");
                                        
                                        guardar = new JButton("Guardar");
                                        guardar.setBounds(170, 333, 110, 30);
                                        guardar.setBorder(borde1);
                                        guardar.setFont(fuente);
                                        guardar.setBackground(Color.RED);
                                        guardar.setFocusable(false);
                                        guardar.addActionListener(this);
                                        this.add(guardar);

                                        datos[0].setText(Long.toString(e.codigo));
                                        datos[0].setEditable(false); //---Al ser el codigo no se puede editar porque nunca cambia---
                                        datos[1].setText(e.nombre);
                                        datos[2].setText(Double.toString(e.nota1));
                                        datos[3].setText(Double.toString(e.nota2));
                                        datos[4].setText(Double.toString(e.nota3));
                                        this.repaint();
                                    }
                                    //e = (Estudiante) input.readObject();
                                } catch (Exception ex) {
                                    System.out.println(ex.getMessage());
                                    break;
                                }

                            }
//                            while (i.hasNext()) {
//                                Estudiante e = new Estudiante();
//                                e = (Estudiante) i.next();
//                                datos[0].setText(Long.toString(e.codigo));
//                                datos[0].setEditable(false); //---Al ser llave primaria este dato no se puede editar---
//                                datos[1].setText(e.nombre);
//                                datos[2].setText(Double.toString(e.nota1));
//                                datos[3].setText(Double.toString(e.nota2));
//                                datos[4].setText(Double.toString(e.nota3));
//                            }
                            os.close();
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        this.setVisible(true);
                        this.repaint();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO se puede ejecutar la busqueda porque el fichero no existe ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (ae.getSource() == consu) {
            code = insertar.getText();
            if (code != null) {
                File fichero = new File("estudiantes.txt");
                if (fichero.exists()) {
                    try {
                        try {
                            ArrayList<Estudiante> ms = new ArrayList<>();
                            FileInputStream os = new FileInputStream("estudiantes.txt");
                            Estudiante e = new Estudiante();
                            while (e != null) {
                                try {
                                    ObjectInputStream input = new ObjectInputStream(os);
                                    e = (Estudiante) input.readObject();
                                    if (Long.toString(e.codigo).equals(code)) {
                                        for (int i = 0; i < 5; i++) {
                                            datos[i] = new JTextField();
                                            datos[i].setBorder(borde1);
                                            datos[i].setBounds(275, 98 + (i * 50), 100, 25);
                                            this.add(datos[i]);
                                        }
                                        datos[0].setText(Long.toString(e.codigo));
                                        datos[0].setEditable(false); //Datos solo para consulta de un estudiante no se puede cambiar o eliminar
                                        datos[1].setText(e.nombre);
                                        datos[1].setEditable(false);
                                        datos[2].setText(Double.toString(e.nota1));
                                        datos[2].setEditable(false);
                                        datos[3].setText(Double.toString(e.nota2));
                                        datos[3].setEditable(false);
                                        datos[4].setText(Double.toString(e.nota3));
                                        datos[4].setEditable(false);
                                        this.repaint();
                                    }
                                } catch (IOException | ClassNotFoundException ex) {
                                    System.out.println(ex.getMessage());
                                    break;
                                }
                            }
                            os.close();
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        this.setVisible(true);
                        this.repaint();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO se puede ejecutar la busqueda porque el fichero no existe ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (ae.getSource() == guardar) {
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
                        if (!Long.toString(e.codigo).equals(code)) {
                            ms.add(e);
                        }
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
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Estudiante e = new Estudiante(); //Instancio la clase para y luego pasos los atributos que voy a serializar
            e.codigo = Long.parseLong(code);
            e.nombre = nombre;
            e.nota1 = notas[0];
            e.nota2 = notas[1];
            e.nota3 = notas[2];
            e.promedio = prom;
            try {
                FileOutputStream os = new FileOutputStream("estudiantes.txt", true); //Es el archivo donde se van a guardar los datos
                ObjectOutput output = new ObjectOutputStream(os);
                ms.add(e); // Al ArrayList le paso el Objeto 'Estudiante'
                output.writeObject(e); //Escribo los datos de la lista en el archivo
                output.close();// Cierro el archivo
                os.close();
                System.out.println("\n" + e.toString());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
