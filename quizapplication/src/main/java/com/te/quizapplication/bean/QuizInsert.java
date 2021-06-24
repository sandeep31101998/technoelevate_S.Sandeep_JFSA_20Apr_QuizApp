package com.te.quizapplication.bean;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class QuizInsert {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Category c1 = new Category();
		c1.setCid(10);
		c1.setCname("General Knowledge");

		Questions q1 = new Questions();
		q1.setQid(1);
		q1.setQuestions("who is the prime minister of india?");
		q1.setOption1("modi");
		q1.setOption2("gandi");
		q1.setOption3("nehru");
		q1.setOption4("shiddu");
		q1.setCorrectAns("modi");
		q1.setCategory(c1);

		Questions q2 = new Questions();
		q2.setQid(2);
		q2.setQuestions("who is chief minister of karnataka?");
		q2.setOption1("yedurappa");
		q2.setOption2("siddu");
		q2.setOption3("motilala");
		q2.setOption4("suresh");
		q2.setCorrectAns("yedurappa");
		q2.setCategory(c1);

		Questions q3 = new Questions();
		q3.setQid(3);
		q3.setQuestions("who is the king of hampi?");
		q3.setOption1("krishnadevaraya");
		q3.setOption2("kumarswamy");
		q3.setOption3("shivappa");
		q3.setOption4("satya");
		q3.setCorrectAns("krishnadevaraya");
		q3.setCategory(c1);

		Questions q4 = new Questions();
		q4.setQid(4);
		q4.setQuestions("who is king of bangalore?");
		q4.setOption1("kempegowda");
		q4.setOption2("raju");
		q4.setOption3("madakarinayaka");
		q4.setOption4("obama");
		q4.setCorrectAns("kempegowda");
		q4.setCategory(c1);

		ArrayList<Questions> al = new ArrayList<Questions>();
		al.add(q1);
		al.add(q2);
		al.add(q3);
		al.add(q4);

		c1.setQuestions(al);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("quizdata");
		EntityManager entitymanager = emf.createEntityManager();
		EntityTransaction transaction = entitymanager.getTransaction();

		transaction.begin();

		entitymanager.persist(c1);

		transaction.commit();
	}
}
