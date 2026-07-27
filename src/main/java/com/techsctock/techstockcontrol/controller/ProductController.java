package com.techsctock.techstockcontrol.controller;

import com.techsctock.techstockcontrol.entity.Product;
import com.techsctock.techstockcontrol.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {

    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/products")
    public String displayProducts(
            Model model,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "productName") String sortBy
    ) {

        Page<Product> productPage;


        if (!keyword.isEmpty() && !brand.isEmpty()) {

            productPage = productRepository
                    .findByProductNameContainingIgnoreCaseAndBrand_BrandNameIgnoreCase(
                            keyword,
                            brand,
                            PageRequest.of(page, 5, Sort.by(sortBy))
                    );


        } else if (!keyword.isEmpty()) {

            productPage = productRepository
                    .findByProductNameContainingIgnoreCase(
                            keyword,
                            PageRequest.of(page, 5, Sort.by(sortBy))
                    );


        } else if (!brand.isEmpty()) {

            productPage = productRepository
                    .findByBrand_BrandNameIgnoreCase(
                            brand,
                            PageRequest.of(page, 5, Sort.by(sortBy))
                    );


        } else {

            productPage = productRepository.findAll(
                    PageRequest.of(page, 5, Sort.by(sortBy))
            );

        }


        model.addAttribute("products", productPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("brand", brand);


        return "products";
    }
}
    