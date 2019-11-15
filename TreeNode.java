public class TreeNode {

	 /* Declaraciones de variables */
	 private Tuple Pos;
	 private Nodo padre;
	 private Nodo hojaIzquierda;
	 private Nodo hojaDerecha;

	 /* Constructor */
	 public Nodo(Tuple pos) {
			 this.Pos = pos;
	 }

	 public void setPos(Tuple pos) {
			 this.valor = pos;
	 }

	 public Tuple getPos() {
			 return pos;
	 }

	 public Nodo getPadre() {
			 return padre;
	 }

	 public void setPadre(Nodo padre) {
			 this.padre = padre;
	 }

	 public Nodo getHojaIzquierda() {
			 return hojaIzquierda;
	 }

	 public void setHojaIzquierda(Nodo hojaIzquierda) {
			 this.hojaIzquierda = hojaIzquierda;
	 }

	 public Nodo getHojaDerecha() {
			 return hojaDerecha;
	 }

	 public void setHojaDerecha(Nodo hojaDerecha) {
			 this.hojaDerecha = hojaDerecha;
	 }

}

	// recorrido inOrder
	public String printInOrder(){
		//Todo: Implementar este metodo
		return "";
	}

}
