package Lista2.Quarto;

public class Pessoa {
    private String nome;
    private int cpf;
    private String email;
    protected int tempoEmprestimo;

    public Pessoa(String nome, String email, int cpf, int tempoEmprestimo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.tempoEmprestimo = tempoEmprestimo;
    }

    public int mostraTempoEmprestimo() {
        return this.tempoEmprestimo;
    }

    public String getNome() {
        return nome;
    }
}
