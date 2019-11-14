import java.util.ArrayList;
public class grafo() implements interfaceGrafo {

  private List<List<Nodo()>> graf;

  public grafo (){
    List<List<Nodo()>> graf = new ArrayList<List<Nodo()>>();
  }

  /*public void insFicha(Pair poss){
    boolean existe = false;//no es nec, xq las pos son todas des pos-condicon.
    for (int i=0; i<graf.size() && !existe; i++ ) {
      if (graf.get(i).get(0).getPos() == fich.getPosX()){
        existe = true;
      }
    }
    if (!existe){
      List<Nodo()> auxGraf = new ArrayList<Nodo()>();
      auxGraf.add(fich);
      graf.add(auxGraf);
    }
  }*/
  public void insFicha(Nodo aux){
    List<Nodo()> auxGraf = new ArrayList<Nodo()>();
    auxGraf.add(aux);
    graf.add(auxGraf);
  }
  public void insListaNodos(lista<Nodo> lis){
    int i=0;
    while (i<list.size()) {
      if (graf.get(i)==list.get(i)){
        graf.get(i).add(list)
      }//nico en la busqueda del ady tambien ponele en la lista el elemnto raiz por asi decirle... o sea el padre de todos..
    }
  }



}
