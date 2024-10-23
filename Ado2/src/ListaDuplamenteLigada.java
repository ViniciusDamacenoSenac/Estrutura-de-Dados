public class ListaDuplamenteLigada {
    No inicio;
    No fim;

    public No buscar(String nome) {
        No atual = inicio;
        while (atual != null) {
            if (atual.dado.nome.equalsIgnoreCase(nome)) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void remover(String nome) {
        No atual = inicio;
        while (atual != null) {
            if (atual.dado.nome.equalsIgnoreCase(nome)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    fim = atual.anterior;
                }
                return;
            }
            atual = atual.proximo;
        }
    }

    public void concatenar(ListaDuplamenteLigada outraLista) {
        if (outraLista.inicio == null) return;
        if (this.fim == null) {
            this.inicio = outraLista.inicio;
        } else {
            this.fim.proximo = outraLista.inicio;
            outraLista.inicio.anterior = this.fim;
        }
        this.fim = outraLista.fim;
    }

    public ListaDuplamenteLigada[] separar() {
        ListaDuplamenteLigada lista1 = new ListaDuplamenteLigada();
        ListaDuplamenteLigada lista2 = new ListaDuplamenteLigada();

        No atual = inicio;
        boolean alterna = true;
        while (atual != null) {
            if (alterna) {
                lista1.adicionar(atual.dado);
            } else {
                lista2.adicionar(atual.dado);
            }
            alterna = !alterna;
            atual = atual.proximo;
        }
        return new ListaDuplamenteLigada[]{lista1, lista2};
    }

    public void adicionar(Pessoa pessoa) {
        No novoNo = new No(pessoa);
        if (fim == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }

    public static void main(String[] args) {

        ListaDuplamenteLigada lista1 = new ListaDuplamenteLigada();
        lista1.adicionar(new Pessoa("jacinto", "123.456.789-91", "Rua que, 478"));
        lista1.adicionar(new Pessoa("Janonis", "987.654.321-11", "Rua Jos"));

        ListaDuplamenteLigada lista2 = new ListaDuplamenteLigada();
        lista2.adicionar(new Pessoa("Karim", "789.222.333-44", "Rua Car"));
        lista2.adicionar(new Pessoa("Mary", "101.102.103.104-11", "Rua Der"));

        System.out.println("Lista 1:"); lista1.imprimir();
        System.out.println("\nLista 2:"); lista2.imprimir();

        System.out.println("\nConcatenando Lista 1 e Lista 2..."); lista1.concatenar(lista2);
        lista1.imprimir();

        System.out.println("\nSeparando a lista concatenada...");
        ListaDuplamenteLigada[] listasSeparadas = lista1.separar();

        System.out.println("Primeira lista separada:"); listasSeparadas[0].imprimir();
        System.out.println("\nSegunda lista separada:"); listasSeparadas[1].imprimir();


        String nomeParaBuscar = "mary";
        System.out.println("\nBuscando '" + nomeParaBuscar + "':"); No noEncontrado = lista1.buscar(nomeParaBuscar);
        System.out.println(noEncontrado != null ? "Pessoa encontrada: " + noEncontrado.dado : "Não encontrado");

        System.out.println("\nRemovendo '" + nomeParaBuscar + "':");
        lista1.remover(nomeParaBuscar);lista1.imprimir();

    }
}
