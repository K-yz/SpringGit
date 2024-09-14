package khly.codelean.project2.controller;

import khly.codelean.project2.entity.Customer;
import khly.codelean.project2.entity.Order;
import khly.codelean.project2.service.customer.CustomerService;
import khly.codelean.project2.service.order.OrderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    private CustomerService customerService;

    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listOrder(Model theModel) {
        List<Order> theOrder = orderService.findAll();
        theModel.addAttribute("orders", theOrder);
        return "admin/Order/list-orders";
    }

    /*@GetMapping("/add")
    public String addOrder(Model theModel) {
        Order theOrder = new Order();

        List<Customer> theCustomers = customerService.findAll();

        theModel.addAttribute("customers", theCustomers);

        theModel.addAttribute("orders", theOrder);
        return "Order/add-order-form";
    }*/
    @GetMapping("/add")
    public String addOrder(Model theModel) {
        Order theOrder = new Order();
        List<Customer> theCustomers = customerService.findAll();
        theModel.addAttribute("customers", theCustomers);
        theModel.addAttribute("orders", theOrder);
        return "admin/Order/add-order-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("orderId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Order theOrder = orderService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("orders", theOrder);

        // send over to our form
        return "admin/Order/add-order-form";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("orders") Order theOrder) {

        Customer theCustomer = customerService.findById(theOrder.getCustomer().getId());
        theOrder.setCustomer(theCustomer);
        // save the Feedback
        orderService.save(theOrder);

        // use a redirect to prevent duplicate submissions
        return "redirect:/orders/list";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("orderId") int theId) {

        // delete the Feedback
        orderService.deleteById(theId);

        // redirect to /Feedback/list
        return "redirect:/orders/list";

    }
}
