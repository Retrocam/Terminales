package co.com.movistar.utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Excel {
    public static final Logger LOGGER = Logger.getLogger(Excel.class.getName());
    public static String path = "src/main/resources/Data/UserData.xlsx";

    public static ArrayList<Map<String, String>> readData( String sheetName){

        ArrayList<Map<String, String>> listData = new ArrayList();
        Map<String, String> information = new HashMap();
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
            XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
            Iterator<Row> rowIterator = newSheet.iterator();
            Row titles = rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.getColumnIndex();
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            information.put(titles.getCell(cell.getColumnIndex()).toString(),
                                    cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            information.put(titles.getCell(cell.getColumnIndex()).toString(),
                                    String.valueOf((long) cell.getNumericCellValue()));
                            break;
                        case BLANK:
                            information.put(titles.getCell(cell.getColumnIndex()).toString(), "");
                            break;
                        default:
                    }
                }
                listData.add(information);
                information = new HashMap();
            }
        }catch(IOException e){
            LOGGER.log(Level.SEVERE, "FILE EXCEL DIDN'T FOUND: ", e);
        }
        return listData;
    }

    public static void writeInCell(String sheetName, int rowIndex, int columnIndex,String text) {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new FileInputStream(path));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "FILE EXCEL DIDN'T FOUND: ", e);

        }
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            cell = row.createCell(columnIndex);
        }
        cell.setCellValue(text);
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "FILE EXCEL CAN'T OVERRIDE : ", e);

        }

    }
}
