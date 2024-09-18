public class No {
    private String nome;
    private int idade;
    private No proximo;

    public No(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.proximo = null;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
