package com.yw.myexcel.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SetObjValues {
    public static Object setValue(Object model,String value) throws NoSuchMethodException {
        //获取所有属性
        Field[] fields = model.getClass().getDeclaredFields();
        String[] val = value.split(";");


        for(int i = 0;i<fields.length;++i){
            //获取属性的名字
            String name = fields[i].getName();
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            //获取类型
            String type = fields[i].getGenericType().toString();


            //允许访问私有变量
            fields[i].setAccessible(true);

            if(type.equals("class java.lang.String")){
                Method m = model.getClass().getMethod("set"+name,String.class);
                try {

                    m.invoke(model,val[i]);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                }


            }
        }
        return model;
    }
}
