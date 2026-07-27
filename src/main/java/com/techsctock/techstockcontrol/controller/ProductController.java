package com.techsctock.techstockcontrol.controller;

import com.techsctock.techstockcontrol.entity.Product;
import com.techsctock.techstockcontrol.repository.BrandRepository;
import com.techsctock.techstockcontrol.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;


    public ProductController(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
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

    @GetMapping("/add-product")
    public String showAddProductForm(Model model) {

        model.addAttribute("product", new Product());

        return "add-product";
    }


    @PostMapping("/add-product")
public String saveProduct(
        @Valid @ModelAttribute("product") Product product,
        BindingResult result,
        Model model){

    if(result.hasErrors()){
        model.addAttribute("brands", brandRepository.findAll());
        return "add-product";
    }

    productRepository.save(product);

    return "redirect:/products";
}
}