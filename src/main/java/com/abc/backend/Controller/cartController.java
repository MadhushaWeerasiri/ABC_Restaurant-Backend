package com.abc.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.backend.Model.cart;
import com.abc.backend.Service.cartService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/cart")
public class cartController {

    private final cartService cartService;

    @Autowired
    public cartController(cartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/allCart")
    public ResponseEntity<List<cart>> getAllCart() {
        return new ResponseEntity<>(cartService.allCart(), HttpStatus.OK);
    }

    @PostMapping("/addCart")
    public ResponseEntity<cart> addCart(@RequestBody cart cart) {
        cart newCart = cartService.addCart(cart);
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }

    @GetMapping("/byCustomer/{customerId}")
    public ResponseEntity<List<cart>> singleCart(@PathVariable String customerId) {
        List<cart> cart = cartService.singleCart(customerId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<cart> updateCart(@PathVariable ObjectId id, @RequestBody cart cartDetails) {
        cart updatedCart = cartService.updateCart(id, cartDetails);
        if (updatedCart != null) {
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable ObjectId id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addOrUpdateCart")
    public ResponseEntity<cart> addOrUpdateCart(@RequestParam String customerId, @RequestParam String productId) {
        cart updatedCart = cartService.addOrUpdateCart(customerId, productId);
        return ResponseEntity.ok(updatedCart);
    }
}
