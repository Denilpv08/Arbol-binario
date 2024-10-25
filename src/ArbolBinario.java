public class ArbolBinario {
    private int preIndex = 0;

    // Construir el árbol binario usando preorden e inorden
    public Nodo construirArbol(char[] preorden, char[] inorden, int inInicio, int inFin) {
        if (inInicio > inFin) return null;

        // Crear el nodo raíz del árbol a partir del preorden
        Nodo nodo = new Nodo(preorden[preIndex++]);

        // Si el nodo no tiene hijos, regresarlo
        if (inInicio == inFin) return nodo;

        // Buscar la posición del nodo en inorden
        int inIndex = buscarEnInorden(inorden, inInicio, inFin, nodo.valor);

        // Construir los subárboles izquierdo y derecho
        nodo.izquierdo = construirArbol(preorden, inorden, inInicio, inIndex - 1);
        nodo.derecho = construirArbol(preorden, inorden, inIndex + 1, inFin);

        return nodo;
    }

    // Buscar un valor en el array inorden
    private int buscarEnInorden(char[] inorden, int inicio, int fin, char valor) {
        for (int i = inicio; i <= fin; i++) {
            if (inorden[i] == valor) return i;
        }
        return -1;
    }

    // Recorrido en postorden
    public void postorden(Nodo nodo) {
        if (nodo == null) return;
        postorden(nodo.izquierdo);
        postorden(nodo.derecho);
        System.out.print(nodo.valor + " ");
    }

    // Recorrido en preorden
    public void preorden(Nodo nodo) {
        if (nodo == null) return;
        System.out.print(nodo.valor + " ");
        preorden(nodo.izquierdo);
        preorden(nodo.derecho);
    }

    // Recorrido en inorden
    public void inorden(Nodo nodo) {
        if (nodo == null) return;
        inorden(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        inorden(nodo.derecho);
    }

    // Método para dibujar el árbol binario
    public void dibujarArbol(Nodo raiz) {
        dibujarArbol(raiz, 0);
    }

    private void dibujarArbol(Nodo nodo, int nivel) {
        if (nodo == null) return;

        // Primero, dibujar el subárbol derecho
        dibujarArbol(nodo.derecho, nivel + 1);

        // Imprimir el nodo actual con una indentación de acuerdo al nivel
        System.out.println("   ".repeat(nivel) + nodo.valor);

        // Luego, dibujar el subárbol izquierdo
        dibujarArbol(nodo.izquierdo, nivel + 1);
    }

    // Método para contar todos los nodos en el árbol
    public int contarNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        // Contar el nodo actual y sumar los nodos de los subárboles izquierdo y derecho
        return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
    }
}
