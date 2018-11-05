package com.codegym.controllers;

import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @RequestMapping("/index")
    public ModelAndView index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView create(Model model) {
        ModelAndView modelAndView = new ModelAndView("create");
        model.addAttribute("customer", new Customer());
        return modelAndView;
    }

    @RequestMapping("/customer/save")
    public String save(Model model, Customer customer) {
        customer.setId((int)(Math.random()*10000));
        customerService.save(customer);
        model.addAttribute("success","Saved customer successfully!" );
        return "redirect:/index";
    }
}
