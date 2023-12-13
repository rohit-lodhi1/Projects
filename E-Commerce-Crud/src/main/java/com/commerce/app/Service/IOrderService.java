package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.Order;

public interface IOrderService {
	public Order addOrder(Order Order);
    
    public Order updateOrder(Order Order);
    
    public boolean deleteOrder(Integer id);
    
    public Order getOrder(Integer id);
    
    public List<Order> getOrders();
    
    public Order orderFromCart(Integer id,Order order) ;
    
    public Order orderItemsToOrder(List<Integer> orderItemsId,Integer id) ;
}
