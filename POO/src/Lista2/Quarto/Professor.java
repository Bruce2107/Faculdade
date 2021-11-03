package Lista2.Quarto;

public class Professor extends Pessoa {
    private String formacao;
    private String departamento;
    private float salario;

    public Professor(String nome, String email, int cpf, int tempoEmprestimo, String formacao, String departamento, float salario) {
        super(nome, email, cpf, tempoEmprestimo);
        this.formacao = formacao;
        this.departamento = departamento;
        this.salario = salario;
    }

    @Override
    public int mostraTempoEmprestimo() {
        return (int) Math.ceil(super.mostraTempoEmprestimo() * 1.7);
    }

    public float getSalario() {
        return salario;
    }
}
