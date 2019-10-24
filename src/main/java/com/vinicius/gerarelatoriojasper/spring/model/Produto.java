package com.vinicius.gerarelatoriojasper.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe responsável por conter os atributos de um produto.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Entity
public class Produto {
	
	/**
	 * Representa o identificador do produto.
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	/**
	 * Representa o nome do produto.
	 */
	private String nome;
	
	/**
	 * Representa o codigo do produto.
	 */
	private Long codigo;
	
	/**
	 * Representa o preço do produto.
	 */
	private Double preco;
	
	/**
	 * Construtor vazio.
	 */
	public Produto() { }
	
	/**
	 * Construtor com argumentos.
	 * @param id - Integer - identificador do produto.
	 * @param nome - String - nome do produto.
	 * @param codigo - Long - codigo do produto.
	 * @param preco - Double - Preço do produto.
	 */
	public Produto(Integer id, String nome, Long codigo, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}



	/**
	 * Metodo get().
	 * @return id - Integer - identificador produto.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Metidi set().
	 * @param id - Integer - identificador produto.
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Metodo get().
	 * @return nome - String - nome do produto.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo set().
	 * @param nome - String - nome do produto.
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo get().
	 * @return codigo - Long - codigo do produto.
	 */
	public Long getCodigo() {
		return this.codigo;
	}

	/**
	 * Metodo set().
	 * @param codigo - Long - codigo do produto.
	 */
	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo get().
	 * @return preco - Double - Preço do produto.
	 */
	public Double getPreco() {
		return this.preco;
	}

	/**
	 * Metodo set().
	 * @param preco - Double - Preço do produto.
	 */
	public void setPreco(final Double preco) {
		this.preco = preco;
	}
	
}
