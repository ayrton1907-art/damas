package jDamas;
public class GrafNodo {

      private boolean hayFicha=false;//Booleano para indicar que hay una ficha en esa posicion del tablero
      private  Tuple  pos;//Indica la posicion del tablero
      private  int color;//Indica el color de la ficha en caso que haya


      //@Post: Ingresa la pos de ese nodo en el tablero.
      //@Param: Aux = posicion del nodo.
      public GrafNodo (Tuple aux){
        pos=aux;
      }
      //@Post: Le asinga el color a la ficha,1 es negro, 0 es blanco.
      //@Param: Col = es el color a asignar.
      public void  setColor (int col){
        color=col;
      }
      //@Post: Indica si hay una ficha en la posicion del nodo.
      public void setFicha (boolean bool){
        hayFicha=bool;
      }
      //@Post: Retorna el color.
      public int getColor(){
        return color;
      }
      //@Post: Retorna la Posicion.
      public Tuple getPos (){//ingresa la pos de cada nodo en el tablero.
        return pos;
      }
      //@Post: Retorna True en caso que haya una ficha en esa posicion, caso contrario retorna False.
      public boolean getFicha(){//prendido->true apagado->false (contiene o no ficha en esa pos)
        return hayFicha;
      }
}
