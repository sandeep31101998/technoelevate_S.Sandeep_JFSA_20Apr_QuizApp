package com.te.quizapplication.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Category implements Serializable{
	@Column
	@Id
	private int cid;

	@Column
	private String cname;

	@Column
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Questions> questions;

}
