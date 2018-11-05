package com.codegym.controllers;

import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @RequestMapping("/")
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
}
