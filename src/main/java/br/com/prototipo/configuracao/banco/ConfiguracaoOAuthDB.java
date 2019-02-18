package br.com.prototipo.configuracao.banco;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfiguracaoOAuthDB {
	
	@Primary
	@Bean
    @ConfigurationProperties("spring.datasource.ds-api")
    public DataSourceProperties apiDataSourceProperties() {
    	return new DataSourceProperties();
    }
	
	@Primary
    @Bean(name = "dsApi")
    @ConfigurationProperties(prefix="spring.datasource.ds-api")
    public DataSource apiDataSource() {
        //return DataSourceBuilder.create().build();
    	return apiDataSourceProperties().initializeDataSourceBuilder().build();
    }
	
	@Bean
    @ConfigurationProperties("spring.datasource.ds-oauth")
    public DataSourceProperties oauthDataSourceProperties() {
    	return new DataSourceProperties();
    }
	
    @Bean(name = "dsOauth")
    @ConfigurationProperties(prefix="spring.datasource.ds-oauth")
    public DataSource oauthDataSource() {
        //return DataSourceBuilder.create().build();
    	return oauthDataSourceProperties().initializeDataSourceBuilder().build();
    }
    
}