package systextil.bo.geradorpdfcurvaabc;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LayoutRepresentante extends PdfPageEventHelper implements EstruturaPDF {

    private static List<Integer> arrTotaisCurva = null;
    private static List<Integer> arrTotalNumeroClientes = null;
    private static List<Integer> arrTotalGeral = null;
    private static FiltrosParametros filtrosParametros;
    private final static MetodosUtils metodosUtils = new MetodosUtils();

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        Date dataHora = new Date();
        SimpleDateFormat df;
        SimpleDateFormat hf;
        df = new SimpleDateFormat("dd/MM/yyyy");
        hf = new SimpleDateFormat("HH:mm:ss");

        String aux = null;
        try {
            aux = new String("MODULO: ADMINISTRAÇÃO DE VENDAS".getBytes("ISO-8859-2"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("EMPRESA: " + filtrosParametros.getMdi().nome_empresa,
                        Fontes.getTitle()), 15, 575, 0);
        String completaTitulo = metodosUtils.retornaTipoVendaFaturamento(filtrosParametros.getVenda_faturamento());
        completaTitulo = completaTitulo.replace("1", "");
        completaTitulo = completaTitulo.replace("2", "");
        completaTitulo = completaTitulo.replace("-", "");
        completaTitulo = completaTitulo.replace(" ", "");
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("PROGRAMA: CURVA ABC DE " + completaTitulo,
                        Fontes.getTitle()), 15, 560, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER,
                new Phrase(aux,
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
                new Phrase("VENDAS/FATURAMENTO: " + metodosUtils.retornaTipoVendaFaturamento(filtrosParametros.getVenda_faturamento()),
                        Fontes.getHeaderDefaultBold()), 15, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("PER�ODO: " + metodosUtils.retornaPerido(filtrosParametros.getDataInicial(), filtrosParametros.getDataFinal()),
                        Fontes.getHeaderDefaultBold()), 210, 539, 0);
        try {
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Paragraph.ALIGN_LEFT,
                    new Phrase("DIVIS�O: " + metodosUtils.retornaDivisao(filtrosParametros.getNivel()),
                            Fontes.getHeaderDefaultBold()), 330, 539, 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("TIPO NOTA/PEDIDO: " + metodosUtils.retornaTipoNotaProdutos(filtrosParametros.getFaturamento()),
                        Fontes.getHeaderDefaultBold()), 440, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("CONSIDERA CANCELADOS: " + metodosUtils.retornaConsideraCancelado(filtrosParametros.getConsideraCancelados()),
                        Fontes.getHeaderDefaultBold()), 580, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase(metodosUtils.retornaOpcaoRelatorio(filtrosParametros.getAgrupamento()),
                        Fontes.getHeaderDefaultBold()), 700, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase(metodosUtils.retornaOpcaoRelatorio(filtrosParametros.getAgrupamento()),
                        Fontes.getHeaderDefaultBold()), 700, 539, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("CURVA A AT�: " + filtrosParametros.getCurvaA() + " - CURVA B AT�" + filtrosParametros.getCurvaB() + " - CURVA C AT� - 35.00",
                        Fontes.getHeaderDefaultBold()), 15, 530, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("QTDE/VALOR: " + metodosUtils.retornaQuantidadeOuValor(filtrosParametros.getQtdeValor()),
                        Fontes.getHeaderDefaultBold()), 390, 530, 0);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Paragraph.ALIGN_LEFT,
                new Phrase("____________________________________________________"
                        + "_______________________________________________________________________________________________________________________________"
                        + "_________________________________",
                        Fontes.getHeaderDefaultBold()), 10, 526, 0);
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {

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
                new Phrase("Layout: ", Fontes.getMinFontGray()), 10, 13, 0);
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

    @Override
    public void body(Document document, final List<ConstrutorView> agrupamentos) {
        PdfPTable tabela = new PdfPTable(new float[]{5f, 75f, 15f, 15f, 15f,
                15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 8f, 15f,
                15f, 11f});
        tabela.setWidthPercentage(100);

        List<String> arrAgrupamento1 = new ArrayList<String>();
        for (ConstrutorView obj : agrupamentos) {
            System.out.println(obj.toString());
            if (!arrAgrupamento1.contains(obj.AGRUPAMENTO_1)) arrAgrupamento1.add(obj.AGRUPAMENTO_1);
        }

        /* borda 1 -> TOP
         * borda 2 -> BOTTOM
         */
        int contador = 0;
        String agrupamentoControle = null;
        List<Integer> arrTotais = null;
        boolean controle = false;
        arrTotalGeral =new ArrayList<Integer>()
        {
            {
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
            }
        };

        arrTotalNumeroClientes = new ArrayList<Integer>() {
            {
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
            }
        };
        for (ConstrutorView obj : agrupamentos) {
            if (!obj.getCURVAGERAL().equals(agrupamentoControle)) {
                agrupamentoControle = obj.getCURVAGERAL();
                contador = 1;
                if (controle == true) {
                    montaLinhaTotalCurva(arrTotaisCurva, tabela, 1, 0);
                    montaLinhaTotalCurva(arrTotalNumeroClientes, tabela, 1, 1);
                    montaLinhaTotalCurva(arrTotais, tabela, 2, 2);
                }

                arrTotaisCurva = new ArrayList<Integer>();
                arrTotais = new ArrayList<Integer>();
                arrTotalNumeroClientes = new ArrayList<Integer>() {
                    {
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                    }
                };

                try {
                    //montaHeader(obj, tabela);
                    montaHeader2(obj, tabela);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                montaLinhaDadosCliente(obj, tabela, 2, contador++);

                arrTotaisCurva.add(0, obj.MES01);
                arrTotaisCurva.add(1, obj.MES02);
                arrTotaisCurva.add(2, obj.MES03);
                arrTotaisCurva.add(3, obj.MES04);
                arrTotaisCurva.add(4, obj.MES05);
                arrTotaisCurva.add(5, obj.MES06);
                arrTotaisCurva.add(6, obj.MES07);
                arrTotaisCurva.add(7, obj.MES08);
                arrTotaisCurva.add(8, obj.MES09);
                arrTotaisCurva.add(9, obj.MES10);
                arrTotaisCurva.add(10, obj.MES11);
                arrTotaisCurva.add(11, obj.MES12);
                arrTotaisCurva.add(12, obj.MES13);

                montaLinhaTotalCurva(arrTotaisCurva, tabela, 2, 0);

                arrTotaisCurva.set(0, (int) ((int) obj.GR1_MES01 - arrTotaisCurva.get(0)));
                arrTotaisCurva.set(1, (int) ((int) obj.GR1_MES02 - arrTotaisCurva.get(1)));
                arrTotaisCurva.set(2, (int) ((int) obj.GR1_MES03 - arrTotaisCurva.get(2)));
                arrTotaisCurva.set(3, (int) ((int) obj.GR1_MES04 - arrTotaisCurva.get(3)));
                arrTotaisCurva.set(4, (int) ((int) obj.GR1_MES05 - arrTotaisCurva.get(4)));
                arrTotaisCurva.set(5, (int) ((int) obj.GR1_MES06 - arrTotaisCurva.get(5)));
                arrTotaisCurva.set(6, (int) ((int) obj.GR1_MES07 - arrTotaisCurva.get(6)));
                arrTotaisCurva.set(7, (int) ((int) obj.GR1_MES08 - arrTotaisCurva.get(7)));
                arrTotaisCurva.set(8, (int) ((int) obj.GR1_MES09 - arrTotaisCurva.get(8)));
                arrTotaisCurva.set(9, (int) ((int) obj.GR1_MES10 - arrTotaisCurva.get(9)));
                arrTotaisCurva.set(10, (int) ((int) obj.GR1_MES11 - arrTotaisCurva.get(10)));
                arrTotaisCurva.set(11, (int) ((int) obj.GR1_MES12 - arrTotaisCurva.get(11)));
                arrTotaisCurva.set(12, (int) ((int) obj.GR1_MES13 - arrTotaisCurva.get(12)));

                arrTotais.add(0, (int) obj.GR1_MES01);
                arrTotais.add(1, (int) obj.GR1_MES02);
                arrTotais.add(2, (int) obj.GR1_MES03);
                arrTotais.add(3, (int) obj.GR1_MES04);
                arrTotais.add(4, (int) obj.GR1_MES05);
                arrTotais.add(5, (int) obj.GR1_MES06);
                arrTotais.add(6, (int) obj.GR1_MES07);
                arrTotais.add(7, (int) obj.GR1_MES08);
                arrTotais.add(8, (int) obj.GR1_MES09);
                arrTotais.add(9, (int) obj.GR1_MES10);
                arrTotais.add(10, (int) obj.GR1_MES11);
                arrTotais.add(11, (int) obj.GR1_MES12);
                arrTotais.add(12, (int) obj.GR1_MES13);
                arrTotais.add(13, (int) obj.VENDIDO_GR1);

                controle = true;
            } else {
                montaLinhaDadosCliente(obj, tabela, 0, contador++);
            }

    }

    montaLinhaTotalCurva(arrTotalNumeroClientes, tabela, 1,1);
    montaLinhaTotalCurva(arrTotalGeral, tabela, 0,3);

    try{
        document.add(tabela);
    } catch(DocumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

    public static void montaLinhaDadosCliente(ConstrutorView obj, PdfPTable tabela, int bordas, int posicao) {
        int mesControle = 0;
        for (int h = 0; h < 20; h++) {
            Paragraph phrase = null;
            PdfPCell cell = new PdfPCell();
            cell.setFixedHeight(15f);
            cell.setBorder(0);
            cell.setPadding(0);
            cell.setPaddingTop(-1);
            cell.setPaddingBottom(4);
            cell.setBorder(bordas);
            cell.setBorderWidth(1.5f);

            switch (h) {
                case 0:
                    phrase = new Paragraph(new Phrase("" + posicao + "", Fontes.getHeaderTableDefaultBold()));
                    phrase.setAlignment(Paragraph.ALIGN_RIGHT);
                    cell.addElement(phrase);
                    break;
                case 1:
                    phrase = new Paragraph(new Phrase("" + obj.AGRUPAMENTO_1 + " " + obj.DESCRICAO_AGRUPAMENTO1, Fontes.getHeaderTableDefaultBold()));
                    cell.addElement(phrase);
                    cell.setPaddingLeft(5);
                    break;
                case 2:
                    phrase = new Paragraph(new Phrase("" + obj.MES01 + " " + obj.CURVAMES01, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES01;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES01, 0);
                    totalGeralRepresentante(arrTotalGeral, 0, obj.MES01);
                    break;
                case 3:
                    phrase = new Paragraph(new Phrase("" + obj.MES02 + " " + obj.CURVAMES02, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES02;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES02, 1);
                    totalGeralRepresentante(arrTotalGeral, 1, obj.MES02);

                    break;
                case 4:
                    phrase = new Paragraph(new Phrase("" + obj.MES03 + " " + obj.CURVAMES03, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES03;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES03, 2);
                    totalGeralRepresentante(arrTotalGeral, 2, obj.MES03);
                    break;
                case 5:
                    phrase = new Paragraph(new Phrase("" + obj.MES04 + " " + obj.CURVAMES04, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES04;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES04, 3);
                    totalGeralRepresentante(arrTotalGeral, 3, obj.MES04);
                    break;
                case 6:
                    phrase = new Paragraph(new Phrase("" + obj.MES05 + " " + obj.CURVAMES05, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES05;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES05, 4);
                    totalGeralRepresentante(arrTotalGeral, 4, obj.MES05);
                    break;
                case 7:
                    phrase = new Paragraph(new Phrase("" + obj.MES06 + " " + obj.CURVAMES06, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES06;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES06, 5);
                    totalGeralRepresentante(arrTotalGeral, 5, obj.MES06);
                    break;
                case 8:
                    phrase = new Paragraph(new Phrase("" + obj.MES07 + " " + obj.CURVAMES07, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES07;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES07, 6);
                    totalGeralRepresentante(arrTotalGeral, 6, obj.MES07);
                    break;
                case 9:
                    phrase = new Paragraph(new Phrase("" + obj.MES08 + " " + obj.CURVAMES08, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES08;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES08, 7);
                    totalGeralRepresentante(arrTotalGeral, 7, obj.MES08);
                    break;
                case 10:
                    phrase = new Paragraph(new Phrase("" + obj.MES09 + " " + obj.CURVAMES09, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES09;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES09, 8);
                    totalGeralRepresentante(arrTotalGeral, 8, obj.MES09);
                    break;
                case 11:
                    phrase = new Paragraph(new Phrase("" + obj.MES10 + " " + obj.CURVAMES10, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES10;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES10, 9);
                    totalGeralRepresentante(arrTotalGeral, 9, obj.MES10);
                    break;
                case 12:
                    phrase = new Paragraph(new Phrase("" + obj.MES11 + " " + obj.CURVAMES11, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES11;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES11, 10);
                    totalGeralRepresentante(arrTotalGeral, 10, obj.MES11);
                    break;
                case 13:
                    phrase = new Paragraph(new Phrase("" + obj.MES12 + " " + obj.CURVAMES12, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES12;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES12, 11);
                    totalGeralRepresentante(arrTotalGeral, 11, obj.MES12);
                    break;
                case 14:
                    phrase = new Paragraph(new Phrase("" + obj.MES13 + " " + obj.CURVAMES13, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES13;
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, obj.MES13, 12);
                    totalGeralRepresentante(arrTotalGeral, 12, obj.MES13);
                    break;
                case 15:
                    phrase = new Paragraph(new Phrase("" + (int) obj.VENDIDO + "", Fontes.getHeaderTableDefaultBold()));
                    verificaNumeroRepresentantes(arrTotalNumeroClientes, (int) obj.VENDIDO, 13);
                    totalGeralRepresentante(arrTotalGeral, 13, (int) obj.VENDIDO);
                    cell.addElement(phrase);
                    cell.setPaddingRight(1);
                    cell.setHorizontalAlignment(1);
                    break;
                case 16:
                    phrase = new Paragraph(new Phrase("" + obj.PARTICIPACAO_GERAL + " " + obj.CURVAMES13, Fontes.getHeaderTableDefaultBold()));
                    cell.addElement(phrase);
                    cell.setPaddingRight(1);
                    cell.setHorizontalAlignment(1);
                    break;
                case 17:
                    phrase = new Paragraph(new Phrase("" + obj.MEDIA + "", Fontes.getHeaderTableDefaultBold()));
                    cell.addElement(phrase);
                    cell.setPaddingRight(1);
                    cell.setHorizontalAlignment(1);
                    break;
                case 18:
                    phrase = new Paragraph(new Phrase("" + obj.ACUM_PARTICIPACAO_GERAL + "", Fontes.getHeaderTableDefaultBold()));
                    cell.addElement(phrase);
                    cell.setPaddingRight(1);
                    cell.setHorizontalAlignment(1);
                    break;
                case 19:
                    phrase = new Paragraph(new Phrase(obj.CURVAGERAL, Fontes.getHeaderTableDefaultBold()));
                    cell.setPaddingLeft(4);
                    break;
                default:

                    break;
            }

            if (h > 1 && h < 15) {
                phrase.setAlignment(Paragraph.ALIGN_RIGHT);
                if (mesControle == 0) {
                    cell.setPaddingRight(6);
                } else {
                    cell.setPaddingRight(1);
                }
                cell.addElement(phrase);
                cell.setHorizontalAlignment(1);
            } else if (h >= 15) {
                if (h == 15) {
                    cell.setPaddingRight(3);
                } else {
                    cell.setPaddingRight(1);
                }

                phrase.setAlignment(Paragraph.ALIGN_RIGHT);
                cell.addElement(phrase);
            }

            tabela.addCell(cell);
        }
    }

    public static void montaLinhaTotalCurva(List<Integer> arr, PdfPTable tabela, int borda, int select) {
        String texto = null;
        int paddingTop = 0;
        Font fonte = null;
        for (int h = 0; h < 20; h++) {
            Paragraph phrase = null;
            PdfPCell cell = new PdfPCell();
            cell.setFixedHeight(13f);
            cell.setPadding(0);
            cell.setBorder(borda);
            cell.setBorderWidth(1.5f);
            if (h <= 14) {
                switch (h) {
                    case 0:
                        phrase = new Paragraph(new Phrase(" ", Fontes.getDefault()));
                        break;
                    case 1:
                        switch (select) {
                            case 0:
                                texto = "TOTAL CURVA";
                                break;
                            case 1:
                                texto = "N�MERO REPRESENTANTES";
                                break;
                            case 2:
                                texto = "TOTAIS..............:";
                                break;
                            case 3:
                                paddingTop = 4;
                                texto = "TOTAIS..............:";
                                break;
                            default:
                                break;
                        }

                        if (select >= 0 && select <= 1) fonte = Fontes.getHeaderTableDefaultBold();
                        else fonte = Fontes.getHeaderTableBold();

                        phrase = new Paragraph(new Phrase(texto, fonte));
                        phrase.setAlignment(Element.ALIGN_LEFT);
                        cell.addElement(phrase);
                        cell.setPaddingLeft(15);
                        cell.setPaddingTop(paddingTop);
                        break;
                    case 2:
                        phrase = new Paragraph(new Phrase("" + arr.get(0) + "", fonte));
                        break;
                    case 3:
                        phrase = new Paragraph(new Phrase("" + arr.get(1) + "", fonte));
                        break;
                    case 4:
                        phrase = new Paragraph(new Phrase("" + arr.get(2) + "", fonte));
                        break;
                    case 5:
                        phrase = new Paragraph(new Phrase("" + arr.get(3) + "", fonte));
                        break;
                    case 6:
                        phrase = new Paragraph(new Phrase("" + arr.get(4) + "", fonte));
                        break;
                    case 7:
                        phrase = new Paragraph(new Phrase("" + arr.get(5) + "", fonte));
                        break;
                    case 8:
                        phrase = new Paragraph(new Phrase("" + arr.get(6) + "", fonte));
                        break;
                    case 9:
                        phrase = new Paragraph(new Phrase("" + arr.get(7) + "", fonte));
                        break;
                    case 10:
                        phrase = new Paragraph(new Phrase("" + arr.get(8) + "", fonte));
                        break;
                    case 11:
                        phrase = new Paragraph(new Phrase("" + arr.get(9) + "", fonte));
                        break;
                    case 12:
                        phrase = new Paragraph(new Phrase("" + arr.get(10) + "", fonte));
                        break;
                    case 13:
                        phrase = new Paragraph(new Phrase("" + arr.get(11) + "", fonte));
                        break;
                    case 14:
                        phrase = new Paragraph(new Phrase("" + arr.get(12) + "", fonte));
                        break;
                }

                if (h != 1) {
                    phrase.setAlignment(Paragraph.ALIGN_RIGHT);
                    cell.addElement(phrase);
                    cell.setPaddingRight(6);
                    if (select == 3) {
                        cell.setPaddingTop(4);
                    }
                }
            }

            if (h == 15 && select != 0) {
                phrase = new Paragraph(new Phrase("" + arr.get(13) + "", fonte));
                phrase.setAlignment(Paragraph.ALIGN_RIGHT);
                cell.addElement(phrase);
                cell.setPaddingRight(3);
                if (select == 3) {
                    cell.setPaddingTop(4);
                }
            }

            tabela.addCell(cell);
        }
    }

    public static void montaHeader2(final ConstrutorView construtorView, PdfPTable tabela) throws ParseException {
        Paragraph paragraph = null;
        PdfPCell cell = null;
        /*
            Cria uma linha em branco, para deixar espaço entre os inicios
            e fins de cada representante
         */
        for (int i = 0; i < 15; i++) {
            paragraph = new Paragraph(new Phrase("     ", Fontes.getHeaderTableDefaultBold()));
            cell = new PdfPCell(paragraph);
            cell.setBorder(0);
            cell.setFixedHeight(10);
            tabela.addCell(cell);
        }

        paragraph = new Paragraph(new Phrase(" -------------- TOTAIS DO ANO --------------- ", Fontes.getHeaderTableDefaultBold()));
        cell = new PdfPCell(paragraph);
        cell.setColspan(6);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingTop(25f);
        tabela.addCell(cell);

        List<String> headers = new ArrayList<String>() {
            {
                add("ORDEM");
            }
        };

      switch (filtrosParametros.getAgrupamento()){
          case 1:
              headers.add("REPRESENTANTES");
              break;
          case 4:
              headers.add("CLIENTES");
              break;
      }

        MetodosUtils.getMeses(headers, filtrosParametros.getDataFinal());

        if (metodosUtils.retornaQuantidadeOuValor(filtrosParametros.getQtdeValor()).equals("QUANTIDADE")) {
            headers.add("QTDE");
        } else {
            headers.add("VALOR");
        }
        headers.add("%");
        headers.add("M�DIA");
        headers.add("% ACUM");
        headers.add("ABC");

        for (int i = 0; i < 15; i++) {
            Font fonteParagraph = null;
            if (headers.get(i).equals("ORDEM")
                    || headers.get(i).equals("REPRESENTANTES")
                    || headers.get(i).equals("CLIENTES")) {
                fonteParagraph = Fontes.getHeaderTableBold();
            } else {
                fonteParagraph = Fontes.getHeaderTableDefaultBold();
            }
            paragraph = new Paragraph(new Phrase("" + headers.get(i) + "", fonteParagraph));
            cell = new PdfPCell(paragraph);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setFixedHeight(10F);
            cell.setPaddingTop(13);
            if (headers.get(i).equals("ORDEM")) {
                cell.setPaddingRight(-20f);
                cell.setHorizontalAlignment(0);
            } else if (headers.get(i).equals("REPRESENTANTES")
                        || headers.get(i).equals("CLIENTES")) {
                cell.setPaddingLeft(15f);
                cell.setHorizontalAlignment(0);
            } else {
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            }
            cell.setBorder(Rectangle.BOTTOM);
            cell.setPaddingBottom(0);
            tabela.addCell(cell);
        }

        for (int i = 15; i < 20; i++) {
            paragraph = new Paragraph(new Phrase("" + headers.get(i) + "",
                    Fontes.getHeaderTableDefaultBold()));
            cell = new PdfPCell(paragraph);
            cell.setPadding(0);
            cell.setPaddingTop(13f);
            cell.setPaddingBottom(5f);
            cell.setBorder(Rectangle.BOTTOM);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            if (headers.get(i).equals("QTDE") || headers.get(i).equals("Valor")) {
                cell.setPaddingLeft(0);
                cell.setPaddingRight(3);
            } else if (headers.get(i).equals("%")) {
                cell.setPadding(2);
                cell.setPaddingTop(13f);
            } else if (headers.get(i).equals("MÉDIA")) {
                cell.setPadding(2);
                cell.setPaddingTop(13f);
            } else if (headers.get(i).equals("% ACUM")) {
                cell.setPaddingRight(0);
            } else if (headers.equals("ABC")) {
                cell.setPaddingLeft(0.5f);
            }

            tabela.addCell(cell);
        }
    }

    public static void verificaNumeroRepresentantes(List<Integer> arr, int mes, int index) {
            if(mes != 0) {
                arr.set(index, arr.get(index) + 1);
            }
    }

    public static void totalGeralRepresentante(List<Integer> arr, int index, int valor){
        arr.set(index, arr.get(index) + valor);
    }

    public static FiltrosParametros getFiltrosParametros() {
        return filtrosParametros;
    }

    public static void setFiltrosParametros(FiltrosParametros filtrosParametros) {
        LayoutRepresentante.filtrosParametros = filtrosParametros;
    }
}
