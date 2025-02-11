package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.com.models.Category;
import ra.com.models.Product;
import ra.com.service.CategoryService;
import ra.com.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "products/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, @RequestAttribute("avatar") MultipartFile avatar) {
        if(!avatar.isEmpty()) {
            product.setProd_image(avatar.getOriginalFilename());
        }
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("product", productService.findById(id));
        return "products/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Product product, @RequestAttribute("avatar") MultipartFile avatar) {
        if(!avatar.isEmpty()) {
            product.setProd_image(avatar.getOriginalFilename());
        }
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
