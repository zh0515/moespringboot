package cn.gov.gdupi.model;

import lombok.Data;

import java.util.Date;

@Data
public class Cron {
    Integer id;
    String name;
    Date create_time;
    String remarks;
    Boolean del_flag;


    String git;
    String cmd;
}
