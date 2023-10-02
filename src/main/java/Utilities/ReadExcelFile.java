package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelFile {

    FileInputStream inputStream;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String [][] arr;




    //method to getRowCount

    public int getRowCount(String Filepath,String SheetName) {

        int row = 0;
        try {
            inputStream = new FileInputStream(Filepath);
            workbook = new XSSFWorkbook(inputStream);
            row = workbook.getSheet(SheetName).getLastRowNum();
            if(row==0){
                row= 1;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return row;

    }

    public int getColumnCount(String Filepath,String SheetName) {
        int column = 0;
        try {
            inputStream = new FileInputStream(Filepath);
            workbook = new XSSFWorkbook(inputStream);
            column = workbook.getSheet(SheetName).getRow(0).getLastCellNum();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return column;
    }

    public String[][] excelData(String Filepath,String SheetName) {
        try {
            inputStream = new FileInputStream(Filepath);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        int rowCount = getRowCount(Filepath, SheetName);
        int cellCount = getColumnCount(Filepath, SheetName);

        arr = new String[rowCount][cellCount];

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {

                arr[i - 1][j] = workbook.getSheet(SheetName).getRow(i).getCell(j).getStringCellValue();
            }
        }
        return arr;
    }

    public String getExcelDataString(String filePath, String SheetName, int rowNum, int cellNum ){

        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        String cellValue = workbook.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

        return cellValue ;


    }
    public double getExcelDataNumeric(String filePath, String SheetName, int rowNum, int cellNum ){

        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        double cellValue = workbook.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();

        return cellValue ;


    }






}
