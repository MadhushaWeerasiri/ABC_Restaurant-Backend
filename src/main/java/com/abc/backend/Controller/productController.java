package com.abc.backend.Controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abc.backend.Model.offer;
import com.abc.backend.Model.product;
import com.abc.backend.Model.productCategory;
import com.abc.backend.Service.productService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping("/productCategory/allProducCategories")
    public ResponseEntity<List<productCategory>> getAllProductCategories() {
        return new ResponseEntity<>(productService.allProductCategory(), HttpStatus.OK);
    }

    @PostMapping("/productCategory/addProductCategory")
    public ResponseEntity<productCategory> addProductCategory(@RequestBody productCategory productCategory) {
        productCategory newProductCategory = productService.addProductCategory(productCategory);
        return new ResponseEntity<>(newProductCategory, HttpStatus.CREATED);
    }

    @GetMapping("/productCategory/{id}")
    public ResponseEntity<Optional<productCategory>> singleProductCategory(@PathVariable ObjectId id) {
        Optional<productCategory> productCategory = productService.singleProductCategory(id);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

    @GetMapping("/productCategory/byId/{id}")
    public ResponseEntity<Optional<productCategory>> singleProductCategoryById(@PathVariable int categoryId) {
        Optional<productCategory> productCategory = productService.singleProductCategoryById(categoryId);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

    @PutMapping("/productCategory/{id}")
    public ResponseEntity<productCategory> updateProductCategory(@PathVariable ObjectId id,
            @RequestBody productCategory productCategoryDetails) {
        productCategory updatedProductCategory = productService.updateProductCategory(id, productCategoryDetails);
        if (updatedProductCategory != null) {
            return new ResponseEntity<>(updatedProductCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productCategory/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable ObjectId id) {
        productService.deleteProductCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ------------------------------------------------------------------------------------------------------------

    @GetMapping("/product/allProducts")
    public ResponseEntity<List<product>> getAllProducts() {
        return new ResponseEntity<>(productService.allProduct(), HttpStatus.OK);
    }

    @PostMapping("/product/addProduct")
    public ResponseEntity<product> addProduct(
            @RequestPart("product") product product,
            @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
            product newProduct = productService.addProduct(product, file);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<product>> singleProduct(@PathVariable ObjectId id) {
        Optional<product> product = productService.singleProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<product> updateProduct(@PathVariable ObjectId id, @RequestBody product productDetails) {
        product updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable ObjectId id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ------------------------------------------------------------------------------------------------------------

    @GetMapping("/offer/allOffers")
    public ResponseEntity<List<offer>> getAlloffers() {
        return new ResponseEntity<>(productService.allOffer(), HttpStatus.OK);
    }

    @PostMapping("/offer/addOffer")
    public ResponseEntity<offer> addOffer(@RequestBody offer offer) {
        offer newOffer = productService.addOffer(offer);
        return new ResponseEntity<>(newOffer, HttpStatus.CREATED);
    }

    @GetMapping("/offer/{id}")
    public ResponseEntity<Optional<offer>> singleOffer(@PathVariable ObjectId id) {
        Optional<offer> offer = productService.singleOffer(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PutMapping("/offer/{id}")
    public ResponseEntity<offer> updateOffer(@PathVariable ObjectId id, @RequestBody offer offerDetails) {
        offer updatedOffer = productService.updateOffer(id, offerDetails);
        if (updatedOffer != null) {
            return new ResponseEntity<>(updatedOffer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/offer/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable ObjectId id) {
        productService.deleteOffer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
