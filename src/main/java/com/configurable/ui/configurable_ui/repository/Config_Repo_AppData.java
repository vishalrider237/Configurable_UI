package com.configurable.ui.configurable_ui.repository;

import com.configurable.ui.configurable_ui.Entity.AppData;
import com.configurable.ui.configurable_ui.dto.AppDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Config_Repo_AppData extends JpaRepository<AppData,Integer> {

   // @Query(value = "select * from CONFIGURABLE_UI_APP_DATA hd where hd.VIEWNAME=?1 AND hd.NAMESPACE=?2",nativeQuery = true)
  @Query("from AppData as c where c.namespace=:name and c.viewname=:view")
    AppData findByViewnameAndNamespace(@Param("name") String name,@Param("view") String view);
    AppDataDto findByAppid(String appid);
}
