package com.configurable.ui.configurable_ui.service;


import com.configurable.ui.configurable_ui.Entity.AppData;
import com.configurable.ui.configurable_ui.Entity.InputData;
import com.configurable.ui.configurable_ui.dto.AppDataDto;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Config_UI_Service {

    public ResponseEntity<?>saveData(AppDataDto appData);
    public ResponseEntity<?>saveInputData(InputData appData);
    public AppDataDto getData(String namespace, String viewname);
    public InputData findByInputNameAndInputId(String inputname,String inputid);

}
