package dev.a13i.hello_springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityAdapter {
  private final RestAuthEntryPoint restAuthEntryPoint;

  public CustomWebSecurityAdapter(RestAuthEntryPoint restAuthEntryPoint) {
    this.restAuthEntryPoint = restAuthEntryPoint;
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("demo")
      .password("{noop}demo")
      .authorities("ROLE_USER");
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(registry -> registry.anyRequest().authenticated())
      .httpBasic(configurer -> configurer.authenticationEntryPoint(restAuthEntryPoint));

    return http.build();
  }
}
