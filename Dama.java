package jDamas;
import java.util.ArrayList;
import java.util.List;
public class Dama{

  private List<List<GrafNodo>> dam;
  private List<Tuple>  blan;
  private List<Tuple>  neg;
  private List<Tuple>  cam;
  private int tamaño;

 public  Dama (){
   List<List<GrafNodo>> aux = new ArrayList<List<GrafNodo>>();
   List<Tuple> blan = new ArrayList<Tuple>() ;    //agregar que inserte los blancos y los negros y el tamaño
   List<Tuple>  neg = new ArrayList<Tuple>() ;
   List<Tuple>  auxi= new ArrayList<Tuple>() ;
   tamaño = 0;
   dam = aux;
   cam = auxi;
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

 public List<GrafNodo> get (int aux){
   return dam.get(aux);
 }
 public int tam (){
   return tamaño;
 }
 public void hacerAdy (){
   for (int i=0; i<dam.size(); i++){
     int x = dam.get(i).get(0).getPos().getPosX();
     int y = dam.get(i).get(0).getPos().getPosY();
     int pos;
     if (x-1>=0 && y-1>=0){
       pos=(((x-1)*tamaño)+(y-1));
       dam.get(i).add(dam.get(pos).get(0));
     }
     if (x-1>=0 && y+1<tamaño){
       pos=(((x-1)*tamaño)+(y+1));
       dam.get(i).add(dam.get(pos).get(0));
     }
     if (x+1<tamaño && y-1>=0){
       pos=(((x+1)*tamaño)+y-1);
       dam.get(i).add(dam.get(pos).get(0));
     }
     if (x+1<tamaño && y+1<tamaño){
       pos=(((x+1)*tamaño)+y+1);
       dam.get(i).add(dam.get(pos).get(0));
     }
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
        if(inBlancas<blan.size()) {
            if ((blan.get(inBlancas).getPosX()==i) && (blan.get(inBlancas).getPosY()==j)){
                aux.setBool(true);
                aux.setColor(0);//cero->blancas
                inBlancas++;
            }
       }
       else if (inNegras<neg.size()) {
           if ((neg.get(inNegras).getPosX()==i) && (neg.get(inNegras).getPosY()==j)){
               aux.setBool(true);
               aux.setColor(1);//Uno->Negras
               inNegras++;
           }
        }
        List<GrafNodo> auxlist = new ArrayList<GrafNodo>();
        auxlist.add(aux);
        dam.add(auxlist);
      }
    }
    hacerAdy();
 }

 private Tuple adyNegro(Tuple b){
   int pos = (b.getPosX()*tamaño +b.getPosY());
   for (int i=1; i<dam.get(pos).size(); i++){
     if (dam.get(pos).get(i).getColor() == 1){
       if (dam.get(pos).get(i).getBool() == true){
         return dam.get(pos).get(i).getPos();
       }
     }
   }
   return null;
 }
 private boolean posibleSalto(Tuple b,Tuple n){
   if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == 1)){
     int x = b.getPosX()-2;
     int y = b.getPosY()-2;
     System.out.println("c");
     if (((x*tamaño + y)<tamaño) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
         System.out.println("a");
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == -1)){
     int x = b.getPosX()-2;
     int y = b.getPosY()+2;
     if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == 1)){
     int x = b.getPosX()+2;
     int y = b.getPosY()-2;
     if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
       return true;
     }
   }
   if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == -1)){
     int x = b.getPosX()+2;
     int y = b.getPosY()+2;
     if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
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
       System.out.println("aaa");
     Tuple porVer = neg.get(i);
     int aux = (porVer.getPosX()*tamaño + porVer.getPosY());
     if (dam.get(aux).get(0).getBool() == false){
         dam.get(aux).get(0).setBool(true);
     }
     i++;
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
   if(ady == null) {
       return false;
   }
   List<Tuple> auxiliar = new ArrayList<Tuple>() ;
   Tuple aux = new Tuple(inicio.getPosX(), inicio.getPosY());

   if (posibleSalto(inicio, ady)){
     System.out.println(aux.mosTuple());
     int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
     dam.get(pos).get(0).setBool(false);
     auxiliar.add(aux);
     System.out.println(String.valueOf(auxiliar.get(auxiliar.size()-1).mosTuple()));
     pos = (ady.getPosX()*tamaño + ady.getPosY());
     dam.get(pos).get(0).setBool(false);
     aux = salto(aux, ady);
     auxiliar.add(aux);
     System.out.println(aux.mosTuple());
   }
   while (auxiliar.size()<=neg.size()){
     ady = adyNegro(aux);
     if (ady == null) {
         System.out.println("1");
         int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
         System.out.println("2");
         System.out.println(dam.get(pos).get(0).getBool());
         dam.get(pos).get(0).setBool(true);
         System.out.println(dam.get(pos).get(0).getBool());
         System.out.println("3");
         auxiliar.clear();
         System.out.println("4");
         desmarcarNegros();
         System.out.println("5");
         return false;
     }
     if (posibleSalto(aux, ady)){
       int pos = (ady.getPosX()*tamaño + ady.getPosY());
       dam.get(pos).get(0).setBool(false);
       aux = salto(aux, ady);
       auxiliar.add(aux);
       System.out.println(auxiliar.get(auxiliar.size()-1).mosTuple());
     }
   }
   cam = auxiliar;
   return true;
 }
 public void mostrar(){
   for (int i=0; i<cam.size(); i++) {
       System.out.println(cam.get(i).mosTuple());
   }
 }
}
