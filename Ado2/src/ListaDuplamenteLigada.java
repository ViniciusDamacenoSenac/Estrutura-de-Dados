public class ListaDuplamenteLigada {
    No inicio;
    No fim;

    public No buscar(String nome) {
        No atual = inicio;
        while (atual != null && !atual.dado.nome.equalsIgnoreCase(nome)) {
            atual = atual.proximo;
        }
        return atual;
    }

    public boolean remover(String nome) {
        No atual = buscar(nome);
        if (atual == null) return false;
        No anterior = atual.anterior;
        No proximo = atual.proximo;
        if (anterior != null) anterior.proximo = proximo;
        inicio = (anterior == null) ? proximo : inicio;
        if (proximo != null) proximo.anterior = anterior;
        fim = (proximo == null) ? anterior : fim;
        return true;
    }

    public void concatenar(ListaDuplamenteLigada outraLista) {
        if (outraLista.inicio == null) return;
        fim = (fim == null) ? outraLista.inicio : fim;
        inicio = (fim == outraLista.inicio) ? outraLista.inicio : inicio;
        if (fim != outraLista.inicio) {
            fim.proximo = outraLista.inicio;
            outraLista.inicio.anterior = fim;
        }
        fim = outraLista.fim;
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
        if (fim != null) {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
        }
        fim = novoNo;
        if (inicio == null) inicio = novoNo;
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
        lista1.adicionar(new Pessoa("TimTim", "123", "Rua A"));
        lista1.adicionar(new Pessoa("Mary", "456", "Rua B"));

        ListaDuplamenteLigada lista2 = new ListaDuplamenteLigada();
        lista2.adicionar(new Pessoa("carlin", "789", "Rua C"));
        lista2.adicionar(new Pessoa("Any", "101", "Rua D"));

        System.out.println("Lista 1:");
        lista1.imprimir();
        System.out.println("\nLista 2:");
        lista2.imprimir();

        System.out.println("\nConcatenando Lista 1 e Lista 2...");
        lista1.concatenar(lista2);
        lista1.imprimir();

        System.out.println("\nSeparando a lista concatenada...");
        ListaDuplamenteLigada[] listasSeparadas = lista1.separar();

        System.out.println("Primeira lista separada:");
        listasSeparadas[0].imprimir();

        System.out.println("\nSegunda lista separada:");
        listasSeparadas[1].imprimir();

        System.out.println("\nBuscando 'Mary':");
        No noEncontrado = lista1.buscar("Mary");
        System.out.println(noEncontrado != null ? noEncontrado.dado : "Não encontrado");

        System.out.println("\nRemovendo 'Mary':");
        lista1.remover("Mary");
        lista1.imprimir();
    }
}
