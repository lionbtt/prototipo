package br.com.prototipo.security.oauth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
public class ConfiguracaoOAuth2 {
	public static final String RESOURCE_ID = "prototipo";

	@EnableResourceServer
	protected static class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {
		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.resourceId(RESOURCE_ID);
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().authenticated().and().requestMatchers().antMatchers("/categoria/**");
		}
	}

	@EnableAuthorizationServer
	protected static class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
		 @Autowired
        private AuthenticationManager authenticationManager;
        
        @Autowired
        private ClientDetailsService clientDetailsService;
        
	        @Autowired @Qualifier("dsOauth")
	        private DataSource dataSource;
        
        @Bean
        public TokenStore tokenStore(){
            return new JdbcTokenStore(dataSource);
        }	
        
        @Bean
        public ApprovalStore approvalStore(){
            return new JdbcApprovalStore(dataSource);
        }
        
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
            clients.jdbc(dataSource);
        }

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			DefaultOAuth2RequestFactory requestFactory = new DefaultOAuth2RequestFactory(clientDetailsService);
            requestFactory.setCheckUserScopes(true);
            endpoints.authenticationManager(authenticationManager)
                    .requestFactory(requestFactory)
                    .approvalStore(approvalStore())
                    .tokenStore(tokenStore());
		}
		
/*		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory().withClient("cliente-teste").secret("{noop}123456").scopes("read", "write")
					.authorizedGrantTypes("password").resourceIds(RESOURCE_ID);
		}
*/
	}

}
