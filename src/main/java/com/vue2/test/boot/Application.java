
package com.vue2.test.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.vue2.test.boot.data.dao.TodoDao;
import com.vue2.test.boot.data.entity.Todo;

@SpringBootApplication
public class Application {

	@Autowired
	private TodoDao todoDao = null;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		System.out.println("java.io.tmpdir = " + System.getProperty("java.io.tmpdir"));
		return args -> {
			todoDao.save(new Todo(0L, "Learn H5", false));
			todoDao.save(new Todo(0L, "Learn CSS3", false));
			todoDao.save(new Todo(0L, "Learn JS (ES6)", false));
		};
	}
}