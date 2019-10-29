package systextil.bo.geradorpdfcurvaabc;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MetodosUtils {

    public String retornaTipoVendaFaturamento(int vendaFaturamento){
        String retorno = null;
        switch (vendaFaturamento){
            case 1:
                retorno = "1 - VENDAS";
                break;
            case 2:
                retorno = "2 - FATURAMENTO";
                break;
        }

        return retorno;
    }

    public String retornaPerido(Date d1, Date d2){
        Calendar cal = Calendar.getInstance();

        cal.setTime(d1);
        String editD1 = retornaNumeroMes(cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR);

        cal.setTime(d2);

        String editD2 = retornaNumeroMes(cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR);

        String retorno = editD1 + " A " + editD2;

        return retorno;
    }

    public String retornaDivisao(int divisao) throws UnsupportedEncodingException {
        String retorno = null;
        switch (divisao){
            case 1:
                retorno = "PEÇAS";
                break;
            case 2:
                retorno = "TECIDOS";
                break;
            case 7:
                retorno = "TECIDOS CRU";
                break;
            case 9:
                retorno = "OUTROS";
                break;
            case 99:
                retorno = "TODOS OS NÍVEIS";
                ByteBuffer aux =  java.nio.charset.StandardCharsets.UTF_8.encode(retorno);
                retorno = new String(aux.array(), "UTF-8");
                break;
        }

        return retorno;
    }

    public String retornaTipoNotaProdutos(int tipoNotaProtutos){
        String retorno = null;
        switch (tipoNotaProtutos){
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

    public String retornaQuantidadeOuValor(int params){
        String retorno = null;
        switch (params){
            case 1:
                retorno = "QUANTIDADE";
                break;
            case 2:
                retorno = "VALOR";
                break;
        }

        return  retorno;
    }

    public String retornaConsideraCancelado(String params){
        if(params.equals("S")){
            return "SIM";
        }else{
            return "NÃO";
        }
    }

    public String retornaOpcaoRelatorio(int opcao){
        String retorno = null;
        switch (opcao){
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
        try{
            d1 = format.parse("10-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR));

            for(Date d2 = format.parse("10-" + (cal.get(Calendar.MONTH) + 1) + "-" + (cal.get(Calendar.YEAR)-1));
                d2.before(d1) || d2.equals(d1);
                d2.setMonth(d2.getMonth() + 1)){
                arr.add(retornaMes(d2.getMonth()));
            }
        }catch (ParseException err){
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

    public int retornaNumeroMes(int mes){
        int retorno = 0;
        switch (mes){
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




}
