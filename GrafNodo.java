public class GrafNodo implements interfaceGrafoNodo{

      private boolean bol=false;
      private  Tuplas  pos;
      private  int color;

      public GrafNodo (Tuplas poss){ //ingresa la pos de cada nodo en el tablero.
       pos=poss;
       color=null;
      }
      public void  setColor (int color){//Blanco->0 Negro->1
        color=color;
      }
      public void setBool (boolean bool){ //prendido->true apagado->false (contiene o no ficha en esa pos)
        bol=bool;
      }
      public int getColor(){//Blanco->0 Negro->1
        return color;
      }
      public int getPos (){//ingresa la pos de cada nodo en el tablero.
        return pos;
      }
      public boolean getBool(){//prendido->true apagado->false (contiene o no ficha en esa pos)
        return bol;
      }
}
