public class ReservaBanhoTosa {
    private NoReserva inicio;

    public ReservaBanhoTosa() {
        this.inicio = null;
    }


    public void InserirReserva(String horario, String nomeTutor, String nomeAnimal, int idadeAnimal) {
        Pet pet = new Pet(nomeAnimal, idadeAnimal);
        NoReserva novaReserva = new NoReserva(horario, nomeTutor, pet);
        if (inicio == null) {
            inicio = novaReserva;
        } else {
            NoReserva atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novaReserva);
        }
    }


    public void ImprimirReservas() {
        NoReserva atual = inicio;
        if (atual == null) {
            System.out.println("Não há reservas.");
            return;
        }
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }


    public void buscarPorNomeAnimal(String nomeAnimal) {
        NoReserva percorre = inicio;
        boolean encontrado = false;
        while (percorre != null) {
            if (percorre.getPet().getNome().equalsIgnoreCase(nomeAnimal)) {
                System.out.println("Reserva encontrada: " + percorre);
                encontrado = true;
            }
            percorre = percorre.getProximo();
        }
        if (!encontrado) {
            System.out.println("Nenhuma reserva encontrada para o nome do animal: " + nomeAnimal);
        }
    }

    public static void main(String[] args) {

        ReservaBanhoTosa reservaBanhoTosa = new ReservaBanhoTosa();
        reservaBanhoTosa.InserirReserva("10:00", "IA", "Robo", 1);
        reservaBanhoTosa.InserirReserva("14:00", "Guilherme", "Thor", 13);
        reservaBanhoTosa.InserirReserva("19:00", "Vinicius", "King Kong", 10);
        System.out.println("Reservas de Banho e Tosa:");
        reservaBanhoTosa.ImprimirReservas();


        String nomeAnimalParaBuscar = "Thor";
        reservaBanhoTosa.buscarPorNomeAnimal(nomeAnimalParaBuscar);
    }
}
