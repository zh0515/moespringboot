package cn.dev.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User extends UserInfo implements Serializable {
    String password;
}
