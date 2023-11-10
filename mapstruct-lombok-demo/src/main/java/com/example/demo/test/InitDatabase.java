package com.example.demo.test;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.dto.GetProductDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.mapper.ProductMapper;
import com.example.demo.repository.ProductoRepository;

@Configuration
public class InitDatabase {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Bean
	public CommandLineRunner testProductosMapperCommand() {
		return args -> {
			List<Product> products = productoRepository.findAll();
			
			System.out.println("Productos");
			
			products.forEach(System.out::println);
			
			System.out.println("Get Product");
			
			/*List<GetProductDTO> getProductDTO = products
					.stream().map(product -> productMapper.toGetDTO(product))
					.peek(System.out::println)
					.collect(Collectors.toList());*/
			List<GetProductDTO> getProductDTO = productMapper.toGetProductDTOList(products);
			getProductDTO.forEach(System.out::println);
			
			System.out.println("Maper Products");
			
			List<Product> mapperProducts = productMapper.toEntityList(getProductDTO);
			mapperProducts.forEach(System.out::println);
		};
	}
}
