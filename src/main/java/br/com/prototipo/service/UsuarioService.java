package br.com.prototipo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.prototipo.exception.impl.ErroLoginDadosInvalidosException;
import br.com.prototipo.model.Usuario;
import br.com.prototipo.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Iterable<Usuario> user = ur.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException(username + " não encontrado");
		}else {
			if ( ((Collection<?>)user).size()>1)
				throw new ErroLoginDadosInvalidosException(username + " não foi possível fazer o login. Verifique com o suporte/administrador do sistema!");
			
			Usuario usuario = user.iterator().next();
			return usuario;/*new org.springframework.security.core.userdetails.User(
					usuario.getEmail(),
					usuario.getSenha(),
	                null//AuthorityUtils.createAuthorityList(user.getRoles()
	                );*/
		}	
	}

}
