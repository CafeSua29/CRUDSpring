package com.example.demo.services;

import com.example.demo.repository.entity.Employee;
import com.example.demo.repository.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public Page<Employee> getAll(String kw, Pageable pageable) {
        if (kw == null || kw.isEmpty()) {
            return repo.findAll(pageable);
        }
        return repo.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCase(
                kw, kw, kw, pageable);
    }
}

