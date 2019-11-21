/*  Juego de damas que indica una posible jugada ganadora en un solo turno.
    @authors Bortol Juan Pablo, Lopez Ayrton Emilio, Rafti Soto Nicolas Ezequiel
*/
package jDamas;
import java.util.ArrayList;
import java.util.List;
public class Dama implements interfaceDamas{

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
 //@Pre-cond:True
 //@Post: cambia el valor de las listas del grafo con las dadas por el usuario
 //@Param: blancas ->Lista de fichas blancas, negras->Lista de fichas Negras
 public void insListas(List<Tuple> blancas, List<Tuple> negras){
   blan = blancas;
   neg  = negras;
 }
//@Pre-cond: Lista no vacia.
//@Post: La lista está ordenada.
//@Param: listOrd->lista, n->longitud de la misma.
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


 /* @Pre: 0 <= begin, mid, end <= array.lenght
 // @Post:: mezcla dos partes consecutivas de array
 // @Param: listOrd->lista, l->Una de las mitades pasadas,r->La otra mitad pasada,left->indice de una de las Listas.
    right-> Indice de la otra lista.
 */
 public  void merge(List<Tuple> listOrd,List<Tuple> l, List<Tuple>  r, int left, int right){
	   int i = 0;
     int j = 0;
     int k = 0;
     Tuple elemL= new Tuple(0,0);
     Tuple elemR= new Tuple(0,0);
	   while (i < left && j < right) {
          elemL=l.get(i);
          elemR=r.get(j);
     if ((elemL.comparToX(elemR))<0) {
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
//@Pre-cond: Tanto las listas de fichas blancas como de negras no tienen que estar vacia.
//@Post-cond:Arma las listas que van a indicar en que posicion del tablero está cada ficha.
//@Param:tam-> Indica el tamaño del tablero
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
 //@Pre-cond:El tablero tiene que estar insertado.
 //@Post-cond:Arma las listas de Nodos adyacentes.
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
  //@Pre-cond: la tupla debe existir.
  //@Post: Indica una posicion.
  //@Param: fichaBlanca->Tupla de enteros.
   public Tuple adyNegro(Tuple  fichaBlanca){
        int pos = (fichaBlanca.getPosX()*tamaño +fichaBlanca.getPosY());
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
    //@Pre-cond: El tablero debe estar insertado.
    //@Post-cond: Indica si una ficha puede realizar un salto.
    //@Param:fichaBlanca-> ficha blanca a indicar el salto, fichaNegra->posible posicion de una ficha negra.
    public boolean posibleSalto(Tuple fichaBlanca,Tuple fichaNegra){
          if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == 1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == 1)){
                  int x = fichaBlanca.getPosX()-2;
                  int y = fichaBlanca.getPosY()-2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == 1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == -1)){
                  int x = fichaBlanca.getPosX()-2;
                  int y = fichaBlanca.getPosY()+2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == -1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == 1)){
                  int x = fichaBlanca.getPosX()+2;
                  int y = fichaBlanca.getPosY()-2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == -1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == -1)){
                  int x = fichaBlanca.getPosX()+2;
                  int y = fichaBlanca.getPosY()+2;
                  if (((x*tamaño + y)<dam.size()) && (dam.get(x*tamaño+y).get(0).getFicha() == false)){
                          return true;
                  }
          }
          return false;
 }
 //@Pre-cond: posibleSalto(fichaBlanca,fichaNegra)=True.
 //@Post-cond:Cambia de posicion a fichaBlanca por el adyacente a fichaNegra.
 //@Param:fichaBlanca->Ficha que pretende saltar.  fichaNegra->ficha a saltar.
 public Tuple salto(Tuple fichaBlanca, Tuple fichaNegra){
      Tuple saltar = new Tuple(0, 0); //el (0,0) no importa
      if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == 1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == 1)){
                  int x = fichaBlanca.getPosX()-2;
                  int y = fichaBlanca.getPosY()-2;
                  saltar.setPos(x,y);
      }
      if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == 1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == -1)){
                  int x = fichaBlanca.getPosX()-2;
                  int y = fichaBlanca.getPosY()+2;
                  saltar.setPos(x,y);
      }
      if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == -1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == 1)){
                  int x = fichaBlanca.getPosX()+2;
                  int y = fichaBlanca.getPosY()-2;
                  saltar.setPos(x,y);
      }
      if ((fichaBlanca.getPosX()-fichaNegra.getPosX() == -1) && (fichaBlanca.getPosY() - fichaNegra.getPosY() == -1)){
                  int x = fichaBlanca.getPosX()+2;
                  int y = fichaBlanca.getPosY()+2;
                  saltar.setPos(x,y);
      }
      return saltar;
}
//@Pre-cond:El tablero debe estar cargado con las listas.
//@Post-cond:Indica si es posible ganar con una ficha en especifico en un solo turno.
//@Param: inicio->posicion de la ficha desde la cual se pretende ganar el juego.
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
//pre:True.
//post:Retorna las fichas negras a su posicion original.
public void desmarcarNegros(){
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
//@Pre-cond:El tablero debe estar cargado con las listas.
//@Post-cond:Indica si hay almenos una ficha que gane el juego en un solo turno.
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
  //@Pre-cond:Las listas a cargar no deben estar vacias.
  //@Post-cond: Arma el tablero del juego e idica si existe una jugada ganadora.
  //@Param: ancho-> anchodel tablero, blancas->lista de fichas blancas, negras->lista de fichas negras.
 public  boolean  jugadaGanadora (int ancho, List<Tuple> blancas, List<Tuple> negras){
   insListas(blancas,negras);
    mergeSort(blan,blan.size());
   mergeSort(neg,neg.size());
   insTablero(ancho);
  return caminos();
}
//@Pre-cond: cam no puede estar vacio.
//@Post-cond:Muestra el camino ganador.
 public void mostrar(){
   for (int i=0; i<cam.size(); i++) {
       System.out.println(cam.get(i).mosTuple());
   }
 }
}
