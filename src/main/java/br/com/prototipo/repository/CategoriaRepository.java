package br.com.prototipo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prototipo.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, String>{
	
	Iterable<Categoria> findByDescricao(String descricao);
	Categoria findBycategoriaId(long categoriaId);
}
