import java.util.ArrayList;
public class Grafo() implements interfaceGrafo {

  private List<List<GrafNodo()>> graf;

  public grafo (){
    List<List<GrafNodo()>> graf = new ArrayList<List<GrafNodo()>>();
  }
  public void insFicha(GrafNodo aux){
    List<GrafNodo()> auxlist = new ArrayList<GrafNodo()>();
    auxlist.add(aux);
    graf.add(auxlist);
  }
  /*public void insListaNodos(lista<Nodo> lis){
    int i=0;
    while (i<list.size()) {
      if (graf.get(i)==list.get(i)){
        graf.get(i).add(list)
      }
    }
  }*/

}
