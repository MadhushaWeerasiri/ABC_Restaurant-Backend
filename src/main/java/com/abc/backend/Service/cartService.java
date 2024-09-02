package com.abc.backend.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.Model.cart;
import com.abc.backend.Repository.cartRepositiry;

@Service
public class cartService {

    @Autowired
    private cartRepositiry cartRepositiry;

    public cartService(cartRepositiry cartRepositiry) {
        this.cartRepositiry = cartRepositiry;
    }

    public List<cart> allCart() {
        return cartRepositiry.findAll();
    }

    public cart addCart(cart cart) {
        return cartRepositiry.save(cart);
    }

    public List<cart> singleCart(String customerId) {
        return cartRepositiry.findByCustomerId(customerId);
    }

    public cart addOrUpdateCart(String customerId, String productId) {
        Optional<cart> existingCart = cartRepositiry.findByCustomerIdAndProductId(customerId, productId);

        if (existingCart.isPresent()) {
            cart cart = existingCart.get();
            cart.setProductQuantity(cart.getProductQuantity() + 1);
            return cartRepositiry.save(cart);
        } else {
            cart newCart = new cart();
            newCart.setCustomerId(customerId);
            newCart.setProductId(productId);
            newCart.setProductQuantity(1);
            return cartRepositiry.save(newCart);
        }
    }

    public cart updateCart(ObjectId id, cart cartDetails) {
        Optional<cart> optionalCart = cartRepositiry.findById(id);
        if (optionalCart.isPresent()) {
            cart cart = optionalCart.get();
            cart.setCustomerId(cartDetails.getCustomerId());
            cart.setProductId(cartDetails.getProductId());
            cart.setProductQuantity(cartDetails.getProductQuantity());
            return cartRepositiry.save(cart);
        }
        return null;
    }

    public void deleteCart(ObjectId id) {
        cartRepositiry.deleteById(id);
    }
}
