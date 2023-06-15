package pacote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI_Listar extends JFrame {

    public GUI_Listar(ArrayList<Classe_Funcionario> listaFuncionarios) {
        // Set frame properties
        setTitle("Listagem Funcionarios");
        // Close window but keep the application running
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GridLayout grid = new GridLayout(0, 1);
        setLayout(grid);

        Font font = new Font("Arial", Font.PLAIN, 20);

        // JPanel with all data
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new GridLayout(0, 3, 30, 5));
        JScrollPane scrollPane = new JScrollPane(labelsPanel);
        add(scrollPane, BorderLayout.CENTER);

        JLabel idFuncionario = new JLabel("ID");
        JLabel nomeLabel = new JLabel("Nome");
        JLabel classeLabel = new JLabel("Classe");

        idFuncionario.setFont(font);
        nomeLabel.setFont(font);
        classeLabel.setFont(font);

        labelsPanel.add(idFuncionario);
        labelsPanel.add(nomeLabel);
        labelsPanel.add(classeLabel);

        for (Classe_Funcionario funcionario : listaFuncionarios) {
            idFuncionario = new JLabel(String.valueOf(funcionario.getIdFuncionario()));
            nomeLabel = new JLabel(funcionario.getNome());
            classeLabel = new JLabel(funcionario.getClasse());

            idFuncionario.setFont(font);
            nomeLabel.setFont(font);
            classeLabel.setFont(font);

            labelsPanel.add(idFuncionario);
            labelsPanel.add(nomeLabel);
            labelsPanel.add(classeLabel);
        }

        JButton detalhes = new JButton("Detalhes");
        JButton remover = new JButton("Remover");

        detalhes.addActionListener(e -> {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog
                    (null, "Insira o ID do funcionário: "));
            for (Classe_Funcionario funcionario : listaFuncionarios) {
                if (funcionario.getIdFuncionario() == opcao) {
                    new GUI_Detalhes(funcionario);
                    dispose();
                }
            }
        });

        remover.addActionListener(e -> {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog
                    (null, "Insira o ID do funcionário: "));
            for (Classe_Funcionario funcionario : listaFuncionarios) {
                if (funcionario.getIdFuncionario() == opcao) {
                    listaFuncionarios.remove(funcionario);
                    JOptionPane.showMessageDialog(null,"O funcionário foi removido com sucesso!");
                    dispose();
                    break;
                }
            }
        });

        detalhes.setFont(font);
        remover.setFont(font);

        labelsPanel.add(detalhes);
        labelsPanel.add(remover);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        int idFuncionario = 0;
        ArrayList<String> equipa1 = new ArrayList<>();
        equipa1.add("Júlio");
        equipa1.add("Susana");
        equipa1.add("Pedro");

        ArrayList<String> equipa2 = new ArrayList<>();
        equipa2.add("João");
        equipa2.add("Beatriz");
        equipa2.add("Nuno");
        equipa2.add("Tiago");

        Classe_Funcionario f1 = new Classe_Funcionario(idFuncionario, "F1", 0);
        idFuncionario += 1;
        Classe_FuncionarioComum f2 = new Classe_FuncionarioComum(idFuncionario, "F2", 0, 2);
        idFuncionario += 1;
        Classe_Gestor g1 = new Classe_Gestor(idFuncionario, "G1", 1, "Vendas1", equipa1);
        idFuncionario += 1;
        Classe_GestorVendas g2 = new Classe_GestorVendas(
                idFuncionario, "G2", 1, "Vendas2", equipa2, 10, 2000);
        //idFuncionario += 1;

        System.out.println("Vendas da equipa do gestor de vendas G2:");
        g2.realizarVenda(200);
        g2.realizarVenda(1);
        g2.realizarVenda(2000);

        System.out.println("\nInformações acerca dos funcionários criados para exemplificar:");
        ArrayList<Classe_Funcionario> listaClasseFuncionarios = new ArrayList<>();
        listaClasseFuncionarios.add(f1);
        listaClasseFuncionarios.add(f2);
        listaClasseFuncionarios.add(g1);
        listaClasseFuncionarios.add(g2);

        new GUI_Listar(listaClasseFuncionarios);
    }

}
