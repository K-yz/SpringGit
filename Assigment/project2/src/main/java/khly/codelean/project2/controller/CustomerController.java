package khly.codelean.project2.controller;

import khly.codelean.project2.entity.Customer;
import khly.codelean.project2.service.customer.CustomerService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomer(Model theModel) {
        List<Customer> theCustomer = customerService.findAll();
        theModel.addAttribute("customers", theCustomer);
        return "admin/Customer/list-customers";
    }

    @GetMapping("/add")
    public String addCustomer(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customers", theCustomer);
        return "admin/Customer/add-customer-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Customer theCustomer = customerService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("customers", theCustomer);

        // send over to our form
        return "admin/Customer/add-customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customers") Customer theCustomer) {

        // save the Feedback
        customerService.save(theCustomer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/customers/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {

        // delete the Feedback
        customerService.deleteById(theId);

        // redirect to /Feedback/list
        return "redirect:/customers/list";

    }
}
