package pacote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI_Edit_GestorVendas extends JFrame {

    private final JTextField nomeTextField;
    private final JTextField escalaoTextField;
    private final JTextField departamentoTextField;
    private final JTextArea equipaTextArea;
    private final JTextField valorMinimoPorVendaTextField;
    private final JTextField metaVendasTextField;
    private final JTextField realizarVendaTextField;

    public GUI_Edit_GestorVendas(Classe_GestorVendas funcionario) {
        // Set frame properties
        setTitle("Editar Gestor Vendas");
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

        JLabel valorMinimoPorVendaLabel = new JLabel("Valor Minimo por Venda:");
        valorMinimoPorVendaTextField = new JTextField(String.valueOf(funcionario.getValorMinimoPorVenda()));
        JLabel metaVendasLabel = new JLabel("Meta de Vendas:");
        metaVendasTextField = new JTextField(String.valueOf(funcionario.getMetaVendas()));
        JButton concluir = new JButton("Concluir");
        JButton reuniao = new JButton("Realizar reunião com a equipa");
        JLabel realizarVenda = new JLabel("Insira o valor da venda a realizar:");
        realizarVendaTextField = new JTextField(1);
        JButton confirmarVenda = new JButton("Confirmar venda");
        JLabel fill = new JLabel();

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
        reuniao.setFont(font);
        realizarVenda.setFont(font);
        realizarVendaTextField.setFont(font);
        confirmarVenda.setFont(font);

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
        add(realizarVenda);
        add(realizarVendaTextField);
        add(fill);
        add(confirmarVenda);
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
                funcionario.setNome(nome);
                funcionario.setEscalao(escalao);
                funcionario.setDepartamento(departamento);
                funcionario.setEquipa(listaEquipa);
                funcionario.setValorMinimoPorVenda(valorMinimoPorVenda);
                funcionario.setMetaVendas(metaVendas);
                System.out.println(funcionario.print() + "\nAs alterações foram efetuadas com sucesso!");
                JOptionPane.showMessageDialog(null, "As alterações foram efetuadas com sucesso!");
                dispose();
            } else {
                System.out.println(erros);
                JOptionPane.showMessageDialog(null, String.valueOf(erros));
            }

        });

        reuniao.addActionListener(e -> {
            String retornoFunc = funcionario.realizarReuniao();
            System.out.println(retornoFunc);
            JOptionPane.showMessageDialog(null, retornoFunc);
        });

        confirmarVenda.addActionListener(e -> {
            double valorVenda = 0;
            String erros = "";
            try {
                valorVenda = Double.parseDouble(realizarVendaTextField.getText());
                if (valorVenda < 0) {
                    erros = "Insira um número não-negativo como valor monetário.";
                }
            } catch (Exception ex) {
                erros = "Insira um número não-negativo como valor monetário.";
            }

            if (erros.equals("")) {
                String retornoFunc = funcionario.realizarVenda(valorVenda);
                System.out.println(retornoFunc);
                JOptionPane.showMessageDialog(null, retornoFunc);
            } else {
                System.out.println(erros);
                JOptionPane.showMessageDialog(null, erros);
            }
        });
    }

    public static void main(String[] args) {
        int idFuncionario = 0;
        ArrayList<String> equipa = new ArrayList<>();
        equipa.add("Seabra");
        equipa.add("Manuel");
        equipa.add("Pedro");
        Classe_GestorVendas f = new Classe_GestorVendas(
                idFuncionario, "Joao", 2, "Vendas2", equipa, 10, 1000);
        new GUI_Edit_GestorVendas(f);
    }

}
