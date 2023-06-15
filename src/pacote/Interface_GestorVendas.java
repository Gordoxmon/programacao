package pacote;

public interface Interface_GestorVendas extends Interface_Gestor {

    double valorMinimoPorVenda = 0;
    double valorVendasFeitas = 0;
    double metaVendas = 0;
    double comissao = 0.05 * metaVendas;
    double salarioFinal = 0;

    double getValorMinimoPorVenda();
    void setValorMinimoPorVenda(double valorVendasFeitas);
    double getValorVendasFeitas();
    double getMetaVendas();
    void setMetaVendas(double metaVendas);
    double getComissao();

    String realizarVenda(double valorMonetario);
    String cumpriuMeta();

}
