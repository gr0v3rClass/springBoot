package com.example.demo.model.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.example.demo.model.dto.GetProductDTO;
import com.example.demo.model.entity.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {
	
	/*@Mapping(source = "id",target = "id")
	@Mapping(source = "nombre",target = "nombre")
	@Mapping(source = "creationDate",target = "creationDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
	GetProductDTO toGetDTO1(Product product);*/
	
	/*@Mappings({
		@Mapping(source = "id",target = "id"),
		@Mapping(source = "nombre",target = "nombre"),
		@Mapping(source = "creationDate",target = "creationDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
	})*/
	
	@Mappings({
		@Mapping(source = "creationDate",target = "creationDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
	})
	GetProductDTO toGetDTO(Product product);
	
	
	// mapeos inversios
	@InheritInverseConfiguration
	Product toEntity(GetProductDTO getProductDTO);
	
	
	List<GetProductDTO> toGetProductDTOList(List<Product> productList);
	
	List<Product> toEntityList(List<GetProductDTO> getProductsList);
	
}
