package br.com.prototipo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.exception.impl.JaExistenteException;
import br.com.prototipo.exception.impl.NaoEncontradoException;
import br.com.prototipo.model.Categoria;
import br.com.prototipo.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {    

   @Autowired
   private CategoriaService categoriaServico;
   
   @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{categoriaId}")
   public Categoria retornaCategoria(@PathVariable long categoriaId){
       Categoria categoria = categoriaServico.findBycategoriaId(categoriaId);
       if(categoria==null){
           throw new NaoEncontradoException("Categoria não encontrada");
       }
       Link selfLink = linkTo(CategoriaController.class).slash(categoria.getId()).withSelfRel();
       categoria.add(selfLink);
       return categoria;
   }
   
   @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = { "" , "/" })
   public Categoria alteraCategoria(@RequestBody Categoria categoria){
	   Categoria buscaCategoria = categoriaServico.findBycategoriaId(categoria.getCategoriaId());
	   if(buscaCategoria!=null)
		   this.salvarCategoria(categoria);
	   else
		   throw new NaoEncontradoException("Categoria não encontrada");
	   
	   return categoria;
   }
   
   @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = { "" , "/" })
   public Categoria salvarCategoria(@RequestBody Categoria categoria){
	   Iterable<Categoria> buscaCategorias = categoriaServico.listarPorDescricao(categoria.getDescricao());
	   if(buscaCategorias==null){
		   categoriaServico.salvar(categoria);
	   }else if(buscaCategorias.spliterator().getExactSizeIfKnown()>0) {
		   throw new JaExistenteException("Categoria com a descrição já existente. Não é permitido cadastro de catégorias iguais.");
	   }
       
       return categoria;
   }
   
   @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{categoriaId}")
   public Categoria apagaCategoria(@PathVariable long categoriaId){
	   Categoria categoria = categoriaServico.findBycategoriaId(categoriaId);
       categoriaServico.excluir(categoria);
	   return categoria;
   }
}