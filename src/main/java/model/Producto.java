package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data/*
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
@Table(name = "tb_productos")
public class Producto {
	
	@Id
	@Column(name="id_prod")
	private String idproducto;
	
	@Column(name="des_prod")
	private String descripcion;
	
	@Column(name="stk_prod")
	private int stok;
	
	@Column(name="pre_prod")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="idcategoria", insertable = false, updatable=false)//porque abajo nos da error y lo ignoramosal insertar o actualizar
	private Categorias categoria;//obtener informacion de categorias segun el campo

	
	private int idcategoria;//grabar en la tabla de productos
	
	@Column(name="est_prod")
	private int estado;

	@ManyToOne
	@JoinColumn(name="idprovedor", insertable = false, updatable=false)//porque abajo nos da error y lo ignoramosal insertar o actualizar
	private Proveedor proveedor;
	
	private int idprovedor;//grabar ebn la tabla de productos
	
	
	

}
