package com.klu.jfsd.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klu.jfsd.model.Cart;
import com.klu.jfsd.model.OrderAddress;
import com.klu.jfsd.model.OrderRequest;
import com.klu.jfsd.model.ProductOrder;
import com.klu.jfsd.repository.CartRepository;
import com.klu.jfsd.repository.ProductOrderRepository;
import com.klu.jfsd.service.OrderService;
import com.klu.jfsd.util.CommonUtil;
import com.klu.jfsd.util.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductOrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception {

        List<Cart> carts = cartRepository.findByUserId(userid);  // Make sure this method exists in CartRepository

        for (Cart cart : carts) {

            ProductOrder order = new ProductOrder();

            // Generate unique order ID
            order.setOrderId(UUID.randomUUID().toString());
            order.setOrderDate(LocalDate.now());

            // Set product, price, quantity, user
            order.setProduct(cart.getProduct());
            order.setPrice(cart.getProduct().getDiscountPrice());
            order.setQuantity(cart.getQuantity());
            order.setUser(cart.getUser());

            // Set default order status
            order.setStatus(OrderStatus.IN_PROGRESS.getName());
            order.setPaymentType(orderRequest.getPaymentType());

            // Set order address from OrderRequest
            OrderAddress address = new OrderAddress();
            address.setFirstName(orderRequest.getFirstName());
            address.setLastName(orderRequest.getLastName());
            address.setEmail(orderRequest.getEmail());
            address.setMobileNo(orderRequest.getMobileNo());
            address.setAddress(orderRequest.getAddress());
            address.setCity(orderRequest.getCity());
            address.setState(orderRequest.getState());
            address.setPincode(orderRequest.getPincode());

            order.setOrderAddress(address);  // Link the address to the order

            // Save the order
            ProductOrder saveOrder = orderRepository.save(order);
            
            // Send email after order is saved
            commonUtil.sendMailForProductOrder(saveOrder, "success");
        }
    }

    @Override
    public List<ProductOrder> getOrdersByUser(Integer userId) {
        // Retrieve all orders for the user
        return orderRepository.findByUserId(userId);  // Make sure this method exists in ProductOrderRepository
    }

    @Override
    public ProductOrder updateOrderStatus(Integer id, String status) {
        Optional<ProductOrder> findById = orderRepository.findById(id);
        
        if (findById.isPresent()) {
            ProductOrder productOrder = findById.get();
            productOrder.setStatus(status);
            return orderRepository.save(productOrder);  // Save the updated order status
        }
        return null;  // Return null if order is not found
    }

    @Override
    public List<ProductOrder> getAllOrders() {
        // Retrieve all orders
        return orderRepository.findAll();
    }

    @Override
    public Page<ProductOrder> getAllOrdersPagination(Integer pageNo, Integer pageSize) {
        // Pagination for orders
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return orderRepository.findAll(pageable);
    }

    @Override
    public ProductOrder getOrdersByOrderId(String orderId) {
        // Retrieve an order by its unique order ID
        return orderRepository.findByOrderId(orderId);
    }
}
