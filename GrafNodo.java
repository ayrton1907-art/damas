package jDamas;
public class GrafNodo {

      private boolean bol=false;
      private  Tuple  pos;
      private  int color;

      public GrafNodo (Tuple poss){ //ingresa la pos de cada nodo en el tablero.
       pos=poss;
      }
      public void  setColor (int col){//Blanco->0 Negro->1
        color=col;
      }
      public void setBool (boolean bool){ //prendido->true apagado->false (contiene o no ficha en esa pos)
        bol=bool;
      }
      public int getColor(){//Blanco->0 Negro->1
        return color;
      }
      public Tuple getPos (){//ingresa la pos de cada nodo en el tablero.
        return pos;
      }
      public boolean getBool(){//prendido->true apagado->false (contiene o no ficha en esa pos)
        return bol;
      }
}
