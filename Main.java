/*  Juego de damas que indica una posible jugada ganadora en un solo turno.
    @authors Bortol Juan Pablo, Lopez Ayrton Emilio, Rafti Soto Nicolas Ezequiel
*/
package jDamas;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main (String [ ] args) {
                  Dama tablero1 = new Dama(); //Creadora de tablero
                  List <Tuple> negras= new ArrayList <Tuple>();//Lista de fichas blancas.
                  List <Tuple> blancas= new ArrayList <Tuple>();//Lista de fichas negras.
                  int ancho=1000;//Tamaño del tablero.
                  Tuple fichaBlan1= new Tuple(9,0);//Crea Ficha en la posicion.
                  Tuple fichaBlan2= new Tuple(4,5);
                  Tuple fichaBlan3= new Tuple(3,8);
                  Tuple fichaNeg1= new Tuple(2,3);
                  Tuple fichaNeg2= new Tuple(2,5);
                  Tuple fichaNeg3= new Tuple(4,1);
                  Tuple fichaNeg4= new Tuple(4,3);
                  Tuple fichaNeg5= new Tuple(4,7);
                  Tuple fichaNeg6= new Tuple(6,1);
                  Tuple fichaNeg7= new Tuple(6,3);
                  Tuple fichaNeg8= new Tuple(6,7);
                  Tuple fichaNeg9= new Tuple(8,1);
                  Tuple fichaNeg10= new Tuple(8,3);
                  Tuple fichaNeg11= new Tuple(8,5);
                  blancas.add(fichaBlan1);//Inserta ficha en lista.
                  blancas.add(fichaBlan2);
                  blancas.add(fichaBlan3);
                  negras.add(fichaNeg1);//Inserta ficha en lista.
                  negras.add(fichaNeg2);
                  negras.add(fichaNeg3);
                  negras.add(fichaNeg4);
                  negras.add(fichaNeg5);
                  negras.add(fichaNeg6);
                  negras.add(fichaNeg7);
                  negras.add(fichaNeg8);
                  negras.add(fichaNeg9);
                  negras.add(fichaNeg10);
                  negras.add(fichaNeg11);

                  if(tablero1.jugadaGanadora(ancho,blancas,negras)){//Si existe un ficha que permita ganar, muestra su camino.
                    tablero1.mostrar();//Muestra el camino completo, desde la pos de inicio de la ficha que permite ganar en un turno;
                  }else{
                    System.out.println("El tablero ingresado no tiene solucion");  //System.out.println("No existe una ficha para terminar el juego en un turno.");//No encuentra ninguna ficha que permita ganar en un turno
                  }
    }
}
/*Ejemplo 1 (Existe ficha para ganar en un turno.)
List <Tuple> negras= new ArrayList <Tuple>(); //Crea lista de fichas negras.
List <Tuple> blancas= new ArrayList <Tuple>();//Crea lista de fichas blancas.
int ancho=5; //Tablero de 5*5(0..4x0..4).
Tuple fichaBlan= new Tuple(0,0);
Tuple fichaNeg1= new Tuple(1,1);
Tuple fichaNeg2= new Tuple(3,3);
blancas.add(fichaBlan);//Inserta ficha en lista.
negras.add(fichaNeg1);//Inserta ficha en lista.
negras.add(fichaNeg2);


Ejemplo 2= (Existe ficha para ganar en un turno.)
List <Tuple> negras= new ArrayList <Tuple>();//Lista de fichas blancas.
List <Tuple> blancas= new ArrayList <Tuple>();//Lista de fichas negras.
int ancho=10;//Tamaño del tablero.
Tuple fichaBlan1= new Tuple(9,0);//Crea Ficha en la posicion.
Tuple fichaBlan2= new Tuple(4,5);
Tuple fichaBlan3= new Tuple(3,8);
Tuple fichaNeg1= new Tuple(2,3);
Tuple fichaNeg2= new Tuple(2,5);
Tuple fichaNeg3= new Tuple(4,1);
Tuple fichaNeg4= new Tuple(4,3);
Tuple fichaNeg5= new Tuple(4,7);
Tuple fichaNeg6= new Tuple(6,1);
Tuple fichaNeg7= new Tuple(6,3);
Tuple fichaNeg8= new Tuple(6,7);
Tuple fichaNeg9= new Tuple(8,1);
Tuple fichaNeg10= new Tuple(8,3);
Tuple fichaNeg11= new Tuple(8,5);
blancas.add(fichaBlan1);//Inserta ficha en lista.
blancas.add(fichaBlan2);
blancas.add(fichaBlan3);
negras.add(fichaNeg1);//Inserta ficha en lista.
negras.add(fichaNeg2);
negras.add(fichaNeg3);
negras.add(fichaNeg4);
negras.add(fichaNeg5);
negras.add(fichaNeg6);
negras.add(fichaNeg7);
negras.add(fichaNeg8);
negras.add(fichaNeg9);
negras.add(fichaNeg10);
negras.add(fichaNeg11);

*Ejemplo 3 (No existe ficha para ganar en un turno.)
List <Tuple> negras= new ArrayList <Tuple>(); //Crea lista de fichas negras
List <Tuple> blancas= new ArrayList <Tuple>();//Crea lista de fichas blancas
int ancho=5; //Tablero de 5*5(0..4x0..4)
Tuple fichaBlan= new Tuple(1,0);
Tuple fichaNeg1= new Tuple(1,1);
Tuple fichaNeg2= new Tuple(3,3);
blancas.add(fichaBlan);//Inserta ficha en lista.
negras.add(fichaNeg1);
negras.add(fichaNeg2);//Inserta ficha en lista.
*/
