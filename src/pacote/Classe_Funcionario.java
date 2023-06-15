package pacote;

public class Classe_Funcionario implements Interface_Funcionario {

    private String nome;
    protected double salarioBase = horasMensais * valorHora;
    private int escalao;
    private double salarioFinal = 0;

    private final String classe = "Funcionario";

    public Classe_Funcionario() {
        nome = "Indefinido";
        escalao = 0;
    }

    public Classe_Funcionario(String nome, int escalao) {
        this.nome = nome;
        if (escalao >= 0) {
            this.escalao = escalao;
        }
    }

    public Classe_Funcionario(Classe_Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.salarioBase = funcionario.getSalarioBase();
        this.escalao = funcionario.getEscalao();
        this.salarioFinal = funcionario.getSalarioFinal();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getEscalao() {
        return escalao;
    }

    public void setEscalao(int escalao) {
        this.escalao = escalao;
    }

    protected double getSalarioFinal() {
        return salarioFinal;
    }

    private String getClasse() { return classe; }

    protected String printFuncionario() {
        return "Nome: " + nome +
                "\nSalario Base: " + salarioBase +
                "\nEscalao: " + escalao;
    }

    public String print() {
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        return printFuncionario() + "\nSalario Final: " + salarioFinal;
    }

    public void salario() {
        salarioFinal = salarioBase + 100 * escalao;
    }

    protected String toStringFuncionario() {
        return nome + " : " + salarioBase + " : " + escalao;
    }

    @Override
    public String toString() {
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        return toStringFuncionario() + " : " + salarioFinal;
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
