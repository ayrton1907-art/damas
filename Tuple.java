package jDamas;
public class Tuple {
  public int x;
  public int y;

  public Tuple(int a, int b) {
    this.x = a;
    this.y = b;
  }
  public int getPosX(){
    return x;
  }
  public int getPosY(){
    return y;
  }
  public void setPos(int a,int b){
    x=a;
    y=b;
  }
  public int comparToX(Tuple pos){
    return x-pos.getPosX();
  }
  public int comparToY(Tuple pos){
    return y-pos.getPosY();
  }
  public String mosTuple(){
    return ('(' + String.valueOf(x) + ',' + String.valueOf(y) + ')');
  }

}
