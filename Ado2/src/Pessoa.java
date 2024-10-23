public class Pessoa {
    String nome;
    String cpf;
    String endereco;

    Pessoa(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ") - " + endereco;
    }

    public static void main(String[] args) {
        Pessoa jacinto = new Pessoa("jacinto", "123.456.789-91", "Rua que, 478");
        System.out.println(jacinto);
    }
}
