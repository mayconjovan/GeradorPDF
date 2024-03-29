package systextil.bo.geradorpdfcurvaabc;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class LayoutTipoDois extends PdfPageEventHelper implements EstruturaPDF {

    private static List<Integer> arrTotaisCurva = null;
    private static List<Integer> arrTotalNumeroClientes = null;
    private static List<Integer> arrTotalGeral = null;
    private static FiltrosParametros filtrosParametros;
    private static boolean controleTotalGeral = true;

    public static boolean isControleTotalGeral() {
        return controleTotalGeral;
    }

    public static void setControleTotalGeral(boolean controleTotalGeral) {
        LayoutTipoDois.controleTotalGeral = controleTotalGeral;
    }

    
    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        MetodosUtils.headerPDF(document, writer, filtrosParametros);
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        MetodosUtils.footerPDF(document, writer);
    }

    @Override
    public void body(Document document, final List<ConstrutorView> agrupamentos) {
        PdfPTable tabela = new PdfPTable(new float[]{7f, 75f, 15f, 15f, 15f,
                15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 8f, 18f,
                11f, 11f});
        tabela.setWidthPercentage(100);

        List<String> arrAgrupamento1 = new ArrayList<String>();
        for (ConstrutorView obj : agrupamentos) {
            if (!arrAgrupamento1.contains(obj.AGRUPAMENTO_1)) arrAgrupamento1.add(obj.AGRUPAMENTO_1);
        }

        /* borda 1 -> TOP
         * borda 2 -> BOTTOM
         */
        int contador = 0;
        String agrupamentoControle = null;
        List<Integer> arrTotais = null;
        boolean controle = false;
        for (ConstrutorView obj : agrupamentos) {
            if (!obj.getAGRUPAMENTO_1().equals(agrupamentoControle)) {
                agrupamentoControle = obj.AGRUPAMENTO_1;
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

        arrTotalGeral = new ArrayList<Integer>() {
            {
                add((int) agrupamentos.get(0).GERAL_MES01);
                add((int) agrupamentos.get(0).GERAL_MES02);
                add((int) agrupamentos.get(0).GERAL_MES03);
                add((int) agrupamentos.get(0).GERAL_MES04);
                add((int) agrupamentos.get(0).GERAL_MES05);
                add((int) agrupamentos.get(0).GERAL_MES06);
                add((int) agrupamentos.get(0).GERAL_MES07);
                add((int) agrupamentos.get(0).GERAL_MES08);
                add((int) agrupamentos.get(0).GERAL_MES09);
                add((int) agrupamentos.get(0).GERAL_MES10);
                add((int) agrupamentos.get(0).GERAL_MES11);
                add((int) agrupamentos.get(0).GERAL_MES12);
                add((int) agrupamentos.get(0).GERAL_MES12);
                add((int) agrupamentos.get(0).VENDIDO_GERAL);
            }
        };

        montaLinhaTotalCurva(arrTotaisCurva, tabela, 1, 0);
        montaLinhaTotalCurva(arrTotalNumeroClientes, tabela, 1, 1);
        montaLinhaTotalCurva(arrTotais, tabela, 2, 2);
        if(controleTotalGeral){
            montaLinhaTotalCurva(arrTotalGeral, tabela, 0, 3);
        }

        try {
            document.add(tabela);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void montaLinhaDadosCliente(ConstrutorView obj, PdfPTable tabela, int bordas, int posicao) {
        int mesControle = 0;
        for (int h = 0; h < 20; h++) {
            Paragraph phrase = null;
            PdfPCell cell = new PdfPCell();
            cell.setFixedHeight(10f);
            cell.setBorder(0);
            cell.setPadding(0);
            cell.setBorder(bordas);
            cell.setBorderWidth(1.5f);

            switch (h) {
                case 0:
                    phrase = new Paragraph(new Phrase("" + posicao + "", Fontes.getHeaderTableDefaultBold()));
                    phrase.setAlignment(Paragraph.ALIGN_RIGHT);
                    cell.addElement(phrase);
                    break;
                case 1:
                    phrase = new Paragraph(new Phrase("" + obj.AGRUPAMENTO_2 + " " + obj.DESCRICAO_AGRUPAMENTO2, Fontes.getHeaderTableDefaultBold()));
                    cell.addElement(phrase);
                    cell.setPaddingLeft(5);
                    break;
                case 2:
                    phrase = new Paragraph(new Phrase("" + obj.MES01 + " " + obj.CURVAMES01, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES01;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES01, 0);
                    break;
                case 3:
                    phrase = new Paragraph(new Phrase("" + obj.MES02 + " " + obj.CURVAMES02, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES02;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES02, 1);
                    break;
                case 4:
                    phrase = new Paragraph(new Phrase("" + obj.MES03 + " " + obj.CURVAMES03, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES03;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES03, 2);
                    break;
                case 5:
                    phrase = new Paragraph(new Phrase("" + obj.MES04 + " " + obj.CURVAMES04, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES04;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES04, 3);
                    break;
                case 6:
                    phrase = new Paragraph(new Phrase("" + obj.MES05 + " " + obj.CURVAMES05, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES05;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES05, 4);
                    break;
                case 7:
                    phrase = new Paragraph(new Phrase("" + obj.MES06 + " " + obj.CURVAMES06, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES06;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES06, 5);
                    break;
                case 8:
                    phrase = new Paragraph(new Phrase("" + obj.MES07 + " " + obj.CURVAMES07, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES07;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES07, 6);
                    break;
                case 9:
                    phrase = new Paragraph(new Phrase("" + obj.MES08 + " " + obj.CURVAMES08, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES08;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES08, 7);
                    break;
                case 10:
                    phrase = new Paragraph(new Phrase("" + obj.MES09 + " " + obj.CURVAMES09, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES09;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES09, 8);
                    break;
                case 11:
                    phrase = new Paragraph(new Phrase("" + obj.MES10 + " " + obj.CURVAMES10, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES10;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES10, 9);
                    break;
                case 12:
                    phrase = new Paragraph(new Phrase("" + obj.MES11 + " " + obj.CURVAMES11, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES11;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES11, 10);
                    break;
                case 13:
                    phrase = new Paragraph(new Phrase("" + obj.MES12 + " " + obj.CURVAMES12, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES12;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES12, 11);
                    break;
                case 14:
                    phrase = new Paragraph(new Phrase("" + obj.MES13 + " " + obj.CURVAMES13, Fontes.getHeaderTableDefaultBold()));
                    mesControle = obj.MES13;
                    verificaNumeroCliente(arrTotalNumeroClientes, obj.MES13, 12);
                    break;
                case 15:
                    phrase = new Paragraph(new Phrase("" + (int) obj.VENDIDO + "", Fontes.getHeaderTableDefaultBold()));
                    verificaNumeroCliente(arrTotalNumeroClientes, (int) obj.VENDIDO, 13);
                    cell.addElement(phrase);
                    cell.setPaddingRight(1);
                    cell.setHorizontalAlignment(1);
                    break;
                case 16:
                    phrase = new Paragraph(new Phrase("" + MetodosUtils.formatarFloat(obj.PART_GR1) + "", Fontes.getHeaderTableDefaultBold()));
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
                    phrase = new Paragraph(new Phrase("" + MetodosUtils.formatarFloat(obj.ACU_GR1) + "", Fontes.getHeaderTableDefaultBold()));
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
            }  else if (h >= 15) {
                if(h == 15) {
                    cell.setPaddingRight(3);
                }else{
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
       
        PdfPCell cell = null;
        Paragraph phrase = null;
        for (int h = 0; h < 20; h++) {
            phrase = null;
            cell = new PdfPCell();
            cell.setFixedHeight(13f);
            cell.setBorder(0);
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
                                if(filtrosParametros.getAgrupamento() == 7){
                                    texto = "N�MERO PRODUTOS";
                                }else{
                                    texto = "N�MERO CLIENTES";
                                }
                                break;
                            case 2:
                                texto = "TOTAIS..............:";
                                break;
                            case 3:
                                paddingTop = 4;
                                texto = "TOTAL GERAL..............:";
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
        for(int i=0;i<20;i++){
            paragraph = new Paragraph(new Phrase("     ", Fontes.getHeaderTableDefaultBold()));
            cell = new PdfPCell(paragraph);
            cell.setBorder(0);
            tabela.addCell(cell);
        }

        List<String> headers = new ArrayList<String>() {
            {
                add("  ");
            }
        };

        switch (filtrosParametros.getAgrupamento()) {
            case 5:
            case 3:
                headers.add("PRODUTO: " + construtorView.AGRUPAMENTO_1 + " " + " " + construtorView.DESCRICAO_AGRUPAMENTO1);
            break;
            case 7:
                headers.add("CLIENTE: " + construtorView.AGRUPAMENTO_1 + " " + " " + construtorView.DESCRICAO_AGRUPAMENTO1);
            default:
                headers.add("REPRESENTANTE: " + construtorView.AGRUPAMENTO_1 + " " + " " + construtorView.DESCRICAO_AGRUPAMENTO1);
                break;
        }
        /*
            Adiciona uma celula em branco
         */
            paragraph = new Paragraph(new Phrase(headers.get(0), Fontes.getHeaderTableDefaultBold()));
            cell = new PdfPCell(paragraph);
            cell.setBorder(0);
            cell.setPaddingBottom(-10);
            cell.setHorizontalAlignment(0);
            tabela.addCell(cell);

        /*
            Adiciona a celula com os dados do AGRUPAMENTO 01
         */
            paragraph = new Paragraph(new Phrase(headers.get(1), Fontes.getHeaderTableBold()));
            cell = new PdfPCell(paragraph);
            cell.setBorder(0);
            cell.setPaddingLeft(-13f);
            cell.setPaddingBottom(-30f);
            cell.setPaddingTop(10f);
            cell.setHorizontalAlignment(0);
            tabela.addCell(cell);

            for (int i = 0; i < 18; i++) {
                paragraph = new Paragraph(new Phrase("   ", Fontes.getHeaderTableDefaultBold()));
                cell = new PdfPCell(paragraph);
                cell.setPaddingBottom(-20);
                cell.setBorder(0);
                tabela.addCell(cell);
            }


        for(int i=0;i<15;i++){
            paragraph = new Paragraph(new Phrase("     ", Fontes.getHeaderTableDefaultBold()));
            cell = new PdfPCell(paragraph);
            cell.setBorder(0);
            cell.setFixedHeight(10f);
            tabela.addCell(cell);
        }

        paragraph = new Paragraph(new Phrase(" -------------- TOTAIS DO ANO --------------- ", Fontes.getHeaderTableDefaultBold()));
        cell = new PdfPCell(paragraph);
        cell.setColspan(6);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingTop(22f);
        cell.setPaddingBottom(2f);
        tabela.addCell(cell);

        headers = new ArrayList<String>() {
            {
                add("ORDEM");
            }
        };

        if(filtrosParametros.getAgrupamento() == 2 || filtrosParametros.getAgrupamento() == 5){
            headers.add("CLIENTES");
        }else if(filtrosParametros.getAgrupamento() == 6
                || filtrosParametros.getAgrupamento() == 10
                || filtrosParametros.getAgrupamento() == 7){
            headers.add("PRODUTOS");
        }else if(filtrosParametros.getAgrupamento() == 3){
            headers.add("REPRESENTANTES");
        }

        MetodosUtils.getMeses(headers, filtrosParametros.getDataFinal());

        if(MetodosUtils.retornaQuantidadeOuValor(filtrosParametros.getQtdeValor()).equals("QUANTIDADE")){
            headers.add("QTDE");
        }else{
            headers.add("VALOR");
        }
        headers.add("%");
        headers.add("M�DIA");
        headers.add("% ACUM");
        headers.add("ABC");

        for(int i=0;i<15;i++){
            Font fonteParagraph = null;
            if(headers.get(i).equals("ORDEM")
                    || headers.get(i).equals("CLIENTES")
                    || headers.get(i).equals("PRODUTOS")
                    || headers.get(i).equals("REPRESENTANTES")) {
                fonteParagraph = Fontes.getHeaderTableBold();
            }else{
                fonteParagraph = Fontes.getHeaderTableDefaultBold();
            }
            paragraph = new Paragraph(new Phrase("" + headers.get(i) + "", fonteParagraph));
            cell = new PdfPCell(paragraph);
            cell.setPadding(0);
            cell.setPaddingBottom(2f);
            cell.setBorder(Rectangle.BOTTOM);
            cell.setFixedHeight(10F);
            if(headers.get(i).equals("ORDEM")){
                cell.setPaddingRight(-20f);
                cell.setHorizontalAlignment(0);
            }else if(headers.get(i).equals("CLIENTES")
                    || headers.get(i).equals("PRODUTOS")
                    || headers.get(i).equals("REPRESENTANTES")){
                cell.setPaddingLeft(15f);
                cell.setHorizontalAlignment(0);
            }else{
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            }

            tabela.addCell(cell);
        }

        for(int i=15;i<20;i++){
            paragraph = new Paragraph(new Phrase("" + headers.get(i) + "",
                                        Fontes.getHeaderTableDefaultBold()));
            cell = new PdfPCell(paragraph);
            cell.setPadding(0);
            cell.setPaddingBottom(2f);
            cell.setBorder(Rectangle.BOTTOM);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            if(headers.get(i).equals("QTDE") || headers.get(i).equals("VALOR")){
                cell.setPaddingLeft(0);
                cell.setPaddingRight(3);
            }else if(headers.get(i).equals("%")){
                cell.setPadding(2f);
                cell.setPaddingTop(0);
            }else if(headers.get(i).equals("M�DIA")){
                cell.setPadding(2);
            }else if(headers.get(i).equals("% ACUM")){
                cell.setPaddingRight(0);
            }else if(headers.equals("ABC")){
                cell.setPaddingLeft(0.5f);
            }

            tabela.addCell(cell);
        }
    }

    public static void verificaNumeroCliente(List<Integer> arr, int mes, int index) {
        if (mes != 0) {
            arr.set(index, arr.get(index) + 1);

        }
    }

    public static FiltrosParametros getFiltrosParametros() {
        return filtrosParametros;
    }

    public static void setFiltrosParametros(FiltrosParametros filtrosParametros) {
        LayoutTipoDois.filtrosParametros = filtrosParametros;
    }
}
