package com.cql.springbootwebrestfulcurd.controller;


import com.cql.springbootwebrestfulcurd.dao.EmployeeDao;
import com.cql.springbootwebrestfulcurd.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    //查询所有员工列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中供页面获取
        model.addAttribute("emps",employees);

        //thymeleaf 的默认配置"classpath:/templates/"+返回值+"/html"
        return "emp/list";
    }


}
