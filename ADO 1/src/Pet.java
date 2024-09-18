public class Pet {
    private final String nome;
    private final int idade;

    public Pet(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Animal: " + nome + ", Idade: " + idade;
    }
}
