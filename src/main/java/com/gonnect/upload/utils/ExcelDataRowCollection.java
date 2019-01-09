package com.gonnect.upload.utils;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 * Created by xschen on 10/7/2016.
 */
public class ExcelDataRowCollection implements Serializable, Iterable<ExcelDataRow> {
    private List<ExcelDataRow> rows = new ArrayList<>();

    public ExcelDataRowCollection(){

    }

    public ExcelDataRowCollection(List<ExcelDataRow> rows){
        for(int i = 0; i < rows.size(); ++i){
            add(rows.get(i).makeCopy());
        }
    }

    public ExcelDataRow add(ExcelDataRow row){
        int rowIndex = rows.size();
        rows.add(row);
        row.setRowIndex(rowIndex);
        return row;
    }

    public List<ExcelDataRow> getRows() {
        return rows;
    }

    public void setRows(List<ExcelDataRow> rows) {
        this.rows = rows;
    }

    public ExcelDataRow row(int index){
        return rows.get(index);
    }

    public int rowCount(){
        return rows.size();
    }

    public ExcelDataRowCollection makeCopy(){
        ExcelDataRowCollection clone = new ExcelDataRowCollection(rows);
        return clone;
    }

    @Override
    public Iterator<ExcelDataRow> iterator() {
        return rows.iterator();
    }

    @Override
    public void forEach(Consumer<? super ExcelDataRow> action) {
        rows.forEach(action);
    }

    @Override
    public Spliterator<ExcelDataRow> spliterator() {
        return rows.spliterator();
    }


    public void addAll(List<ExcelDataRow> rows) {
        this.rows.addAll(rows);
    }


    public boolean isEmpty() {
        return rows.isEmpty();
    }


    public <T> Stream<T> map(Function<ExcelDataRow, T> transformer) {
        return rows.stream().map(transformer);
    }
}
