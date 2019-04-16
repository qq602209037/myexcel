package com.yw.myexcel.utils;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yw.myexcel.entity.Employee;
import com.yw.myexcel.entity.Manager;
import com.yw.myexcel.entity.MergeEntity;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil<T>  {
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

    public  void loadExcel(int startRow, int endRow, InputStream in, String filename, Class<T> clazz,Map<String, MergeEntity> map) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        {
            Workbook workbook = ExcelUtil.getWorkbook(in,filename);
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getPhysicalNumberOfRows();

            List employees = new ArrayList();
            int count = 0;
            int staticRow=0;

            for(int i = 0;i<rowNum-endRow;++i){
                Row row = sheet.getRow(i);
                if(i<startRow){
                    continue;
                }
                //如果第一行第一列没有数据
                if(row.getCell(0).toString().equals("")){
                    break;
                }

                int columnTotalNum = row.getPhysicalNumberOfCells();




                int end = row.getLastCellNum();

                String tempRow = "";
                String bsc = "";
                for(int j = 0;j<end ;++j){
                    Cell cell =row.getCell(j);
                    if(j == 0){
                        bsc = ExcelUtil.getValue(cell)+"";
                    }
                    if(cell == null){

                        continue;
                    }

                    tempRow += ExcelUtil.getValue(cell)+";";
                }
                if(map.containsKey(bsc)){
                    if(clazz.getName().equals("com.yw.myexcel.entity.Employee")){
                        map.get(bsc).getEmployees().add((Employee) SetObjValues.setValue(clazz.newInstance(),tempRow));
                    }else if(clazz.getName().equals("com.yw.myexcel.entity.Manager")){
                        map.get(bsc).getManagers().add((Manager) SetObjValues.setValue(clazz.newInstance(),tempRow));

                    }
                }else{
                    if(clazz.getName().equals("com.yw.myexcel.entity.Employee")){
                        MergeEntity mergeEntity = new MergeEntity();
                        mergeEntity.setBsc(bsc);
                        mergeEntity.getEmployees().add((Employee) SetObjValues.setValue(clazz.newInstance(),tempRow));
                        map.put(bsc,mergeEntity);
                    }else if(clazz.getName().equals("com.yw.myexcel.entity.Manager")){
                        MergeEntity mergeEntity = new MergeEntity();
                        mergeEntity.setBsc(bsc);
                        mergeEntity.getManagers().add((Manager) SetObjValues.setValue(clazz.newInstance(),tempRow));
                        map.put(bsc,mergeEntity);
                    }
                }



            }

        }
    }


    public static String createExcel(Map<String,MergeEntity> map) throws IOException, IllegalAccessException {

        for(Map.Entry<String,MergeEntity> entry: map.entrySet()){
            //创建HSSFWorkbook对象(excel的文档对象)
            HSSFWorkbook wb = new HSSFWorkbook();
            //建立新的sheet对象（excel的表单）
            HSSFSheet sheet=wb.createSheet("整表");
//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
            int rowNum = 0;
            List<Manager> managers = entry.getValue().getManagers();
            HSSFRow row1 = null;
//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
            HSSFCell cell = null;
            //设置单元格内容
            if(managers.size()>0) {
                row1 = sheet.createRow(rowNum);
                cell = row1.createCell(rowNum);
                cell.setCellValue("经理表");

                for (int i = 0; i < managers.size(); ++i) {
                    Manager temp = managers.get(i);
//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
                    // sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
//在sheet里创建第二行
                    int k = 0;
                    HSSFRow row = sheet.createRow(rowNum + 1);
                    for (Field field : temp.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        row.createCell(k++).setCellValue((String) field.get(temp));

                    }
                    rowNum++;
                }
            }
            List<Employee> employees = entry.getValue().getEmployees();
            if(employees.size()>0) {
                row1 = sheet.createRow(++rowNum);
//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
                cell = row1.createCell(0);
                //设置单元格内容
                cell.setCellValue("文员表");

                for (int i = 0; i < employees.size(); ++i) {
                    Employee temp = employees.get(i);
//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
                    // sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
//在sheet里创建第二行
                    int k = 0;
                    HSSFRow row = sheet.createRow(rowNum + 1);
                    for (Field field : temp.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        row.createCell(k++).setCellValue((String) field.get(temp));

                    }
                    rowNum++;
                }
            }
            OutputStream output = new FileOutputStream("D://"+entry.getKey()+".xls");
            wb.write(output);
            output.close();
            }
            return null;
        }


}
