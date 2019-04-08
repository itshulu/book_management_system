package com.sl.entity;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;


/**
 * @author ShuLu
 */
public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = 8656597559014685635L;
    /**
     * 总记录数
     */
    private long totalElements;
    /**
     * 结果集
     */
    private List<T> content;
    /**
     *页码
     */
    private int number;
    /**
     * 每页记录数
     */
    private int size=10;
    /**
     * 总页数
     */
    private int totalPages;
    /**
     * 该页元素数量 <= pageSize，该属性来自ArrayList的size属性
     */
    private int numberOfElements;
    /**
     * 是否为空数据
     */
    private boolean empty;
    /**
     * 是否为第一页
     */
    private boolean first;
    /**
     * 是否为最后一页
     */
    private boolean last;
    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param list          page结果
     */
    public PageBean(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.number = page.getPageNum();
            this.size = page.getPageSize();
            this.totalElements = page.getTotal();
            this.totalPages = page.getPages();
            this.content = page;
            this.numberOfElements = page.size();
            this.first= page.getPageNum() == 1;
            this.last=page.getPageNum()==totalPages;
            this.empty=totalElements==0;
        }
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content  ;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}

