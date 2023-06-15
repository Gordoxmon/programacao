package pacote;

import javax.swing.*;
import java.awt.*;

public class GUI_Edit_Funcionario extends JFrame{

    private final JTextField nomeTextField;
    private final JTextField escalaoTextField;
    private final JTextArea outputTextArea;

    public GUI_Edit_Funcionario(Classe_Funcionario funcionario) {
        // Set frame properties
        setTitle("Editar Funcionario");
        // Close window but keep the application running
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GridLayout grid = new GridLayout(0, 2, 20, 25);
        setLayout(grid);

        // Initialize components
        JLabel nomeLabel = new JLabel("Nome:");
        nomeTextField = new JTextField(funcionario.getNome());
        JLabel escalaoLabel = new JLabel("Escalao:");
        escalaoTextField = new JTextField(String.valueOf(funcionario.getEscalao()));
        JButton concluir = new JButton("Concluir");
        outputTextArea = new JTextArea(0, 1);

        Font font = new Font("Arial", Font.PLAIN, 20);
        nomeLabel.setFont(font);
        nomeTextField.setFont(font);
        escalaoLabel.setFont(font);
        escalaoTextField.setFont(font);
        concluir.setFont(font);
        outputTextArea.setFont(font);

        // Add components to the frame
        add(nomeLabel);
        add(nomeTextField);
        add(escalaoLabel);
        add(escalaoTextField);
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
                System.out.println(funcionario.print() + "\nAs alterações foram efetuadas com sucesso!");
                outputTextArea.setText("As alterações foram efetuadas com sucesso!");
            } else {
                System.out.println(erros);
                outputTextArea.setText(String.valueOf(erros));
            }
        });
    }

    public static void main(String[] args) {
        int idFuncionario = 0;
        Classe_Funcionario f = new Classe_Funcionario(idFuncionario, "Joao", 2);
        new GUI_Edit_Funcionario(f);
    }

}
