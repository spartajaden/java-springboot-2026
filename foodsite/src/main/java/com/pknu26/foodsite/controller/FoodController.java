package com.pknu26.foodsite.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pknu26.foodsite.dto.Food;
import com.pknu26.foodsite.dto.PageResponse;
import com.pknu26.foodsite.mapper.FoodMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final FoodMapper foodMapper;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "") String category,
                       @RequestParam(defaultValue = "1") int page) {

        int size = 10;
        int offset = (page - 1) * size;

        List<Food> foodList = foodMapper.selectAllFoods(offset, size, keyword, category);
        long totalCount = foodMapper.countFoods(keyword, category);

        PageResponse<Food> pageResponse = new PageResponse<>(foodList, totalCount, page, size);

        model.addAttribute("pageResponse", pageResponse);
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category);

        return "food/list";
    }

    // 나머지는 동일
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("food", new Food());  
        return "food/addForm";
    }

    @PostMapping("/add")
    public String add(Food food) {
        foodMapper.insertFood(food);
        return "redirect:/food/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("food", foodMapper.selectFoodById(id));
        return "food/editForm";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Food food) {
        food.setId(id);
        foodMapper.updateFood(food);
        return "redirect:/food/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        foodMapper.deleteFood(id);
        return "redirect:/food/list";
    }
}