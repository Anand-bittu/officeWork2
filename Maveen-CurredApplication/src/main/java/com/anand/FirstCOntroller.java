package com.anand;


import com.anand.dto.EmployeeDto;
import com.anand.service.EmployeeServiceBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/curd_Application")
public class FirstCOntroller {

    @Autowired
    private EmployeeServiceBo employeeServiceBo;


    @RequestMapping("/first")
    public ModelAndView getPage() {
        System.out.println("inside Hello Method");
        ModelAndView m = new ModelAndView();
        m.setViewName("welcome");
        return m;
    }

    @RequestMapping(value = "/add_employee", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getTablePage(@RequestParam(value = "sname", required = false) String sname,
                                     @RequestParam(value = "salary", required = false) Double salary) {
        System.out.println("inside Get table page method ");

        //create EmployeeDTO CLass First here ok na
       /* EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setName(sname);employeeDto.setSalary(salary);
        //now save this to the databases
        employeeServiceBo.saveEmployeeBo(employeeDto);*/
        ModelAndView modelandView = new ModelAndView();
        modelandView.setViewName("add_employee");

        // Process form submission only if the form data is present (POST request)
        if (sname != null && salary != null) {
            System.out.println("inside Get table page method");
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setName(sname);
            employeeDto.setSalary(salary);
            // Now save this to the database
            employeeServiceBo.saveEmployeeBo(employeeDto);
            // Add a success message and the employee details to the model
            modelandView.addObject("successMessage", "Employee added successfully!");
            modelandView.addObject("addedEmployee", employeeDto);
        }
        return modelandView;
    }


}
