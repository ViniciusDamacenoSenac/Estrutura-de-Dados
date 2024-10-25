public class Fila {
    ListaDuplamenteLigada lista = new ListaDuplamenteLigada();

    public void enfileirar(Pessoa pessoa) {
        lista.adicionar(pessoa);
    }

    public Pessoa desenfileirar() {
        Pessoa pessoa = (lista.inicio != null) ? lista.inicio.dado : null;
        lista.inicio = (lista.inicio != null) ? lista.inicio.proximo : null;
        lista.fim = (lista.inicio == null) ? null : lista.fim;
        if (lista.inicio != null) lista.inicio.anterior = null;
        return pessoa;
    }

    public void imprimirFila() {
        lista.imprimir();
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.enfileirar(new Pessoa("ViniciusDamaceno", "222.222.222-13", "Rua dos damaceno"));
        fila.enfileirar(new Pessoa("Senac", "333.333.333-22", "Rua da tortura"));

        System.out.println("Fila inicial:");
        fila.imprimirFila();

        System.out.println("\nDesenfileirando:");
        System.out.println(fila.desenfileirar());

        System.out.println("\nFila após desenfileirar:");
        fila.imprimirFila();
    }
}
