package systextil.bo.geradorpdfcurvaabc;

import br.com.intersys.systextil.connection.AppConnection;
import br.com.intersys.systextil.global.Mdi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FiltrosParametros {
    
    private int agrupamento, qtdeValor, custo, faturamento, nivel, venda_faturamento;
    private String consideraCancelados;
    private float percPis, percCofins, curvaA, curvaB;
    private int mesFinal, anoFinal;
    private Date dataFinal;
    private Date dataInicial;
    private String dataInicialSQL;
    private java.sql.Date dataFinalSQL;
    private Mdi mdi;
    //parametros localizados no Where do Sql
     
    //public Date termino;

    public FiltrosParametros(int venda_faturamento, int agrupamento, int qtdeValor, int custo, int faturamento,
                             int nivel, String consideraCancelados, Double percPis, Double percConfins, Double curvaA,
                             Double curvaB,int mesFinal, int anoFinal, int codigoEmpresa, String usuario) {

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
        mdi = new Mdi(codigoEmpresa, usuario);

        SimpleDateFormat sf = new SimpleDateFormat("MM-yyyy");
        try{
            Date data = sf.parse(mesFinal + "-" + anoFinal);
            this.dataFinal = data;
            data = sf.parse(mesFinal + "-" + (anoFinal - 1));
            this.dataInicial = data;

            dataInicialSQL = "28/"+ MetodosUtils.retornaMesInglesSQL((mesFinal - 1)) +"/" + anoFinal ;

            System.out.println(dataInicialSQL);
        }catch (ParseException err){
            err.printStackTrace();
        }

        System.out.println(toString());
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

    @Override
    public String toString() {
        return "FiltrosParametros{" +
                "agrupamento=" + agrupamento +
                ", qtdeValor=" + qtdeValor +
                ", custo=" + custo +
                ", faturamento=" + faturamento +
                ", nivel=" + nivel +
                ", venda_faturamento=" + venda_faturamento +
                ", consideraCancelados='" + consideraCancelados + '\'' +
                ", percPis=" + percPis +
                ", percCofins=" + percCofins +
                ", curvaA=" + curvaA +
                ", curvaB=" + curvaB +
                ", dataFinal=" + dataFinal +
                ", dataInicial=" + dataInicial +
                '}';
    }


}
