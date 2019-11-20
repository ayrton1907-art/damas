package jDamas;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main (String [ ] args) {
                  Dama tablero1 = new Dama();
                  List <Tuple> negras= new ArrayList <Tuple>();
                  List <Tuple> blancas= new ArrayList <Tuple>();
                  int ancho=5; //Tablero de 5*5(0..4x0..4)
                  Tuple auxB= new Tuple(0,0);
                  Tuple auxN1= new Tuple(1,1);
                  Tuple auxN2= new Tuple(3,3);
                  blancas.add(auxB);
                  negras.add(auxN1);
                  negras.add(auxN2);


                  if(tablero1.jugadaGanadora(ancho,blancas,negras)){//Si existe un ficha que permita ganar, muestra su camino.
                    tablero1.mostrar();//Muestra el camino completo, desde la pos de inicio de la ficha que permite ganar en un turno;
                  }else{
                    System.out.println("no funca");  //System.out.println("No existe una ficha para terminar el juego en un turno.");//No encuentra ninguna ficha que permita ganar en un turno
                  }





        //Aquí las instrucciones de inicio y control del programa
    }
}
/*Ejemplo 1 (Existe ficha para ganar en un turno.)
List <Tuple> negras= new ArrayList <Tuple>();
List <Tuple> blancas= new ArrayList <Tuple>();
int ancho=5; //Tablero de 5*5(0..4x0..4)
Tuple auxB= new Tuple(0,0);
Tuple auxN1= new Tuple(1,1);
Tuple auxN2= new Tuple(3,3);
blancas.add(auxB);
negras.add(auxN1);
negras.add(auxN2);


Ejemplo 2=
List <Tuple> negras= new ArrayList <Tuple>();//Lista de fichas blancas
List <Tuple> blancas= new ArrayList <Tuple>();//Lista de fichas negras
int ancho=10;//Tamaño del tablero
Tuple auxB1= new Tuple(9,0);
Tuple auxB2= new Tuple(4,5);
Tuple auxB3= new Tuple(3,8);
Tuple auxN1= new Tuple(2,3);
Tuple auxN2= new Tuple(2,5);
Tuple auxN3= new Tuple(4,1);
Tuple auxN4= new Tuple(4,3);
Tuple auxN5= new Tuple(4,7);
Tuple auxN6= new Tuple(6,1);
Tuple auxN7= new Tuple(6,3);
Tuple auxN8= new Tuple(6,7);
Tuple auxN9= new Tuple(8,1);
Tuple auxN10= new Tuple(8,3);
Tuple auxN11= new Tuple(8,5);
blancas.add(auxB1);
blancas.add(auxB2);
blancas.add(auxB3);
negras.add(auxN1);
negras.add(auxN2);
negras.add(auxN3);
negras.add(auxN4);
negras.add(auxN5);
negras.add(auxN6);
negras.add(auxN7);
negras.add(auxN8);
negras.add(auxN9);
negras.add(auxN10);
negras.add(auxN11);

*/
