package Damas;
import java.util.List;
import java.util.ArrayList;
public class Grafo implements interfaceGrafo {

  private List<List<GrafNodo>> graf;

  public Grafo (){
    List<List<GrafNodo>> graf = new ArrayList<List<GrafNodo>>();
  }
  public void insFicha(GrafNodo aux){
    List<GrafNodo> auxlist = new ArrayList<GrafNodo>();
    auxlist.add(aux);
    graf.add(auxlist);
  }

  public void hacerAdy (int tamaño){
    for (int i=0; i<graf.size(); i++){
      int x = graf.get(i).get(0).getX();
      int y = graf.get(i).get(0).getY();
      int pos;
      if (x-1>=0 && y-1>=0){
        pos=(((x-1)*tamaño)+y-1);
        graf.get(i).add(graf.get(pos).get(0));
      }
      if (x-1>=0 && y+1<tamaño){
        pos=(((x-1)*tamaño)+y+1);
        graf.get(i).add(graf.get(pos).get(0));
      }
      if (x+1<tamaño && y-1>=0){
        pos=(((x+1)*tamaño)+y-1);
        graf.get(i).add(graf.get(pos).get(0));
      }
      if (x+1<tamaño && y+1<tamaño){
        pos=(((x+1)*tamaño)+y+1);
        graf.get(i).add(graf.get(pos).get(0));
      }
    }
  }

}
