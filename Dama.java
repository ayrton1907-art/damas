import java.util.ArrayList;
public class Dama implements interfaceDamas{

  private Grafo() dam;
  private List<Tuplas()> blan;
  private List<Tuplas()> neg;
  private List<Tuplas()> camino;
  private int tamaño;

 public  Dama (){
   Grafo dam =new Grafo();
   List<Tuplas()> blan = new List<Tuplas()>;
   List<Tuplas()> neg = new List<Tuplas()>;
   List<Tuplas()> camino = new List<Tuplas()>;
   int tamaño = 0;
 }
 public radixSort(list<Tuplae> listFich){

   Tuple aux=

 }

 public boolean camino (tuple() inicio){
   tuple() ady = adyNegro(inicio);
   if (posibleSalto(inicio, ady)){
     tuple() aux = new tuple();
     aux = inicio;
     int pos = (inicio.getX()*tamaño + inicio.getY());
     dam.get(pos).get(0).setBool(false);
     camino.add(aux);
     int pos = (ady.getX()*tamaño + ady.getY());
     dam.get(pos).get(0).setBool(false);
     aux = salto(aux, ady);
     camino.add(aux);
   }
   else{
     return false;
   }
   while (camino.size()<=neg.size()){
     ady = adyNegro(aux);
     if (posibleSalto(inicio, ady)){
       pos = (ady.getX()*tamaño + ady.getY());
       dam.get(pos).get(0).setBool(false);
       aux = salto(aux, ady);
       camino.add(aux);
     }
     else{
       int pos = (inicio.getX()*tamaño + inicio.getY());
       dam.get(pos).get(0).setBool(false);
       camino.clear();
       desmarcarNegros();
       return false;
     }
   }
   return true;
 }

 private void desmarcarNegros(){

 }

 private tuple() adyNegro(tuple() b){
   int pos = (b.getX()*tamaño +b.getY());
   for (int i=1, i<graf.get(pos).size(), i++){
     if (dam.get(pos).get(i).getColor() == 1){
       if (dam.get(pos).get(i).getBool() == true){
         return dam.get(pos).get(i).getPos();
       }
     }
   }
   return nil;
 }

 private boolean posibleSalto(tuple() b, tuple() n){
   if (n == nil){
     return false;
   }
   if ((b.getX()-n.getX() == 1) && (b.getY() - n.getY() == 1)){
     int x = b.getX()-2;
     int y = b.getY()-2;
     if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
       return true;
     }
   }
   if ((b.getX()-n.getX() == 1) && (b.getY() - n.getY() == -1)){
     int x = b.getX()-2;
     int y = b.getY()+2;
     if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
       return true;
     }
   }
   if ((b.getX()-n.getX() == -1) && (b.getY() - n.getY() == 1)){
     int x = b.getX()+2;
     int y = b.getY()-2;
     if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
       return true;
     }
   }
   if ((b.getX()-n.getX() == -1) && (b.getY() - n.getY() == -1)){
     int x = b.getX()+2;
     int y = b.getY()+2;
     if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getBool() == false)){
       return true;
     }
   }
 }

 public void mostrar(){
   if(!camino.isEmpy()){
     tuple aux = camino.top();
     camino.pop();
     mostrar();
     System.out.println(aux.mosTuple());
   }
 }








 public  void insTablero (int tamaño, List<Tuplas> blan, List<Tuplas> neg){
   int inBlancas = 0;
   int inNegras = 0;
   for (int i=0, i<tamaño, i++ ) {
      for (int j=0, j<tamaño, j++ ){
        GrafNodo() aux= new GrafNodo(Tuplas());
        if (blan.get(inBlancas)==<i,j> && inBlancas<blan.size()){
            aux.setBool(true);
            aux.setColor(0);//cero->blancas
            inBlancas++;
        }else if (neg.get(inNegras)==<Pair> && inNegras<neg.size()){
              aux.setBool(true);
              aux.setColor(1);//Uno->Negras
              inNegras++;
        }
        dam.insFicha(aux);//nico cambie el insFicha y ahora directamente dado el nodo lo mete como una lista nuieva al grafo, te toca sumarle a la lista de cada nodo su adya..
      }
    }
 }

  public  lista<Nodos> adyaNodo (Grafo graf){
    list<GrafNodo()> list= new lista<GrafNodo()>;



    list.insListaNodos();
  }

}
