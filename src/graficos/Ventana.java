package graficos;

import controlador.Driver;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Sebastian Salazar - 20172020016
 */
public class Ventana extends JFrame {

    private JPanel cronometro, botones;
    private JButton inicio;
    private JButton mol2;
    private JButton salir;
    private JLabel autor;
    private Font fuente, fuente2, fuente3;
    private Border borde1, borde2, borde3;
    private Color colorAzul, colorTinto, ColorGris;
    private Cursor mano;
    private Modulo m[];
    private Fecha rel;
    private PanelTablas pc;
    PanelModulo1 pm1;
    PanelModulo3 pm3;
    int ancho;
    int alto;
    
    public Ventana() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        
        this.setTitle("Sistema de Notas!");
        this.getRootPane().setWindowDecorationStyle(1);
        this.setBounds(0, 0, ancho, alto);
        this.setUndecorated(true);
        this.setLayout(new GridLayout(2, 3));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        agregarPaneles();
        this.setVisible(true);

    }

    private void agregarPaneles() {
        fuente = new Font("Comic Sans MS", Font.BOLD, 20);
        fuente2 = new Font("Comic Sans MS", Font.BOLD, 14);
        fuente3 = new Font("Comic Sans MS", Font.BOLD, 12);
        borde1 = BorderFactory.createMatteBorder(2, 10, 1, 10, new Color(153, 153, 153));
        borde2 = BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(24, 100, 167));
        borde3 = BorderFactory.createLineBorder(new Color(255, 0, 0), 3);
        colorAzul = new Color(15, 100, 167);
        colorTinto = new Color(161, 52, 55);
        ColorGris = new Color(126, 134, 143);
        mano = new Cursor(HAND_CURSOR);
        //-------------------------------------------------------------------------------
        setCronometro(new JPanel());
        getCronometro().setPreferredSize(new Dimension(250, 500));
        this.add(getCronometro());
        setBotones(new JPanel());
        this.getBotones().setPreferredSize(new Dimension(250, 250));
        setM(new Modulo[4]);
        for (int i = 0; i < 2; i++) {
            getM()[i] = new Modulo();
            this.add(getM()[i]);
        }
        getM()[0].setBackground(Color.DARK_GRAY);
        getM()[1].setBackground(new Color(15, 100, 167));
        this.add(getBotones());
        //---------------------------
        for (int i = 2; i < 4; i++) {
            getM()[i] = new Modulo();
            this.add(getM()[i]);
        }
        getM()[2].setBackground(new Color(15, 100, 167));
        getM()[3].setBackground(Color.DARK_GRAY);
        //---------------------------
        setRel(new Fecha());
        getCronometro().setLayout(new BorderLayout());
        getCronometro().add(getRel(), BorderLayout.NORTH);
        setInicio(new JButton("<html>Sistema de notas<br>con 'Serializacion'</html>"));
        inicio.setFont(fuente);
        inicio.setContentAreaFilled(false);
        inicio.setBorder(borde2);
        inicio.setEnabled(false);
        inicio.setCursor(getMano());
        inicio.setForeground(new Color(161, 52, 55));;
        inicio.setFocusable(false);
        inicio.addActionListener(Driver.escuchador);
        inicio.addMouseListener(Driver.escuchador);

        setSalir(new JButton("Salir"));
        getSalir().setFont(fuente2);
        getSalir().setBorder(borde2);
        getSalir().setCursor(getMano());
        getSalir().setForeground(new Color(187, 197, 210));
        getSalir().setBackground(new Color(255, 0, 0));
        getSalir().setFocusable(false);
        getCronometro().add(getSalir(), BorderLayout.SOUTH);
        getSalir().addActionListener(Driver.escuchador);
        //---------------------------

        pm1= new PanelModulo1();
        pm1.setBackground(Color.WHITE);
        getM()[0].setLayout(new BorderLayout());
        getM()[0].add(pm1, BorderLayout.CENTER);

        setMol2(new JButton("<html>Consultar todos<br>los estudiantes</html>"));
        getMol2().setFont(fuente);
        getMol2().setCursor(getMano());
        getMol2().setContentAreaFilled(false);
        getMol2().setForeground(new Color(187, 197, 210));;
        getMol2().setFocusable(false);
        getMol2().addActionListener(Driver.escuchador);
        getMol2().addMouseListener(Driver.escuchador);
        getM()[1].setLayout(new BorderLayout());
        getM()[1].add(getMol2(), BorderLayout.CENTER);

        pm3= new PanelModulo3();
        getM()[2].setLayout(new BorderLayout());
        getM()[2].add(pm3, BorderLayout.CENTER);

        pc = new PanelTablas();
        getM()[3].add(getPc());
        //---------------------------
        autor = new JLabel("");
        autor.setFont(fuente3);
        autor.setBorder(borde1);
        getBotones().setLayout(new BorderLayout());
        getBotones().add(getInicio(), BorderLayout.CENTER);
        getBotones().add(autor, BorderLayout.SOUTH);

    }

    public Modulo[] getM() {
        return m;
    }

    public void setM(Modulo[] m) {
        this.m = m;
    }

    public Fecha getRel() {
        return rel;
    }

    public void setRel(Fecha rel) {
        this.rel = rel;
    }

    public JPanel getCronometro() {
        return cronometro;
    }

    public void setCronometro(JPanel cronometro) {
        this.cronometro = cronometro;
    }

    public JPanel getBotones() {
        return botones;
    }

    public void setBotones(JPanel botones) {
        this.botones = botones;
    }

    public JButton getInicio() {
        return inicio;
    }

    public void setInicio(JButton inicio) {
        this.inicio = inicio;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    public JButton getMol2() {
        return mol2;
    }

    public void setMol2(JButton mol2) {
        this.mol2 = mol2;
    }

    public Color getColorTinto() {
        return colorTinto;
    }

    public Color getColorGris() {
        return ColorGris;
    }

    public Color getColorAzul() {
        return colorAzul;
    }

    public Cursor getMano() {
        return mano;
    }

    public Border getBorde3() {
        return borde3;
    }

    public PanelTablas getPc() {
        return pc;
    }

}
