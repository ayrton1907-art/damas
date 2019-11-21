/*  Juego de damas que indica una posible jugada ganadora en un solo turno.
    @authors Bortol Juan Pablo, Lopez Ayrton Emilio, Rafti Soto Nicolas Ezequiel
*/
package jDamas;
import java.util.ArrayList;
import java.util.List;
interface interfaceDamas{
  //Toma la lista de fichas blancas y negras
  public void insListas(List<Tuple> blancas, List<Tuple> negras);

  //Ordena las listas de fichas.
  public void mergeSort(List<Tuple> listOrd, int n);
  public  void merge(List<Tuple> listOrd,List<Tuple> l, List<Tuple>  r, int left, int right);

  //inserta toda las posiciones del tablero junto con la de las fichas.
  public void insTablero (int tam);

  //Crea toda las posiciones adyacentes a un nodo.
  public void hacerAdy ();

  //verifica si el adyacente es una ficha de color negra.
  public Tuple adyNegro(Tuple  fichaBlanca);

  //Verifica si puede saltar sobre una ficha negra, a un lugar vacion en diagonal.
 public boolean posibleSalto(Tuple fichaBlanca,Tuple fichaNegra);

  //Nos da la posicion a la cual es posible sltar.
  public Tuple salto(Tuple fichaBlanca, Tuple fichaNegra);

  //Verifica que si para una ficha dada, existe o no una posibilidad de ganar enun turno
  public boolean camino (Tuple inicio);

  //Desmarca toa ficha negra que fuese marcada como comida, en el trayecto de buscar un camino, y si este no fue  posible.
  public void desmarcarNegros();

  //Busca si existe algun camino posible para la lista de fichas blancas.
  public boolean caminos();

  //Metodo que ejecuta todo el juego de damas.
  public  boolean  jugadaGanadora (int ancho, List<Tuple> blancas, List<Tuple> negras);

  //Imprime el camino de la ficha blanca que resulto vicootorioso.
  public void mostrar();
}
