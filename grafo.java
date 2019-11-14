import java.util.ArrayList;
public class grafo() implements interfaceGrafo {

  private List<List<Nodo()>> graf;

  public grafo (){
    List<List<Nodo()>> graf = new ArrayList<List<Nodo()>>();
  }

  public void insFicha(Pair poss){
    boolean existe = false;
    for (int i=0; i<graf.size() && !existe; i++ ) {
      if (graf.get(i).get(0).getPosX() == fich.getPosX() && graf.get(i).get(0).getPosY() == fich.getPosY()){
        existe = true;
      }
    }
    if (!existe){
      List<Nodo()> auxGraf = new ArrayList<Nodo()>();
      auxGraf.add(fich);
      graf.add(auxGraf);
    }
  }
  

}
