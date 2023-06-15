package pacote;

public class Classe_FuncionarioComum extends Classe_Funcionario implements Interface_FuncionarioComum {
    private double horasExtra;
    private double salarioFinal = 0;

    private final String classe = "FuncionarioComum";

    public Classe_FuncionarioComum() {
        super();
        horasExtra = 0;
    }

    public Classe_FuncionarioComum(int idFuncionario, String nome, int escalao, double horasExtra) {
        super(idFuncionario, nome, escalao);
        this.horasExtra = horasExtra;
    }

    public Classe_FuncionarioComum(Classe_FuncionarioComum funcionarioComum) {
        super(funcionarioComum);
        this.horasExtra = funcionarioComum.getHorasExtra();
        this.salarioFinal = funcionarioComum.getSalarioFinal();
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public String getClasse() { return classe; }

    @Override
    public String print() {
        super.printFuncionario();
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        return super.printFuncionario() +
                "\nHoras Extra: " + horasExtra +
                "\nTaxa por Hora Extra: " + taxaHoraExtra +
                "\nSalario Final: " + salarioFinal;
    }

    @Override
    public void salario() {
        salarioFinal = getSalarioBase() + 100 * getEscalao() + horasExtra * taxaHoraExtra;
    }

    @Override
    public String toString() {
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        return super.toStringFuncionario() + " : " + horasExtra + " : " + salarioFinal;
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
