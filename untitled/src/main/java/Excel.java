//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Excel {
//
//    public static void main(String[] args) {
////        Workbook workbook = getWorkbook();
//
//        // Save the workbook to an Excel file
//        try {
//            FileOutputStream fileOut = new FileOutputStream("report.xlsx"); // Choose the desired file name
//            workbook.write(fileOut);
//            fileOut.close();
//            System.out.println("Excel file created successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
////    private static Workbook getWorkbook() {
////        ExcelReportWithListData report = new ExcelReportWithListData();
////        // Create a new workbook
////        Workbook workbook = new SXSSFWorkbook(); // For .xlsx format
////        // Create a new worksheet
////        Sheet sheet = workbook.createSheet("MySheet");
////
////        // Add headers (if needed)
////        Row headerRow = sheet.createRow(0);
////        int i = 0;
////        for (String header : report.getHeaderConstant()) {
////            Cell cell = headerRow.createCell(i);
////            report.setCellBorderBrown(cell, workbook);
////            cell.setCellValue(header);
////            i++;
////        }
////        return workbook;
////    }
//
//    public void setCellBorderBrown(Cell cell, Workbook workbook) {
//        CellStyle cellStyle = cell.getSheet().getWorkbook().createCellStyle();
//        XSSFColor lightGray = new XSSFColor(new java.awt.Color(204, 204, 255));
//        cellStyle.setFillForegroundColor((short) (IndexedColors.LAVENDER.getIndex() + IndexedColors.LIGHT_BLUE.getIndex()));
//        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
//        Font font = workbook.createFont();
//        font.setFontName("SansSerif");
//
//        cellStyle.setFont(font);
//
//        cell.setCellStyle(cellStyle);
//    }
////    public XSSFCellStyle getHeaderStyle(SXSSFWorkbook workbook) {
////        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
////        try {
////            XSSFColor lightGray = new XSSFColor(Color.LIGHT_GRAY);
////            style.setFillForegroundColor(lightGray);
////            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
////            style.setAlignment(CellStyle.ALIGN_CENTER);
////            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
////            style.setBorderBottom(CellStyle.BORDER_THIN);
////            style.setBorderLeft(CellStyle.BORDER_THIN);
////            style.setBorderRight(CellStyle.BORDER_THIN);
////            style.setBorderTop(CellStyle.BORDER_THIN);
////            style.setWrapText(true);
////
////            XSSFFont font = (XSSFFont) workbook.createFont();
////            font.setFontName("Trebuchet MS");
////            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
////            font.setFontHeightInPoints((short) 8);
////            style.setFont(font);
////        } catch (Exception e) {
////            LOG.debug("Error while ExcelReportServiceImpl->getHeaderStyle : " + e.getMessage());
////        }
////        return style;
////    }
//
//    private List<String> getHeaderConstant() {
//        List<String> list = new ArrayList<>();
//        list.add("ABC");
//        list.add("ABC2");
//        list.add("ABC3");
//        list.add("ABC4");
//        return list;
//    }
//}
