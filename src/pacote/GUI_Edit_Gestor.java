package pacote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI_Edit_Gestor extends JFrame {

    private final JTextField nomeTextField;
    private final JTextField escalaoTextField;
    private final JTextField departamentoTextField;
    private final JTextArea equipaTextArea;

    public GUI_Edit_Gestor(Classe_Gestor funcionario) {
        // Set frame properties
        setTitle("Editar Gestor");
        // Close window but keep the application running
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GridLayout grid = new GridLayout(0, 2, 20, 25);
        setLayout(grid);

        // Initialize components
        JLabel nomeLabel = new JLabel("Nome:");
        nomeTextField = new JTextField(funcionario.getNome());
        JLabel escalaoLabel = new JLabel("Escalao:");
        escalaoTextField = new JTextField(String.valueOf(funcionario.getEscalao()));
        JLabel departamentoLabel = new JLabel("Departamento:");
        departamentoTextField = new JTextField(funcionario.getDepartamento());
        JLabel equipaLabel = new JLabel("Equipa (cada elemento é separado pela mudança de linha, tecla Enter):");

        StringBuilder auxiliar = new StringBuilder();
        for (int i = 0; i < funcionario.getEquipa().size(); i++) {
            auxiliar.append(funcionario.getEquipa().get(i)).append("\n");
        }
        equipaTextArea = new JTextArea(String.valueOf(auxiliar), 0, 1);

        JButton concluir = new JButton("Concluir");
        JButton reuniao = new JButton("Realizar reunião com a equipa");

        Font font = new Font("Arial", Font.PLAIN, 20);
        nomeLabel.setFont(font);
        nomeTextField.setFont(font);
        escalaoLabel.setFont(font);
        escalaoTextField.setFont(font);
        departamentoLabel.setFont(font);
        departamentoTextField.setFont(font);
        equipaLabel.setFont(font);
        equipaTextArea.setFont(font);
        concluir.setFont(font);
        reuniao.setFont(font);

        // Add components to the frame
        add(nomeLabel);
        add(nomeTextField);
        add(escalaoLabel);
        add(escalaoTextField);
        add(departamentoLabel);
        add(departamentoTextField);
        add(equipaLabel);
        add(new JScrollPane(equipaTextArea));
        add(reuniao);
        add(concluir);

        // Set frame size and make it visible
        pack();
        setVisible(true);

        concluir.addActionListener(e -> {

            String nome = nomeTextField.getText();
            String departamento = departamentoTextField.getText();
            String[] equipa = equipaTextArea.getText().split("\n");
            ArrayList<String> listaEquipa = new ArrayList<>(Arrays.asList(equipa));
            int escalao = 0;
            StringBuilder erros = new StringBuilder();

            // Verificacoes //
            try {
                escalao = Integer.parseInt(escalaoTextField.getText());
                if (escalao < 0) {
                    erros.append("O escalão inserido é inválido! Insira um número inteiro não-negativo.\n");
                }
            } catch (Exception ex) {
                erros.append("O escalão inserido é inválido! Insira um número inteiro não-negativo.\n");
            }

            if (String.valueOf(erros).equals("")) {
                funcionario.setNome(nome);
                funcionario.setEscalao(escalao);
                funcionario.setDepartamento(departamento);
                funcionario.setEquipa(listaEquipa);
                System.out.println(funcionario.print() + "\nAs alterações foram efetuadas com sucesso!");
                JOptionPane.showMessageDialog(null, "As alterações foram efetuadas com sucesso!");
                dispose();
            } else {
                System.out.println(erros);
                JOptionPane.showMessageDialog(null, String.valueOf(erros));
            }

        });

        reuniao.addActionListener(e -> {
            System.out.println(funcionario.realizarReuniao());
            JOptionPane.showMessageDialog(null, funcionario.realizarReuniao());
        });
    }

    public static void main(String[] args) {
        int idFuncionario = 0;
        ArrayList<String> equipa = new ArrayList<>();
        equipa.add("Julio");
        equipa.add("Susana");
        equipa.add("Joaquim");
        Classe_Gestor f = new Classe_Gestor(idFuncionario, "Joao", 2, "Vendas1", equipa);
        new GUI_Edit_Gestor(f);
    }

}
