package com.sdyy.excemple.springbootdome.controller;

import com.sdyy.excemple.springbootdome.dao.DepartmentDao;
import com.sdyy.excemple.springbootdome.dao.EmployeeDao;
import com.sdyy.excemple.springbootdome.entities.Department;
import com.sdyy.excemple.springbootdome.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * 处理员工的增删改查
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
   //员工列表页面
    @GetMapping(value = "/emps")
    public String emps(Model model){
       Collection<Employee>emps = employeeDao.getAll();
          model.addAttribute("emps",emps);
        return "/emp/list";
    }

    //添加页面
    @GetMapping(value = "/emp")
    public String toAddEmp(Model model){
        //将部门显示出来
        Collection<Department> departments = departmentDao.getDepartments();
         model.addAttribute("depts",departments);
        return "/emp/add";
    }

    //添加功能
    @PostMapping(value = "/emp")
    public String addEmp(Employee emp){
        System.out.println("员工信息："+emp);
        employeeDao.save(emp);
        //redirect 重定向
         // forward 转发
        return "redirect:/emps";
    }

    //修改页面
    @GetMapping(value = "/emp/{id}")
    public String toEditEmp(@PathVariable("id") Integer id , Model model){
       Employee  emp =  employeeDao.get(id);
        Collection<Department> depts = departmentDao.getDepartments();

        model.addAttribute("emp",emp);
        model.addAttribute("depts",depts);
        return "emp/add";
    }
}
