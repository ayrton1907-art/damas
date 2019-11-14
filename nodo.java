public class Nodo{

      private boolean bol=false;
      private  Pair  pos;
      private  int color;

      public Nodo (Pair poss){ //ingresa la pos de cada nodo en el tablero.
       pos=poss;
       color=null;
      }
      public void  setColor ( Int color){//Blanco->0 Negro->1
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
