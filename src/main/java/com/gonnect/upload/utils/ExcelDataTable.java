package com.gonnect.upload.utils;


import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 *  xschen on 10/7/2016.
 */
public class ExcelDataTable implements Serializable {
    private ExcelDataColumnCollection dataColumns = new ExcelDataColumnCollection();
    private ExcelDataRowCollection dataRows = new ExcelDataRowCollection();
    private String name = "";
    private String projectId = "";
    private String id = "";

    public ExcelDataTable(){

    }

    public ExcelDataTable(List<String> columnNames, List<ExcelDataRow> rows) {
        for(int i=0; i < columnNames.size(); ++i){
            columns().add(columnNames.get(i));
        }
        dataRows.addAll(rows);
    }

    public ExcelDataTable(int columnCount) {
        for(int i=0; i < columnCount; ++i) {
            columns().add("c" + (i+1));
        }
    }

    public ExcelDataTable(String... columnNames){
        for(int i=0; i < columnNames.length; ++i){
            columns().add(columnNames[i]);
        }
    }


    public ExcelDataColumnCollection columns(){
        return dataColumns;
    }

    public void setDataColumns(List<ExcelDataColumn> columns){
        this.dataColumns = new ExcelDataColumnCollection(columns);
    }

    public List<ExcelDataColumn> getDataColumns(){
        return dataColumns.getColumns();
    }

    public List<ExcelDataRow> getDataRows(){
        return dataRows.getRows();
    }

    public void setDataRows(List<ExcelDataRow> rows){
        this.dataRows = new ExcelDataRowCollection(rows);
    }

    public ExcelDataRowCollection rows(){
        return dataRows;
    }

    public ExcelDataRow newRow(){
        return new ExcelDataRow(dataColumns.makeCopy());
    }

    public int rowCount() {
        return dataRows.rowCount();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if(id == null || id.equals("")){
            id = name;
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExcelDataRow addRow(String label, String... values) {
        ExcelDataRow row = newRow();
        if(!StringUtils.isEmpty(label)) {
            row.setLabel(label);
        }

        double value;
        try{
            value = Double.parseDouble(label);
        }catch(NumberFormatException ex){
            value = 0;
        }

        row.setOutputValue(value);

        for(int i=0; i < values.length; ++i){
            row.cell(i, values[i]);
        }
        return rows().add(row);
    }

    public ExcelDataRow addRow(String label, List<String> values) {
        ExcelDataRow row = newRow();
        if(!StringUtils.isEmpty(label)) {
            row.setLabel(label);
        }

        double value;
        try{
            value = Double.parseDouble(label);
        }catch(NumberFormatException ex){
            value = 0;
        }

        row.setOutputValue(value);

        for(int i=0; i < values.size(); ++i){
            row.cell(i, values.get(i));
        }
        return rows().add(row);
    }

    public ExcelDataRow addRow(String label, Map<Integer, String> values) {
        ExcelDataRow row = newRow();
        if(!StringUtils.isEmpty(label)) {
            row.setLabel(label);
        }

        double value;
        try{
            value = Double.parseDouble(label);
        }catch(NumberFormatException ex){
            value = 0;
        }

        row.setOutputValue(value);

        for(Map.Entry<Integer, String> entry : values.entrySet()) {
            row.cell(entry.getKey(), entry.getValue());
        }
        return rows().add(row);
    }




    public ExcelDataRow row(int i) {
        return dataRows.row(i);
    }


    public boolean isEmpty() {
        return dataRows.isEmpty();
    }
}
