package com.tnsif.sm.OrderItem;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;
	import java.util.Optional;

	@RestController
	@RequestMapping("/api/orderitems")
	public class OrderItemController {

	    @Autowired
	    private OrderItemService orderItemService;

	    @GetMapping
	    public List<OrderItem> getAllOrderItems() {
	        return orderItemService.getAllOrderItems();
	    }

	    @GetMapping("/{id}")
	    public Optional<OrderItem> getOrderItemById(@PathVariable int id) {
	        return orderItemService.getOrderItemById(id);
	    }

	    @PostMapping
	    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
	        return orderItemService.saveOrderItem(orderItem);
	    }

	    @PutMapping("/{id}")
	    public OrderItem updateOrderItem(@PathVariable int id, @RequestBody OrderItem orderItem) {
	        if (orderItemService.getOrderItemById(id).isPresent()) {
	            orderItem.setOrderItemId(id);
	            return orderItemService.saveOrderItem(orderItem);
	        } else {
	            throw new RuntimeException("OrderItem not found");
	        }
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOrderItem(@PathVariable int id) {
	        orderItemService.deleteOrderItem(id);
	    }
}