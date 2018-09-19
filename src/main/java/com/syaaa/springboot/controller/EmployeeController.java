package com.syaaa.springboot.controller;

import com.syaaa.springboot.dao.EmployeeDao;
import com.syaaa.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author APPO
 * @Date 13:23   2018-9-19
 * @Version 1.0
 **/
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;


    @GetMapping(value = "/emps")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "employee/list" ;
    }
}
