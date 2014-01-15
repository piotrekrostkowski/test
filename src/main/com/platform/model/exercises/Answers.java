package com.platform.model.exercises;
// Generated 2014-01-08 12:50:14 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;

/**
 * Answers generated by hbm2java
 */
@Entity
@Table(name = "answers", catalog = "platform")
public class Answers implements java.io.Serializable {

	private Integer id;
	private String value;
	private Boolean correct;
	private Set<ExercisesAnswers> exercisesAnswerses = new HashSet<ExercisesAnswers>(
			0);

	public Answers() {
	}

	public Answers(String value, Boolean correct,
			Set<ExercisesAnswers> exercisesAnswerses) {
		this.value = value;
		this.correct = correct;
		this.exercisesAnswerses = exercisesAnswerses;
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

	@Column(name = "VALUE", length = 200)
	@Length(max = 200)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "CORRECT")
	public Boolean getCorrect() {
		return this.correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "answers")
	public Set<ExercisesAnswers> getExercisesAnswerses() {
		return this.exercisesAnswerses;
	}

	public void setExercisesAnswerses(Set<ExercisesAnswers> exercisesAnswerses) {
		this.exercisesAnswerses = exercisesAnswerses;
	}

}
