package com.example.demo.controllers;

import com.example.demo.repository.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService svc;

    @GetMapping
    public Page<Employee> list(
            @RequestParam(value="search", required=false) String search,
            @PageableDefault(size=10, sort="name") Pageable pageable) {
        return svc.getAll(search, pageable);
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) { /* ... */ }
    @PutMapping("/{id}") public Employee update(@PathVariable Long id, @RequestBody Employee emp) { /* ... */ }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { /* ... */ }
}

