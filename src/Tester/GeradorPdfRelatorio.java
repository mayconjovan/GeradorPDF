package Tester;

import DAO.ViewDAO;
import Domain.ConstrutorView;
import Domain.FiltrosParametros;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
//import br.com.intersys.systextil.global.Mdi;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPageEventHelper;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeradorPdfRelatorio extends PdfPageEventHelper {

    public static final Font FMEN = FontFactory.getFont("Verdana", 2);
    public static final Font FMEN2 = FontFactory.getFont("Verdana", 6);

    public static final Font F5 = FontFactory.getFont("Verdana", 5);
    public static final Font F5B = FontFactory.getFont("Verdana", 5, Font.BOLD);
    public static final Font LINERED = FontFactory.getFont("Verdana", 32, Color.RED);

    public static final Font TITLE = FontFactory.getFont("Verdana", 8);
    public static final Font DEFAULT = FontFactory.getFont("Verdana", 5);
    public static final Font DEFAULT_BOLD = FontFactory.getFont("Verdana", 5, Font.BOLD);
    public static final Font SUMMARY = FontFactory.getFont("Verdana", 6, Font.BOLD);
    //public static final Font GROUP_HEADER = FontFactory.getFont("Verdana", 6, Font.BOLD, GROUP_BLUE);
    public static final Font SETTINGS_LABEL = FontFactory.getFont("Verdana", 5, Font.BOLD);

  //  public static Mdi mdi;

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        //Cabeçalho        
        Date dataHora = new Date();
        SimpleDateFormat df;
        SimpleDateFormat hf;
        df = new SimpleDateFormat("dd/MM/yyyy");
        hf = new SimpleDateFormat("HH:mm:ss");

        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("EMPRESA: ", TITLE), 15, 575, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("PROGRAMA: ", TITLE), 15, 560, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("MODULO: ADMINISTRAÇÃO DE VENDAS", TITLE), 420, 575, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(df.format(dataHora) + " - " + hf.format(dataHora) + " - Pagina: " + document.getPageNumber(), TITLE), 770, 575, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("___________________________________________________", LINERED), 10, 550, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("___________________________________________________", LINERED), 10, 550, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("___________________________________________________", LINERED), 10, 550, 0);

    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("AAAAAAAAAAAA"), 110, 20, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("BBBBBBBBBBBB " + document.getPageNumber()), 550, 30, 0);
    }

    public static void montaCabecalhoPagina(PdfPTable tc, Document doc)
            throws IOException, DocumentException {

        //String nomeEmpresa = mdi.nome_empresa;
        //PdfPCell cb1 = new PdfPCell(new Paragraph("EMPRESA:" + nomeEmpresa, DEFAULT_BOLDb));
//        PdfPCell cb1 = new PdfPCell(new Paragraph("EMPRESA: LANSER CONFECÇÕES LTDA", DEFAULT_BOLDb));
//        cb1.setColspan(7);
//        cb1.setBorder(0);
//        tc.addCell(cb1);
        PdfPCell cb2 = new PdfPCell(new Paragraph("MODULO: ADMINISTRAÇÃO DE VENDAS", TITLE));
        cb2.setColspan(8);
        cb2.setBorder(0);
        tc.addCell(cb2);

        PdfPCell cb3 = new PdfPCell(new Paragraph(" - ", TITLE));

        cb3.setColspan(5);
        cb3.setBorder(Rectangle.BOTTOM);
        tc.addCell(cb3);
//
//        PdfPCell cb4 = new PdfPCell(new Paragraph("PROGRAMA: ", DEFAULT_BOLDb));
//        cb4.setColspan(20);
//        cb4.setBorder(Rectangle.BOTTOM);
//        cb4.setBorderColor(Color.red);
//        tc.addCell(cb4);

        doc.add(tc);

    }

    public static void montaQuadroDados(PdfPTable tc, Document doc)
            throws IOException, DocumentException {

        Date data = new Date();
        FiltrosParametros filtros = new FiltrosParametros(2, 1, 1, 1, 99, "S", 999.99f, 999.99f, 10f, 60f/*, data*/);

        ArrayList<ConstrutorView> a = ViewDAO.buscarDados(filtros);
        int i = 0;

        for (ConstrutorView a1 : a) {
            i++;

            PdfPCell b1 = new PdfPCell(new Paragraph(i + "  ", DEFAULT_BOLD));
            b1.setBorder(0);
            b1.setFixedHeight(15f);
            tc.addCell(b1);

            PdfPCell b2 = new PdfPCell(new Paragraph(a1.AGRUPAMENTO_2 + " TESTE" + a1.DESCRICAO_AGRUPAMENTO2, DEFAULT_BOLD));
            b2.setBorder(0);
            tc.addCell(b2);

            PdfPCell b3 = new PdfPCell(new Paragraph(a1.MES01 + " " + a1.CURVAMES01, DEFAULT_BOLD));
            b3.setBorder(0);
            tc.addCell(b3);

            PdfPCell b4 = new PdfPCell(new Paragraph(a1.MES02 + "" + a1.CURVAMES02, DEFAULT_BOLD));
            b4.setBorder(0);
            tc.addCell(b4);

            PdfPCell b5 = new PdfPCell(new Paragraph(a1.MES03 + "" + a1.CURVAMES03, DEFAULT_BOLD));
            b5.setBorder(0);
            tc.addCell(b5);

            PdfPCell b6 = new PdfPCell(new Paragraph(a1.MES04 + "" + a1.CURVAMES04, DEFAULT_BOLD));
            b6.setBorder(0);
            tc.addCell(b6);

            PdfPCell b7 = new PdfPCell(new Paragraph(a1.MES05 + "" + a1.CURVAMES05, DEFAULT_BOLD));
            b7.setBorder(0);
            tc.addCell(b7);

            PdfPCell b8 = new PdfPCell(new Paragraph(a1.MES06 + "" + a1.CURVAMES06, DEFAULT_BOLD));
            b8.setBorder(0);
            tc.addCell(b8);

            PdfPCell b9 = new PdfPCell(new Paragraph(a1.MES07 + "" + a1.CURVAMES07, DEFAULT_BOLD));
            b9.setBorder(0);
            tc.addCell(b9);

            PdfPCell b10 = new PdfPCell(new Paragraph(a1.MES08 + "" + a1.CURVAMES08, DEFAULT_BOLD));
            b10.setBorder(0);
            tc.addCell(b10);

            PdfPCell b11 = new PdfPCell(new Paragraph(a1.MES09 + "" + a1.CURVAMES09, DEFAULT_BOLD));
            b11.setBorder(0);
            tc.addCell(b11);

            PdfPCell b12 = new PdfPCell(new Paragraph(a1.MES10 + "" + a1.CURVAMES10, DEFAULT_BOLD));
            b12.setBorder(0);
            tc.addCell(b12);

            PdfPCell b13 = new PdfPCell(new Paragraph(a1.MES11 + "" + a1.CURVAMES11, DEFAULT_BOLD));
            b13.setBorder(0);
            tc.addCell(b13);

            PdfPCell b14 = new PdfPCell(new Paragraph(a1.MES12 + "" + a1.CURVAMES12, DEFAULT_BOLD));
            b14.setBorder(0);
            tc.addCell(b14);

            PdfPCell b15 = new PdfPCell(new Paragraph(a1.MES13 + "" + a1.CURVAMES13, DEFAULT_BOLD));
            b15.setBorder(0);
            tc.addCell(b15);

            PdfPCell b16 = new PdfPCell(new Phrase(a1.VENDIDO + "", DEFAULT_BOLD));
            b16.setBorder(0);
            tc.addCell(b16);

            PdfPCell b17 = new PdfPCell(new Phrase(a1.PARTICIPACAO_GERAL + "", DEFAULT_BOLD));
            b17.setBorder(0);
            tc.addCell(b17);

            PdfPCell b18 = new PdfPCell(new Phrase(a1.MEDIA + "", DEFAULT_BOLD));
            b18.setBorder(0);
            tc.addCell(b18);

            PdfPCell b19 = new PdfPCell(new Phrase(a1.ACUM_PARTICIPACAO_GERAL + "", DEFAULT_BOLD));
            b19.setBorder(0);

            tc.addCell(b19);

            PdfPCell b20 = new PdfPCell(new Phrase(a1.CURVAGERAL + "", DEFAULT_BOLD));
            b20.setBorder(0);
            tc.addCell(b20);
        }
        doc.add(tc);
    }

    public static void montaRodapePagina(PdfPTable tc, Document doc)
            throws IOException, DocumentException {
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");

        Document doc;
        OutputStream opts;

        doc = new Document(PageSize.A4.rotate(), 20, 20, 100, 100);
        double a = Math.random();
        String b = Double.toString(a);

        opts = new FileOutputStream(b + ".pdf");

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, opts);
            GeradorPdfRelatorio event = new GeradorPdfRelatorio();
            writer.setPageEvent(event);

            doc.open();
            //PdfContentByte cb = pwt.getDirectContent();
            //cb.saveState();

            PdfPTable tabela = new PdfPTable(new float[]{8f, 50f, 15f, 15f, 15f,
                15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f,
                15f, 5f}); //20 Colunas. Parametriza tamanho das colunas do PDF
            //tabela.setHeaderRows(2);

            tabela.setWidthPercentage(100);
            //montaCabecalhoPagina(tabela, doc);
            //montaQuadroDados(tabela, doc);
            //montaRodapePagina(tabela, doc);
            montaQuadroDados(tabela, doc);
            doc.close();

        } catch (DocumentException ex) {
            Logger.getLogger(GeradorPdfRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        //if (pwt != null) {
        opts.close();
    }
}
//}
