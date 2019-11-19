package jDamas;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main (String [ ] args) {
                  Dama tablero1 = new Dama();
                  List <Tuple> listBlan= new ArrayList <Tuple>();
                  List <Tuple> listNeg= new ArrayList <Tuple>();
                  Tuple auxB= new Tuple(0,0);
                  Tuple auxN1= new Tuple(1,1);
                  Tuple auxN2= new Tuple(3,5);
                  Tuple auxN3 = new Tuple(5,3);
                  Tuple auxN4 = new Tuple(7,1);
                  Tuple auxN5 = new Tuple(3,4);
                  Tuple auxN6 = new Tuple(4,3);
                  Tuple auxN7 = new Tuple(0,3);
                  Tuple auxN8 = new Tuple(4,4);
                  Tuple auxN9 = new Tuple(1,4);
                  Tuple auxN10 = new Tuple(2,1);
                  listBlan.add(auxB);
                  listNeg.add(auxN1);
                  listNeg.add(auxN2);
                  listNeg.add(auxN3);
                  listNeg.add(auxN4);
                  /*listNeg.add(auxN5);
                  listNeg.add(auxN6);
                  listNeg.add(auxN7);
                  listNeg.add(auxN8);
                  listNeg.add(auxN9);
                  listNeg.add(auxN10);*/
                  tablero1.insListas(listBlan,listNeg);
                  tablero1.mergeSort(listBlan,listBlan.size());
                  tablero1.insTablero(8);
                  System.out.println(tablero1.camino(auxB));
                  tablero1.mostrar();
                  System.out.println ("Empezamos la ejecución del programa");
        //Aquí las instrucciones de inicio y control del programa

    }
}
