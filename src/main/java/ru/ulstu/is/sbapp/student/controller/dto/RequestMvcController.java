package ru.ulstu.is.sbapp.student.controller.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ulstu.is.sbapp.student.repository.CustomerRepository;
import ru.ulstu.is.sbapp.student.repository.OrderrRepository;
import ru.ulstu.is.sbapp.student.service.ConsignmentService;
import ru.ulstu.is.sbapp.student.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/request")

public class RequestMvcController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final OrderrRepository orderrRepository;
    private final ConsignmentService consignmentService;

    public RequestMvcController(CustomerService customerService, OrderrRepository orderrService, ConsignmentService consignmentService, CustomerRepository customerRepository){
        this.customerService = customerService;
        this.orderrRepository = orderrService;
        this.consignmentService = consignmentService;
        this.customerRepository = customerRepository;
    }

    /*@GetMapping
    public String getConsignments(Model model) {
        model.addAttribute("consignments",
                consignmentService.findAllConsignments().stream()
                        .map(ConsignmentDto::new)
                        .toList());
        return "request";
    }*/

   /* public String request(@PathVariable(required = false) Long id, Model model) {
        model.addAttribute("customers", customerRepository.findAll().stream()
                .map(CustomerDto::new)
                .toList());
        return "customer";
    }*/

    @GetMapping
    public String getConsignmentForCustomer(@RequestParam(value = "getId", required = false) Long getId, Model model) { //, defaultValue = "3"
        model.addAttribute("customers", customerService.findAllCustomers().stream().map(CustomerDto::new).toList());
        model.addAttribute("NewConsignmentDto", consignmentService.getConsignmentForCustomer(getId));
        return "request";
        //return consignmentService.getConsignmentForCustomer(getId);
    }
}