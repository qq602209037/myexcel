package com.yw.myexcel.utils;

import com.yw.myexcel.entity.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil<T> {
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

    public  List<Object> loadExcel(InputStream in,String filename,Class<T> clazz) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        {
            Workbook workbook = ExcelUtil.getWorkbook(in,filename);
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getPhysicalNumberOfRows();
            List<Object> employees = new ArrayList<>();
            int count = 0;
            int staticRow=0;

            for(int i = 0;i<rowNum-2;++i){
                Row row = sheet.getRow(i);
                if(i<3){
                    continue;
                }
                //如果第一行第一列没有数据
                if(row.getCell(0).toString().equals("")){
                    break;
                }

                int columnTotalNum = row.getPhysicalNumberOfCells();




                int end = row.getLastCellNum();

                String tempRow = "";
                for(int j = 0;j<end ;++j){
                    Cell cell =row.getCell(j);
                    if(cell == null){

                        continue;
                    }

                    tempRow += ExcelUtil.getValue(cell)+";";
                }

                employees.add(SetObjValues.setValue(clazz.newInstance(),tempRow));


            }


            return employees;
        }
    }

}
