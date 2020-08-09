package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import tacos.model.Orders;
import tacos.data.OrdersRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    private  OrdersRepository ordersRepository;
    @Autowired
    public OrderController(OrdersRepository ordersRepository){
        this.ordersRepository=ordersRepository;
    };
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("orders", new Orders());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(Orders orders, Model model) {
        ordersRepository.save(orders);
		model.addAttribute(orders);
        log.info("Order submitted: " + orders);
        return "result";
    }
}

