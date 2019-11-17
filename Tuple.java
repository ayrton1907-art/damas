package jDamas;
public class Tuple  {
  public int x;
  public int y;

  public Tuple(int a,int b) {//Inicializacion de la tupla.
    this.x = a;
    this.y = b;
  }
  public int getPosX(){ //Devuelve el elemento de la pocision X.
    return x;
  }
  public int getPosY(){ //Devuelve el elemento de la pocision Y.
    return y;
  }
  public void setPos(int a,int b){ //Cambia las Pocisiones.
    x=a;
    y=b;
  }
  public int comparToX(Tuple pos){ //Compara la posicion x de una Tupla pasada como parametro.
    return x-pos.getPosX();
  }
  public int comparToY(Tuple pos){ //Compara la posicion y de una Tupla pasada como parametro.
    return y-pos.getPosY();
  }
  public String mosTuple(){//Muestra la tupla en la pantalla.
    return ('(' + String.valueOf(x) + ',' + String.valueOf(y) + ')');
  }
}
