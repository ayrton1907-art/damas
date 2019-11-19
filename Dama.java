package jDamas;
import java.util.ArrayList;
import java.util.List;
public class Dama{

  private List<List<GrafNodo>> dam; //Grafo para encontrar caminos
  private List<Tuple>  blan; //Lista de fichas Blancas con sus posiciones
  private List<Tuple>  neg; //Lista de fichas Negras con sus posiciones
  private List<Tuple>  cam;//Lista de posiciones del camino resolutivo.
  private int tamaño; //Tamaño del tablero

//@Post: Constructor de la clase Dama.
 public  Dama (){//probar cambiar aux y aux 2
   List<List<GrafNodo>> aux = new ArrayList<List<GrafNodo>>();
   List<Tuple> blan = new ArrayList<Tuple>() ;
   List<Tuple> neg = new ArrayList<Tuple>() ;
   List<Tuple> aux2= new ArrayList<Tuple>() ;
   tamaño = 0;
   dam = aux;
   cam = aux2;
 }
 //Pre-cond: La lista está ordenada.
 //Post:Listas de Pocisiones llenas.
 public void insListas(List<Tuple> blancas, List<Tuple> negras){
   blan = blancas;
   neg  = negras;
 }
 public void mergeSort(List<Tuple> listOrd, int n) {
      if (n <= 1) {
          return;
      }
      int mid = n / 2;
      List<Tuple> l = new ArrayList<Tuple>() ;//[mid];
      List<Tuple> r = new ArrayList<Tuple>() ;//[n - mid];
      for (int i = 0; i < mid; i++) {
          l.add(listOrd.get(i));
      }
      for (int i = mid; i < n; i++) {
          r.add(listOrd.get(i));
      }
      mergeSort(l, mid);
      mergeSort(r, n-mid);
      merge(listOrd, l, r, mid, n- mid);
 }
 public static void merge(List<Tuple> listOrd,List<Tuple> l, List<Tuple>  r, int left, int right){
	   int i = 0;
     int j = 0;
     int k = 0;
     Tuple elemL= new Tuple(0,0);
     Tuple elemR= new Tuple(0,0);
	   while (i < left && j < right) {
          elemL=l.get(i);
          elemR=r.get(j);
     if ((elemL.comparToX(elemR))<0) {//if (l[i] <= r[j])
					listOrd.set(k,l.get(i));
          i++;
          k++;
		 }
		 else if ((elemL.comparToX(elemR))==0){
              if ((elemL.comparToY(elemR))<0){
                  listOrd.set(k,l.get(i));
                  i++;
                  k++;
             }
             else{
                 listOrd.set(k,r.get(j));
                 j++;
                 k++;
            }
			    }
          else{
              listOrd.set(k,r.get(j));
              j++;
              k++;
         }

	    }
	  while (i < left) {
       listOrd.set(k,l.get(i));
       i++;
       k++;
	  }
	 while (j < right) {
      listOrd.set(k,r.get(j));
      j++;
      k++;
	 }
}
public void insTablero (int tam){
   int inBlancas = 0;
   int inNegras = 0;
   tamaño = tam;
   for (int i=0; i<tamaño; i++ ) {
          for (int j=0; j<tamaño; j++ ){
                Tuple posFicha = new Tuple(i, j);
                GrafNodo ficha = new GrafNodo(posFicha);
                if(inBlancas<blan.size()) {
                    if ((blan.get(inBlancas).getPosX()==i) && (blan.get(inBlancas).getPosY()==j)){
                            ficha.setFicha(true);
                            ficha.setColor(0);
                            inBlancas++;
                    }
                }
                if (inNegras<neg.size()) {
                        if ((neg.get(inNegras).getPosX()==i) && (neg.get(inNegras).getPosY()==j)){
                            ficha.setFicha(true);
                            ficha.setColor(1);
                            inNegras++;
                       }
                    }
                List<GrafNodo> listaFicha = new ArrayList<GrafNodo>();
              listaFicha.add(ficha);
              dam.add(listaFicha);
            }
    }
    hacerAdy();
 }
 private Tuple adyNegro(Tuple b){
      int pos = (b.getPosX()*tamaño +b.getPosY());
      for (int i=1; i<dam.get(pos).size(); i++){
            if (dam.get(pos).get(i).getColor() == 1){
                  if (dam.get(pos).get(i).getFicha() == true){
                      return dam.get(pos).get(i).getPos();
                  }
            }
      }
      Tuple aux = new Tuple(tamaño, tamaño);
      return aux;
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

  private boolean posibleSalto(Tuple b,Tuple n){
          if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == 1)){
                  int x = b.getPosX()-2;
                  int y = b.getPosY()-2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == -1)){
                  int x = b.getPosX()-2;
                  int y = b.getPosY()+2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == 1)){
                  int x = b.getPosX()+2;
                  int y = b.getPosY()-2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == -1)){
                  int x = b.getPosX()+2;
                  int y = b.getPosY()+2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          return false;
 }
 //pre:True.
 //post:Retorna las fichas negras a su posicion original.
 private void desmarcarNegros(){
      int i = 0;
      while (i<neg.size()){
            Tuple porVer = neg.get(i);
            int pos = (porVer.getPosX()*tamaño + porVer.getPosY());
            if (dam.get(pos).get(0).getFicha() == false){
                    dam.get(pos).get(0).setFicha(true);
            }
            i++;
      }
 }

 private Tuple salto(Tuple b, Tuple n){
      Tuple saltar = new Tuple(0, 0); //el (0,0) no importa
      if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == 1)){
                  int x = b.getPosX()-2;
                  int y = b.getPosY()-2;
                  saltar.setPos(x,y);
      }
      if ((b.getPosX()-n.getPosX() == 1) && (b.getPosY() - n.getPosY() == -1)){
                  int x = b.getPosX()-2;
                  int y = b.getPosY()+2;
                  saltar.setPos(x,y);
      }
      if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == 1)){
                  int x = b.getPosX()+2;
                  int y = b.getPosY()-2;
                  saltar.setPos(x,y);
      }
      if ((b.getPosX()-n.getPosX() == -1) && (b.getPosY() - n.getPosY() == -1)){
                  int x = b.getPosX()+2;
                  int y = b.getPosY()+2;
                  saltar.setPos(x,y);
      }
      return saltar;
}
public boolean camino (Tuple inicio){
     Tuple ady = adyNegro(inicio);
     Tuple auxi = new Tuple(tamaño, tamaño);
     if(ady == auxi) {
           return false;
     }
     List<Tuple> sendero = new ArrayList<Tuple>() ;
     Tuple fichaBlanca = new Tuple(inicio.getPosX(), inicio.getPosY());
     if (posibleSalto(inicio, ady)){
           int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
           dam.get(pos).get(0).setFicha(false);
           sendero.add(fichaBlanca);
           pos = (ady.getPosX()*tamaño + ady.getPosY());
           dam.get(pos).get(0).setFicha(false);
           fichaBlanca = salto(fichaBlanca, ady);
           sendero.add(fichaBlanca);
     }
     while (sendero.size()<=neg.size()){
           ady = adyNegro(fichaBlanca);
           Tuple aux = new Tuple(tamaño,tamaño);
           if (ady == aux) {
                   int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
                   dam.get(pos).get(0).setFicha(true);
                   sendero.clear();
                   desmarcarNegros();
                   return false;
           }
           if (posibleSalto(fichaBlanca, ady)){
                   int pos = (ady.getPosX()*tamaño + ady.getPosY());
                   dam.get(pos).get(0).setFicha(false);
                   fichaBlanca = salto(fichaBlanca, ady);
                   sendero.add(fichaBlanca);
           }
           else{
             int pos = (inicio.getPosX()*tamaño + inicio.getPosY());
             dam.get(pos).get(0).setFicha(true);
             sendero.clear();
             desmarcarNegros();
             return false;
           }
    }
    cam = sendero;
    return true;
}
 public boolean caminos(){
  int i = 0;
   while (i < blan.size()){
         if (camino(blan.get(i))){
          return (true);
         }
      i++;
   }
    return false;
  }
 public  boolean  jugadaGanadora (int ancho, List<Tuple> blancas, List<Tuple> negras){
   insListas(blancas,negras);
    mergeSort(blan,blan.size());
   mergeSort(neg,neg.size());
   insTablero(ancho);
  return caminos();
}
 public void mostrar(){
   for (int i=0; i<cam.size(); i++) {
       System.out.println(cam.get(i).mosTuple());
   }
 }
}
