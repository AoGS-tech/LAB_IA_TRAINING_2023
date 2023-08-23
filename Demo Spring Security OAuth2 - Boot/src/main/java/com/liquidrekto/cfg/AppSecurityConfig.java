/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector).servletPath("/");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http.csrf(csrf -> csrf.disable())
                
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers(antMatcher("/profile")).authenticated()
                            .requestMatchers(antMatcher("/admin/**")).hasAuthority("USER_ADMIN")
                            .requestMatchers(antMatcher("/student/**")).hasAnyAuthority("USER_STUDENT","USER_ADMIN")
                            .requestMatchers(antMatcher("/teacher/**")).hasAnyAuthority("USER_TEACHER","USER_ADMIN")
                            .anyRequest().permitAll();
                })
                .oauth2Login(oauth -> oauth.loginPage("/login"))
                .exceptionHandling(ex -> ex.accessDeniedPage("/403"))
                .logout(logout -> logout.invalidateHttpSession(true) // invalidates the HttpSession
                .clearAuthentication(true) // clears the SecurityContextHolder
                .logoutRequestMatcher(antMatcher("/logout")) // specifies the URL to trigger a logout
                .logoutSuccessUrl("/") // specifies the URL to redirect to after a successful logout
                .permitAll());
                
                

        return http.build();

    }
   

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("liquidrekto")
            .password("Dung6c@@")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
*/
     
}
