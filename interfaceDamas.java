package jDamas;
interface interfaceDamas{

  public void insListas(List<Tuple> blancas, List<Tuple> negras);
  public  void insTablero (int tamaño);
  public  Tuple adyaNegro (Tuple b);
  private boolean posibleSalto(Tuple b,Tuple n);
  private void desmarcarNegros();
  private Tuple salto(Tuple aux, Tuple ady);
  public boolean camino (Tuple inicio);
  public void mostrar();

}
