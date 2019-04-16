package com.yw.myexcel.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.yw.myexcel.entity.Employee;
import com.yw.myexcel.entity.Manager;
import com.yw.myexcel.entity.MergeEntity;
import com.yw.myexcel.utils.ExcelUtil;
import com.yw.myexcel.utils.SetObjValues;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author a1387537
 */

@Controller
public class IndexController {
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index (Model model){
        return "index";
    }

    @RequestMapping(value = "upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping(value = "uploadFile")
    public String execUpload(MultipartFile []file) throws Exception {
        Map<String, MergeEntity> map = new HashMap<>();

        new ExcelUtil<Employee>().loadExcel(3,2,file[0].getInputStream(),file[0].getOriginalFilename(),Employee.class,map);
        new ExcelUtil<Manager>().loadExcel(5,3,file[1].getInputStream(),file[1].getOriginalFilename(),Manager.class,map);



        System.out.println(map);
        System.exit(1);
        return "";
        }
/*
        for( Row row:sheet){
            if(count<3){
                staticRow = row.getPhysicalNumberOfCells();
                count ++;
                continue;
            }*/

/*            //如果第一行第一列没有数据
            if(row.getCell(0).toString().equals("")){
                break;
            }

            int columnTotalNum = row.getPhysicalNumberOfCells();
            System.out.println("总列数为: "+columnTotalNum);
            System.out.println("最大列数为: "+row.getLastCellNum());

            if(staticRow != columnTotalNum){
                break;
            }

            int end = row.getLastCellNum();

            String tempRow = "";
            for(int i = 0;i<end ;++i){
                Cell cell =row.getCell(i);
                if(cell == null){
                    System.out.println("null"+"\t");
                    continue;
                }
                System.out.print(ExcelUtil.getValue(cell)+"\t");
                tempRow += ExcelUtil.getValue(cell)+";";
            }
            System.out.println(tempRow);
            employees.add(SetObjValues.setValue(new Employee(),tempRow));
            System.out.println();

        }
        System.out.println(employees.toString());

        return "";*/



}


/**/