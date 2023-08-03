package com.grileddev.thatknow.web.datasource;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    basePackages = "com.grileddev.thatknow.web.database.repository.koreaAreaRepository",
    entityManagerFactoryRef = "KoreaAreaEntityManager", 
    transactionManagerRef = "KoreaAreaTransactionManager"
)
public class KoreaAreaDatasource {
	@Autowired
	private Environment env;

	@Bean
	@Qualifier
	public LocalContainerEntityManagerFactoryBean KoreaAreaEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(KoreaAreaDataSource());
        
        em.setPackagesToScan(new String[] { "com.grileddev.thatknow.web.entity.areaEntity" });
	
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
        
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	@Qualifier

	@ConfigurationProperties(prefix="spring.korea-area.datasource")
	public DataSource KoreaAreaDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Qualifier
	public PlatformTransactionManager KoreaAreaTransactionManager() {	
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(KoreaAreaEntityManager().getObject());
		return transactionManager;
	}
}