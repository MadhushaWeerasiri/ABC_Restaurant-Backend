package com.abc.backend.config;

import com.abc.backend.Model.reservationProduct;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.bson.Document;

@ReadingConverter
public class StringToReservationProductConverter implements Converter<Document, reservationProduct> {
    @Override
    public reservationProduct convert(Document source) {
        reservationProduct product = new reservationProduct();
        product.setProductId(source.getString("productId"));
        product.setProductQuantity(source.getInteger("productQuantity"));
        return product;
    }
}