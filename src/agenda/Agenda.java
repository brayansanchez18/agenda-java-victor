package agenda;

import java.io.*;
import java.util.Vector;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

public class Agenda {
  private Vector<Contacto> contactos;

  public Agenda() {
    this.contactos = new Vector<>(10, 1);
  }

  public Agenda(int capacidad) {
    this.contactos = new Vector<>(capacidad, 1);
  }

  public void mainMenu() {
    String menu = "Seleccione un elemento del menu: \n" +
        "(1) agregar contacto\n" +
        "(2) existe contacto\n" +
        "(3) listar contactos\n" +
        "(4) buscar contacto\n" +
        "(5) eliminar contacto\n" +
        "(6) Agenda llena?\n" +
        "(7) espacios libres\n" +
        "(0) salir";

    try {
      int seleccion = Integer.parseInt(
          JOptionPane.showInputDialog(null,
              menu,
              "menu principal",
              JOptionPane.QUESTION_MESSAGE));

      switch (seleccion) {
        case 1:
          String nombre = JOptionPane.showInputDialog(null, "ingrese el nombre del contacto", "nombre de contacto",
              JOptionPane.QUESTION_MESSAGE);

          if (!existContact(nombre)) {
            long telefono = setTelefono();
            Contacto contacto = new Contacto(nombre, telefono);
            this.contactos.add(contacto);
          } else {
            JOptionPane.showMessageDialog(null, "el nombre del contacto ya existe en la agenda",
                "contacto preexistente", JOptionPane.PLAIN_MESSAGE);
          }

          mainMenu();
          break;

        case 3:
          listarContactos();
          mainMenu();
          break;

        case 4:
          if (existContact(
              JOptionPane.showInputDialog(null, "ingese un nombre", "nombre de contacto a buscar",
                  JOptionPane.QUESTION_MESSAGE))) {
            JOptionPane.showMessageDialog(null, "el contacto si existe en la agenda", "contacto encotrado",
                JOptionPane.INFORMATION_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(null, "contacto no encontrado", "sin coincidencias",
                JOptionPane.INFORMATION_MESSAGE);
          }
          mainMenu();
          break;

        case 6:
          isFull();
          mainMenu();
          break;

        case 7:
          freeSlots();
          mainMenu();
          break;

        case 0:
          JOptionPane.showMessageDialog(null, "gracias por usar su agenda", "adios", JOptionPane.PLAIN_MESSAGE);
          break;

        default:
          JOptionPane.showMessageDialog(null, "intente de nuevo", "seleccion invalida", JOptionPane.PLAIN_MESSAGE);
          mainMenu();
          break;
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "intente de nuevo", "seleccion invalida", JOptionPane.PLAIN_MESSAGE);
      mainMenu();
    }
  }

  private long setTelefono() {
    long telefono = 0;

    try {
      telefono = Long.parseLong(
          JOptionPane.showInputDialog(null, "ingrese el telefono", "numero de telefono", JOptionPane.QUESTION_MESSAGE));
      return telefono;
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "intente de nuevo", "valor invalido", JOptionPane.ERROR_MESSAGE);
      return setTelefono();
    }
  }

  private boolean existContact(String nombre) {
    return IntStream.range(0, this.contactos.size())
        .anyMatch(index -> this.contactos.elementAt(index).getNombre().equals(nombre));
  }

  private void isFull() {
    if (this.contactos.size() == this.contactos.capacity()) {
      JOptionPane.showMessageDialog(null, "la agenda esta llena", "warning", JOptionPane.WARNING_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "la agenda aun tiene espacios libres", "aun con espacios",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private void freeSlots() {
    if (this.contactos.size() == this.contactos.capacity()) {
      JOptionPane.showMessageDialog(null, "La agenda no cuenta con espacio libre", "WARNING",
          JOptionPane.WARNING_MESSAGE);
    } else {
      int slots = this.contactos.capacity() - this.contactos.size();
      String message = "La agenda cuenta con %d espacio libre de %d espasio disponible";
      JOptionPane.showMessageDialog(null, String.format(message, slots, this.contactos.capacity()), "aun con espacios",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private void listarContactos() {
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

  public Vector<Contacto> getContactos() {
    return contactos;
  }

  public void setContactos(Vector<Contacto> contactos) {
    this.contactos = contactos;
  }
}