package br.com.intersys.systextil.batch.pedi;

import br.com.intersys.systextil.exception.NoDataException;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import systextil.bo.geradorpdfcurvaabc.*;

import br.com.intersys.systextil.batch.base.BaseThread;
import systextil.temp.TempFilter;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class pedi_e015 extends BaseThread {

    private static String nomeArquivo = null;

    @Override
    protected void processarBatch() {
        /*
            Pegando dados da tabela oper_001
        */
        int empresaSelecionado = campo_31;
        int vendaFaturamento = campo_20;
        int opcaoRelatorio = campo_45;
        int qtdeValor = campo_05;
        int custo = campo_107;
        int faturamento = campo_32;
        String nivel = campo_91;
        String consideraCancelados = campo_15;
        Double percPis = campo_86;
        Double percConfins = campo_88;
        Double curvaA = campo_07;
        Double curvaB = campo_08;
        Double curvaC =  campo_09;
        int mesFinal = campo_03;
        int anoFinal = campo_04;
        int codigoEmp = codigo_empresa;
        String usuario = solicitante;
        int colecao = campo_71;
        int linhaProduto = campo_23;
        int representante = campo_72;
        int cliente = campo_74;
        int estadoCliente = campo_130;
        int tipoCliente = campo_75;
        int cidadeCliente = campo_76;
        int produtos = campo_77;
        int artigoProdutos = campo_78;
        int contaDeEstoque = campo_79;

        nomeArquivo = null;

        FiltrosParametros parametros = new FiltrosParametros(vendaFaturamento, opcaoRelatorio, qtdeValor, custo, faturamento,
                Integer.parseInt(nivel), consideraCancelados, percPis, percConfins, curvaA, curvaB, mesFinal, anoFinal,
                codigoEmp, usuario, curvaC, linhaProduto, representante, cliente, estadoCliente, tipoCliente,
                cidadeCliente, produtos, artigoProdutos, contaDeEstoque, colecao, empresaSelecionado);

        System.out.println(parametros.getCodigoEmpresa());

        parametros.setWidgetRepresentante(tempMap.get("campo_72"));
        parametros.setWidgetColecao(tempMap.get("campo_71"));
        parametros.setWidgetLinhaProduto(tempMap.get("campo_23"));
        parametros.setWidgetCliente(tempMap.get("campo_74"));
        parametros.setWidgetEstadoCliente(tempMap.get("campo_130"));
        parametros.setWidgetTipoCliente(tempMap.get("campo_75"));
        parametros.setWidgetCidadeCliente(tempMap.get("campo_76"));
        parametros.setWidgetProdutos(tempMap.get("campo_77"));
        parametros.setWidgetArtigoProdutos(tempMap.get("campo_78"));
        parametros.setWidgetContaDeEstoque(tempMap.get("campo_79"));

        try {
            gerarPDF(parametros);
        } catch (IOException err) {
            err.printStackTrace();
        }catch(SQLException err){
            err.printStackTrace();
        }

        try{
            insertSaida(nomeArquivo);
        }catch(NullPointerException err){
            err.printStackTrace();
        }
    }
    
    public static void gerarPDF(FiltrosParametros filtrosParametros) throws IOException, IOException, FileNotFoundException, SQLException {
        List<ConstrutorView> agrupamentos = ViewDAO.buscarDados(filtrosParametros);

        System.out.println(filtrosParametros.toString());
        if (agrupamentos.size() > 0) {
            Document doc;
            OutputStream opts;
            doc = new Document(PageSize.A4.rotate(), 20, 20, 75, 70);
            double a = Math.random();
            String b = Double.toString(a);

            Date date = new Date();
            nomeArquivo =  "curvaabc_" + filtrosParametros.getAgrupamento() + 
                    "_" + date.getDate() + "_" + MetodosUtils.retornaMes(date.getMonth()) + "_" + date.getTime() + ".pdf";
            opts = new FileOutputStream("C:\\Systextil\\App\\SystextilWeb\\relatorios\\" + nomeArquivo );

            try {
                PdfWriter writer = PdfWriter.getInstance(doc, opts);
                MetodosUtils.setNomeDoArquivo(nomeArquivo);
                
                /*
                    Foram criados 3 classes que representam os 
                    3 tipos de Layouts existentes até no momento.
                    Onde nessas classes existem regras que foram melhor
                    introduzidas dividindo em três.
                */
                switch (filtrosParametros.getAgrupamento()) {
                    case 1:
                    case 4:
                    case 8:
                    case 10:
                        LayoutTipoUm event = new LayoutTipoUm();
                        LayoutTipoUm.setFiltrosParametros(filtrosParametros);
                        writer.setPageEvent(event);
                        doc.open();
                        
                        event.body(doc, agrupamentos);
                        doc.close();
                        break;
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                        LayoutTipoDois event1 = new LayoutTipoDois();
                        LayoutTipoDois.setFiltrosParametros(filtrosParametros);
                        writer.setPageEvent(event1);
                        doc.open();
                        /*
                            Garante que será mostrado o TOTAL GERAL ao final 
                        do PDF
                        */
                        event1.setControleTotalGeral(true);
                        event1.body(doc, agrupamentos);
                        doc.close();
                        break;
                    case 7:
                        LayoutTipoDois event2 = new LayoutTipoDois();
                        LayoutTipoDois.setFiltrosParametros(filtrosParametros);
                        
                        List<ConstrutorView> listAux = new ArrayList<>();
                        List<List<ConstrutorView>> separadas = new ArrayList<>();
                        int contadorAux = 0;
                       
                        /*
                            Irá criar uma lista nova para cada agrupamento 1 
                        */
                        String agrupamentoControle = null;
                        for(ConstrutorView array : agrupamentos){
                            if(!array.getAGRUPAMENTO_1().equals(agrupamentoControle)){
                                agrupamentoControle = array.getAGRUPAMENTO_1();
                                if(listAux != null){
                                    separadas.add(listAux);
                                }
                                
                                listAux = new ArrayList<>();
                                listAux.add(array);
                               
                            }else{
                               listAux.add(array); 
                            }
                        }
               
                        writer.setPageEvent(event2);
                        doc.open();
                        
                        int contAux = 0;
                        /*
                            Garanto que setControleTotalGeral começará como 
                            false
                        */
                        event2.setControleTotalGeral(false);
                        for(List<ConstrutorView> array : separadas){
                              contAux++;
                              if(array.size() > 0){
                              /*
                                Quando está condição for verdadeira, setControleTotalGeral
                                receberá true, quando o mesmo for true poderá
                                ser escrito no PDF o TOTAL GERAL
                              */
                              if(contAux == separadas.size()){
                                  event2.setControleTotalGeral(true);
                              }
                              event2.body(doc, array);
                              }
                        }
                        
                        doc.close();
                        break;
                    case 9:
                        try {
                            LayoutTipoTres event4 = new LayoutTipoTres();
                            LayoutTipoTres.setFiltrosParametros(filtrosParametros);
                            writer.setPageEvent(event4);
                            doc.open();
                            event4.body(doc, agrupamentos);
                            doc.close();
                        }catch (OutOfMemoryError err){
                           err.printStackTrace();
                        }
                        break;
                }
            } catch (DocumentException err) {
                err.printStackTrace(); 
                doc.close();
                opts.close();
            }
            opts.close();

        }
    }
}
