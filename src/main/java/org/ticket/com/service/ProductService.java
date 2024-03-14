package org.ticket.com.service;

import org.ticket.com.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity create(ProductEntity productEntity);

    List<ProductEntity> list(String category, double price);


}
