public class Fila {
    ListaDuplamenteLigada lista = new ListaDuplamenteLigada();

    public void enfileirar(Pessoa pessoa) {
        lista.adicionar(pessoa);

    }

    public Pessoa desenfileirar() {
        if (lista.inicio == null) {
            return null;
        }
        Pessoa pessoa = lista.inicio.dado;
        lista.inicio = lista.inicio.proximo;

        if (lista.inicio != null) {
            lista.inicio.anterior = null;
        } else {
            lista.fim = null;
        }
        return pessoa;
    }

    public void imprimirFila() {
        lista.imprimir();
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.enfileirar(new Pessoa("Lucas", "222.222.222-13", "Rua L"));
        fila.enfileirar(new Pessoa("Bruna", "333.333.333-22", "Rua B"));

        System.out.println("Fila:");
        fila.imprimirFila();

        System.out.println("\nDesenfileirando:");
        System.out.println(fila.desenfileirar());
        System.out.println("Fila após desenfileirar:");
        fila.imprimirFila();
    }
}
