package jDamas;
interface interfaceDamas{

  public void insListas(List<Tuple> blancas, List<Tuple> negras);
  public void mergeSort(List<Tuple> listNeg, int n);
  private void merge(List<Tuple> listNeg,List<Tuple> l, List<Tuple>  r, int left, int right);
  public  void insTablero (int tamaño);
  public  Tuple adyaNegro (Tuple b);
  private boolean posibleSalto(Tuple b,Tuple n);
  private void desmarcarNegros();
  private Tuple salto(Tuple aux, Tuple ady);
  public boolean camino (Tuple inicio);
  public void mostrar();

}
