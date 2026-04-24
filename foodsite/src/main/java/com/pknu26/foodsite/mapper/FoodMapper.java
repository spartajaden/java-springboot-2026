package com.pknu26.foodsite.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pknu26.foodsite.controller.FoodController;

@Mapper
public interface FoodMapper {
    List<FoodController> selectAllFoods(@Param("offset") int offset, @Param("size") int size, 
                              @Param("keyword") String keyword, @Param("category") String category);
    long countFoods(@Param("keyword") String keyword, @Param("category") String category);
    void insertFood(FoodController food);
    FoodController selectFoodById(Long id);
    void updateFood(FoodController food);
    void deleteFood(Long id);
}