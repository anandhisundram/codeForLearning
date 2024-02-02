package com.practise.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by AAS on 2/12/2018.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	/* @Autowired
	  private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

	  @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf()
        .disable().authorizeRequests().requestMatchers("/*").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic().authenticationEntryPoint(authenticationEntryPoint);;
	    return http.build();
	  }*/
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	      http.csrf(AbstractHttpConfigurer::disable)
	          .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry.requestMatchers("/**").authenticated())
	          .httpBasic(Customizer.withDefaults())
	          .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))	
	         .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	


}