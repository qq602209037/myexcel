package com.yw.myexcel.entity;

import java.util.ArrayList;
import java.util.List;

public class MergeEntity {
    String bsc;
    List<Employee> employees =new ArrayList<>();
    List<Manager> managers = new ArrayList<>();


    @Override
    public String toString() {
        return "MergeEntity{" +
                "bsc='" + bsc + '\'' +
                ", employees=" + employees +
                ", managers=" + managers +
                '}';
    }

    public String getBsc() {
        return bsc;
    }

    public void setBsc(String bsc) {
        this.bsc = bsc;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }
}
