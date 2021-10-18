package com.jpa.hibernate.jpaadvanced.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Table(name = "CourseDetails")

@Entity
//@NamedQuery(name = "query_get_all_courses", query = "Select c from Course c")
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_courses", query = "Select c from Course c"),
		@NamedQuery(name = "query_get_100_step_courses", query = "Select c from Course c where name like '%100 steps'")
})
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(name = "fullName", nullable = false, length = 10)
	private String name;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Course() {
	}
	
	public Course(String name) {
		super();
		this.name = name;
	}
	
	
	public Course(Long id, String name, LocalDateTime lastUpdatedDate, LocalDateTime createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdatedDate = lastUpdatedDate;
		this.createdDate = createdDate;
	}

	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
