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
                  Tuple auxN2= new Tuple(3,3);
                  listBlan.add(auxB);
                  listNeg.add(auxN1);
                  listNeg.add(auxN2);
                  tablero1.insListas(listBlan,listNeg);
                  tablero1.insTablero(5);
                  System.out.println ("Empezamos la ejecución del programa");
        //Aquí las instrucciones de inicio y control del programa

    }

}
