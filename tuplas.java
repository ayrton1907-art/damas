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
  public void comparTo(Tuple() pos){
    if (pos.getPosX()==x && pos.getPosY()==y){
      return true;
    }
    return false;
  }

}
