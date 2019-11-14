import OLA;
public class Nodo{

      private boolean bol=false;
      private  Pair  pos;
      private  int color;

      public Nodo (Pair poss){
       pos=poss;
      }
      public void  setColor ( Int color){
        color=color;//Blanco->0 Negro->1
      }
      public void setBool (boolean bool){
        bol=bool;//prendido->true apagado->false (contiene o no ficha en esa pos)
      }
      public int getPos (){
        return pos;
      }

}
