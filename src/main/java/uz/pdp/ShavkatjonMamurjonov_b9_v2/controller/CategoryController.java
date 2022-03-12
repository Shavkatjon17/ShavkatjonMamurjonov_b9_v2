package uz.pdp.ShavkatjonMamurjonov_b9_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.dto.CategoryDTO;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.dto.Response;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.entity.Category;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.repository.CategoryRepository;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.service.CategoryService;

import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("message", "All Category");
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "category-show";
    }

    @GetMapping("/crud")
    public String getHomePage(Model model) {
        model.addAttribute("message", "All Category");
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "book";
    }

    @GetMapping("/add")
    public String productSavePage(Model model) {

        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "book";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute CategoryDTO categoryDTO, Model model) {
        Response add = categoryService.add(categoryDTO);
        model.addAttribute("message", add.getMessage());
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "book";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id));
        return "edit_book";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable Integer id,
                                 @ModelAttribute("category") CategoryDTO category,
                                 Model model) {

        Response edit = categoryService.edit(id, category);
        model.addAttribute("message", "Edited Category!");
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "book";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id, Model model) {
        categoryService.delete(id);
        model.addAttribute("message", "Deleted Category!");
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "book";
    }
}