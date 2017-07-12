package BackUp;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nahuel
 */
public class BackUp {
    

 
public static void backup(String rutaBackup) {
   try {
      Process p = Runtime
            .getRuntime()
            .exec("C:\\xampp\\mysql\\bin\\mysqldump -u root  sminmobiliaria");
      

      InputStream is = p.getInputStream();
      FileOutputStream fos = new FileOutputStream(rutaBackup+".sql");
      //FileOutputStream fos = new FileOutputStream("C:\\Users\\Nahuel\\Desktop\\SM Inmobiliaria\\src\\BackUp\\sminmobiliariacopia.sql");
      byte[] buffer = new byte[1000];

      int leido = is.read(buffer);
      while (leido > 0) {
         fos.write(buffer, 0, leido);
         leido = is.read(buffer);
      }

      fos.close();

      JOptionPane.showMessageDialog(new JDialog(),"BackUp creado correctamente");
   } catch (Exception e) {
       JOptionPane.showMessageDialog(new JDialog(),"Error "+e.toString());
      //e.printStackTrace();
   }
} 
public static void restore(String rutaRestore) {
   try {
      Process p = Runtime
            .getRuntime()
            .exec("C:\\xampp\\mysql\\bin\\mysql -u root  sminmobiliaria");
      

      OutputStream os = p.getOutputStream();
      FileInputStream fis = new FileInputStream(rutaRestore);
     // FileInputStream fis = new FileInputStream("C:\\Users\\Nahuel\\Desktop\\SM Inmobiliaria\\src\\BackUp\\sminmobiliariacopia.sql");
      byte[] buffer = new byte[1000];

      int leido = fis.read(buffer);
      while (leido > 0) {
         os.write(buffer, 0, leido);
         leido = fis.read(buffer);
      }

      os.flush();
      os.close();
      fis.close();

      JOptionPane.showMessageDialog(new JDialog(),"La base de datos ha sido restaurada");
   } catch (Exception e) {
       JOptionPane.showMessageDialog(new JDialog(),"Error "+e.toString());
      //e.printStackTrace();
   }
}
}
