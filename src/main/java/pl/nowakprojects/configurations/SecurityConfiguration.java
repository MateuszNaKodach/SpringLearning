package pl.nowakprojects.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String ROLE_ADMIN = "pl.nowakprojects.spirngLearn.ADMIN";
    private static final String ROLE_USER = "pl.nowakprojects.spirngLearn.USER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().antMatchers("/start").permitAll();
        http.authorizeRequests().antMatchers("/user").hasRole(ROLE_USER);
        http.authorizeRequests().antMatchers("/admin").hasRole(ROLE_ADMIN);
      //  http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles(ROLE_USER)
                .and()
                .withUser("user").password("user1").roles(ROLE_ADMIN);
    }
}
