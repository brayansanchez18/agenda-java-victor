package archivos;

import java.io.Serializable;

public class Simple implements Serializable {
  private String texto;
  private int dato;

  public Simple(String texto, int dato) {
    this.texto = texto;
    this.dato = dato;
  }

  @Override
  public String toString() {
    return "{" +
        " texto='" + texto + "'" +
        ", dato='" + dato + "'" +
        "}";
  }

  public String getTexto() {
    return this.texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public int getDato() {
    return this.dato;
  }

  public void setDato(int dato) {
    this.dato = dato;
  }

}
