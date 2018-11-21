package com.encore.entities;

import javax.persistence.*;

@Entity(name="select_options")
public class SelectOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "select_type")
    private int selectType;

    @Column(name = "key")
    private int key;

    @Column(name = "value")
    private String value;

    public SelectOptions() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSelectType() {
        return selectType;
    }

    public void setSelectType(int selectType) {
        this.selectType = selectType;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
