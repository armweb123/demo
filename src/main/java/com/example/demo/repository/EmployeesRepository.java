package com.example.demo.repository;

import com.example.demo.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}