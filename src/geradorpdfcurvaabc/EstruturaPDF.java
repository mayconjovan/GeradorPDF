package systextil.bo.geradorpdfcurvaabc;
import java.util.List;

import com.lowagie.text.Document;

public interface EstruturaPDF{

    public void body(Document document, List<ConstrutorView> agrupamentos);

}
