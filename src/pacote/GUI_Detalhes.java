package pacote;

import javax.swing.*;
import java.awt.*;

public class GUI_Detalhes extends JFrame {

    public GUI_Detalhes(Classe_Funcionario funcionario) {
        // Set frame properties
        setTitle("Detalhes Funcionario");
        // Close window but keep the application running
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Layout
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(grid);
        // Allow the components to fill the space
        gbc.fill = GridBagConstraints.BOTH;

        JTextArea print = new JTextArea(funcionario.print());
        JButton edit = new JButton("Editar");
        JButton remove = new JButton("Remover");

        Font font = new Font("Arial", Font.PLAIN, 20);
        print.setFont(font);
        edit.setFont(font);
        remove.setFont(font);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        add(new JScrollPane(print), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        // Occupy half of the available horizontal space
        gbc.weightx = 0.5;
        add(edit, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        add(remove, gbc);


        edit.addActionListener(e -> {
            String classe = funcionario.getClasse();
            switch (classe) {
                case "Funcionario" -> {
                    new GUI_Edit_Funcionario(funcionario);
                }
                case "FuncionarioComum" -> {
                    new GUI_Edit_FuncionarioComum((Classe_FuncionarioComum) funcionario);
                }
                case "Gestor" -> {
                    new GUI_Edit_Gestor((Classe_Gestor) funcionario);
                }
                case "GestorVendas" -> {
                    new GUI_Edit_GestorVendas((Classe_GestorVendas) funcionario);
                }
            }
            dispose();
        });

        remove.addActionListener(e -> {
            GUI_Main.listaFuncionarios.remove(funcionario);
            JOptionPane.showMessageDialog(null,"O funcionário foi removido com sucesso!");
            dispose();
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        int idFuncionario = 0;
        Classe_Funcionario f1 = new Classe_Funcionario(idFuncionario, "A", 0);
        idFuncionario += 1;
        Classe_FuncionarioComum f2 = new Classe_FuncionarioComum(idFuncionario, "B", 0, 2);
        new GUI_Detalhes(f2);
    }

}
