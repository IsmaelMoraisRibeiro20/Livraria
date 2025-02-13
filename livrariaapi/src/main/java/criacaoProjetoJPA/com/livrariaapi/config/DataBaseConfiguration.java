package criacaoProjetoJPA.com.livrariaapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@Configuration
public class DataBaseConfiguration {
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Value("${spring.datasource.driver-class-name}")
	String driver;
	
	
	//@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setDriverClassName(driver);
		
		return ds;
	
	}
	
	//@Bean
	public DataSource hikariDataSource() {
		HikariConfig config = new HikariConfig();
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		
		config.setMaximumPoolSize(10); //maximo de conexões liberadas
		config.setMinimumIdle(1);//tamanho de conexão com pool
		config.setPoolName("livraria-db-pool");
		config.setMaxLifetime(600000);//Qual o tamanho maximo de uma conexão 
		config.setConnectionTimeout(100000);//ele é o tempo que vai gastar para obter uma conexão 
		config.setConnectionTestQuery("select 1"); //Query de teste, para saber se esta conectando com o banco 
		
		
		return new HikariDataSource(config);
	}

	
	
	

	
}
