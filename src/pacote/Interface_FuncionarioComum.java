package pacote;

public interface Interface_FuncionarioComum extends Interface_Funcionario {

    double horasExtra = 0;
    double taxaHoraExtra = 1.15 * valorHora;

    double getHorasExtra();
    void setHorasExtra(double horasExtra);

}
