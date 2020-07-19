/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_buscador;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ADMI
 */
public class IA_Buscador {

    public static void main(String[] args) {
/*        String sCarpAct = null;
        File carpeta;
        carpeta = new File("D:");
String[] listado = carpeta.list();
if (listado == null || listado.length == 0) {
    System.out.println("No hay elementos dentro de la carpeta actual");
    return;
}
else {
    for (int i=0; i< listado.length; i++) {
        System.out.println(listado[i]);
    }
}
 */       
        
        
        
        
    File unidades[] = File.listRoots();
for(int i=0;i<unidades.length;i++){
    if (!unidades[i].toString().equals("C:\\")) {
     //letra de la unidad  
        System.out.println(unidades[i]);
        
       System.out.println(FileSystemView.getFileSystemView().getSystemDisplayName (unidades[i]));
       mostrarArchivos(unidades[i]);
       
      
        
    }else{
        //System.out.println("no hay unidades externas");
    }
        
}
 
    }
    
    
   static void mostrarArchivos(File ruta){
        File carpeta;
        carpeta = new File(ruta.toString());
String[] listado = carpeta.list();
if (listado == null || listado.length == 0) {
    System.out.println("No hay elementos dentro de la carpeta actual");
    return;
}
else {
    for (int i=0; i< listado.length; i++) {
        System.out.println(listado[i]);
    }
}
    }
    
}
 
