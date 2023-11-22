package io.github.pakiruchinoike;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class MyConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Projeto Indústria 4.0";
    }

    @Bean(name="executar")
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("RUNNING DEVELOPMENT CODE");
        };
    }

}
