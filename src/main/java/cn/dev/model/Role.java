package cn.dev.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role extends Base implements Serializable {
    String permissions;
}
