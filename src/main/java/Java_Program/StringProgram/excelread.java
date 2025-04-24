package Java_Program.StringProgram;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class excelread {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(Row row : sheet){
            Cell cell = row.getCell(0);
            if(cell!=null)
                switch(cell.getCellType()){
                    case STRING :
                        System.out.println(cell.getStringCellValue());
                }
            }
        }

    }
