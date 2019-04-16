package com.yw.myexcel.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class ExcelUtil {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";


    public static Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            case FORMULA:
                obj = cell.getNumericCellValue();
                break;
            default:
                break;
        }
        return obj;
    }

    /**
     * 获取Workbook对象
     * @param in
     * @param filename
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream in,String filename) throws IOException {
        Workbook wb = null;
        if(filename.endsWith(EXCEL_XLS)) {
            wb = new HSSFWorkbook(in);
        }else{
         if(filename.endsWith(EXCEL_XLSX)){
                wb = new XSSFWorkbook(in);
            }
        }
        return wb;
    }

}
