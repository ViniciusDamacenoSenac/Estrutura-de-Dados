public class Lista {
    private No cabeca;

    public Lista() {
        this.cabeca = null;
    }
    public void Inserir(String nome, int idade) {
        No novoPet = new No(nome, idade);
        if (cabeca == null) {
            cabeca = novoPet;
        } else {
            No atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoPet);
        }
    }

    public void Imprimir() {
        if (cabeca == null) {
            System.out.println("A lista de pets está vazia.");
            return;
        }
        No atual = cabeca;
        while (atual != null) {
            System.out.println("Nome: " + atual.getNome() + ", Idade: " + atual.getIdade());
            atual = atual.getProximo();
        }
    }
    public static void main(String[] args) {

        Lista listaPets = new Lista();
        listaPets.Inserir("IA", 1);
        listaPets.Inserir("Thor", 13);
        listaPets.Inserir("King Kong", 10);

        System.out.println("\nLista de Pets:");
        listaPets.Imprimir();
    }
}
