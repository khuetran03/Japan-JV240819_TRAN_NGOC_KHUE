package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.com.models.Category;
import ra.com.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        return "categories/list";
    }

    @GetMapping
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categories/create";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryService.create(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/edit";
    }

    @PostMapping("/edit")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }

}
