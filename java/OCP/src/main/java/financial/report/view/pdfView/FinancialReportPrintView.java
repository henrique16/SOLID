package financial.report.view.pdfView;
import java.io.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import financial.report.presenter.printPresenter.FinancialReportPrintModel;
import financial.report.presenter.printPresenter.IFinancialReportPrintView;
import streamHandler.interfaces.IStreamHandler;

public class FinancialReportPrintView implements IFinancialReportPrintView {
  private IStreamHandler streamHandler;

  public FinancialReportPrintView(
    IStreamHandler streamHandler
  ) {
    this.streamHandler = streamHandler;
  }

  @Override
  public byte[] createFinancialReportPrintView(FinancialReportPrintModel financialReportPrintModel) {

    try (PDDocument document = new PDDocument()) {

      PDPage page = new PDPage();
      document.addPage(page);

      try (PDPageContentStream content = new PDPageContentStream(document, page)) {

        content.beginText();
        content.setFont(
            new PDType1Font(Standard14Fonts.FontName.HELVETICA),
            12);
        content.newLineAtOffset(50, 750);
        content.showText("Hello, PDF!");
        content.endText();
      }

      ByteArrayOutputStream  output = this.streamHandler.getByteArrayOutputStream();
      document.save(output);

      System.out.println("Tamanho do PDF: " + output.size() + " bytes");
      System.out.println("PDF gerado: " + (output.size() > 0));
      
      return output.toByteArray();

    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
      throw new RuntimeException("Error creating financial report print view");
    }
  }
}
