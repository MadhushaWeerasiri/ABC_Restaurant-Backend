package com.abc.backend.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abc.backend.Model.offer;
import com.abc.backend.Model.product;
import com.abc.backend.Model.productCategory;
import com.abc.backend.Repository.offerRepository;
import com.abc.backend.Repository.productCategoryRepository;
import com.abc.backend.Repository.productRepository;

@Service
public class productService {

    @Autowired
    private productCategoryRepository productCategoryRepository;

    public List<productCategory> allProductCategory() {
        return productCategoryRepository.findAll();
    }

    public productCategory addProductCategory(productCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public Optional<productCategory> singleProductCategory(ObjectId id) {
        return productCategoryRepository.findById(id);
    }

    public Optional<productCategory> singleProductCategoryById(int categoryId) {
        return productCategoryRepository.findByCategoryId(categoryId);
    }

    public productCategory updateProductCategory(ObjectId id, productCategory productCategoryDetails) {
        Optional<productCategory> optionalProductCategory = productCategoryRepository.findById(id);
        if (optionalProductCategory.isPresent()) {
            productCategory productCategory = optionalProductCategory.get();
            productCategory.setCategoryName(productCategoryDetails.getCategoryName());
            productCategory.setCategoryDescription(productCategoryDetails.getCategoryDescription());
            productCategory.setCategoryImage(productCategoryDetails.getCategoryImage());
            return productCategoryRepository.save(productCategory);
        }
        return null;
    }

    public void deleteProductCategory(ObjectId id) {
        productCategoryRepository.deleteById(id);
    }

    // ----------------------------------------------------------------------------

    private final String UPLOAD_DIR = "C:/Users/madhusha/Downloads/uploads/"; 

    @Autowired
    private productRepository productRepository;

    public List<product> allProduct() {
        return productRepository.findAll();
    }

    public product addProduct(product product, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            // Get the extension of the file
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

            // Rename the file to productId + extension
            String newFilename = product.getProductId() + "." + extension;
            String filePath = UPLOAD_DIR + newFilename;

            // Save the file to the specified directory
            File destinationFile = new File(filePath);
            file.transferTo(destinationFile);

            // Update the product's image field with only the extension
            product.setProductImage(extension);
        } else {
            // If no file is provided, set the image field to an empty string
            product.setProductImage("");
        }

        // Save the product to the database
        return productRepository.save(product);
    }

    public Optional<product> singleProduct(ObjectId id) {
        return productRepository.findById(id);
    }

    public product updateProduct(ObjectId id, product productDetails) {
        Optional<product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            product product = optionalProduct.get();
            product.setProductName(productDetails.getProductName());
            product.setProductDescription(productDetails.getProductDescription());
            product.setProductImage(productDetails.getProductImage());
            product.setProductPrice(productDetails.getProductPrice());
            product.setProductCategory(productDetails.getProductCategory());
            product.setProductStatus(productDetails.getProductStatus());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(ObjectId id) {
        productRepository.deleteById(id);
    }

    // ----------------------------------------------------------------------------

    @Autowired
    private offerRepository offerRepository;

    public List<offer> allOffer() {
        return offerRepository.findAll();
    }

    public offer addOffer(offer offer) {
        return offerRepository.save(offer);
    }

    public Optional<offer> singleOffer(ObjectId id) {
        return offerRepository.findById(id);
    }

    public offer updateOffer(ObjectId id, offer offerDetails) {
        Optional<offer> optionalOffer = offerRepository.findById(id);
        if (optionalOffer.isPresent()) {
            offer offer = optionalOffer.get();
            offer.setOfferId(offerDetails.getOfferId());
            offer.setOfferName(offerDetails.getOfferName());
            offer.setOfferDescription(offerDetails.getOfferDescription());
            offer.setOfferImage(offerDetails.getOfferImage());
            offer.setOfferPrice(offerDetails.getOfferPrice());
            offer.setOfferDiscount(offerDetails.getOfferDiscount());
            offer.setOfferStatus(offerDetails.getOfferStatus());
            offer.setOfferStartDate(offerDetails.getOfferStartDate());
            offer.setOfferEndDate(offerDetails.getOfferEndDate());
            offer.setOfferCategory(offerDetails.getOfferCategory());
            return offerRepository.save(offer);
        }
        return null;
    }

    public void deleteOffer(ObjectId id) {
        offerRepository.deleteById(id);
    }

}
