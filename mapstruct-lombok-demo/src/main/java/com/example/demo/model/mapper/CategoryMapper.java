package com.example.demo.model.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.dto.GetCategoryDTO;
import com.example.demo.model.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface CategoryMapper {
public abstract class CategoryMapper {
	
	@Autowired
	private CategoryRepository categoryRepository;

	abstract GetCategoryDTO toGetCategosy(Category categosry);
	
	/*@InheritInverseConfiguration
	Category toEntity(GetCategoryDTO getcategoryDto);*/
	
	Category toEntity(GetCategoryDTO getCategoryDto){
		if (getCategoryDto == null) {
			return null;
		}
		
		Category category = categoryRepository.findById(getCategoryDto.getId()).orElse(null);
		
		if(category == null)return null;
		
		category.setId(getCategoryDto.getId());
		category.setNombre(getCategoryDto.getNombre());
		
		return category;
		
	}
	
	
	abstract List<GetCategoryDTO> toGetCategosryList(List<Category> categoryList);
	
	abstract List<Category> toEntityList(List<GetCategoryDTO> getCategoryList);
}
