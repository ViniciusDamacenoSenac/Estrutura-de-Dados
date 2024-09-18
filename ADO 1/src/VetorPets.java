public class VetorPets {
    private Pet[] pets;
    private int tamanho;

    public VetorPets() {
        pets = new Pet[2];
        tamanho = 0;
    }

    public void adicionarPet(String nome, int idade) {
        if (tamanho == pets.length) {
            redimensionarVetor();
        }
        pets[tamanho] = new Pet(nome, idade);
        tamanho++;
    }

    private void redimensionarVetor() {
        Pet[] novoArray = new Pet[pets.length * 2];

        for (int i = 0; i < pets.length; i++) {
            novoArray[i] = pets[i];
        }
        pets = novoArray;
    }

    public void imprimirPets() {
        System.out.println("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(pets[i]);
            if (i < tamanho - 1) {
                System.out.println(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        VetorPets vetor = new VetorPets();

        vetor.adicionarPet("IA", 1);
        vetor.adicionarPet("Thor", 13);
        vetor.adicionarPet("King Kong", 10);

        vetor.imprimirPets();
    }
}
