package com.vinicius.gerarelatoriojasper.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vinicius.gerarelatoriojasper.spring.model.Produto;

/**
 * Interface ProdutoRepository responsável por anotar nossas operações de CRUD ( acessar banco de dados, consultas, etc ).
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{

}
