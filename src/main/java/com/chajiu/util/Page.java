package com.chajiu.util;

public class Page {
    private Integer start;
    private Integer count;

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                '}';
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Page calLast(Integer total){
        if(0==total%count)
            start=total-count;
        else
            start=total-total%count;
        return this;
    }
}
