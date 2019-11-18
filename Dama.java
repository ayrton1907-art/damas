package jDamas;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class Dama{

  private List<List<GrafNodo>> dam;
  private List<Tuple>  blan;
  private List<Tuple>  neg;
  private Stack<Tuple>  cam;
  private int tamaño;

 public  Dama (){
   List<List<GrafNodo>> aux = new ArrayList<List<GrafNodo>>();
   List<Tuple> blan = new ArrayList<Tuple>() ;    //agregar que inserte los blancos y los negros y el tamaño
   List<Tuple>  neg = new ArrayList<Tuple>() ;
   Stack<Tuple>  cam= new Stack<Tuple>() ;
   int tamaño = 0;
   dam = aux;
 }

 public void insFicha(GrafNodo aux){
   System.out.println("sumo");
   List<GrafNodo> auxlist = new ArrayList<GrafNodo>();
   if (dam==null){
     System.out.println("asda");
   }
   auxlist.add(aux);
   dam.add(auxlist);
 }

 public GrafNodo getLista (int aux, int aux2){
   return dam.get(aux).get(aux2);
 }
 public int tam (){
   return tamaño;
 }
 public void hacerAdy (){
   for (int i=0; i<dam.size(); i++){
     int x = dam.get(i).get(0).getPos().getPosX();
     int y = dam.get(i).get(0).getPos().getPosY();
     int pos;
     System.out.print(dam.get(i).get(0).getPos().mosTuple());
     if (x-1>=0 && y-1>=0){
       pos=(((x-1)*tamaño)+(y-1));
       dam.get(i).add(dam.get(pos).get(0));
       System.out.print(String.valueOf(pos));
       System.out.print(dam.get(pos).get(dam.get(pos).size()-1).getPos().mosTuple());
     }
     if (x-1>=0 && y+1<tamaño){
       pos=(((x-1)*tamaño)+(y+1));
       dam.get(i).add(dam.get(pos).get(0));
       System.out.print(String.valueOf(pos));
       System.out.print(dam.get(pos).get(dam.get(pos).size()-1).getPos().mosTuple());
     }
     if (x+1<tamaño && y-1>=0){
       pos=(((x+1)*tamaño)+y-1);
       dam.get(i).add(dam.get(pos).get(0));
       System.out.print(String.valueOf(pos));
       System.out.print(dam.get(pos).get(dam.get(pos).size()-1).getPos().mosTuple());
     }
     if (x+1<tamaño && y+1<tamaño){
       pos=(((x+1)*tamaño)+y+1);
       dam.get(i).add(dam.get(pos).get(0));
       System.out.print(String.valueOf(pos));
        System.out.print(dam.get(pos).get(dam.get(pos).size()-1).getPos().mosTuple());
     }
     System.out.println(" ");
   }
 }
 //Pre-cond: La lista está ordenada.
 //Post:Listas de Pocisiones llenas.
public void insListas(List<Tuple> blancas, List<Tuple> negras){
  blan = blancas;
  System.out.println(blan.get(0).mosTuple());
  neg=negras;
  System.out.println(neg.get(0).mosTuple());
  System.out.println(neg.get(1).mosTuple());
}
public  void insTablero (int tam){
   int inBlancas = 0;
   int inNegras = 0;
   tamaño = tam;
   for (int i=0; i<tamaño; i++ ) {
      for (int j=0; j<tamaño; j++ ){
        Tuple auxDos = new Tuple(i, j);
        GrafNodo aux = new GrafNodo(auxDos);
        List<List<GrafNodo>> auxTres = new ArrayList<List<GrafNodo>>();
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
        List<GrafNodo> auxlist = new ArrayList<GrafNodo>();
        auxlist.add(aux);
        dam.add(auxlist);
      }
    }
    System.out.println("1");
    hacerAdy();
    System.out.println("2");
 }

 private Tuple adyNegro(Tuple b){
   int pos = (b.getPosX()*tamaño +b.getPosY());
   for (int i=1; i<5; i++){
     if (getLista(pos,i).getColor() == 1){
       if (getLista(pos, i).getBool() == true){
         return getLista(pos, i).getPos();
       }
     }
   }
   return null;
 }
 private boolean posibleSalto(Tuple b,Tuple n){
   if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == 1)){
     int x = b.getPosX()-2;
     int y = b.getPosY()-2;
     if (((x*tamaño + y)<tamaño) && (getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == -1)){
     int x = b.getPosX()-2;
     int y = b.getPosY()+2;
     if (((x*tamaño + y)<tamaño) && (getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == 1)){
     int x = b.getPosX()+2;
     int y = b.getPosY()-2;
     if (((x*tamaño + y)<tamaño) && (getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == -1)){
     int x = b.getPosX()+2;
     int y = b.getPosY()+2;
     if (((x*tamaño + y)<tamaño) && (getLista(x*tamaño+y,0).getBool() == false)){
       return true;
     }
   }
   return false;
 }
 //pre:True.
 //post:Retorna las fichas negras a su pocision original.
 private void desmarcarNegros(){
   int i = 0;
   while (i<neg.size()){
     Tuple porVer = neg.get(i);
     int aux = (porVer.getPosX()*tamaño + porVer.getPosY());
     if (getLista(aux, 0).getBool() == true){
       getLista(aux, 0).setBool(false);
     }
   }
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
     getLista(pos,0).setBool(false);
     cam.add(aux);
     pos = (ady.getPosX()*tamaño + ady.getPosY());
     getLista(pos,0).setBool(false);
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
       getLista(pos,0).setBool(false);
       aux = salto(aux, ady);
       cam.add(aux);
     }
     else{
       int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
       getLista(pos,0).setBool(false);
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
