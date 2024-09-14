package khly.codelean.project2.controller;

import khly.codelean.project2.entity.Order;
import khly.codelean.project2.entity.OrderDetail;
import khly.codelean.project2.service.order.OrderService;
import khly.codelean.project2.service.orderdetail.OrderDetailService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/orderdetails")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;
    private final OrderService orderService;

    public OrderDetailController(OrderDetailService orderDetailService, OrderService orderService) {
        this.orderDetailService = orderDetailService;
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String listOrderDetail(Model theModel) {
        List<OrderDetail> theOrderDetail = orderDetailService.findAll();
        theModel.addAttribute("orderdetails", theOrderDetail);
        return "/admin/OrderDetail/list-orderdetails";
    }

    @GetMapping("/add")
    public String addOrderDetail(Model theModel) {
        OrderDetail theOrderDetail = new OrderDetail();
        List<Order> theOrder = orderService.findAll();
        theModel.addAttribute("orders", theOrder);
        theModel.addAttribute("orderdetails", theOrderDetail);
        return "/admin/OrderDetail/add-orderdetail-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("orderdetailId") int theId,
                                    Model theModel) {

        // get the employee from the service
        OrderDetail theOrderDetail = orderDetailService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("orderdetails", theOrderDetail);

        // send over to our form
        return "/admin/OrderDetail/add-orderdetail-form";
    }

    @PostMapping("/save")
    public String saveOrderDetail(@ModelAttribute("orderdetails") OrderDetail theOrderDetail) {

        Order theOrder = orderService.findById(theOrderDetail.getOrder().getId());
        theOrderDetail.setOrder(theOrder);

        // save the Feedback
        orderDetailService.save(theOrderDetail);

        // use a redirect to prevent duplicate submissions
        return "redirect:/orderdetails/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("orderdetailId") int theId) {

        // delete the Feedback
        orderDetailService.deleteById(theId);

        // redirect to /Feedback/list
        return "redirect:/orderdetails/list";

    }
}
