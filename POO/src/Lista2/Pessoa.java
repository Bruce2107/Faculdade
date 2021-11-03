package Lista2;

public class Pessoa {
    private String nome;
    private int idade;
    public Pessoa(String nome, int idade) {
        this.idade = idade;
        this.nome = nome;
    }
}

class Medico extends Pessoa {
    private  String especializacao;
    public Medico(String especializacao,int idade, String nome) {
        super(nome,idade);
        this.especializacao = especializacao;
    }
}
