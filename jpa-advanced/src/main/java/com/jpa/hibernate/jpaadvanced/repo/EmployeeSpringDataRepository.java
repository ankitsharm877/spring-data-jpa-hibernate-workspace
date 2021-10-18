package com.jpa.hibernate.jpaadvanced.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.jpaadvanced.entity.Employee;

@Repository
public interface EmployeeSpringDataRepository extends PagingAndSortingRepository<Employee, Long>{
	
	List<Employee> findAllByPrice(double price, Pageable pageable);
}
