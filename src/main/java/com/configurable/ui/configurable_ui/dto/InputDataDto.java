package com.configurable.ui.configurable_ui.dto;

import com.configurable.ui.configurable_ui.Entity.AppData;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class InputDataDto {
	@JsonIgnore
	private String appid;
    private String inputname;

    private String inputid;
    private String labelid;
    private boolean ismandatory;

    private boolean isenabled;


}
