package com.trung.controller;

import com.trung.convert.EmployeeConverter;
import com.trung.entity.EmployeeEntity;
import com.trung.request.EmployeeRequest;
import com.trung.service.EmployeeService;
import com.trung.validation.EmployeeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String displayEmployee(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeRequest", new EmployeeRequest());
        return "create";
    }

    @PostMapping("/create")
    public String checkValidation(@Valid @ModelAttribute EmployeeRequest employeeRequest,
                                  BindingResult bindingResult,
                                  Model model) {
        new EmployeeValidation().validate(employeeRequest, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeRequest", employeeRequest);
            return "create";
        } else {
            model.addAttribute("message", "New employee was create");
            model.addAttribute("employeeRequest", new EmployeeRequest());
            employeeService.save(EmployeeConverter.convertRequestToEntity(employeeRequest));
            return "create";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model,
                               @PathVariable Long id) {
        EmployeeEntity employeeEntity = employeeService.findById(id);
        EmployeeRequest employeeRequest = EmployeeConverter.convertEntityToRequest(employeeEntity);
        model.addAttribute("employee", employeeRequest);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateEmployee(@Valid @ModelAttribute EmployeeRequest employeeRequest,
                                 Model model,
                                 BindingResult bindingResult) {
        new EmployeeValidation().validate(employeeRequest, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employeeRequest);
            return "edit";
        } else {
            employeeService.remove(employeeRequest.getId());
            employeeService.save(EmployeeConverter.convertRequestToEntity(employeeRequest));
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String showEmployeeDelete(@PathVariable Long id,
                                     Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute EmployeeEntity employeeEntity) {
        employeeService.remove(employeeEntity.getId());
        return "redirect:/";
    }

    @PostMapping("/find")
    public String find(@RequestParam String key, Model model) {
        EmployeeEntity employeeEntity = employeeService.findByName(key);
        if (employeeEntity != null) {
            model.addAttribute("employee", employeeEntity);
            return "result";
        }
        employeeEntity = employeeService.findByEmployeeCode(key);
        if (employeeEntity != null) {
            model.addAttribute("employee", employeeEntity);
            return "result";
        }
        return "redirect:/";
    }
}
