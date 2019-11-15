import java.util.ArrayList;
public class dama {

private Grafo() dam;
private List<Tuplas()> blan;
private List<Tuplas()> neg;

 public  damas (){
   Grafo dam =new Grafo();
   List<Tuplas()> blan = new   List<Tuplas()>;
   List<Tuplas()> neg = new   List<Tuplas()>;
 }

 public  void insTablero (int tamaño, List<Tuplas> blan, List<Tuplas> neg){
   int inBlancas = 0;
   int inNegras = 0;
   for (int i=0, i<tamaño, i++ ) {
      for (int j=0, j<tamaño, j++ ){
        Nodo() aux= new Nodo(Tuplas());
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
    lista<Nodo> list= new lista<Nodo>
    .
    .busco
    .el ady|
    .de cada
    .nod y lo sumo a
    .la lista jusnto
    .con el padre.
    .
    list.insListaNodos();
}
