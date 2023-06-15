package pacote;

import java.util.ArrayList;

public class Classe_Gestor extends Classe_Funcionario implements Interface_Gestor {

    private String departamento;
    private ArrayList<String> equipa;
    private double salarioFinal = 0;

    private final String classe = "Gestor";

    public Classe_Gestor() {
        super();
        departamento = "Indefinido";
    }

    public Classe_Gestor(String nome, int escalao, String departamento, ArrayList<String> equipa) {
        super(nome, escalao);
        this.departamento = departamento;
        this.equipa = equipa;
    }

    public Classe_Gestor(Classe_Gestor gestor) {
        super(gestor);
        this.departamento = gestor.getDepartamento();
        // Copia profunda (cria uma nova instancia de equipa)
        this.equipa = new ArrayList<>(gestor.getEquipa());
        this.salarioFinal = gestor.getSalarioFinal();
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ArrayList<String> getEquipa() {
        return equipa;
    }

    public void setEquipa(ArrayList<String> equipa) {
        this.equipa = equipa;
    }

    private String getClasse() { return classe; }

    public String realizarReuniao() {
        StringBuilder aux = new StringBuilder("Reunião do departamento " + departamento + " com a equipe:");
        for (String membro : equipa) {
            aux.append("\n- " + membro);
        }
        aux.append("\nReunião realizada com sucesso!");
        return String.valueOf(aux);
    }

    protected String printGestor() {
        StringBuilder a = new StringBuilder(super.printFuncionario() + "\nDepartamento: " + departamento +
                "\nEquipa:\n");
        for (String membro : equipa) {
            a.append("-> ").append(membro).append("\n");
        }
        return String.valueOf(a);
    }

    @Override
    public String print() {
        StringBuilder a = new StringBuilder(printGestor());
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        a.append("Salario Final: ").append(salarioFinal);
        return String.valueOf(a);
    }

    @Override
    public void salario() {
        salarioFinal = 2 * getSalarioBase() + 150 * getEscalao();
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder(super.toStringFuncionario() + " : " + departamento + " : \n");
        for (String membro : equipa) {
            a.append("-> ").append(membro).append("\n");
        }
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        a.append(" : ").append(salarioFinal);
        return String.valueOf(a);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

}
