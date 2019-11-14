import java.util.ArrayList;
public class dama {

private grafo() damas;
private List<Nodo()> blan;
private List<Nodo()> neg;

 public  damas (int tamaño, List<Pair> blan, List<Pair> neg){
   int inBlancas = 0;
   int inNegras = 0;
   for (int i=0, i<tamaño, i++ ) {
      for (int j=0, j<tamaño, j++ ){
        Nodo() aux= new Nodo(Pair);
        if (blan.get(inBlancas)==<i,j> && inBlancas<blan.size()){
            aux.setBool(true);
            aux.setColor(0);//cero->blancas
            inBlancas++;
        }else if (neg.get(inNegras)==<Pair> && inNegras<neg.size()){
              aux.setBool(true);
              aux.setColor(1);//Uno->Negras
              inNegras++;
        }
        damas.insFicha(aux);//nico cambie el insFicha y ahora directamente dado el nodo lo mete como una lista nuieva al grafo, te toca sumarle a la lista de cada nodo su adya..
      }
    }
 }
  public  lista<Nodos> adyaNodo (Grafo graf){
    lista<Nodo> list= new lista<Nodo>
    list.insListaNodos();
}
