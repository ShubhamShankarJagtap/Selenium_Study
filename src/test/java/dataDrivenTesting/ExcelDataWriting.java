package dataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataWriting {

    @Test
    protected void enter_Data_Into_Excel(){


        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/WriteData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet =workbook.createSheet("Data");
            XSSFRow row = sheet.createRow(0);
            row.createCell(0).setCellValue("NAME");
            row.createCell(1).setCellValue("JOB");
            row.createCell(2).setCellValue("CITY");

            XSSFRow row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("SHUBHAM");
            row1.createCell(1).setCellValue("TEST AUTOMATION ENGINEERING");
            row1.createCell(2).setCellValue("PUNE");

            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The file has been created..");
    }
}
