package graficos;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanelModulo3 extends JPanel {
        public static PanelEditar pca;

    public PanelModulo3() {
        this.setSize(750, 500);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        //-----------      
        pca = new PanelEditar();
        this.add(pca);
    }

    public PanelEditar getPca() {
        return pca;
    }

    public void setPca(PanelEditar pca) {
        this.pca = pca;
    }
    
}


