public class Tuple {
  public int x;
  public int y;

  public Tuple(int a, int b) {
    this.x = a;
    this.y = b;
  }
  public int getPosx(){
    return x;
  }
  public int getPosY(){
    return y;
  }
  public void setPos(int a,int b){
    x=a;
    y=b;
  }
  public void comparToX(Tuple pos){
    return (x-pos.getPosX());
  }
  public void comparToY(Tuple pos){
    return (y-pos.getPosy());
  }

  public String mosTuple(){
    return ("( " + x + ", " + y ")");
  }

}
