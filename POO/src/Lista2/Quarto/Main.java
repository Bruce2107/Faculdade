package Lista2.Quarto;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    ArrayList<Pessoa> list = new ArrayList<Pessoa>();

    public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Lista Professores");
        System.out.println("2. Lista Aluno");
        System.out.println("3. Lista Professores Salario");
        System.out.println("4. Cadastra Professore");
        System.out.println("5. Cadastra Aluno");
        System.out.println("6. Mostra Tempo Pessoa");
        var op = Integer.parseInt(in.nextLine());
        do {
            switch (op) {
                case 1 -> this.listaProfessores();
                case 2 -> this.listaAlunos();
                case 3 -> {
                    System.out.println("salario");
                    var s = Float.parseFloat(in.nextLine());
                    this.listaProfessoresSalario(s);
                }
                case 4 -> this.cadastraProfessor();
                case 5 -> this.cadastraAluno();
                case 6 -> {
                    System.out.println("Nome da pessoa");
                    var nome = in.nextLine();
                    var p = list.stream().filter(l -> l.getNome().equals(nome)).collect(Collectors.toList());
                    if (p.get(0) != null) {
                        this.mostraTempoEmprestimo(p.get(0));
                    } else {
                        System.out.println("Nao encontrado");
                    }
                }

                default -> {
                }
            }
            System.out.println("Numero do exercicio");
            op = Integer.parseInt(in.nextLine());
        } while (op != 0);
    }

    private void listaProfessores() {
        this.list.forEach(p -> {
            if (p instanceof Professor) {
                System.out.println(p);
            }
        });
    }

    private void listaAlunos() {
        this.list.forEach(p -> {
            if (p instanceof Aluno) {
                System.out.println(p);
            }
        });
    }

    private void listaProfessoresSalario(float salario) {
        this.list.forEach(p -> {
            if (p instanceof Professor && ((Professor) p).getSalario() >= salario) {
                System.out.println(p);
            }
        });
    }

    private void cadastraProfessor() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nome");
        String nome = in.nextLine();
        System.out.println("cpf");
        int cpf = Integer.parseInt(in.nextLine());
        System.out.println("email");
        String email = in.nextLine();
        System.out.println("Tempo");
        int tempoEmprestimo = Integer.parseInt(in.nextLine());
        System.out.println("formacao");
        String formacao = in.nextLine();
        System.out.println("dp");
        String departamento = in.nextLine();
        System.out.println("salario");
        float salario = Float.parseFloat(in.nextLine());
        Professor p = new Professor(nome, email, cpf, tempoEmprestimo, formacao, departamento, salario);
        list.add(p);
        in.close();
    }

    private void cadastraAluno() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nome");
        String nome = in.nextLine();
        System.out.println("cpf");
        int cpf = Integer.parseInt(in.nextLine());
        System.out.println("email");
        String email = in.nextLine();
        System.out.println("Tempo");
        int tempoEmprestimo = Integer.parseInt(in.nextLine());
        System.out.println("curso");
        String curso = in.nextLine();
        System.out.println("fase");
        String fase = in.nextLine();
        System.out.println("matricula");
        int matricula = Integer.parseInt(in.nextLine());
        Aluno p = new Aluno(nome, email, cpf, tempoEmprestimo, curso, fase, matricula);
        list.add(p);
        in.close();
    }

    private void mostraTempoEmprestimo(Pessoa p) {
        System.out.println(p.mostraTempoEmprestimo());
    }
}

