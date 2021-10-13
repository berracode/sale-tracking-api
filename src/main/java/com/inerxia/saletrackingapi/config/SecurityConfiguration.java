package com.inerxia.saletrackingapi.config;



import com.inerxia.saletrackingapi.config.jwt2.JwtAuthenticationEntryPoint;
import com.inerxia.saletrackingapi.config.jwt2.JwtFiltroAutenticacion;
import com.inerxia.saletrackingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_LIST = {
			// -- swagger ui
			"/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security", "/swagger-ui.html",
			"/webjars/**" };

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CORSFilter corsFilter;

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public JwtFiltroAutenticacion jwtFiltroAutenticacion() {
		return new JwtFiltroAutenticacion();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests().antMatchers(HttpMethod.GET, AUTH_LIST).permitAll()
				.antMatchers(HttpMethod.POST, "/user/auth/**").permitAll()
				.antMatchers(HttpMethod.POST, "/user/customer/**").permitAll()

				.antMatchers("/").permitAll().anyRequest().authenticated().and()
				.addFilterBefore(corsFilter, ChannelProcessingFilter.class)
				.addFilterBefore(jwtFiltroAutenticacion(), UsernamePasswordAuthenticationFilter.class)
				.csrf().disable()
				
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler);
		http.httpBasic().disable();
		http.formLogin().disable();

	}
	

	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userService)
				.passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
				"/configuration/security", "/swagger-ui.html", "/webjars/**");
	}

}
