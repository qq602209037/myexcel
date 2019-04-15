package com.yw.myexcel.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.yw.myexcel.entity.Employee;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public String execUpload(MultipartFile file) throws Exception {
        ImportParams importParams = new ImportParams();

        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        importParams.setLastOfInvalidRow(2);
        ;
        List<Employee> result = ExcelImportUtil.importExcel(file.getInputStream(),Employee.class,importParams);



        for(int i = 0;i<result.size();++i){
            System.out.println(ReflectionToStringBuilder.toString(result.get(i)));
        }

        System.exit(1);
        return "";
    }
}
