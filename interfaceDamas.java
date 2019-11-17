package jDamas;
interface interfaceDamas{

  public  void insTablero (int tamaño, List<Tuple> blan, List<Tuple> neg);
  public  List<GrafNodo> adyaNodo (Grafo graf);
  private boolean posibleSalto(Tuple b,Tuple n);
  /private Tuple salto(Tuple aux, Tuple ady);
  public boolean camino (Tuple inicio);
  public void mostrar();

}
