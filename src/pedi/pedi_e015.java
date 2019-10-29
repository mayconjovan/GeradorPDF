package br.com.intersys.systextil.batch.pedi;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import systextil.bo.geradorpdfcurvaabc.*;


import br.com.intersys.systextil.batch.base.BaseThread;

import java.io.*;
import java.util.List;

public class pedi_e015 extends BaseThread {

    @Override
    protected void processarBatch(){
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
        int mesFinal = campo_03;
        int anoFinal = campo_04;
        int codigoEmp = codigo_empresa;
        String usuario = solicitante;

        FiltrosParametros parametros = new FiltrosParametros(vendaFaturamento, opcaoRelatorio, qtdeValor, custo, faturamento,
                Integer.parseInt(nivel), consideraCancelados, percPis, percConfins, curvaA, curvaB,
                mesFinal, anoFinal, codigoEmp, usuario);
        try {
            gerarPDF(parametros);
        } catch (IOException err) {
            err.printStackTrace();
        }
        System.out.println("Funcionou!");
    }

    public static void gerarPDF(FiltrosParametros filtrosParametros) throws IOException, IOException, FileNotFoundException {

        Document doc;
        OutputStream opts;
        doc = new Document(PageSize.A4.rotate(), 20, 20, 100, 100);
        double a = Math.random();
        String b = Double.toString(a);

        opts = new FileOutputStream("C:\\Systextil\\App\\SystextilWeb\\" + b + ".pdf");
        String path = "C:\\Systextil\\App\\SystextilWeb\\" + b + ".pdf";

        System.out.println(path);
        try {
            PdfWriter writer = PdfWriter.getInstance(doc, opts);

            List<ConstrutorView> agrupamentos = ViewDAO.buscarDados(filtrosParametros);
            if(filtrosParametros.getAgrupamento() == 1
                || filtrosParametros.getAgrupamento() == 4){
                LayoutRepresentante event = new LayoutRepresentante();
                LayoutRepresentante.setFiltrosParametros(filtrosParametros);
                writer.setPageEvent(event);
                doc.open();
                event.body(doc, agrupamentos);
                doc.close();
            } else if(filtrosParametros.getAgrupamento() == 2
                    || filtrosParametros.getAgrupamento() == 6) {
                LayoutRepresentanteECliente event = new LayoutRepresentanteECliente();
                LayoutRepresentanteECliente.setFiltrosParametros(filtrosParametros);
                writer.setPageEvent(event);
                doc.open();
                event.body(doc, agrupamentos);
                doc.close();
            }
        } catch (DocumentException err) {
            err.printStackTrace();
        }

        opts.close();
    }
}
