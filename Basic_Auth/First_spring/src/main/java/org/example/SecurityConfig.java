package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Security filter chain configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF and configure HTTP security
        http
                .csrf(AbstractHttpConfigurer::disable)  // ✅ Correct syntax in Spring Security 6+
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/create").permitAll()  // Allow /api/create without authentication
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")                        .anyRequest().authenticated()  // Require authentication for any other requests
                )
                .httpBasic(Customizer.withDefaults());  // Basic Authentication (no form login)

        return http.build();
    }
}
