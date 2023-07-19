package agenda;
// TODO: CLASE QUE REPRESENTA A LOS CONTACTOS DE NUESTRA AGENDA

import javax.swing.JOptionPane;

public class Contacto {
  // TODO: NOMBRE DEL CONTACTO DENTRO DE NUESTRA AGENDA, ESTE NO SE PUEDE REPETIR
  private String nombre;
  private long telefono;

  public Contacto(String nombre, long telefono) {
    this.nombre = nombre;
    this.telefono = telefono;
  }

  public void Conctacto() {
    this.nombre = JOptionPane.showInputDialog(
        null,
        "Ingrese el nombre del contacto",
        "Nombre",
        JOptionPane.QUESTION_MESSAGE);
    Telefono();
  }

  public void Telefono() {
    try {
      this.telefono = Long.parseLong(JOptionPane.showInputDialog(
          null,
          "Ingrese el numero telefonico",
          "numero de telefono",
          JOptionPane.QUESTION_MESSAGE));
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
          null,
          "Intente de nuevo",
          "valor invalido",
          JOptionPane.ERROR_MESSAGE);
      Telefono();
    }
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public long getTelefono() {
    return this.telefono;
  }

  public void setTelefono(long telefono) {
    this.telefono = telefono;
  }
}
