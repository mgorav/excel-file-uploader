package com.gonnect.upload.utils;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 */
public class ExcelDataRow implements Serializable {
    private static final long serialVersionUID = 3954495190283446947L;
    private ExcelDataColumnCollection columns = new ExcelDataColumnCollection();

    private Map<Integer, String> data = new HashMap<>();

    private String predictedLabel = null;
    private String label = "";

    private double predictedOutputValue = 0;
    private double outputValue = 0;
    private int rowIndex = -1;

    public ExcelDataRow(){

    }

    public ExcelDataRow(ExcelDataColumnCollection columns){
        this.columns = columns;
    }

    public ExcelDataRow makeCopy(){
        ExcelDataRow clone = new ExcelDataRow(columns.makeCopy());
        clone.data.putAll(data);

        clone.predictedLabel = predictedLabel;
        clone.label = label;

        clone.predictedOutputValue = predictedOutputValue;
        clone.outputValue = outputValue;

        clone.rowIndex = rowIndex;



        return clone;
    }



    public Map<Integer, String> getData() {
        return data;
    }

    public void setData(Map<Integer, String> data) {
        this.data = data;
    }

    public void setColumns(ExcelDataColumnCollection columns) {
        this.columns = columns;
    }

    public String getPredictedLabel() {
        return predictedLabel;
    }

    public void setPredictedLabel(String predictedLabel) {
        this.predictedLabel = predictedLabel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPredictedOutputValue() {
        return predictedOutputValue;
    }

    public void setPredictedOutputValue(double predictedOutputValue) {
        this.predictedOutputValue = predictedOutputValue;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }

    public ExcelDataColumnCollection getColumns() {
        return columns;
    }

    public String cell(String name){
        int columnIndex = columns.indexOf(name);
        return cell(columnIndex);
    }

    public void cell(String name, String value){
        int columnIndex = columns.indexOf(name);
        if(columnIndex != -1) {
            cell(columnIndex, value);
        }
    }

    public void addCell(String name, String value) {
        int columnIndex = columns.indexOf(name);
        if(columnIndex != -1) {
            cell(columnIndex, value);
        } else {
            columns.add(name);
            cell(name, value);
        }
    }

    public void cell(int columnIndex, String value){
        if(!StringUtils.isEmpty(value)) {
            data.put(columnIndex, value);
        } else {
            data.remove(columnIndex);
        }
    }

    public String cell(int columnIndex){
        return data.getOrDefault(columnIndex, "");
    }

    public int columnCount(){
        return columns.columnCount();
    }

    public String[] cells() {
        int count = columns.columnCount();
        String[] values = new String[count];
        for(int i=0; i < count; ++i){
            values[i] = cell(i);
        }

        return values;

    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }





    @Override
    public String toString(){
        Map<String, String> columns = new HashMap<>();
        for(ExcelDataColumn c : getColumns().getColumns()) {
            columns.put(c.getName(), data.getOrDefault(c.getColumnIndex(), ""));
        }

        return JSON.toJSONString(columns);
    }



}
