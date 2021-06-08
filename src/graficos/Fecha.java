package graficos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * @author Sebastian Salazar y SimarGod
 */
public class Fecha extends JPanel {

    private JTextField texto;
    private final Border bordes;
    private final Cursor mano;
    private final Font fuente1;
    String dia, mes, anio;
    public Fecha() {
        bordes = BorderFactory.createMatteBorder(2, 4, 2, 4, new Color(126, 134, 143));
        mano = new Cursor(HAND_CURSOR);
        fuente1 = new Font("Comic Sans MS", Font.BOLD, 40);
        //-----------------------------
        this.setBackground(new Color(187, 197, 210));
        this.setBorder(bordes);

        Calendar c = Calendar.getInstance();
        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        anio = Integer.toString(c.get(Calendar.YEAR));
        
        texto = new JTextField();
        texto.setText(dia+"/"+mes+"/"+anio);
        texto.setBackground(Color.BLACK);
        texto.setBorder(bordes);
        texto.setCursor(mano);
        texto.setFont(fuente1);
        texto.setForeground(Color.red);
        texto.setEditable(false);
        texto.setToolTipText("Fecha de hoy");

        this.add(texto);
        this.setVisible(true);
    }
}
