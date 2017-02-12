package com.example.JiangHu;


import java.io.Serializable;

/**
 * 新闻实体类
 * Created by Administrator on 2015/1/18.
 */
public class PersonInfo implements Serializable{

    private String name = "";  //姓名
    private int id;  //姓名id
    private int imageID;  //id

    public PersonInfo(String name, int id, int imageID) {
        this.name = name;
        this.id = id;
        this.imageID = imageID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }


    @Override
    public String toString() {
        return "PersonInfo{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }



}
