package com.luobo.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * . Description: Date: 2019/3/11 10:30
 *
 * @author: ws
 * @version: 1.0
 */
@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "created")
	private Long created = System.currentTimeMillis();

	private String name;

	@Column(name = "phone")
	private String phone;

	private String teachNo;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "teachers_students", joinColumns = {
		@JoinColumn(name = "teacher_id") }
		, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTeachNo() {
		return teachNo;
	}

	public void setTeachNo(String teachNo) {
		this.teachNo = teachNo;
	}
}
