package com.asiantech.ducdh.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiantech.ducdh.entity.TaskJob;
import com.asiantech.ducdh.repository.TaskJobRepository;
import com.asiantech.ducdh.service.AccountService;

@Service(AccountService.NAME_SERVICE)
public class AccountServiceImpl implements AccountService {

	@Resource
	private TaskJobRepository taskRepository;
	
	/*
	 * (delete in list)
	 * @see com.asian.spring.two.dao.AccountDAO#delete(java.lang.String, java.util.List)
	 */
	public void delete(int idTask,List<TaskJob> list){
		for(int i = 0;i < list.size();i++){
			if (list.get(i).getIdTask() == idTask)
				list.remove(i);
			}
	}
	/*
	 * delete in SQL
	 */
	@Transactional
	public void deleteSQL(int idTask) throws Exception {
		TaskJob task = taskRepository.findOne(idTask);
		if (task == null) throw new Exception();
		else {
			taskRepository.delete(task);
		}
	}

	public List<TaskJob> list() {
		
		List<TaskJob> list = new ArrayList<TaskJob>();
		list = taskRepository.findAll();
		return list;
	}
	/*
	 * get Task to list
	 * 
	 * @see com.asian.spring.two.dao.AccountDAO#getTask(java.lang.String,
	 * java.util.List)
	 */
	public TaskJob getTask(int idTask, List<TaskJob> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdTask() == idTask)
				return list.get(i);
		}

		return null;
	}

	/*
	 * save task to list
	 * 
	 * @see
	 * com.asian.spring.two.dao.AccountDAO#saveOrUpdate(com.asian.spring.two
	 * .entity.TaskJob, java.util.List)
	 */
	public void saveOrUpdate(TaskJob task, List<TaskJob> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdTask() == task.getIdTask())
				list.remove(i);
		}
		list.add(task);
	}

	/*
	 * search in list
	 * 
	 * @see com.asian.spring.two.dao.AccountDAO#search(java.lang.String,
	 * java.util.List)
	 */
	public List<TaskJob> search(String keyword, List<TaskJob> list) {
		// TODO Auto-generated method stub
		for (int i = list.size() - 1; i >= 0; i--) {
			if (!list.get(i).getNameTask().contains(keyword)) {
				list.remove(i);
			}
		}
		return list;
	}

	/*
	 * save all job
	 * 
	 * @see com.asian.spring.two.dao.AccountDAO#saveJob(java.util.List)
	 */
	@Transactional
	public void saveJob(List<TaskJob> listResult) {
		taskRepository.deleteAll();
		for (int i = 0;i < listResult.size();i++){
			taskRepository.save(listResult);
		}
		
	}

	/*
	 * check delete
	 */
	public boolean checkDelete(int id, List<TaskJob> list){
		boolean check = false;
		for (int i = 0;i < list.size();i++){
			if (list.get(i).getIdTask() == id)
				check = true;
		}
		return check;
	}

	public int getMaxPage(List<TaskJob> list,int recordInPage) {
		// TODO Auto-generated method stub
		int max = 1;
		if (list.size()%recordInPage == 0){
			max = (list.size()/recordInPage);
		}else{
			max = (list.size()/recordInPage) + 1;
		}
		System.out.println(max);
		return max;
	}
	/*
	 * get list paging
	 * @see com.asian.spring.two.dao.AccountDAO#list(java.util.List, int, int)
	 */
	public List<TaskJob> list(List<TaskJob> list,int currentPage, int recordInPage) {
		List<TaskJob> listCurrent = new ArrayList<TaskJob>();
		for (int i = 0;i < recordInPage;i++){
			if ((currentPage*recordInPage + i) < list.size())
			listCurrent.add(list.get(currentPage*recordInPage + i));
		}
		
		return listCurrent;
	}

	public boolean checkTask(int idTask, List<TaskJob> list) {
		boolean check = false;
		for (int i = 0;i < list.size();i++){
			if (idTask == (list.get(i).getIdTask())){
				check = true;
			}
		}
		
		return check;
	}
	
	public int getCurrentPage(int idTask, List<TaskJob> list,
			int recordInPage) {
		int post = 0;
		for (int i = 0;i < list.size();i++){
			if (idTask == (list.get(i).getIdTask())){
				post = i;
			}
		}
		
		return post/recordInPage;
	}
	
	public void changePublic(int idTask, List<TaskJob> list) {
		for (int i = 0;i < list.size();i++){
			if (idTask == (list.get(i).getIdTask())){
				list.get(i).setPublicTask(!list.get(i).isPublicTask());
			}
		}
		System.out.println("change");
	}
	
	public void changeStatus(int idTask,String statusTask, List<TaskJob> list) {
		for (int i = 0;i < list.size();i++){
			if (idTask == (list.get(i).getIdTask())){
				list.get(i).setStatusTask(statusTask);
			}
		}
		System.out.println("changeSTT");
	}
}
