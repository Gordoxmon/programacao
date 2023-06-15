package pacote;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> equipa1 = new ArrayList<>();
        equipa1.add("Júlio");
        equipa1.add("Susana");
        equipa1.add("Pedro");

        ArrayList<String> equipa2 = new ArrayList<>();
        equipa2.add("João");
        equipa2.add("Beatriz");
        equipa2.add("Nuno");
        equipa2.add("Tiago");

        Classe_Funcionario f1 = new Classe_Funcionario("F1", 0);
        Classe_FuncionarioComum f2 = new Classe_FuncionarioComum("F2", 0, 2);
        Classe_Gestor g1 = new Classe_Gestor("G1", 1, "Vendas1", equipa1);
        Classe_GestorVendas g2 = new Classe_GestorVendas(
                "G2", 1, "Vendas2", equipa2, 10, 2000);

        System.out.println("Vendas da equipa do gestor de vendas G2:");
        g2.realizarVenda(200);
        g2.realizarVenda(1);
        g2.realizarVenda(2000);

        // Teste de um método de clonagem
        Classe_GestorVendas g3 = new Classe_GestorVendas(g2);

        System.out.println("\nInformações acerca dos funcionários criados para exemplificar:");
        ArrayList<Classe_Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios.add(f1);
        listaFuncionarios.add(f2);
        listaFuncionarios.add(g1);
        listaFuncionarios.add(g2);
        listaFuncionarios.add(g3);

        for (Classe_Funcionario i : listaFuncionarios) {
            System.out.println(i.print());
            System.out.println();
        }
    }
}
