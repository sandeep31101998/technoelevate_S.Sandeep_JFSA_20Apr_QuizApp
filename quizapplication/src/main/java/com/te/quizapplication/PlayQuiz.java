package com.te.quizapplication;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.quizapplication.bean.Questions;

public class PlayQuiz {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("quizdata");
		EntityManager entitymanager = emf.createEntityManager();
		EntityTransaction transaction = entitymanager.getTransaction();

		transaction.begin();
		Scanner sc = new Scanner(System.in);
		int qno = 1, correct = 0, wrong = 0;
		String res = null;
		do {
			Questions questions = entitymanager.find(Questions.class, qno);
			if (questions == null) {
				System.out.println("The Quiz result is");
				System.err.println("Number of wrong answer-> " + wrong);
				System.out.println("Number of correct answer-> " + correct);
				break;
			} else {
				System.out.println(questions.getQid() + " " + questions.getQuestions());
				System.out.println("A." + questions.getOption1());
				System.out.println("B." + questions.getOption2());
				System.out.println("C." + questions.getOption3());
				System.out.println("D." + questions.getOption4());
				System.out.print("type the correct answer: ");
				String readAns = sc.next().toLowerCase();

				if (questions.getCorrectAns().equals(readAns)) {
					correct++;
				} else {
					wrong++;
				}

				System.out.println("next question? (next)");
				res = sc.next();
				qno++;
			}
		} while (res.equalsIgnoreCase("next"));

		transaction.commit();

	}

}
