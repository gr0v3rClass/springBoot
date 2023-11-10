package com.example.demo.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="product")
public class Product {
	@Id
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "creation_date")
	private LocalDate creationDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	/*public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nombre=" + nombre + ", creationDate=" + creationDate + "]";
	}*/
	
	
	
}
