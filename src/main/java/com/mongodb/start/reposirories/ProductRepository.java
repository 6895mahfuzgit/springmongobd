package com.mongodb.start.reposirories;

import com.mongodb.start.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 03-Jan-17.
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String s);

}
