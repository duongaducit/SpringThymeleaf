package com.asiantech.ducdh.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "TaskJob")
public class TaskJob implements Serializable {
	
	@Id
	@Column(name = "idTask", length = 11)
	private int idTask;
	
	@NotNull
	@NotEmpty
	@Column(name = "nameTask")
	private String nameTask;
	
	@Column(name = "timeUpdate")
	@Temporal(TemporalType.DATE)
	private Date timeUpdate;
	
	@Column(name = "statusTask")
	private String statusTask;
	
	@Column(name = "publicTask")
	private boolean publicTask;

	public TaskJob() {
		super();
	}

	public TaskJob(int idTask, String nameTask, Date timeUpdate,
			String statusTask, boolean publicTask) {
		super();
		this.idTask = idTask;
		this.nameTask = nameTask;
		this.timeUpdate = timeUpdate;
		this.statusTask = statusTask;
		this.publicTask = publicTask;

	}

	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	public String getNameTask() {
		return nameTask;
	}

	public void setNameTask(String nameTask) {
		this.nameTask = nameTask;
	}

	public Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	public String getStatusTask() {
		return statusTask;
	}

	public void setStatusTask(String statusTask) {
		this.statusTask = statusTask;
	}

	public boolean isPublicTask() {
		return publicTask;
	}

	public void setPublicTask(boolean publicTask) {
		this.publicTask = publicTask;
	}

	public static Comparator<TaskJob> TASK_NAME_COMPARETO = new Comparator<TaskJob>() {

		public int compare(TaskJob s1, TaskJob s2) {
			String taskName1 = s1.getNameTask().toUpperCase();
			String taskName2 = s2.getNameTask().toUpperCase();

			// ascending order
			return taskName1.compareTo(taskName2);

			// descending order
		}
	};

	/* Comparator for sorting the list by roll no */
	public static Comparator<TaskJob> ID_TASK = new Comparator<TaskJob>() {

		public int compare(TaskJob s1, TaskJob s2) {

			int taskIdN1 = s1.getIdTask();
			int taskIdN2 = s2.getIdTask();

			/* For ascending order */
			return taskIdN1 - taskIdN2;

			/* For descending order */
			// rollno2-rollno1;
		}
	};

	public static Comparator<TaskJob> COMPARETO_NAME = new Comparator<TaskJob>() {

		public int compare(TaskJob s1, TaskJob s2) {
			String taskName1 = s1.getNameTask().toUpperCase();
			String taskName2 = s2.getNameTask().toUpperCase();

			// ascending order
			return taskName2.compareTo(taskName1);

			// descending order
		}
	};

	/* Comparator for sorting the list by roll no */
	public static Comparator<TaskJob> TASK_ID = new Comparator<TaskJob>() {

		public int compare(TaskJob s1, TaskJob s2) {

			int taskIdN1 = s1.getIdTask();
			int taskIdN2 = s2.getIdTask();

			/* For ascending order */
			return taskIdN2 - taskIdN1;

			/* For descending order */
			// rollno2-rollno1;
		}
	};
	@Override
	public String toString() {
		return "[ id =" + idTask + ", name =" + nameTask + ", time ="
				+ timeUpdate + "]";
	}

}
