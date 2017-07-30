/*
 * esta clase va a contraolar las acciones de la clase Panel grafo
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelControlGrafo extends JPanel{
    private JPanel panelContenedor;
    private PanelGrafo panelGrafo;
    private JTextField txtNombreVertice1;
    private JTextField txtNombreVertice2;
    private JTextField cantSalto; 
    private JButton boton;
    
    public PanelControlGrafo(){
   this.armarPanel();
    }
    
    public PanelControlGrafo(PanelGrafo panel)
    {
        this.panelGrafo=panel;
        this.armarPanel();
    }

    public void armarPanel() 
    {
            
        this.txtNombreVertice1 =new JTextField(20);
        this.txtNombreVertice2 =new JTextField(20);
        this.cantSalto =new JTextField(5); 
        this.boton= new JButton();
        
        
        this.add(new JLabel("Vertice Origen"));
        this.add(txtNombreVertice1);
        this.add(new JLabel("Vertice Destino"));
        this.add(txtNombreVertice2);  
        this.add(new JLabel("Cantidad de saltos"));   
        this.add(cantSalto);
        this.add(new JButton("Buscar Camino"));
        this.add(boton);
    }

   
//public static void main(String[] args) {
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//           PanelControlGrafo panel=new PanelControlGrafo();
//         panel.crearPanelShowGUI();
//        }
//    });
//}
//
//    private void crearPanelShowGUI() {
//        JFrame ventana = new JFrame("Biblioteca");
//        ventana.setSize(500, 500);
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        PanelControlGrafo panel = new PanelControlGrafo();
//        panel.setSize(500, 500);
//        ventana.add(panel);
//        ventana.add(panel, BorderLayout.PAGE_END);
//        ventana.pack();
//        ventana.setVisible(true);
//    }
}
