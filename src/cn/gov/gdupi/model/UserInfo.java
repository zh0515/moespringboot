package cn.gov.gdupi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo extends Base implements Serializable {

    String role;
}
