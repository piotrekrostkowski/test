package com.platform.model.exercises;
// Generated 2014-01-08 12:50:14 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.platform.model.lessons.Vocabulary;
import com.platform.model.menus.Menu;

/**
 * Exercises generated by hbm2java
 */
@Entity
@Table(name = "exercises", catalog = "platform")
public class Exercises implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -125267385809653176L;
	
	private Integer id;
	private Menu menu;
	private ExercisesType exercisesType;
	private Questions questions;
	private Vocabulary vocabulary;
	private Set<ExercisesAnswers> exercisesAnswerses = new HashSet<ExercisesAnswers>(
			0);
	private Set<Answers> answers= new HashSet<Answers>(
			0);

	public Exercises() {
	}

	public Exercises(Menu menu, ExercisesType exercisesType,
			Questions questions, Vocabulary vocabulary,
			Set<ExercisesAnswers> exercisesAnswerses,Set<Answers> answers) {
		this.menu = menu;
		this.exercisesType = exercisesType;
		this.questions = questions;
		this.vocabulary = vocabulary;
		this.exercisesAnswerses = exercisesAnswerses;
		this.answers=answers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID")
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	public ExercisesType getExercisesType() {
		return this.exercisesType;
	}

	public void setExercisesType(ExercisesType exercisesType) {
		this.exercisesType = exercisesType;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	public Questions getQuestions() {
		return this.questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VOCABULARY_ID")
	public Vocabulary getVocabulary() {
		return this.vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exercises")
	public Set<ExercisesAnswers> getExercisesAnswerses() {
		return this.exercisesAnswerses;
	}

	public void setExercisesAnswerses(Set<ExercisesAnswers> exercisesAnswerses) {
		this.exercisesAnswerses = exercisesAnswerses;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Answers.class)
	@JoinTable(name = "EXERCISES_ANSWERS", joinColumns = { @JoinColumn(name = "EXERCISE_ID") }, inverseJoinColumns = { @JoinColumn(name = "ANSWER_ID") })
	public Set<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answers> answers) {
		this.answers = answers;
	}

}
