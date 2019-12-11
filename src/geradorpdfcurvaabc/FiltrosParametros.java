package systextil.bo.geradorpdfcurvaabc;

import br.com.intersys.systextil.global.Mdi;
import systextil.temp.TempFilter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FiltrosParametros {
    
    private int agrupamento, qtdeValor, custo, faturamento, nivel, venda_faturamento, linhaProduto, representante,
                cliente, estadoCliente, tipoCliente, cidadeCliente, produtos, artigoProdutos, contaDeEstoque,mesFinal,
                anoFinal, colecao, codigoEmpresa;
    private String consideraCancelados;
    private float percPis, percCofins, curvaA, curvaB, curvaC;
    private Date dataFinal;
    private Date dataInicial;
    private String dataInicialSQL;
    private java.sql.Date dataFinalSQL;
    private Mdi mdi;
    private TempFilter widgetRepresentante;
    private TempFilter widgetColecao;
    private TempFilter widgetLinhaProduto;
    private TempFilter widgetCliente;
    private TempFilter widgetEstadoCliente;
    private TempFilter widgetTipoCliente;
    private TempFilter widgetCidadeCliente;
    private TempFilter widgetProdutos;
    private TempFilter widgetArtigoProdutos;
    private TempFilter widgetContaDeEstoque;
    //parametros localizados no Where do Sql
     
    //public Date termino;

    public FiltrosParametros(){}

    public FiltrosParametros(int venda_faturamento, int agrupamento, int qtdeValor, int custo, int faturamento,
                             int nivel, String consideraCancelados, Double percPis, Double percConfins, Double curvaA,
                             Double curvaB,int mesFinal, int anoFinal, int codigoEmpresa, String usuario, Double curvaC,
                             int linhaProduto, int representante, int cliente, int estadoCliente, int tipoCliente,
                             int cidadeCliente, int produtos, int artigoProdutos, int contaDeEstoque, int colecao, int codEmpresa ) {

        this.venda_faturamento = venda_faturamento;
        this.agrupamento = agrupamento;
        this.qtdeValor = qtdeValor;
        this.custo = custo;
        this.faturamento = faturamento;
        this.nivel = nivel;
        this.consideraCancelados = consideraCancelados;
        this.percPis = Float.parseFloat(percPis.toString());
        this.percCofins = Float.parseFloat(percConfins.toString());
        this.curvaA = Float.parseFloat(curvaA.toString());
        this.curvaB = Float.parseFloat(curvaB.toString());
        this.mesFinal = mesFinal;
        this.anoFinal = anoFinal;
        this.curvaC = Float.parseFloat(curvaC.toString());
        mdi = new Mdi(codigoEmpresa, usuario);
        this.linhaProduto = linhaProduto;
        this.representante = representante;
        this.cliente = cliente;
        this.estadoCliente = estadoCliente;
        this.tipoCliente = tipoCliente;
        this.cidadeCliente = cidadeCliente;
        this.produtos = produtos;
        this.artigoProdutos = artigoProdutos;
        this.contaDeEstoque = contaDeEstoque;
        this.colecao = colecao;
        this.codigoEmpresa = codEmpresa;

        SimpleDateFormat sf = new SimpleDateFormat("MM-yyyy");
        try{
            Date data = sf.parse(mesFinal + "-" + anoFinal);
            this.dataFinal = data;
            data = sf.parse(mesFinal + "-" + (anoFinal - 1));
            this.dataInicial = data;

            dataInicialSQL = "28/"+ (MetodosUtils.retornaMes(mesFinal - 1)) +"/" + anoFinal ;
        }catch (ParseException err){
            err.printStackTrace();
        }
    }

    public int getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(int codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public TempFilter getWidgetColecao() {
        return widgetColecao;
    }

    public void setWidgetColecao(TempFilter widgetColecao) {
        this.widgetColecao = widgetColecao;
    }

    public TempFilter getWidgetLinhaProduto() {
        return widgetLinhaProduto;
    }

    public void setWidgetLinhaProduto(TempFilter widgetLinhaProduto) {
        this.widgetLinhaProduto = widgetLinhaProduto;
    }

    public TempFilter getWidgetCliente() {
        return widgetCliente;
    }

    public void setWidgetCliente(TempFilter widgetCliente) {
        this.widgetCliente = widgetCliente;
    }

    public TempFilter getWidgetEstadoCliente() {
        return widgetEstadoCliente;
    }

    public void setWidgetEstadoCliente(TempFilter widgetEstadoCliente) {
        this.widgetEstadoCliente = widgetEstadoCliente;
    }

    public TempFilter getWidgetTipoCliente() {
        return widgetTipoCliente;
    }

    public void setWidgetTipoCliente(TempFilter widgetTipoCliente) {
        this.widgetTipoCliente = widgetTipoCliente;
    }

    public TempFilter getWidgetCidadeCliente() {
        return widgetCidadeCliente;
    }

    public void setWidgetCidadeCliente(TempFilter widgetCidadeCliente) {
        this.widgetCidadeCliente = widgetCidadeCliente;
    }

    public TempFilter getWidgetProdutos() {
        return widgetProdutos;
    }

    public void setWidgetProdutos(TempFilter widgetProdutos) {
        this.widgetProdutos = widgetProdutos;
    }

    public TempFilter getWidgetArtigoProdutos() {
        return widgetArtigoProdutos;
    }

    public void setWidgetArtigoProdutos(TempFilter widgetArtigoProdutos) {
        this.widgetArtigoProdutos = widgetArtigoProdutos;
    }

    public TempFilter getWidgetContaDeEstoque() {
        return widgetContaDeEstoque;
    }

    public void setWidgetContaDeEstoque(TempFilter widgetContaDeEstoque) {
        this.widgetContaDeEstoque = widgetContaDeEstoque;
    }

    public TempFilter getWidgetRepresentante() {
        return widgetRepresentante;
    }

    public void setWidgetRepresentante(TempFilter widgetRepresentante) {
        this.widgetRepresentante = widgetRepresentante;
    }

    public int getColecao() {
        return colecao;
    }

    public void setColecao(int colecao) {
        this.colecao = colecao;
    }

    public int getLinhaProduto() {
        return linhaProduto;
    }

    public void setLinhaProduto(int linhaProduto) {
        this.linhaProduto = linhaProduto;
    }

    public int getRepresentante() {
        return representante;
    }

    public void setRepresentante(int representante) {
        this.representante = representante;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(int estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(int cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public int getProdutos() {
        return produtos;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    public int getArtigoProdutos() {
        return artigoProdutos;
    }

    public void setArtigoProdutos(int artigoProdutos) {
        this.artigoProdutos = artigoProdutos;
    }

    public int getContaDeEstoque() {
        return contaDeEstoque;
    }

    public void setContaDeEstoque(int contaDeEstoque) {
        this.contaDeEstoque = contaDeEstoque;
    }

    public int getAgrupamento() {
        return agrupamento;
    }

    public void setAgrupamento(int agrupamento) {
        this.agrupamento = agrupamento;
    }

    public int getQtdeValor() {
        return qtdeValor;
    }

    public void setQtdeValor(int qtdeValor) {
        this.qtdeValor = qtdeValor;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(int faturamento) {
        this.faturamento = faturamento;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVenda_faturamento() {
        return venda_faturamento;
    }

    public void setVenda_faturamento(int venda_faturamento) {
        this.venda_faturamento = venda_faturamento;
    }

    public String getConsideraCancelados() {
        return consideraCancelados;
    }

    public void setConsideraCancelados(String consideraCancelados) {
        this.consideraCancelados = consideraCancelados;
    }

    public float getPercPis() {
        return percPis;
    }

    public void setPercPis(float percPis) {
        this.percPis = percPis;
    }

    public float getPercCofins() {
        return percCofins;
    }

    public void setPercCofins(float percCofins) {
        this.percCofins = percCofins;
    }

    public float getCurvaA() {
        return curvaA;
    }

    public void setCurvaA(float curvaA) {
        this.curvaA = curvaA;
    }

    public float getCurvaB() {
        return curvaB;
    }

    public void setCurvaB(float curvaB) {
        this.curvaB = curvaB;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Mdi getMdi() {
        return mdi;
    }

    public void setMdi(Mdi mdi) {
        this.mdi = mdi;
    }

    public String getDataInicialSQL() {
        return dataInicialSQL;
    }

    public void setDataInicialSQL(String dataInicialSQL) {
        this.dataInicialSQL = dataInicialSQL;
    }

    public java.sql.Date getDataFinalSQL() {
        return dataFinalSQL;
    }

    public void setDataFinalSQL(java.sql.Date dataFinalSQL) {
        this.dataFinalSQL = dataFinalSQL;
    }

    public float getCurvaC() {
        return curvaC;
    }

    public void setCurvaC(float curvaC) {
        this.curvaC = curvaC;
    }


    @Override
    public String toString() {
        return "FiltrosParametros{" +
                "agrupamento=" + agrupamento +
                ", qtdeValor=" + qtdeValor +
                ", custo=" + custo +
                ", faturamento=" + faturamento +
                ", nivel=" + nivel +
                ", venda_faturamento=" + venda_faturamento +
                ", linhaProduto=" + linhaProduto +
                ", representante=" + representante +
                ", cliente=" + cliente +
                ", estadoCliente=" + estadoCliente +
                ", tipoCliente=" + tipoCliente +
                ", cidadeCliente=" + cidadeCliente +
                ", produtos=" + produtos +
                ", artigoProdutos=" + artigoProdutos +
                ", contaDeEstoque=" + contaDeEstoque +
                ", mesFinal=" + mesFinal +
                ", anoFinal=" + anoFinal +
                ", consideraCancelados='" + consideraCancelados + '\'' +
                ", percPis=" + percPis +
                ", percCofins=" + percCofins +
                ", curvaA=" + curvaA +
                ", curvaB=" + curvaB +
                ", curvaC=" + curvaC +
                ", dataFinal=" + dataFinal +
                ", dataInicial=" + dataInicial +
                ", dataInicialSQL='" + dataInicialSQL + '\'' +
                ", dataFinalSQL=" + dataFinalSQL +
                ", MDI='" + + this.mdi.codigo_empresa +
                '}';
    }
}
