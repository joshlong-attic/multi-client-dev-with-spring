package org.springsource.examples.sawt.web.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springsource.examples.sawt.CustomerService;
import org.springsource.examples.sawt.services.model.Customer;

import javax.inject.Inject;

@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @ModelAttribute
    public Customer customer(@RequestParam(value = "id", required = false) Long id) {
        if (null != id) {
            return customerService.getCustomerById(id);
        }
        return new Customer();
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String customer(@RequestParam("id") Long id, Model model) {
        Customer customerById = customerService.getCustomerById(id);
        model.addAttribute("customer", customerById);
        return "display";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddition(@ModelAttribute Customer c, Model model) {
        Customer customer = this.customerService.createCustomer(c.getFirstName(), c.getLastName());
        model.addAttribute("id", customer.getId());
        return "redirect:/display";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String setupForAddition() {
        return "add";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/display";
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String setupForUpdate() {
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Customer customer, Model model) {
        customerService.updateCustomer(customer.getId(), customer.getFirstName(), customer.getLastName());
        model.addAttribute("id", customer.getId());
        return "redirect:/display";
    }
}


