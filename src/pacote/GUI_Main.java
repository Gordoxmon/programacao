package pacote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI_Main extends JFrame {

    public static int i = 0;

    public static ArrayList<Classe_Funcionario> listaFuncionarios = new ArrayList<>();
    public GUI_Main() {
        setTitle("Gestão dos Funcionários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton listarFuncionariosButton = new JButton("Listar Funcionários");
        JButton funcionarioButton = new JButton("Adicionar Funcionário");
        JButton funcionarioComumButton = new JButton("Adicionar Funcionário Comum");
        JButton gestorButton = new JButton("Adicionar Gestor");
        JButton gestorVendasButton = new JButton("Adicionar Gestor Vendas");
        JButton exitButton = new JButton("Exit");

        listarFuncionariosButton.addActionListener(e -> new GUI_Listar(listaFuncionarios));
        funcionarioButton.addActionListener(e -> new GUI_Add_Funcionario(listaFuncionarios, i));
        funcionarioComumButton.addActionListener(e -> new GUI_Add_FuncionarioComum(listaFuncionarios, i));
        gestorButton.addActionListener(e -> new GUI_Add_Gestor(listaFuncionarios, i));
        gestorVendasButton.addActionListener(e -> new GUI_Add_GestorVendas(listaFuncionarios, i));
        exitButton.addActionListener(e -> dispose());

        add(listarFuncionariosButton);
        add(funcionarioButton);
        add(funcionarioComumButton);
        add(gestorButton);
        add(gestorVendasButton);
        add(exitButton);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_Main();
    }
}
