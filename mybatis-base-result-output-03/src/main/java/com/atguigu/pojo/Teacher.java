package com.atguigu.pojo;

/**
 * Author: 牛耀辉
 * Date: 2024/11/4 23:08
 * Description:
 */
public class Teacher {
    private String tId;
    private String tName;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                '}';
    }
}
