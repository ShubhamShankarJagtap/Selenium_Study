package dataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class ExcelDataReading {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow specific_Row;
    XSSFCell specific_Cell;

    @Test
    protected void excel_Data_Reading() {

        try {

            FileInputStream fileInputStream = new FileInputStream("src/test/resources/ApachePOI.xlsx");
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(0);
            int total_Rows = sheet.getLastRowNum();
            int total_Cells = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("Total number of rows are: " + total_Rows);
            System.out.println("The total number of cells present in a given row are : " + total_Cells);

            for (int current_Row = 1; current_Row < total_Rows; current_Row++) {

//                For specific row
                specific_Row = sheet.getRow(current_Row);
                for (int current_Cell = 0; current_Cell < total_Cells; current_Cell++) {

                    specific_Cell = (specific_Row.getCell(current_Cell));
                    System.out.print(specific_Cell.getStringCellValue());
                    System.out.print("\t");
                }
                System.out.println(" ");
            }

            fileInputStream.close();
            workbook.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
