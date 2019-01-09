package com.gonnect.upload.utils;

import java.io.Serializable;


public class ExcelDataColumn implements Serializable {
    private String name = "";
    private int columnIndex;

    public ExcelDataColumn(){

    }

    public ExcelDataColumn(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ExcelDataColumn makeCopy(){
        ExcelDataColumn c = new ExcelDataColumn(name);
        c.setColumnIndex(columnIndex);
        return c;
    }


    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getColumnIndex(){
        return columnIndex;
    }
}
