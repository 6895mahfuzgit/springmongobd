package com.mongodb.start.reposirories;

import com.mongodb.start.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by user on 03-Jan-17.
 */
//@Repository
public class ProductSearchRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Collection searchByName(String s) {

        return mongoTemplate.find(Query.query(new Criteria().orOperator(Criteria.where("name").regex(s, "i"), Criteria.where("productId").regex(s, "i"))), Product.class);


    }


}
