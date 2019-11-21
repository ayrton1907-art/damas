/*  Juego de damas que indica una posible jugada ganadora en un solo turno.
    @authors Bortol Juan Pablo, Lopez Ayrton Emilio, Rafti Soto Nicolas Ezequiel
*/
package jDamas;
public class Tuple  {
  public int x;//Posicion x
  public int y;//Posicion y

  //@Post:Inicializacion de la Posiciones.
  //@Param:(a,b) = Posiciones a asignar previstas por el usuario
  public Tuple(int a,int b) {
    this.x = a;
    this.y = b;
  }
  //@Post:Retorna el elemento de la pocision X.
  public int getPosX(){
    return x;
  }
  //@Post:Retorna el elemento de la pocision Y.
  public int getPosY(){
    return y;
  }
  //@Post: Cambia las Pocisiones anteriores por Pocisiones nuevas.
  public void setPos(int a,int b){
    x=a;
    y=b;
  }
  //@Post:Compara la posicion x de una Tupla.
  //@Param: pos = Tupla a comparar.
  public int comparToX(Tuple pos){
    return x-pos.getPosX();
  }
  //@Post:Compara la posicion y de una Tupla.
  //@Param: pos = Tupla a comparar.
  public int comparToY(Tuple pos){
    return y-pos.getPosY();
  }
  //@Post:Muestra la tupla en la pantalla.
  public String mosTuple(){
    return ('(' + String.valueOf(x) + ',' + String.valueOf(y) + ')');
  }
}
