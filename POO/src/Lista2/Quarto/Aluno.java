package Lista2.Quarto;

public class Aluno extends Pessoa {
    private String curso;
    private String fase;
    private int matricula;

    public Aluno(String nome, String email, int cpf, int tempoEmprestimo, String curso, String fase, int matricula) {
        super(nome, email, cpf, tempoEmprestimo);
        this.curso = curso;
        this.fase = fase;
        this.matricula = matricula;
    }

    @Override
    public int mostraTempoEmprestimo() {
        return (int) Math.ceil(super.mostraTempoEmprestimo() * 1.4);
    }
}
