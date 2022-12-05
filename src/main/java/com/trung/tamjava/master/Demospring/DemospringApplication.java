package com.trung.tamjava.master.Demospring;

import com.trung.tamjava.master.Demospring.entity.Laptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringApplication.class, args);
	}


	// spring container
	// bean: objects: IoC
	// DI (dependency Inject)	: dung lại bean

	@Bean(name = "laptop1")
	public Laptop laptop1() {
		Laptop laptop = new Laptop();
		laptop.setId(1);
		laptop.setName("A");
		return laptop;
	}

	@Bean(name = "laptop2")
	public Laptop laptop2() {
		Laptop laptop = new Laptop();
		laptop.setId(1);
		laptop.setName("A");
		return laptop;
	}
}

