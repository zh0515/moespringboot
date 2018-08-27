package cn.gov.gdupi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    Integer id;
    String name;
    Date create_date;
    String remarks;
    Boolean del_flag;

    String password;
    String role;

}
