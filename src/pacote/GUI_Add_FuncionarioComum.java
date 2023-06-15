package pacote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI_Add_FuncionarioComum extends JFrame {

    private final JTextField nomeTextField;
    private final JTextField escalaoTextField;
    private final JTextField horasExtraTextField;
    private final JTextArea outputTextArea;

    public GUI_Add_FuncionarioComum(ArrayList<Classe_Funcionario> listaFuncionarios, int idFuncionario) {
        // Set frame properties
        setTitle("Adicionar Funcionario Comum");
        // Close window but keep the application running
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GridLayout grid = new GridLayout(0, 2, 20, 25);
        setLayout(grid);

        // Initialize components
        JLabel nomeLabel = new JLabel("Nome:");
        nomeTextField = new JTextField(1);
        JLabel escalaoLabel = new JLabel("Escalao:");
        escalaoTextField = new JTextField(1);
        JLabel horasExtraLabel = new JLabel("Horas Extra:");
        horasExtraTextField = new JTextField(1);
        JButton concluir = new JButton("Concluir");
        outputTextArea = new JTextArea(0, 1);

        Font font = new Font("Arial", Font.PLAIN, 20);
        nomeLabel.setFont(font);
        nomeTextField.setFont(font);
        escalaoLabel.setFont(font);
        escalaoTextField.setFont(font);
        horasExtraLabel.setFont(font);
        horasExtraTextField.setFont(font);
        concluir.setFont(font);
        outputTextArea.setFont(font);

        // Add components to the frame
        add(nomeLabel);
        add(nomeTextField);
        add(escalaoLabel);
        add(escalaoTextField);
        add(horasExtraLabel);
        add(horasExtraTextField);
        add(concluir);
        add(new JScrollPane(outputTextArea));

        // Set frame size and make it visible
        pack();
        setVisible(true);

        // Keypress "enter" to activate the button
        getRootPane().setDefaultButton(concluir);

        concluir.addActionListener(e -> {

            String nome = nomeTextField.getText();
            int escalao = 0;
            double horasExtra = 0;
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

            try {
                horasExtra = Double.parseDouble(horasExtraTextField.getText());
                if (horasExtra < 0) {
                    erros.append("O número de horas extra inseridas é inválido! Insira um número não-negativo.\n");
                }
            } catch (Exception ex) {
                erros.append("O número de horas extra inseridas é inválido! Insira um número não-negativo.\n");
            }

            if (String.valueOf(erros).equals("")) {
                Classe_FuncionarioComum funcionarioComum = new Classe_FuncionarioComum
                        (idFuncionario, nome, escalao, horasExtra);
                System.out.println(funcionarioComum.print() + "\nA criação foi bem sucedida!");
                outputTextArea.setText("A criação foi bem sucedida!");
                listaFuncionarios.add(funcionarioComum);
                GUI_Main.i += 1;
                dispose();
            } else {
                System.out.println(erros);
                outputTextArea.setText(String.valueOf(erros));
            }
        });
    }

}
