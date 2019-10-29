package systextil.bo.geradorpdfcurvaabc;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Font;
import java.awt.*;
import java.io.IOException;

public class Fontes {

    //Create a specific font object
	public static final Font FMEN = FontFactory.getFont("Verdana", 2);
	private static final Font FMEN2 = FontFactory.getFont("Verdana", 6);

	private static final Font F5 = FontFactory.getFont("Verdana", 5);
	private static final Font F5B = FontFactory.getFont("Verdana", 5, Font.BOLD);
	private static final Font LINERED = FontFactory.getFont("Verdana", 7, Color.RED);
	private static final Font LINERED_GRAY = FontFactory.getFont("Verdana", 7, Color.GRAY);
	private static final Font MIN_FONT_GRAY = FontFactory.getFont("Verdana", 6, Color.GRAY);
	private static final Font TITLE = FontFactory.getFont("Verdana", 8);
	private static final Font HEADER_BOLD = FontFactory.getFont("Verdana", 7, Font.BOLD);
	private static final Font HEADER_DEFAULT_BOLD = FontFactory.getFont("Verdana", 7);


	private static final Font HEADER_TABLE_DEFAULT_BOLD = FontFactory.getFont("Verdana", 6);
	private static final com.lowagie.text.Font HEADER_TABLE_BOLD = FontFactory.getFont("Verdana", 6, Font.BOLD);

	private static final Font DEFAULT = FontFactory.getFont("Verdana", 5);
	private static final Font DEFAULT_BOLD = FontFactory.getFont("Verdana", 5, Font.BOLD);
	private static final Font SUMMARY = FontFactory.getFont("Verdana", 6, Font.BOLD);
	private static final Font SETTINGS_LABEL = FontFactory.getFont("Verdana", 5, Font.BOLD);

    public Fontes() throws IOException, DocumentException {
    }

    public static Font getFmen() {
		return FMEN;
	}
	public static Font getFmen2() {
		return FMEN2;
	}
	public static Font getF5() {
		return F5;
	}
	public static Font getF5b() {
		return F5B;
	}
	public static Font getLinered() {
		return LINERED;
	}
	public static Font getLineredGray() {
		return LINERED_GRAY;
	}
	public static Font getTitle() {
		return TITLE;
	}
	public static Font getHeaderBold() {
		return HEADER_BOLD;
	}
	public static Font getHeaderDefaultBold() {
		return HEADER_DEFAULT_BOLD;
	}
	public static Font getHeaderTableDefaultBold() {
		return HEADER_TABLE_DEFAULT_BOLD;
	}
	public static Font getHeaderTableBold() {
		return HEADER_TABLE_BOLD;
	}
	public static Font getDefault() {
		return DEFAULT;
	}
	public static Font getDefaultBold() {
		return DEFAULT_BOLD;
	}
	public static Font getSummary() {
		return SUMMARY;
	}
	public static Font getSettingsLabel() {
		return SETTINGS_LABEL;
	}

	public static Font getMinFontGray() {
		return MIN_FONT_GRAY;
	}
}
