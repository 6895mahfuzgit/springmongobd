package com.mongodb.start.controllers;

import com.mongodb.start.model.Product;
import com.mongodb.start.reposirories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by user on 03-Jan-17.
 */
@Controller
@RequestMapping("/product")
public class ProductController {


    public static final String ALL_PRODUCT_VIEW = "product";

    @Autowired
    private ProductRepository productRepository;

//
//    @RequestMapping
//    public String productList(Model model) {
//
//
//        List<Product> productList = productRepository.findAll();
//
//        model.addAttribute("productList", productList);
//
//        return ALL_PRODUCT_VIEW;
//    }


    @RequestMapping
    public String product() {

        return "product";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Product product) {

        productRepository.save(product);


        return "redirect:/product/getAllProduct";
    }

    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET)
    public String getAllProduct(Model model) {

        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        return "getAllProduct";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("id") String productId) {

        Product product = productRepository.findOne(productId);
        productRepository.delete(product);

        return "redirect:/product/getAllProduct";
    }

    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam("search") String search) {


        model.addAttribute("productList", productRepository.findByName(search));
        model.addAttribute("search", search);


        return "getAllProduct";
    }


    @RequestMapping(value = "/edit")
    public String editProduct(Model model, @RequestParam("productId") String productId) {

        Product product = productRepository.findOne(productId);


        model.addAttribute("product", product);

        return "editPage";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute Product product) {

        productRepository.save(product);


        return "redirect:/product/getAllProduct";
    }


}
