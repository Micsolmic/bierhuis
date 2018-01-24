package be.vdab.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import be.vdab.repositories.BestelbonlijnRepository;

@Configuration
@ComponentScan
public class ServicesConfig {
@Bean
BestelbonlijnService bestelbonlijnService(BestelbonlijnRepository bblR) { 
return new BestelbonlijnService(bblR);
}
}