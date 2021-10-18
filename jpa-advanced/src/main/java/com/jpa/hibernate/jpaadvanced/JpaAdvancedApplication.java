package com.jpa.hibernate.jpaadvanced;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jpa.hibernate.jpaadvanced.entity.Employee;
import com.jpa.hibernate.jpaadvanced.repo.CourseRepository;
import com.jpa.hibernate.jpaadvanced.repo.EmployeeRepository;
import com.jpa.hibernate.jpaadvanced.repo.EmployeeSpringDataRepository;
import com.jpa.hibernate.jpaadvanced.repo.StudentRepository;

@SpringBootApplication
public class JpaAdvancedApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeSpringDataRepository employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10001L);
//		logger.info("Course 10001 -> {}", course);
//		
//		courseRepository.deleteById(10001L);
//		
//		courseRepository.save(new Course("Microservices in 100 Steps"));
		
//		courseRepository.playWithEntityManager();
		
//		courseRepository.refreshEntityManager();
		
//		studentRepository.saveStudentWithPassport();
		
//		courseRepository.addHardcodedReviewsForCourse();
//		
//		List<Review> reviews = new ArrayList<>();
//
//		reviews.add(new Review(ReviewRating.FIVE, "Great Hands-on Stuff."));
//		reviews.add(new Review(ReviewRating.FIVE, "Hatsoff."));
//
//		courseRepository.addReviewsForCourse(10003L, reviews );
		
//		studentRepository.insertHardcodedStudentAndCourse();
//		studentRepository.insertStudentAndCourse(new Student("Jack"),
//				new Course("Microservices in 100 Steps"));
		
//		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//		logger.info("Full Time Employees -> {}", 
//				employeeRepository.retrieveAllFullTimeEmployees());
//		
//		logger.info("Part Time Employees -> {}", 
//				employeeRepository.retrieveAllPartTimeEmployees());
		
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		Pageable secondPageWithFiveElements = PageRequest.of(1, 0);
		Page<Employee> employees = employeeRepo.findAll(firstPageWithTwoElements);
		List<Employee> list = employees.getContent();
		
		List<Employee> customFun = 
				employeeRepo.findAllByPrice(10, secondPageWithFiveElements);
		
		Iterable<Employee> allProductsSortedByName = employeeRepo.findAll(Sort.by("name"));
	}

}
