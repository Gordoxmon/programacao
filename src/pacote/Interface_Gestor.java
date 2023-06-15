package pacote;

import java.util.ArrayList;

public interface Interface_Gestor extends Interface_Funcionario {

    String departamento = "Departamento";
    ArrayList<String> equipa = new ArrayList<>();

    String getDepartamento();
    void setDepartamento(String departamento);
    ArrayList<String> getEquipa();
    void setEquipa(ArrayList<String> equipa);

    String realizarReuniao();

}
