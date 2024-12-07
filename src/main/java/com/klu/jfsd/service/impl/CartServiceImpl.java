package com.klu.jfsd.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.klu.jfsd.model.Cart;
import com.klu.jfsd.model.Product;
import com.klu.jfsd.model.UserDtls;
import com.klu.jfsd.repository.CartRepository;
import com.klu.jfsd.repository.ProductRepository;
import com.klu.jfsd.repository.UserRepository;
import com.klu.jfsd.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart saveCart(Integer productId, Integer userId) {

        UserDtls userDtls = userRepository.findById(userId).get();
        Product product = productRepository.findById(productId).get();

        Cart cartStatus = cartRepository.findByProductIdAndUserId(productId, userId);

        Cart cart = null;

        if (ObjectUtils.isEmpty(cartStatus)) {
            cart = new Cart();
            cart.setProduct(product);
            cart.setUser(userDtls);
            cart.setQuantity(1);
            cart.setTotalPrice((double) (1 * product.getDiscountPrice())); 
        } else {
            cart = cartStatus;
            cart.setQuantity(cart.getQuantity() + 1);
            cart.setTotalPrice((double) (cart.getQuantity() * cart.getProduct().getDiscountPrice())); 
            }
        Cart saveCart = cartRepository.save(cart);

        return saveCart;
    }

    @Override
    public List<Cart> getCartsByUser(Integer userId) {
        List<Cart> carts = cartRepository.findByUserId(userId);

        double totalOrderPrice = 0.0;  // Use double for total order price
        List<Cart> updateCarts = new ArrayList<>();
        for (Cart c : carts) {
            double totalPrice = c.getProduct().getDiscountPrice() * c.getQuantity();  // Use double for price calculation
            c.setTotalPrice(totalPrice);
            totalOrderPrice += totalPrice;  // Accumulate total order price
            updateCarts.add(c);
        }

        // Optionally set the total order price to all carts (not overwriting individual totalPrice)
        for (Cart c : updateCarts) {
            c.setTotalOrderPrice(totalOrderPrice);  // Set total order price for all carts
        }

        return updateCarts;
    }

    @Override
    public Integer getCountCart(Integer userId) {
        Integer countByUserId = cartRepository.countByUserId(userId);
        return countByUserId;
    }

    @Override
    public void updateQuantity(String sy, Integer cid) {

        Cart cart = cartRepository.findById(cid).get();
        int updateQuantity;

        if (sy.equalsIgnoreCase("de")) {
            updateQuantity = cart.getQuantity() - 1;

            if (updateQuantity <= 0) {
                cartRepository.delete(cart);
            } else {
                cart.setQuantity(updateQuantity);
                cartRepository.save(cart);
            }

        } else {
            updateQuantity = cart.getQuantity() + 1;
            cart.setQuantity(updateQuantity);
            cartRepository.save(cart);
        }

    }

}
