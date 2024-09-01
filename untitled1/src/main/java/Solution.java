import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
	void display(){
		try {
		//	String fontPath = "C:/Users/jaydeep.chauhan/Downloads/simsun/SIMSUN.ttf";
			String fontPath = "C:/Users/gkamble/Desktop/NotoSansCJKsc-VF.ttf";
	    //	String fontPath = "C:/Users/jaydeep.chauhan/Desktop/ARIALUNI.TTF";
	    //	String fontPath = "C:/Users/jaydeep.chauhan/Downloads/diphylleia/Fonts/Diphylleia-Regular.ttf";
	    //	InputStream inputStream = getClass().getResourceAsStream(fontPath2);

			PDDocument pdDocument = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			pdDocument.addPage(page);
			PDAcroForm form = new PDAcroForm(pdDocument);
			pdDocument.getDocumentCatalog().setAcroForm(form);

			PDFont font = PDType1Font.TIMES_ROMAN;
			PDResources resources = new PDResources();
			resources.put(COSName.getPDFName("Time"), font);
			form.setDefaultResources(resources);

			PDPageContentStream contentStream = new PDPageContentStream(pdDocument, page);

			setEditableFieldMaxLen(form,page, "Test",75,750,200,50,"/Time 10 Tf 0 0 255 rg","test1",true,80);

			contentStream.setNonStrokingColor(Color.BLUE);
			contentStream.addRect(30, 650, 535, 50);
			// Drawing a rectangle
			contentStream.fill();

			setLabel(contentStream, "test", 80, 580, Color.WHITE,
					PDType1Font.TIMES_BOLD, 14);
//			setLabel(contentStream, "( ", 157, 760, Color.WHITE, PDType1Font.TIMES_BOLD, 14);

			PDAcroForm test = setResourceForLocalLang(pdDocument,form, resources);


			String fontNew = "";
			for (COSName fontObj : test.getDefaultResources().getFontNames()) {
				fontNew = fontObj.getName();
			}

			setEditableFieldMaxLen(test,page, "你好你好你好你好 : HEllo",75,150,200,50,"/" + fontNew + " 10 Tf 255 0 0 rg","test",true,80);
			contentStream.close();
	        pdDocument.save("C:/Users/gkamble/Desktop/output.pdf");
	        System.out.println("PDF Created");
	        pdDocument.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private PDAcroForm setResourceForLocalLang(PDDocument pdDocument, PDAcroForm form,PDResources resources) throws IOException {
		InputStream fontStream = null;
		fontStream = getClass().getResourceAsStream("/NotoSansCJKsc-VF.ttf");
		PDFont formFont = PDType0Font.load(pdDocument, fontStream);
		PDResources resources2 = new PDResources();
		resources2.add(formFont);
		form.setDefaultResources(resources2);
		return form;
	}

	private void setLabel(PDPageContentStream contentStream, String labelValue, float tx, float ty, Color fontColor,
						  PDType1Font fontType, float fontSize) throws IOException {

		if (null == labelValue) {
			labelValue = "-";
		}

		contentStream.beginText();
		contentStream.setFont(fontType, fontSize);
		contentStream.setNonStrokingColor(fontColor);
		contentStream.newLineAtOffset(tx, ty);
		contentStream.showText(labelValue);
		contentStream.endText();
	}

	private void setEditableFieldMaxLen(PDAcroForm form, PDPage page, String fieldValue, float tx, float ty, float width,
										float height, String defaultAppearance, String partialName, boolean isMultiLine, int maxChars) throws  IOException {
		PDTextField exchangeRate = new PDTextField(form);
		exchangeRate.setMaxLen(maxChars);
		exchangeRate.setMultiline(isMultiLine);
		exchangeRate.setPartialName(partialName);
		exchangeRate.setDefaultAppearance(defaultAppearance);
		form.getFields().add(exchangeRate);
		PDAnnotationWidget exchangeRateWidget = exchangeRate.getWidgets().get(0);
		PDRectangle exchangeRateRect = new PDRectangle(tx, ty, width, height);
		exchangeRateWidget.setPrinted(true);
		exchangeRateWidget.setRectangle(exchangeRateRect);
		exchangeRateWidget.setPage(page);
		page.getAnnotations().add(exchangeRateWidget);
		exchangeRate.setValue(fieldValue);

	}

    public static void main(String[] args) throws Exception{
    	Solution solution = new Solution();
    	solution.display();
    }
}