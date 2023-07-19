package archivos;

import java.io.*;
import javax.swing.JOptionPane;

public class FileManagerOb {
  public void writeObject() {
    OutputStream file = null;
    BufferedOutputStream buffer = null;
    ObjectOutputStream output = null;
    try {
      // En esta linea la ectension .poo es creada por nuestra cuenta
      file = new FileOutputStream("files/ejemplo.poo");
      buffer = new BufferedOutputStream(file);
      output = new ObjectOutputStream(buffer);
      Simple simple = new Simple("Ejemplo", 20);
      output.writeObject(simple);
      output.close();
      buffer.close();
      file.close();
    } catch (Exception e1) {
      e1.printStackTrace();
      if (output != null) {
        try {
          output.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (buffer != null) {
        try {
          buffer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (file != null) {
        try {
          file.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void readObject() {
    Simple simple = null;
    InputStream file = null;
    BufferedInputStream buffer = null;
    ObjectInput input = null;
    try {
      // Indicamos en donde estara el archivo a leer
      file = new FileInputStream("file/ejemplo.poo");
      buffer = new BufferedInputStream(file);
      input = new ObjectInputStream(buffer);
      /*
       * Con el ObjectImputStream leemos el archivo y lo guardamos en
       * una variable
       */
      simple = (Simple) input.readObject();
      // Una vez con la variable, la imprimimos en pantalla
      JOptionPane.showMessageDialog(null, simple);
      // Al finalizar, cerraremos todos los streams
      input.close();
      buffer.close();
      file.close();
    } catch (Exception e1) {
      e1.printStackTrace();
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (buffer != null) {
        try {
          buffer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (file != null) {
        try {
          file.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}