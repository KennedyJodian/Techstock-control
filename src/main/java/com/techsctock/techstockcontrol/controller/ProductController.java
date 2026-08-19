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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductController(
            ProductRepository productRepository,
            BrandRepository brandRepository) {

        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    // =========================
    // PRODUCT LIST
    // =========================

    @GetMapping("/products")
    public String displayProducts(
            Model model,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "productName") String sortBy) {

        Page<Product> productPage;

        PageRequest pageRequest =
                PageRequest.of(page, 5, Sort.by(sortBy));

        if (!keyword.isEmpty() && !brand.isEmpty()) {

            productPage = productRepository
                    .findByProductNameContainingIgnoreCaseAndBrand_BrandNameIgnoreCase(
                            keyword,
                            brand,
                            pageRequest);

        } else if (!keyword.isEmpty()) {

            productPage = productRepository
                    .findByProductNameContainingIgnoreCase(
                            keyword,
                            pageRequest);

        } else if (!brand.isEmpty()) {

            productPage = productRepository
                    .findByBrand_BrandNameIgnoreCase(
                            brand,
                            pageRequest);

        } else {

            productPage = productRepository.findAll(pageRequest);
        }

        model.addAttribute("products", productPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("brand", brand);

        // Needed for the brand filter
        model.addAttribute("brands", brandRepository.findAll());

        return "products";
    }


    // =========================
    // PRODUCT DETAILS
    // =========================

    @GetMapping("/products/{id}")
    public String productDetails(
            @PathVariable Long id,
            Model model) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Product not found: " + id));

        model.addAttribute("product", product);

        return "product-details";
    }


    // =========================
    // ADD PRODUCT FORM
    // =========================

    @GetMapping("/add-product")
    public String showAddProductForm(Model model) {

        model.addAttribute("product", new Product());

        // IMPORTANT:
        // This loads Dell, Samsung, HP, Apple, etc.
        model.addAttribute("brands", brandRepository.findAll());

        return "add-product";
    }


    // =========================
    // SAVE PRODUCT
    // =========================

    @PostMapping("/add-product")
    public String saveProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "brands",
                    brandRepository.findAll());

            return "add-product";
        }

        productRepository.save(product);

        return "redirect:/products/" + product.getProductId();
    }
}