package com.io.industry.industria.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Value("${sys.user}")
    private String user;
    @Value("${sys.passwd}")
    private String passwd;
    @Value("${sys.adm.user}")
    private String admUser;
    @Value("${sys.adm.passwd}")
    private String admPasswd;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(customizer -> {
                customizer.requestMatchers("/public").permitAll();
                customizer.requestMatchers("/private").hasRole("ADMIN");
                customizer.anyRequest().authenticated();
            })
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())    
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails commonUser = User.builder()
            .username(user)
            .password(passwordEncoder().encode(passwd))
            .roles("USER")
            .build();

        UserDetails adminUser = User.builder()
            .username(admUser)
            .password(passwordEncoder().encode(admPasswd))
            .roles("USER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(commonUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
