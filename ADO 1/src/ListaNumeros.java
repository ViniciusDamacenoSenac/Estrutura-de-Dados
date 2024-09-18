public class ListaNumeros {
    private NoNumero cabeca;

    public ListaNumeros() {
        this.cabeca = null;
    }

    public void Inserir(int numero) {
        NoNumero novoNumero = new NoNumero(numero);
        if (cabeca == null) {
            cabeca = novoNumero;
        } else {
            NoNumero atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNumero;
        }
    }

    public void ImprimirPares() {
        if (cabeca == null) {
            System.out.println("A lista de números está vazia.");
            return;
        }
        NoNumero atual = cabeca;
        while (atual != null) {
            if (atual.numero % 2 == 0) {
                System.out.println(atual.numero);
            }
            atual = atual.proximo;
        }
    }

    class NoNumero {
        int numero;
        NoNumero proximo;

        public NoNumero(int numero) {
            this.numero = numero;
            this.proximo = null;
        }
    }

    public static void main(String[] args) {
        // coloquei dessa maneira para ficar melhor visualmente, pq inserir diretamente ia ficar muita coisa.
        ListaNumeros listaNumeros = new ListaNumeros();
        int[] numeros = {18, 22, 2, 49, 99};
        for (int numero : numeros) {
            listaNumeros.Inserir(numero);
        }
        System.out.println("Números Pares:");
        listaNumeros.ImprimirPares();
    }
}
