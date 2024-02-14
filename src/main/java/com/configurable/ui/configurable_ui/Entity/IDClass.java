package com.configurable.ui.configurable_ui.Entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
public class IDClass implements Serializable{
	private static final long serialVersionUID = 1L;
	 private String appid;
	    private String inputname;
	    private String inputid;
}
