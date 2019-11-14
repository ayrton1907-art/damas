import java.util.ArrayList;
public class dama {

private grafo() damas;
private List<Nodo()> blancas;
private List<Nodo()> negras;

 public  damas (int tamaño, List<Pair> blan, List<Pair> neg){
   int blancas = 0;
   int negras = 0;
   for (int i=0, i<tamaño, i++ ) {
      for (int j=0, j<tamaño, j++ ){
        Nodo() aux= new Nodo(Pair);
        if (blan.get(blancas)==<i,j> && negras<neg.size()){
            aux.setBool(true);
            aux.setColor(0);
            blancas++;//cero->blancas
        }else if (neg.get(negras)==<Pair> && negras<neg.size()){
              aux.setBool(true);
              aux.setColor(1);//cero->blanca
              negras++;
        }
        damas.insFicha(Pair);
      }
    }
 }
}
