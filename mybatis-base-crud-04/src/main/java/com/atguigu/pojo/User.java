package com.atguigu.pojo;

import lombok.Data;

@Data //lombok  get set toString 方法，不需要自己写了
public class User {
  private Integer id;
  private String username;
  private String password;
}