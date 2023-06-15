package pacote;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Classe_GestorVendas extends Classe_Gestor implements Interface_GestorVendas {

    private double valorMinimoPorVenda;
    private double valorVendasFeitas;
    private double metaVendas;
    private double comissao;
    private double salarioFinal = 0;

    private final String classe = "GestorVendas";

    DecimalFormat format = new DecimalFormat("#.##");

    public Classe_GestorVendas() {
        super();
        valorMinimoPorVenda = 0;
        metaVendas = 0;
    }

    public Classe_GestorVendas(int idFuncionario, String nome, int escalao, String departamento,
                               ArrayList<String> equipa, double valorMinimoPorVenda, double metaVendas) {
        super(idFuncionario, nome, escalao, departamento, equipa);
        this.valorMinimoPorVenda = valorMinimoPorVenda;
        this.metaVendas = metaVendas;
    }

    public Classe_GestorVendas(Classe_GestorVendas gestorVendas) {
        super(gestorVendas);
        this.valorMinimoPorVenda = gestorVendas.getValorMinimoPorVenda();
        this.valorVendasFeitas = gestorVendas.getValorVendasFeitas();
        this.metaVendas = gestorVendas.getMetaVendas();
        this.comissao = gestorVendas.getComissao();
        this.salarioFinal = gestorVendas.getSalarioFinal();
    }

    public double getValorMinimoPorVenda() {
        return valorMinimoPorVenda;
    }

    public void setValorMinimoPorVenda(double valorMinimoPorVenda) {
        this.valorMinimoPorVenda = valorMinimoPorVenda;
    }

    public double getValorVendasFeitas() {
        return valorVendasFeitas;
    }

    public double getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    public double getComissao() {
        return comissao;
    }

    public String getClasse() { return classe; }

    private double arredondar(double valor) {
        return Double.parseDouble(format.format(valor).replaceAll(",", "."));
    }

    public String realizarVenda(double valorMonetario) {
        if (valorMonetario >= valorMinimoPorVenda) {
            valorVendasFeitas += valorMonetario;
            return "A venda foi feita com sucesso!";
        } else {
            return "A venda é inválida, o valor monetário é muito baixo.";
        }
    }

    public String cumpriuMeta() {
        if (valorVendasFeitas >= metaVendas) {
            comissao = arredondar(0.05 * valorVendasFeitas);
            salario();
            return "A meta de vendas foi alcançada com sucesso!";
        } else {
            return "A meta de vendas não foi alcançada. Poderá ser necessário mudar a estratégia da equipa " +
                    "ou falar com um superior sobre a situação.";
        }
    }

    @Override
    public String print() {
        StringBuilder a = new StringBuilder(super.printGestor() + "\n");
        a.append("Valor Minimo por Venda: ").append(valorMinimoPorVenda).append("\n");
        a.append("Valor Vendas Feitas: ").append(valorVendasFeitas).append("\n");
        a.append("Meta de Vendas: ").append(metaVendas).append("\n");
        a.append(cumpriuMeta()).append("\n");
        a.append("Comissao: ").append(comissao).append("\n");
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        a.append("Salario Final: ").append(salarioFinal);
        return String.valueOf(a);
    }

    @Override
    public void salario() {
        salarioFinal = 2 * getSalarioBase() + 120 * getEscalao() + comissao;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder(super.toStringFuncionario() + " : " + getDepartamento() + " : \n");
        for (String membro : getEquipa()) {
            a.append("-> ").append(membro).append("\n");
        }
        if (salarioFinal == 0) {
            // Caso o salarioFinal ainda nao tenha sido calculado apos insercao/mudanca parametros
            salario();
        }
        a.append(" : ").append(salarioFinal);
        return String.valueOf(a);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

}
