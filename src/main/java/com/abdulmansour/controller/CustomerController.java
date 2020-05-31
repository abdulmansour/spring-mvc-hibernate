package com.abdulmansour.controller;

import com.abdulmansour.entity.Customer;
import com.abdulmansour.entity.Search;
import com.abdulmansour.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        //get customers from the DAO
        List<Customer> customers = customerService.getCustomers();

        //add the customers to the model
        model.addAttribute("customers", customers);

        //add empty search filet
        Search search = new Search("");

        model.addAttribute("search", search);

        return "list-customers";
    }

    @GetMapping("/saveCustomerForm")
    public String saveCustomerForm(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "save-customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        //save customer using serviceCustomer
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/updateCustomerForm")
    public String updateCustomerForm(@RequestParam("customerId") int customerId, Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "update-customer-form";
    }

    @RequestMapping("/deleteCustomerForm")
    public String deleteCustomerForm(@RequestParam("customerId") int customerId, Model model) {
        Customer customer = customerService.getCustomer(customerId);
        customerService.deleteCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/searchCustomer")
    public String searchCustomer(@ModelAttribute("search") Search search, Model model) {
        //get customers from the DAO
        List<Customer> customers = customerService.searchCustomers(search.getSearchValue());

        for (Customer customer:customers) {
            System.out.println(customer);
        }

        //add the customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
