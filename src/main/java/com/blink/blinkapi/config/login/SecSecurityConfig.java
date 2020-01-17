package com.blink.blinkapi.config.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    CustomAuthenticationProvider customAuthProvider;
 
    @Override
    public void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
 
        auth.authenticationProvider(customAuthProvider);
        
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public Map<String,String> userMapAuth() {
    	Map<String,String> userList = new HashMap<>();
    	userList.putIfAbsent("admin", "admin");
    	//QUI POSSIAMO LEGGERE DA DB TUTTI GLI UTENTI AUTORIZZATI
    	return userList;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.antMatcher("/**")
            .csrf().disable()
//            .authorizeRequests().anyRequest().authenticated()
            .authorizeRequests().antMatchers("/", "/login**").permitAll() 
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .cors();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception
//    {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}password")
//                .roles("USER");
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}