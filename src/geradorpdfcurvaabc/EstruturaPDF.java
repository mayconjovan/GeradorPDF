package systextil.bo.geradorpdfcurvaabc;
import java.util.List;

import com.lowagie.text.Document;
import systextil.bo.geradorpdfcurvaabc.ConstrutorView;

public interface EstruturaPDF {

    public void body(Document document, List<ConstrutorView> agrupamentos);

}
