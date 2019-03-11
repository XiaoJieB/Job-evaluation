package com.luobo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * . Description: Date: 2019/3/11 10:38
 *
 * @author: ws
 * @version: 1.0
 */
@Entity
@Table(name = "score")
public class Score {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "created")
	private Long created = System.currentTimeMillis();


	private Double selfScore;

	private Double selfRatio;

	private Double mutualScore;

	private Double mutualRatio;

	private Double teacherScore;

	private Double teacherRatio;

	private Double totalScore;

	private String remark;

	public Double CalcTotalScore(Double selfScore, Double selfRatio, Double mutualScore, Double mutualRatio,
		Double teacherScore, Double teacherRatio) {
		Double totalScore = selfScore * selfRatio + mutualScore * mutualRatio + teacherScore * teacherRatio;
		return totalScore;
	}

	public Double getSelfScore() {
		return selfScore;
	}

	public void setSelfScore(Double selfScore) {
		this.selfScore = selfScore;
	}

	public Double getSelfRatio() {
		return selfRatio;
	}

	public void setSelfRatio(Double selfRatio) {
		this.selfRatio = selfRatio;
	}

	public Double getMutualScore() {
		return mutualScore;
	}

	public void setMutualScore(Double mutualScore) {
		this.mutualScore = mutualScore;
	}

	public Double getMutualRatio() {
		return mutualRatio;
	}

	public void setMutualRatio(Double mutualRatio) {
		this.mutualRatio = mutualRatio;
	}

	public Double getTeacherScore() {
		return teacherScore;
	}

	public void setTeacherScore(Double teacherScore) {
		this.teacherScore = teacherScore;
	}

	public Double getTeacherRatio() {
		return teacherRatio;
	}

	public void setTeacherRatio(Double teacherRatio) {
		this.teacherRatio = teacherRatio;
	}

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
