package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityconfig {
	
	
	
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	    }

	@Bean
	public static PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests((authorize) -> {
//	                	//admin can only access the post and delete request
//	                	authorize.requestMatchers(HttpMethod.POST,"api/**").hasRole("admin");	
//	                	authorize.requestMatchers(HttpMethod.DELETE,"api/**").hasRole("admin");
//	                	////admin and user both can  access the put and patch request
//	                	authorize.requestMatchers(HttpMethod.PUT,"api/**").hasAnyRole("admin","user");
//	                	authorize.requestMatchers(HttpMethod.PATCH,"api/**").hasAnyRole("admin","user");
//	                	//Anyone can  access the get request
//	                	authorize.requestMatchers(HttpMethod.GET,"api/**").permitAll();
	                
	                    authorize.anyRequest().authenticated();
	                    
	                }).httpBasic(Customizer.withDefaults());
	        return http.build();
	    }
//
//	@Bean
//	public UserDetailsService userdetails()
//	{
//		
////		
////		UserDetails devi=User.builder().username("devi").password(passwordEncoder().encode("devi@29")).roles("user").build();
////		
////		UserDetails admin=User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("admin").build();
////		
////		 return new InMemoryUserDetailsManager(devi,admin);
//		
//	}

}
