package br.com.prototipo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.prototipo.service.UsuarioService;

@EnableWebSecurity
public class ConfiguracaoDeSeguranca {

	@Autowired
	public UsuarioService usuarioService;

	@Configuration
	@Order(1)
	public class ConfiguracaoParaAPI extends WebSecurityConfigurerAdapter {
		
		@Override
		@Bean(name="myAuthenticationManager")
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.authorizeRequests().anyRequest().authenticated().and().antMatcher("/categoria").httpBasic().and()
					.csrf().disable();
			// @formatter:on
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
		}
	}
}
