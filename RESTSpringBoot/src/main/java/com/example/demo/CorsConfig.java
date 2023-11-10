package com.example.demo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {

	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir solicitudes desde cualquier origen
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200/api/v1");
        
        config.addAllowedOrigin("http://localhost:4200/api/v2");

        // Permitir solicitudes con los siguientes métodos HTTP
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");

        // Permitir solicitudes con los siguientes encabezados
        config.addAllowedHeader("Origin");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Accept");
        config.addAllowedHeader("Authorization");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuración de CORS
        http.cors().and()
            // Otras configuraciones de seguridad
            .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic()
            .and()
            .csrf().disable(); // Deshabilitar CSRF para simplificar el ejemplo
    }
}
