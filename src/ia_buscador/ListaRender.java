/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_buscador;

import java.awt.Component;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ADMI
 */
public class ListaRender extends JLabel implements ListCellRenderer{
    String imgFolder="/folder.png";
    final ImageIcon folder = new ImageIcon(getClass().getResource("folder.png"));
    String imgFile="/file.png";
    final ImageIcon file = new ImageIcon((getClass().getResource("file.png")));
    String icon;
   
    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
       
        
        String valor = e.toString();
        setText(valor);
        if (valor.contains(".")) {
            setIcon(file);
          
            
        }else{
            setIcon(folder);
          
        }
        if (bln) {
            setBackground(jlist.getSelectionBackground());
            setForeground(jlist.getSelectionForeground());
            setOpaque(true);
        }else{
            setBackground(jlist.getBackground());
            setForeground(jlist.getForeground());
             setOpaque(false);
        }
        setEnabled(jlist.isEnabled());
        setFont(jlist.getFont());
       
    
    return this;
    
    }
    public void setIcon(String icon ){
        this.icon=icon;
    }
    
}
