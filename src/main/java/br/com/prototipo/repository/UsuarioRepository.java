package br.com.prototipo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prototipo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Iterable<Usuario> findByEmail(String email);
	Usuario findById(long id);

}
