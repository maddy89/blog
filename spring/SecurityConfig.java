package com.pick5now.config;

import com.pick5now.common.security.RestAuthenticationSuccessHandler;
import com.pick5now.common.security.RestLogoutSuccessHandler;
import com.pick5now.common.security.RestMobileAPIAuthenticationEntryPoint;
import com.pick5now.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Security Configuration.
 *
 * @author Madhawa Bandara
 */
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @Configuration
    @Order(1)
    public class MobileWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(getBasicAuthEntryPoint())
                //login config
                .and()
                .formLogin()
                .loginProcessingUrl("/api/mobile/v1/login")
                .successHandler(restAuthSuccessHandler())
                .failureHandler(restAuthFailureHandler())
                //logout config
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/mobile/v1/logout", "DELETE"))
                .permitAll()
                .logoutSuccessHandler(restLogoutSuccessHandler())
                //URL matchers
                .and()
                .authorizeRequests()
                .antMatchers("/api/mobile/**").authenticated();
        }
    }

    @Bean
    public static RestMobileAPIAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return new RestMobileAPIAuthenticationEntryPoint();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationBuilder) throws Exception {
        authenticationBuilder
            .authenticationProvider(rememberMeAuthenticationProvider())
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
        return new RememberMeAuthenticationProvider("P5N");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationSuccessHandler restAuthSuccessHandler() {
        return new RestAuthenticationSuccessHandler();
    }

    @Bean
    AuthenticationFailureHandler restAuthFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Bean
    LogoutSuccessHandler restLogoutSuccessHandler() {
        return new RestLogoutSuccessHandler();
    }
}




