package com.configurable.ui.configurable_ui.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Configurable_UI_AppData")
@Data
public class AppData {
    @Id
    private String appid;

    private String appname;

    private String namespace;

    private String viewname;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Timestamp lastmodified;
  
}
