package pacote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI_Add_Gestor extends JFrame {

    private final JTextField nomeTextField;
    private final JTextField escalaoTextField;
    private final JTextField departamentoTextField;
    private final JTextArea equipaTextArea;
    private final JTextArea outputTextArea;

    public GUI_Add_Gestor(ArrayList<Classe_Funcionario> listaFuncionarios, int idFuncionario) {
        // Set frame properties
        setTitle("Adicionar Gestor");
        // Close window but keep the application running
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GridLayout grid = new GridLayout(0, 2, 20, 25);
        setLayout(grid);

        // Initialize components
        JLabel nomeLabel = new JLabel("Nome:");
        nomeTextField = new JTextField(1);
        JLabel escalaoLabel = new JLabel("Escalao:");
        escalaoTextField = new JTextField(1);
        JLabel departamentoLabel = new JLabel("Departamento:");
        departamentoTextField = new JTextField(1);
        JLabel equipaLabel = new JLabel("Equipa (cada elemento é separado pela mudança de linha, tecla Enter):");
        equipaTextArea = new JTextArea(0, 1);
        JButton concluir = new JButton("Concluir");
        outputTextArea = new JTextArea(0, 1);

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
        outputTextArea.setFont(font);

        // Add components to the frame
        add(nomeLabel);
        add(nomeTextField);
        add(escalaoLabel);
        add(escalaoTextField);
        add(departamentoLabel);
        add(departamentoTextField);
        add(equipaLabel);
        add(new JScrollPane(equipaTextArea));
        add(concluir);
        add(new JScrollPane(outputTextArea));

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
                Classe_Gestor classeGestor = new Classe_Gestor(idFuncionario, nome, escalao, departamento, listaEquipa);
                System.out.println(classeGestor.print());
                outputTextArea.setText("A criação foi bem sucedida!");
                listaFuncionarios.add(classeGestor);
                GUI_Main.i += 1;
                dispose();
            } else {
                System.out.println(erros);
                outputTextArea.setText(String.valueOf(erros));
            }

        });
    }

}
