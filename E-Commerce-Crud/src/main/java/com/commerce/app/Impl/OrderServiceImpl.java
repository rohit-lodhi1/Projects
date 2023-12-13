package com.commerce.app.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IOrderRepository;
import com.commerce.app.Repository.IUserRepositoty;
import com.commerce.app.Service.ICartService;
import com.commerce.app.Service.IOrderItemService;
import com.commerce.app.Service.IOrderService;
import com.commerce.app.entities.Cart;
import com.commerce.app.entities.CartItem;
import com.commerce.app.entities.Order;
import com.commerce.app.entities.OrderItem;
import com.commerce.app.exception.OrderNotFoundException;

@Service
public class OrderServiceImpl implements IOrderService{


	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IOrderItemService orderItemService;
	
	
	@Autowired
	private ICartService cartService;
	
	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return this.orderRepo.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		if(this.orderRepo.existsById(order.getOId())) {
			return this.orderRepo.save(order);
		}else
		throw new OrderNotFoundException("Order not found with Id : "+order.getOId());
		
	}

	@Override
	public boolean deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		if(this.orderRepo.existsById(id)) {
			this.orderRepo.deleteById(id);
			return true;
		}
		throw new OrderNotFoundException("Order not found with Id : "+id);
		
	}

	@Override
	public Order getOrder(Integer id) {
		// TODO Auto-generated method stub
		Optional<Order> findById = this.orderRepo.findById(id);
		 if(findById.isPresent()) 
			  return findById.get();
			 
		 throw new OrderNotFoundException("Order not found with Id : "+id);
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return this.orderRepo.findAll();
	}

	public Order orderFromCart(Integer id,Order order) {
		Cart cart = this.cartService.getCart(id);
		List<CartItem> cartItems = cart.getCartItems();
		List<OrderItem> orderItems = new ArrayList();
        cartItems.forEach(c->{
             OrderItem ot = new OrderItem();
             ot.setPrice(c.getProduct().getPrice());
             ot.setProduct(c.getProduct());
             ot.setGroupVarient(c.getGroupVarient());
             orderItems.add(ot);
        });
        order.setOrderItems(orderItems);
        return this.orderRepo.save(order);
	}
	
	public Order orderItemsToOrder(List<Integer> orderItemsId,Integer id) {
		Order order = this.orderRepo.findById(id).orElseThrow(()->new OrderNotFoundException("Order Not found with id : "+id));
		orderItemsId.forEach((orderItems)->{
		   order.getOrderItems().add(this.orderItemService.getOrderItem(orderItems));
		});
       return	this.orderRepo.save(order);
		
	}
	
}
