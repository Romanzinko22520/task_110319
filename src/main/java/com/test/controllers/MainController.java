package com.test.controllers;

import com.test.beans.EmployeeBean;
import com.test.beans.PageBean;
import com.test.entity.Department;
import com.test.entity.Employee;
import com.test.persistence.service.DepartmentService;
import com.test.persistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;


    @GetMapping({"","/","/index"})
    public  ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("departments", departmentService.getAll());
        return mv;
    }

    @ResponseBody
    @GetMapping("/employees")
    public PageBean getEmployees(HttpServletRequest request){
        List<EmployeeBean> employeeBeans;
        long count;
        int length = Integer.parseInt(request.getParameter("length"));
        if(!request.getParameter("search[value]").isEmpty()){
            employeeBeans = employeeService.findByNameStartingWith(request.getParameter("search[value]"),new PageRequest(Integer.parseInt(request.getParameter("start"))/length, length))
                .stream().map(EmployeeBean::new).collect(Collectors.toList());
            count=employeeService.countByNameStartingWith(request.getParameter("search[value]"));
        }else {
            count=employeeService.count();
         employeeBeans = employeeService.getAll(new PageRequest(Integer.parseInt(request.getParameter("start"))/length, length))
                .stream().map(EmployeeBean::new).collect(Collectors.toList());}
        return  new PageBean().setData(employeeBeans)
                .setDraw(request.getParameter("draw")).setRecordsFiltered(count).setRecordsTotal(count);
    }

    @DeleteMapping("/employee")
    public Boolean deleteEmployee(@RequestParam(value = "id")long id){
        return employeeService.deleteById(id);
    }

    @ResponseBody
    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute("employee")EmployeeBean bean){
        Employee employee = new Employee();
        employee.setActive(bean.isActive()).setName(bean.getName()).setDepartment(departmentService.findById(Long.parseLong(bean.getDepartment())));
        employeeService.save(employee);
        return "ok";
    }



    @ResponseBody
    @PostMapping("/employee")
    public String updateEmployee(@ModelAttribute("employee")EmployeeBean bean){
        Employee employee = employeeService.findById(bean.getId());
        employee.setActive(bean.isActive()).setName(bean.getName()).setDepartment(departmentService.findById(Long.parseLong(bean.getDepartment())));
        employeeService.save(employee);
        return "ok";
    }


    @GetMapping("/employee/{id}")
    public String viewEmployee (@PathVariable(value = "id") Long id){
        return employeeService.findById(id).toString();
    }

    @ResponseBody
    @PostMapping("/department")
    public Department addDepartment(@RequestParam(value = "name") String name){
       return departmentService.save(new Department().setName(name));
    }

}
