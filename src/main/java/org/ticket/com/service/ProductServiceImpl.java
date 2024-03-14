package org.ticket.com.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.ticket.com.entity.ProductEntity;
import org.ticket.com.repository.ProductJpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository repository;
    @Override
    public ProductEntity create(ProductEntity productEntity) {
        //check something
        return repository.save(productEntity);
    }

    @Override
    public List<ProductEntity> list(String category, double price) {
        return null;
    }
}
