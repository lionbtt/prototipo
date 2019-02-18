package br.com.prototipo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.model.Categoria;
import br.com.prototipo.repository.CategoriaRepository;


@Service
public class CategoriaService{
	
	@Autowired
	private CategoriaRepository cr;
	
	public void salvar(Categoria c) {
		cr.save(c);	
	}
	
	public void excluir(Categoria c) {
		cr.delete(c);
	}
	
	public Iterable<Categoria> listar(){
		return cr.findAll();
	}
	
	public Iterable<Categoria> listarPorDescricao(String descricao){
		return cr.findByDescricao(descricao);
	}
	
	public Categoria findBycategoriaId(long categoriaId) {
		return cr.findBycategoriaId(categoriaId);
	}


}
