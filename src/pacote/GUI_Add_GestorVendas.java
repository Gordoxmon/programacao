package pacote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI_Add_GestorVendas extends JFrame {

    private final JTextField nomeTextField;
    private final JTextField escalaoTextField;
    private final JTextField departamentoTextField;
    private final JTextArea equipaTextArea;
    private final JTextField valorMinimoPorVendaTextField;
    private final JTextField metaVendasTextField;
    private final JTextArea outputTextArea;

    public GUI_Add_GestorVendas(ArrayList<Classe_Funcionario> listaFuncionarios, int idFuncionario) {
        // Set frame properties
        setTitle("Adicionar Gestor Vendas");
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
        JLabel valorMinimoPorVendaLabel = new JLabel("Valor Minimo por Venda:");
        valorMinimoPorVendaTextField = new JTextField(1);
        JLabel metaVendasLabel = new JLabel("Meta de Vendas:");
        metaVendasTextField = new JTextField(1);
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
        valorMinimoPorVendaLabel.setFont(font);
        valorMinimoPorVendaTextField.setFont(font);
        metaVendasLabel.setFont(font);
        metaVendasTextField.setFont(font);
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
        add(valorMinimoPorVendaLabel);
        add(valorMinimoPorVendaTextField);
        add(metaVendasLabel);
        add(metaVendasTextField);
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
            double valorMinimoPorVenda = 0;
            double metaVendas = 0;
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
                valorMinimoPorVenda = Double.parseDouble(valorMinimoPorVendaTextField.getText());
                if (valorMinimoPorVenda < 0) {
                    erros.append("O valor mínimo por venda inserido é inválido! Insira um número não-negativo.\n");
                }
            } catch (Exception ex) {
                erros.append("O valor mínimo por venda inserido é inválido! Insira um número não-negativo.\n");
            }

            try {
                metaVendas = Double.parseDouble(metaVendasTextField.getText());
                if (metaVendas < 0) {
                    erros.append("A meta de vendas inserida é inválida! Insira um número não-negativo.\n");
                }
            } catch (Exception ex) {
                erros.append("A meta de vendas inserida é inválida! Insira um número não-negativo.\n");
            }

            if (String.valueOf(erros).equals("")) {
                Classe_GestorVendas gestorVendas = new Classe_GestorVendas(idFuncionario, nome, escalao, departamento,
                        listaEquipa, valorMinimoPorVenda, metaVendas);
                System.out.println(gestorVendas.print());
                outputTextArea.setText("A criação foi bem sucedida!");
                listaFuncionarios.add(gestorVendas);
                GUI_Main.i += 1;
                dispose();
            } else {
                System.out.println(erros);
                outputTextArea.setText(String.valueOf(erros));
            }

        });
    }

}
