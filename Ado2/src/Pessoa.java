public class Pessoa {
    String nome;
    String cpf;
    String endereco;

    public Pessoa(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ") - " + endereco;
    }
}
