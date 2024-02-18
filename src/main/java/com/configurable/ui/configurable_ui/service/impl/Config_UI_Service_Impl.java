package com.configurable.ui.configurable_ui.service.impl;


import com.configurable.ui.configurable_ui.Entity.AppData;
import com.configurable.ui.configurable_ui.Entity.InputData;
import com.configurable.ui.configurable_ui.dto.AppDataDto;
import com.configurable.ui.configurable_ui.dto.InputDataDto;
import com.configurable.ui.configurable_ui.repository.Config_Repo_AppData;
import com.configurable.ui.configurable_ui.repository.Config_Repo_InputData;
import com.configurable.ui.configurable_ui.service.Config_UI_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.configurable.ui.configurable_ui.dto.Response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class Config_UI_Service_Impl implements Config_UI_Service {

    @Autowired
    private Config_Repo_AppData configRepo;
    @Autowired
    private Config_Repo_InputData inputData;
    @Autowired
    ModelMapper mapper;


    @Override
    public ResponseEntity<Response> saveData(AppDataDto appDatadto) {
        AppData appData = mapper.map(appDatadto, AppData.class);
        
        
        long currentTimeMillis = System.currentTimeMillis();
        Timestamp currentTime = new Timestamp(currentTimeMillis);
        appData.setLastmodified(currentTime);
        String namespace = appDatadto.getNamespace();
        String viewname = appDatadto.getViewname();
        AppData appdata = this.configRepo.findByViewnameAndNamespace(namespace, viewname);
        System.out.println(appdata);
        System.out.println("----------------------");
        if (appdata == null) {
        	String appid = UUID.randomUUID().toString();
        	appData.setAppid(appid);
            List<InputDataDto> inputdatadto = appDatadto.getInputData();

            for (InputDataDto inputdto : inputdatadto) {
                InputData inputData = new InputData();
                inputData.setAppid(appid);
                inputData.setInputid(inputdto.getInputid());
                inputData.setInputname(inputdto.getInputname());
                inputData.setIsenabled(inputdto.isIsenabled());
                inputData.setLabelid(inputdto.getLabelid());
                inputData.setIsmandatory(inputdto.isIsmandatory());
                this.inputData.save(inputData);
            }

            this.configRepo.save(appData);
            return ResponseEntity.ok(new Response("Data inserted"));
        }
        
        
             
            
   //     }
        else {
        	this.inputData.DeleteById(appdata.getAppid());
//        	 List<InputData> inputdatadto = this.inputData.findById(appdata.getAppid());
//             System.out.println(inputdatadto);
//             int i=1;
//                for (InputData inputdto : inputdatadto) {
//               System.out.println(inputdto.getAppid());
//               if (inputdto.getAppid() != null) {
//                 this.inputData.DeleteById(appdata.getAppid());
//                 System.out.println("Deleted:"+i);
//                 i++;
//                 System.out.println("----------------------");
//              }
//        	 
//        }
       
        List<InputDataDto> inputDataDtos = appDatadto.getInputData();
        System.out.println(inputDataDtos);
        
        for (InputDataDto inputDataDto : inputDataDtos) {
            InputData inputData = new InputData();
            
            inputData.setAppid(appdata.getAppid());
            inputData.setInputid(inputDataDto.getInputid());
            inputData.setInputname(inputDataDto.getInputname());
            inputData.setIsenabled(inputDataDto.isIsenabled());
            inputData.setIsmandatory(inputDataDto.isIsmandatory());
            inputData.setLabelid(inputDataDto.getLabelid());
            System.out.println("Inserttion:"+" "+inputData);
            
            this.inputData.save(inputData);
        }
       
         return ResponseEntity.ok(new Response("Input Data Updated"));
        }

    }


    @Override
    public ResponseEntity<Response> saveInputData(InputData appData) {
        this.inputData.save(appData);
        return ResponseEntity.ok(new Response("Input Data inserted"));
    }

    @Override
    public AppDataDto getData(String namespace, String viewname) {
        try {
            AppData appdata = this.configRepo.findByViewnameAndNamespace(namespace,viewname);

                AppDataDto appdatadto = new AppDataDto();
                appdatadto.setAppid(appdata.getAppid());
                appdatadto.setAppname(appdata.getAppname());
                appdatadto.setNamespace(appdata.getNamespace());
                appdatadto.setViewname(appdata.getViewname());
                appdatadto.setLastmodified(appdata.getLastmodified());
                List<InputDataDto> inputDatadto = new ArrayList<>();

                List<InputData> inputdata = (List<InputData>) this.inputData.findById(appdata.getAppid());

                for (InputData inputData : inputdata) {
                    InputDataDto inputdatadto = new InputDataDto();
                    inputdatadto.setInputid(inputData.getInputid());
                    inputdatadto.setInputname(inputData.getInputname());
                    inputdatadto.setIsenabled(inputData.isIsenabled());
                    inputdatadto.setIsmandatory(inputData.isIsmandatory());
                    inputdatadto.setLabelid(inputData.getLabelid());
                    inputDatadto.add(inputdatadto);
                }

                appdatadto.setInputData(inputDatadto);
                return appdatadto;


            		            
        } catch (Exception ex) {
            // Log the exception or handle it as needed
            ex.printStackTrace();
            // You might want to throw custom exceptions or return an empty list here
            return null;
        }
    }

    @Override
    public InputData findByInputNameAndInputId(String inputname,String inputid) {
        return this.inputData.findByInputIdAndInputName(inputid,inputname);
    }




}
