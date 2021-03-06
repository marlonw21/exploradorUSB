/*


http://www.myjavazone.com/2011/02/explorador-de-archivos.html
https://www.lawebdelprogramador.com/foros/Java/1668041-Reconocer-los-puertos-usb-en-java.html
https://geekytheory.com/introduccion-a-java-native-interface
https://stackoverrun.com/es/q/885810
https://codigosparadesarrolladores.blogspot.com/2014/06/codigo-java-abrir-archivo-de-cualquier-tipo.html

 */
package ia_buscador;

import static ia_buscador.IA_Buscador.mostrarArchivos;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ADMI
 */
public class Explorador extends javax.swing.JFrame {

    DefaultListModel modeloLista;
    DefaultListModel modeloListaArchivos;
    DefaultListModel modeloListaCache;
   

    /**
     * Creates new form Explorador
     */
    public Explorador() {
        initComponents();
        jPopupMenu1.add(jPanel1);

        //inicializamos el modelo de la lista de dispositivos
        modeloLista = new DefaultListModel();
        listDevice.setModel(modeloLista);
        //lista de Archvios
        modeloListaArchivos = new DefaultListModel();
        listArchivos.setModel(modeloListaArchivos);
        //clase para agregar imagenes de carpetas
        listArchivos.setCellRenderer(new ListaRender());

        //lista de cache
        modeloListaCache = new DefaultListModel();
        jList1.setModel(modeloListaCache);

        //al inicializar el programa se deben detectar las unidades externas
        File unidades[] = File.listRoots();
        for (int i = 0; i < unidades.length; i++) {
            if (!unidades[i].toString().equals("C:\\")) {
                //letra de la unidad  
                System.out.println(unidades[i]);

                System.out.println(FileSystemView.getFileSystemView().getSystemDisplayName(unidades[i]));
                //se agrega el elemento a la lista
                modeloLista.addElement(unidades[i] + " " + FileSystemView.getFileSystemView().getSystemDisplayName(unidades[i]));

            } else {
                // modeloLista.addElement("no hay unidades externas");
            }

        }

    }

    //identifica si es un directorio o un archivo
    public void idDir(String ruta) {
        File carpeta = new File(ruta);

        if (carpeta.isDirectory()) {
            abrirCarpeta(ruta);
        } else {
            abrirArchivo(ruta);
        }

    }

    //metodo para mostrar los archvios de una carpeta
    public void abrirCarpeta(String ruta) {
        modeloListaArchivos.clear();

        File carpeta = new File(ruta);

        File[] archivos = carpeta.listFiles();
        for (int i = 0; i < archivos.length; i++) {
            modeloListaArchivos.addElement(archivos[i].toString());
        }

    }
    
    //metodo para poder abrir los Archivos con el programa predeterminado
    public void abrirArchivo(String ruta) {

        try {
            System.out.println("Archivo");
            File objetofile = new File(ruta);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            Logger.getLogger(Explorador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDevice = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listArchivos = new javax.swing.JList<>();
        buscador = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();

        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listDevice.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDeviceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listDevice);

        listArchivos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listArchivosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listArchivos);

        buscador.setToolTipText("");
        buscador.setComponentPopupMenu(jPopupMenu1);
        buscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorMouseClicked(evt);
            }
        });
        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
        });

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listDeviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDeviceMouseClicked
        //   System.out.println(listDevice.getMousePosition());
        modeloListaArchivos.clear();
        String pathSelected = listDevice.getSelectedValue();
        String pathSub = pathSelected.substring(0, 3);
        System.out.println("Cadena recortada: " + pathSub);
        System.out.println(listDevice.getSelectedIndex());
        System.out.println(listDevice.getSelectedValue());

        //agragamos archivos a la lista nueva
        File carpeta;
        carpeta = new File(pathSub);
        File[] tipo = carpeta.listFiles();

        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            modeloListaArchivos.addElement("No hay elementos dentro de la carpeta actual");
            return;
        } else {
            for (int i = 0; i < listado.length; i++) {
                System.out.println(listado[i]);

                System.out.println("list FIles;   " + tipo[i] + " " + tipo[i].isDirectory());
                modeloListaArchivos.addElement(tipo[i].toString());

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_listDeviceMouseClicked

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorActionPerformed


    }//GEN-LAST:event_buscadorActionPerformed

    private void listArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listArchivosMouseClicked
        String nuevoDir = "";
        String ruta = listDevice.getSelectedValue();
        String nuevaRuta = ruta.substring(0, 3);
        String directorio = listArchivos.getSelectedValue();
        nuevaRuta = directorio;

        //   System.out.println(listDevice.getSelectedValue());
        //   System.out.println(listArchivos.getSelectedValue());
        System.out.println("nueva ruta: " + nuevaRuta);
        //al hacer doble click
        if (evt.getClickCount() == 2) {
                //verifica si es un archivo o un directorio
            idDir(listArchivos.getSelectedValue());
         
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_listArchivosMouseClicked
    //desplegable de historial de busquedas
    private void buscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorMouseClicked
        //al hacer doble click sobre la caja de texto de debe despelegar el hiostorial
        if (evt.getClickCount() == 2) {
            if (modeloListaCache.getSize() == 0) {
                jPopupMenu1.setVisible(false);

            } else {

                jPopupMenu1.show(buscador, 0, buscador.getHeight());
                System.out.println(modeloListaArchivos.getSize());

            }
        } else {

            buscador.setEditable(true);
            buscador.setEnabled(true);
            //buscador.setComponentPopupMenu(jPopupMenu1);
        }


    }//GEN-LAST:event_buscadorMouseClicked

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed

//obtenemos lo tecleado en la caja de texto
        String valor = buscador.getText();
        //se agrega a la lista de cache el valor buscado

        modeloListaCache.add(0, valor);
        System.out.println(modeloListaCache.get(0));

        //busqueda de archivos
        //Al presionar el boton comenzara la busqueda
        //primero verificar que los valores no sean nulos
        if (valor.equals("")) {
            //si el campo de texto para buscar es nulo
            JOptionPane.showMessageDialog(this, "no hay elementos para buscar");
        } else if (modeloListaArchivos.getSize() <= 0) {
            //si no se ha seleccionado ninguna unidad
            JOptionPane.showMessageDialog(this, "Seleccione una unidad");
        } else {
        }
        //en caso que ninguno sea nulo se debe realizar la busqueda
        String[] archivos = new String[modeloListaArchivos.getSize()];
        System.out.println("Tamaño" + archivos.length);
        for (int i = 0; i < modeloListaArchivos.getSize(); i++) {
            //  archivos[i] = modeloListaArchivos.get(i).toString();
            System.out.println("cliclo numero " + i + " i vale" + i);
            System.out.println("Posicion " + i + " Almacena" + modeloListaArchivos.get(i));
            if (!modeloListaArchivos.get(i).toString().toLowerCase().contains(valor.toLowerCase())) {

                System.out.println("elemento eliminado " + modeloListaArchivos.get(i));

                modeloListaArchivos.removeElementAt(i);
                i = -1;

                
            } else {

               
            }
        }

      
        //Si no hay elementos despliega mensaje
        if (modeloListaArchivos.getSize() <= 0) {
            JOptionPane.showMessageDialog(this, "archivo no encontrado, verifique su búsqueda");
        }


    }//GEN-LAST:event_BtnBuscarActionPerformed
        //buscador
    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        //cada que el usuario presione y suelte una tecla, el buscador ira buscando
        String txt = buscador.getText();
        System.out.println(txt);
        String mar = "kfkaskld";
        if (txt.equals(mar)) {
            System.out.println("si");
        } else {
            // System.out.println("no");
        }

        //      System.out.println(modeloListaCache.getSize());
        String[] cache = new String[modeloListaCache.getSize()];
        for (int i = 0; i < modeloListaCache.getSize(); i++) {
            cache[i] = modeloListaCache.get(i).toString();
            if (cache[i].startsWith(txt)) {
                System.out.println(cache[i]);
                // String txtMatch = modeloListaCache.get(i).toString();
                //    modeloListaCache.clear();
                //    modeloListaCache.addElement(cache[i]);
                //    jPopupMenu1.show(buscador, 0, buscador.getHeight());

            } else {
                //    for (int j = 0; j < cache.length; j++) {
                //        modeloListaCache.clear();
                //        modeloListaCache.add(i, cache[i]);
                //        jPopupMenu1.setVisible(false);
                //    }

            }
        }
    }//GEN-LAST:event_buscadorKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Explorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Explorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Explorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Explorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Explorador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JTextField buscador;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listArchivos;
    private javax.swing.JList<String> listDevice;
    // End of variables declaration//GEN-END:variables
}
