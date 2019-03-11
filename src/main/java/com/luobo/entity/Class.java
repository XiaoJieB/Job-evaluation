package com.luobo.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * . Description: Date: 2019/3/11 10:34
 *
 * @author: ws
 * @version: 1.0
 */
public class Class {
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "teachers_students", joinColumns = {
		@JoinColumn(name = "teacher_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private Set<Student> students;

}
