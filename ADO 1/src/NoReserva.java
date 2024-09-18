public class NoReserva {
    private final String horario;
    private final String nomeTutor;
    private final Pet pet;
    private NoReserva proximo;

    public NoReserva(String horario, String nomeTutor, Pet pet) {
        this.horario = horario;
        this.nomeTutor = nomeTutor;
        this.pet = pet;
        this.proximo = null;
    }

    public Pet getPet() {
        return pet;
    }

    public NoReserva getProximo() {
        return proximo;
    }

    public void setProximo(NoReserva proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Horário: " + horario + ", Tutor: " + nomeTutor + ", " + pet;
    }
}
