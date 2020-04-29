package br.com.qintess.projetoEventos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.qintess.projetoEventos.service.UsuarioLoginService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioLoginService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception{
		return authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
//				.antMatchers("/resources/**").permitAll()
//				.antMatchers("/", "/evento/**", "/carregaRegistro","/registra").permitAll()
//				.antMatchers("/compra/**").hasRole("USER")
//				.antMatchers("/adm/**").hasRole("ADMIN")
				.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/loga")
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/")
			.and()
			.exceptionHandling()
				.accessDeniedPage("/acessoNegado")
			.and()
			.csrf()
				.disable();
	}
	
}
