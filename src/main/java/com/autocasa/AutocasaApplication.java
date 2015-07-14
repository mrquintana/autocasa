package com.autocasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
public class AutocasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutocasaApplication.class, args);
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	    hibernateJpaVendorAdapter.setShowSql(true);
	    hibernateJpaVendorAdapter.setGenerateDdl(true); //Auto creating scheme when true
	    hibernateJpaVendorAdapter.setDatabase(Database.H2);//Database type
	    return hibernateJpaVendorAdapter;
	}
}
