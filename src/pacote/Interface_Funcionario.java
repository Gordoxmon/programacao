package pacote;

public interface Interface_Funcionario {

    String nome = "Funcionario";
    double horasMensais = 160;
    double valorHora = 5;
    double salarioBase = horasMensais * valorHora;
    int escalao = 0;
    double salarioFinal = 0;
    String classe = "Funcionario";

    String getNome();
    void setNome(String nome);
    double getSalarioBase();
    void setSalarioBase(double salarioBase);
    int getEscalao();
    void setEscalao(int escalao);

    String print();
    void salario();
    boolean equals(Object o);

}
