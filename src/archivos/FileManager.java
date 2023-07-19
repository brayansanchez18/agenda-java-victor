package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class FileManager {
  public static void main(String[] args) {
    FileManager fileManager = new FileManager();
    fileManager.readFile();
  }

  public void writeFile() {
    String fileName = "files/simple.txt";
    FileWriter file = null;
    PrintWriter print = null;

    try {
      file = new FileWriter(fileName, true);
      print = new PrintWriter(file);

      for (int i = 0; i < 10; i++) {
        print.println("linea: " + i);
      }
      print.close();
      file.close();
      JOptionPane.showMessageDialog(null, "archivo escrito correctamente");
    } catch (FileNotFoundException fne) {
      JOptionPane.showMessageDialog(null, "no existe la carpeta para el archivo");
    } catch (Exception ex) {
      ex.printStackTrace();

      try {
        if (file != null) {
          file.close();
        }
      } catch (Exception e) {
        e.printStackTrace(print);
      }
    }
  }

  public void readFile() {
    File file = null;
    FileReader reader = null;
    BufferedReader bufferedReader = null;
    String linea = null;

    try {
      file = new File("files/simple.txt");
      reader = new FileReader(file);
      bufferedReader = new BufferedReader(reader);

      while ((linea = bufferedReader.readLine()) != null) {
        System.out.println(linea);
      }
      bufferedReader.close();
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();

      try {
        if (reader != null) {
          reader.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
}
