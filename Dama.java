package jDamas;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class Dama{

  private Grafo dam;
  private List<Tuple>  blan;
  private List<Tuple>  neg;
  private Stack<Tuple>  cam;
  private int tamaño;

 public  Dama (){
   Grafo dam =new Grafo();
   List<Tuple> blan = new ArrayList<Tuple>() ;    //agregar que inserte los blancos y los negros y el tamaño
   List<Tuple>  neg = new ArrayList<Tuple>() ;
   Stack<Tuple>  cam= new Stack<Tuple>() ;
   int tamaño = 0;
 }
 private void desmarcarNegros(){
   int i = 0;
   while (i<neg.size()){
     Tuple porVer = neg.get(i);
     int aux = (porVer.getPosX()*tamaño + porVer.getPosY());
     if (dam.getLista(aux, 0).getBool() == true){
       dam.getLista(aux, 0).setBool(false);
     }
   }
 }
public void insListas(List<Tuple> blancas, List<Tuple> negras){
  int i = 0;
  while (i<blancas.size()){
    blan.add(blancas.get(i));
  }
  i = 0;
  while (i<negras.size()){
    neg.add(negras.get(i));
  }
}
 public  void insTablero (int tam){
   int inBlancas = 0;
   int inNegras = 0;
   tamaño = tam;
   for (int i=0; i<tamaño; i++ ) {
      for (int j=0; j<tamaño; j++ ){
        Tuple auxDos = new Tuple(i, j);
        GrafNodo aux = new GrafNodo(auxDos);
        if ((blan.get(inBlancas).getPosX()==i) && (blan.get(inBlancas).getPosY()==j) &&  (inBlancas<blan.size())){
            aux.setBool(true);
            aux.setColor(0);//cero->blancas
            inBlancas++;
            blan.add(auxDos);
        }else if ((neg.get(inNegras).getPosX()==i) && (neg.get(inNegras).getPosY()==j)  &&  (inNegras<neg.size())){
              aux.setBool(true);
              aux.setColor(1);//Uno->Negras
              inNegras++;
              neg.add(auxDos);
        }
        dam.insFicha(aux);//nico cambie el insFicha y ahora directamente dado el nodo lo mete como una lista nuieva al grafo, te toca sumarle a la lista de cada nodo su adya..
      }
    }
 }
 private Tuple adyNegro(Tuple b){
   int pos = (b.getPosX()*tamaño +b.getPosY());
   for (int i=1; i<5; i++){
     if (dam.getLista(pos, i).getColor() == 1){
       if (dam.getLista(pos, i).getBool() == true){
         return dam.getLista(pos, i).getPos();
       }
     }
   }
   return null;
 }
 private boolean posibleSalto(Tuple b,Tuple n){
   if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == 1)){
     int x = b.getPosX()-2;
     int y = b.getPosY()-2;
     if (((x*tamaño + y)<dam.tam()) && (dam.getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == -1)){
     int x = b.getPosX()-2;
     int y = b.getPosY()+2;
     if (((x*tamaño + y)<dam.tam()) && (dam.getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == 1)){
     int x = b.getPosX()+2;
     int y = b.getPosY()-2;
     if (((x*tamaño + y)<dam.tam()) && (dam.getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == -1)){
     int x = b.getPosX()+2;
     int y = b.getPosY()+2;
     if (((x*tamaño + y)<dam.tam()) && (dam.getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   return false;
 }
private Tuple salto(Tuple b, Tuple n){
  Tuple aux = new Tuple(0, 0);
 if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == 1)){
   int x = b.getPosX()-2;
   int y = b.getPosY()-2;
   aux.setPos(x,y);
   }
 if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == -1)){
   int x = b.getPosX()-2;
   int y = b.getPosY()+2;
   aux.setPos(x,y);
 }
 if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == 1)){
   int x = b.getPosX()+2;
   int y = b.getPosY()-2;
   aux.setPos(x,y);
 }
 if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == -1)){
   int x = b.getPosX()+2;
   int y = b.getPosY()+2;
   aux.setPos(x,y);
 }
 return aux;
}
 public boolean camino (Tuple inicio){
   Tuple ady = adyNegro(inicio);
   if (posibleSalto(inicio, ady)){
     Tuple aux = new Tuple(inicio.getPosX(), inicio.getPosY());
     int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
     dam.getLista(pos,0).setBool(false);
     cam.add(aux);
     pos = (ady.getPosX()*tamaño + ady.getPosY());
     dam.getLista(pos,0).setBool(false);
     aux = salto(aux, ady);
     cam.add(aux);
   }
   else{
     return false;
   }
   while (cam.size()<=neg.size()){
     Tuple aux = new Tuple(0, 0); //La posicion del aux no importa, pues no la va a usar
     ady = adyNegro(aux);
     if (posibleSalto(inicio, ady)){
       int pos = (ady.getPosX()*tamaño + ady.getPosY());
       dam.getLista(pos,0).setBool(false);
       aux = salto(aux, ady);
       cam.add(aux);
     }
     else{
       int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
       dam.getLista(pos,0).setBool(false);
       cam.clear();
       desmarcarNegros();
       return false;
     }
   }
   return true;
 }
 public void mostrar(){
   if(!cam.isEmpty()){
     Tuple aux = cam.peek();
     cam.pop();
     mostrar();
     System.out.println(aux.mosTuple());
   }
 }

}
