package com.awesome.model;

import java.util.List;

public class TableResponse<T> {
    private long total;
    private List<T> list;



    public long getTotal() {
        return total;
    }



    public void setTotal(long pTotal) {
        total = pTotal;
    }



    public List<T> getList() {
        return list;
    }



    public void setList(List<T> pList) {
        list = pList;
    }
}
