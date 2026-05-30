package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@Configuration
public class LoginpageSecurity {
	
	@Autowired
	Jwtfilter jwtfilter;
@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http
		.csrf(csrf ->csrf.disable())
		.authorizeHttpRequests(auth->auth
		.requestMatchers("/api/register", "/api/login","/**" ).permitAll()
		.anyRequest().authenticated())
        .addFilterBefore(
                jwtfilter,
                UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
@Bean
    PasswordEncoder passwordencoder() {
    	return new BCryptPasswordEncoder();
    }
@Bean
public CorsFilter corsFilter() {
	CorsConfiguration config=new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("http://localhost:5173");
	config.addAllowedHeader("*");
	config.addAllowedMethod("*");
UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
source.registerCorsConfiguration("/**", config);
return new CorsFilter(source);
	
}
}
	

