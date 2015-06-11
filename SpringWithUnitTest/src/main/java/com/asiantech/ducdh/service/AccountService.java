package com.asiantech.ducdh.service;

import java.util.List;

import com.asiantech.ducdh.entity.TaskJob;


public interface AccountService {
	public static String NAME_SERVICE = "accountService";
	//---------------
	List<TaskJob> list();
	//----------------
	public void saveOrUpdate(TaskJob task,List<TaskJob> list);
	//-----------------
	public void delete(int idTask,List<TaskJob> list);
	//------------------
	TaskJob getTask(int idTask, List<TaskJob> list);
	//------------------
	List<TaskJob> search(String keyword,List<TaskJob> list);
	//-----------------
	void saveJob(List<TaskJob> listResult);
	//-------------------
	int getMaxPage(List<TaskJob> list,int recordInPage);
	//-------------------
	List<TaskJob> list(List<TaskJob> list,int currentPage, int recordInPage);
	//-------------------
	boolean checkTask(int idTask, List<TaskJob> list);
	//-------------------
	int getCurrentPage(int idTask, List<TaskJob> list,int recordInPage);
	//-------------------
	void changePublic(int idTask, List<TaskJob> list);
	//-------------------
	void changeStatus(int idTask, String statusTask, List<TaskJob> list);
	//-------------------
}
