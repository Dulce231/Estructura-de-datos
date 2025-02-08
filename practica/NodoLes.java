package practica;

public class NodoLes {
    int numart;
    String nomart;
    int existencia;
    NodoLes next;

    public NodoLes(int numart, String nomart, int existencia) {
        this.numart = numart;
        this.nomart = nomart;
        this.existencia = existencia;
        this.next = null;
    }
}