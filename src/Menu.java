import java.util.Scanner;

public class Menu {
    private final ArbolBinario arbol;
    private final Nodo raiz;

    public Menu() {
        // Dato de entrada
        char[] preorden = "GEAIBMCLDFKJH".toCharArray();
        char[] inorden = "IABEGLDCFMKHJ".toCharArray();

        // Inicializar el árbol y construirlo
        this.arbol = new ArbolBinario();
        this.raiz = arbol.construirArbol(preorden, inorden, 0, inorden.length - 1);
    }

    // Método para mostrar el menú y manejar la interacción con el usuario
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n---- Menú ----");
            System.out.println("1. Mostrar arbol en Preorden");
            System.out.println("2. Mostrar arbol en Inorden");
            System.out.println("3. Mostrar arbol en Postorden");
            System.out.println("4. Dibujar Árbol Binario");
            System.out.println("5. Contar Nodos del Árbol");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            // Ejecutar la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.print("Árbol en Preorden: ");
                    arbol.preorden(raiz);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Árbol en Inorden: ");
                    arbol.inorden(raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Árbol en Postorden: ");
                    arbol.postorden(raiz);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Dibujo del Árbol Binario:");
                    arbol.dibujarArbol(raiz);
                    break;
                case 5:
                    int totalNodos = arbol.contarNodos(raiz);
                    System.out.println("Total de nodos en el árbol: " + totalNodos);
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
