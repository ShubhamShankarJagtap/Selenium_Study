package dataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Apache_POI {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    @Test
    public void handleExcel(){

        File file = new File("src/test/resources/ApachePOI.xlsx");

        try {

            FileInputStream inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);

            sheet = workbook.getSheetAt(0);

            int totalRowCount = sheet.getLastRowNum();
            int totalCellCount = sheet.getRow(0).getLastCellNum();

            for (int currentRow = 0; currentRow<totalRowCount; currentRow++){
                for (int currentCell = 0; currentCell<totalCellCount; currentCell++){

                    System.out.print(sheet.getRow(currentRow).getCell(currentCell).getStringCellValue());
                    System.out.print("\t");
                }
                System.out.println();
            }

            workbook.close();
            inputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
