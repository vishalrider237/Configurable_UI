package com.configurable.ui.configurable_ui.controller;



import com.configurable.ui.configurable_ui.Entity.AppData;
import com.configurable.ui.configurable_ui.Entity.InputData;
import com.configurable.ui.configurable_ui.dto.AppDataDto;
import com.configurable.ui.configurable_ui.dto.InputDataUpdateRequest;
import com.configurable.ui.configurable_ui.dto.PostDataGet;
import com.configurable.ui.configurable_ui.service.Config_UI_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/config/ui")
public class Configurable_UI_Controller {

    @Autowired
    private Config_UI_Service configUiService;

    @PostMapping("/insert/data")
    public ResponseEntity<?> saveData( @RequestBody AppDataDto appDatadto) {
        return this.configUiService.saveData(appDatadto);
    }
    @PostMapping ("/get/data")
    public AppDataDto getData(@RequestBody PostDataGet postDataGet){
        String namespace= postDataGet.getNamespace();
        String viewname= postDataGet.getViewname();
        System.out.println("Received namespace: " + namespace);
        System.out.println("Received viewname: " + viewname);
       return  this.configUiService.getData(namespace,viewname);
    }
    @PutMapping("/update/{inputname}/{inputid}")
    @Transactional
    public ResponseEntity<?> updateData(@PathVariable String inputname ,@PathVariable String inputid, @RequestBody InputDataUpdateRequest request){
        InputData  inputData = this.configUiService.findByInputNameAndInputId(inputname,inputid);
        if (inputData == null) {
            return ResponseEntity.notFound().build();
        }
        inputData.setIsenabled(request.isIsenabled());
        inputData.setIsmandatory(request.isIsmandatory());
        this.configUiService.saveInputData(inputData);

        return ResponseEntity.ok("InputData with InputName " + inputname + " updated successfully.");
    }
}
