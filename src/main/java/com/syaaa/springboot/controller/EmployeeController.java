package com.syaaa.springboot.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.syaaa.springboot.dao.DepartmentDao;
import com.syaaa.springboot.dao.EmployeeDao;
import com.syaaa.springboot.entities.Department;
import com.syaaa.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping(value = "/emps")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "employee/list" ;
    }

    @GetMapping(value = "/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "employee/add";
    }

    @PostMapping(value = "/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        /*
        * redirect 重定向到指定的路径
        * forward 转发到指定的路径
        * */
        return "redirect:/emps";
    }

    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable(value = "id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "employee/add";
    }


    @PutMapping(value = "/emp")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping(value = "/emp/{id}")
    public String delEmp(@PathVariable(value = "id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
