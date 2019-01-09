package com.gonnect.upload.utils;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;


/**
 *  xschen on 10/7/2016.
 */
public class ExcelDataColumnCollection implements Serializable, Iterable<ExcelDataColumn> {
    private static final long serialVersionUID = 1295848949690118176L;
    private List<ExcelDataColumn> columns = new ArrayList<>();
    private Map<String, Integer> columNames = new HashMap<>();

    public ExcelDataColumnCollection(){

    }

    public ExcelDataColumnCollection(List<ExcelDataColumn> columns){
        for(int i=0; i < columns.size(); ++i){
            add(columns.get(i).makeCopy());
        }
    }

    public ExcelDataColumn add(String columnName){
        ExcelDataColumn column = new ExcelDataColumn(columnName);
        return add(column);
    }

    public ExcelDataColumn add(ExcelDataColumn column){
        int columnIndex = columns.size();
        columns.add(column);
        columNames.put(column.getName(), columnIndex);
        column.setColumnIndex(columnIndex);

        return column;
    }

    public int columnCount(){
        return columns.size();
    }

    public List<ExcelDataColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<ExcelDataColumn> columns) {
        this.columns = columns;
    }

    public Map<String, Integer> getColumNames() {
        return columNames;
    }

    public void setColumNames(Map<String, Integer> columNames) {
        this.columNames = columNames;
    }

    public ExcelDataColumnCollection makeCopy(){
        ExcelDataColumnCollection clone = new ExcelDataColumnCollection(columns);
        return clone;
    }

    @Override
    public Iterator<ExcelDataColumn> iterator() {
        return columns.iterator();
    }

    @Override
    public void forEach(Consumer<? super ExcelDataColumn> action) {
        columns.forEach(action);
    }

    @Override
    public Spliterator<ExcelDataColumn> spliterator() {
        return columns.spliterator();
    }

    public int indexOf(String name) {
        return columNames.getOrDefault(name, -1);
    }

    public ExcelDataColumn column(String name){
        return column(indexOf(name));
    }

    public ExcelDataColumn column(int index){
        return columns.get(index);
    }
}
