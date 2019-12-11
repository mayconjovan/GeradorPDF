package systextil.bo.geradorpdfcurvaabc;

import com.lowagie.text.*;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MetodosUtils {
    
    private static String nomeDoArquivo;

    public static String retornaTipoVendaFaturamento(int vendaFaturamento) {
        String retorno = null;
        switch (vendaFaturamento) {
            case 1:
                retorno = "1 - VENDAS";
                break;
            case 2:
                retorno = "2 - FATURAMENTO";
                break;
        }

        return retorno;
    }

    public static String retornaPerido(Date d1, Date d2) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(d1);
        String editD1 = retornaNumeroMes(cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR);

        cal.setTime(d2);

        String editD2 = retornaNumeroMes(cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR);

        String retorno = editD1 + " A " + editD2;

        return retorno;
    }

    public static String retornaDivisao(int divisao) throws UnsupportedEncodingException {
        String retorno = null;
        switch (divisao) {
            case 1:
                retorno = "PEÇAS";
                break;
            case 2:
                retorno = "TECIDOS";
                break;
            case 7:
                retorno = "TECIDOS CRÚ";
                break;
            case 9:
                retorno = "OUTROS";
                break;
            case 99:
                retorno = "TODOS OS NÍVEIS";
                ByteBuffer aux = java.nio.charset.StandardCharsets.UTF_8.encode(retorno);
                retorno = new String(aux.array(), "UTF-8");
                break;
        }

        return retorno;
    }

    public static String retornaTipoNotaProdutos(int tipoNotaProtutos) {
        String retorno = null;
        switch (tipoNotaProtutos) {
            case 1:
                retorno = "FATURAMENTO";
                break;
            case 2:
                retorno = "OUTROS";
                break;
            case 0:
                retorno = "AMBOS";
                break;
        }

        return retorno;
    }

    public static String retornaQuantidadeOuValor(int params) {
        String retorno = null;
        switch (params) {
            case 1:
                retorno = "QUANTIDADE";
                break;
            case 2:
                retorno = "VALOR";
                break;
        }

        return retorno;
    }

    public static String retornaConsideraCancelado(String params) {
        if (params.equals("S")) {
            return "SIM";
        } else {
            return "NÃƒO";
        }
    }

    public static String retornaOpcaoRelatorio(int opcao) {
        String retorno = null;
        switch (opcao) {
            case 1:
                retorno = "POR REPRESENTANTE";
                break;
            case 2:
                retorno = "POR REPRESENTANTE/CLIENTE";
                break;
            case 3:
                retorno = "POR PRODUTO/REPRESENTANTE";
                break;
            case 4:
                retorno = "POR CLIENTE";
                break;
            case 5:
                retorno = "POR PRODUTO/CLIENTE";
                break;
            case 6:
                retorno = "POR REPRESENTANTE/PRODUTO";
                break;
            case 7:
                retorno = "POR CLIENTE/PRODUTO";
                break;
            case 8:
                retorno = "POR PRODUTO";
                break;
            case 9:
                retorno = "POR PRODUTO/MARGEM";
                break;
            case 10:
                retorno = "POR PRODUTO/NARRATIVA";
                break;
        }

        return retorno;
    }

    public static List<String> getMeses(List<String> arr, Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = null;
        try {
            d1 = format.parse("10-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR));

            for (Date d2 = format.parse("10-" + (cal.get(Calendar.MONTH) + 1) + "-" + (cal.get(Calendar.YEAR) - 1));
                 d2.before(d1) || d2.equals(d1);
                 d2.setMonth(d2.getMonth() + 1)) {
                arr.add(retornaMes(d2.getMonth()));
            }
        } catch (ParseException err) {
            err.printStackTrace();
        }

        return arr;
    }

    public static String retornaMes(int args0) {
        String mes = null;
        switch (args0) {
            case 0:
                mes = "JAN";
                break;
            case 1:
                mes = "FEV";
                break;
            case 2:
                mes = "MAR";
                break;
            case 3:
                mes = "ABR";
                break;
            case 4:
                mes = "MAI";
                break;
            case 5:
                mes = "JUN";
                break;
            case 6:
                mes = "JUL";
                break;
            case 7:
                mes = "AGO";
                break;
            case 8:
                mes = "SET";
                break;
            case 9:
                mes = "OUT";
                break;
            case 10:
                mes = "NOV";
                break;
            case 11:
                mes = "DEZ";
                break;
            default:
                break;
        }

        return mes;
    }

    public static int retornaNumeroMes(int mes) {
        int retorno = 0;
        switch (mes) {
            case 0:
                retorno = 1;
                break;
            case 1:
                retorno = 2;
                break;
            case 2:
                retorno = 3;
                break;
            case 3:
                retorno = 4;
                break;
            case 4:
                retorno = 5;
                break;
            case 5:
                retorno = 6;
                break;
            case 6:
                retorno = 7;
                break;
            case 7:
                retorno = 8;
                break;
            case 8:
                retorno = 9;
                break;
            case 9:
                retorno = 10;
                break;
            case 10:
                retorno = 11;
                break;
            case 11:
                retorno = 12;
                break;
        }

        return retorno;
    }

    public static String retornaMesInglesSQL(int args0) {
        String mes = null;
        switch (args0) {
            case 0:
                mes = "JAN";
                break;
            case 1:
                mes = "FEB";
                break;
            case 2:
                mes = "MAR";
                break;
            case 3:
                mes = "APR";
                break;
            case 4:
                mes = "MAY";
                break;
            case 5:
                mes = "JUN";
                break;
            case 6:
                mes = "JUL";
                break;
            case 7:
                mes = "AUG";
                break;
            case 8:
                mes = "SEP";
                break;
            case 9:
                mes = "OCT";
                break;
            case 10:
                mes = "NOV";
                break;
            case 11:
                mes = "DEC";
                break;
            default:
                break;
        }

        return mes;
    }

    public static String formatarFloat(float numero) {
        String retorno = "";
        if(numero >= 1.00) {
            DecimalFormat formatter = new DecimalFormat("#.00");
            try {
                retorno = formatter.format(numero);
            } catch (Exception err) {
                System.err.println("Erro ao formatar numero: " + err);
            }
        }else{
            DecimalFormat formatter = new DecimalFormat("0.00");
            try {
                retorno = formatter.format(numero);
            } catch (Exception err) {
                System.err.println("Erro ao formatar numero: " + err);
            }
        }

        return retorno;
    }

    public static void headerPDF(Document document, PdfWriter writer, FiltrosParametros filtrosParametros){
        Date dataHora = new Date();
        SimpleDateFormat df;
        SimpleDateFormat hf;
        df = new SimpleDateFormat("dd/MM/yyyy");
        hf = new SimpleDateFormat("HH:mm:ss");

        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("EMPRESA: " + filtrosParametros.getMdi().nome_empresa,
                        Fontes.getTitle()), 15, 575, 0);
        String completaTitulo = retornaTipoVendaFaturamento(filtrosParametros.getVenda_faturamento());
        completaTitulo = completaTitulo.replace("1", "");
        completaTitulo = completaTitulo.replace("2", "");
        completaTitulo = completaTitulo.replace("-", "");
        completaTitulo = completaTitulo.replace(" ", "");
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("PROGRAMA: CURVA ABC DE " + completaTitulo + " - " + retornaOpcaoRelatorio(filtrosParametros.getAgrupamento()),
                        Fontes.getTitle()), 15, 560, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER,
                new Phrase("MODULO: ADMINISTRAÇÃO DE VENDAS",
                        Fontes.getTitle()), 420, 575, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER,
                new Phrase(df.format(dataHora) + " - " + hf.format(dataHora) + " - Pagina: " + document.getPageNumber(),
                        Fontes.getTitle()), 770, 575, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getLinered()), 10, 551, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getLinered()), 10, 550, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getLineredGray()), 10, 549, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getLineredGray()), 10, 548, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("VENDAS/FATURAMENTO: " + retornaTipoVendaFaturamento(filtrosParametros.getVenda_faturamento()),
                        Fontes.getHeaderDefaultBold()), 15, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("PERÍODO: " + retornaPerido(filtrosParametros.getDataInicial(), filtrosParametros.getDataFinal()),
                        Fontes.getHeaderDefaultBold()), 230, 539, 0);
        try {
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Paragraph.ALIGN_LEFT,
                    new Phrase("DIVISÃO: " + retornaDivisao(filtrosParametros.getNivel()),
                            Fontes.getHeaderDefaultBold()), 380, 539, 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("TIPO NOTA/PEDIDO: " + retornaTipoNotaProdutos(filtrosParametros.getFaturamento()),
                        Fontes.getHeaderDefaultBold()), 500, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("CONSIDERA CANCELADOS: " + retornaConsideraCancelado(filtrosParametros.getConsideraCancelados()),
                        Fontes.getHeaderDefaultBold()), 650, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase(String.format("CURVA A ATÉ " + formatarFloat(filtrosParametros.getCurvaA()) + " - CURVA B ATÉ "
                        + formatarFloat(filtrosParametros.getCurvaB()) + " - CURVA C ATÉ " + formatarFloat(filtrosParametros.getCurvaC())),
                        Fontes.getHeaderDefaultBold()), 15, 530, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("QTDE/VALOR: " + retornaQuantidadeOuValor(filtrosParametros.getQtdeValor()),
                        Fontes.getHeaderDefaultBold()), 380, 530, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getHeaderDefaultBold()), 10, 526, 0);
    }

    public static void footerPDF(Document document, PdfWriter writer){
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getLinered()), 10, 41, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getLinered()), 10, 40, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________", Fontes.getLineredGray()), 10, 39, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________", Fontes.getLineredGray()), 10, 38, 0);

        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("Programa: PEDI_E015", Fontes.getMinFontGray()), 10, 20, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("Layout: " + nomeDoArquivo, Fontes.getMinFontGray()), 10, 13, 0);
        Image image = null;
        try {
            image = Image.getInstance("C:\\Systextil\\App\\SystextilWeb\\imagens\\logosystextil.png");
            image.setAlignment(Paragraph.ALIGN_RIGHT);
            image.setAbsolutePosition(750, 12);
            image.scalePercent(6f, 6f);
            writer.getDirectContent().addImage(image, true);
        } catch (DocumentException | IOException err) {
            err.printStackTrace();
        }
    }

    public static String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public static void setNomeDoArquivo(String nomeDoArquivo) {
        MetodosUtils.nomeDoArquivo = nomeDoArquivo;
    }

    

}
