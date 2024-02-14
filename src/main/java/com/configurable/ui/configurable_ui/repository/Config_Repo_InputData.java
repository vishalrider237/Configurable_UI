package com.configurable.ui.configurable_ui.repository;

import com.configurable.ui.configurable_ui.Entity.InputData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Config_Repo_InputData extends JpaRepository<InputData,Integer> {
	@Query("from InputData as c where c.appid=:appid")
	  List<InputData> findById(@Param("appid") String appid);

	@Transactional
	@Modifying
	@Query("delete from InputData as c where c.appid=:appid")
	void   DeleteById( @Param("appid") String appid);
	@Transactional
	@Modifying
	@Query("delete from InputData")
	void DeleteAll();
	@Query("from InputData as c where c.inputid=:inputid and  c.inputname=:inputname")
	InputData findByInputIdAndInputName(@Param("inputid") String inputid, @Param("inputname") String inputname);
	@Query("from InputData as c where c.inputid=:inputid and  c.inputname=:inputname")
	List<InputData> findByInputIdAndInputName1(@Param("inputid") String inputid, @Param("inputname") String inputname);
}
