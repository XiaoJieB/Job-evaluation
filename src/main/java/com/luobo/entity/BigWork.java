package com.luobo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * . Description: Date: 2019/3/15 09:58
 *
 * @author: ws
 * @version: 1.0
 */
@Entity
@Table(name = "big_work")
public class BigWork {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "created")
	private Long created = System.currentTimeMillis();

	private String name;

	private String gitSrc;

	private String projectSrc;

	private String imgSrc;

	private Long studentId;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGitSrc() {
		return gitSrc;
	}

	public void setGitSrc(String gitSrc) {
		this.gitSrc = gitSrc;
	}

	public String getProjectSrc() {
		return projectSrc;
	}

	public void setProjectSrc(String projectSrc) {
		this.projectSrc = projectSrc;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
