package com.te.quizapplication.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Questions implements Serializable
{
	@Column @Id
	private int qid;
	
	@Column
	private String questions;
	
	@Column
	private String option1;
	
	@Column
	private String option2;
	
	@Column
	private String option3;
	
	@Column
	private String option4;
	
	@Column
	private String correctAns;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	private Category category;
	
}
