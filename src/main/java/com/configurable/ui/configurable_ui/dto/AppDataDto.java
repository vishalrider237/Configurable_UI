package com.configurable.ui.configurable_ui.dto;

import com.configurable.ui.configurable_ui.Entity.InputData;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Data
public class AppDataDto {
    private String appid;

    private String appname;

    private String namespace;

    private String viewname;


    private Timestamp lastmodified;

     private List<InputDataDto> inputData;
}
