package com.atguigu.pojo;

/**
 * Author: 牛耀辉
 * Date: 2024/11/2 22:47
 * Description:
 */
public class Student {
    private int sid;
    private String sname;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
