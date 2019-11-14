public class ficha extends nodo implements Interficha {

  private  Int color;//0->B; 1->N;
  private  Int posX;-
  private  Int posY;

  public ficha (Int col,Int possX,Int possY){
    color=col;
    posX=possX;
    posY=possY;
  }
  public Int  getColor(){
    return color;
  }
  public int getPosX (){
    return posX;
  }
  public int getPosY (){
    return posY;
  }
  public void  setPosX( Int auxX,Int auxY){
    posX= auxX;
    posY= auxY;
  }
}
