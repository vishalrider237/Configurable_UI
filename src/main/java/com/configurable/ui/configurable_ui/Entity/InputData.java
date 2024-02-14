package com.configurable.ui.configurable_ui.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Configurable_UI_InputData")
@Data
@IdClass(IDClass.class)
public class InputData {
	@Id
	 private String appid;
    @Id
    private String inputname;
    @Id
    private String inputid;
    private String labelid;
    private boolean ismandatory;

    private boolean isenabled;
   
    
}
