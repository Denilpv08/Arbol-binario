public class Nodo {
    char valor;
    Nodo izquierdo, derecho;

    public Nodo(char valor) {
        this.valor = valor;
        this.izquierdo = this.derecho = null;
    }
}
