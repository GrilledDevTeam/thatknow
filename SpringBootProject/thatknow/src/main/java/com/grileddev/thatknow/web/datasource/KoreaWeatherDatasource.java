package com.grileddev.thatknow.web.datasource;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;



@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
    basePackages = "com.grileddev.thatknow.web.repository.koreaWeatherRepository",
    entityManagerFactoryRef = "koreaWeatherEntityManager", 
    transactionManagerRef = "koreaWeatherTransactionManager"
)
public class KoreaWeatherDatasource {
	@Autowired
	private Environment env;

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean koreaWeatherEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(koreaWeatherDataSource());
        
        em.setPackagesToScan(new String[] { "com.grileddev.thatknow.web.entity.weatherResponseHourEntity" });
	
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
        
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);
		return em;
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.korea-weather.datasource")
	public DataSource koreaWeatherDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager koreaWeatherTransactionManager() {	
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(koreaWeatherEntityManager().getObject());
		return transactionManager;
	}
}
