package com.example.gues5.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final UserDetailsService userService;

    // 스프링 시큐리티 기능 비활성화
//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring();
//                //.requestMatchers(toH2Console())
//                //.requestMatchers("/static/**");
//    }

     //특정 HTTP 요청에 대한 웹 기반 보안 구성
    @Bean
    protected SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
        //http
                //.authorizeRequests()
                //.requestMatchers("/login", "/user/register", "/css/**", "/images/**", "/js/**").permitAll()
                //.anyRequest().authenticated();


                //.and()
                //.formLogin()
                //.loginPage("/login")
                //.loginProcessingUrl("/실제 로그인이 되는 url")
                //.permitAll();

        //http
                //.sessionManagement()
                //.invalidSessionUrl("/로그인페이지")

                //.and()
                //.logout()
                //.logoutRequestMatcher(new AntPathRequestMatcher("/실제 로그아웃이 되는 url"))
                //.invalidateHttpSession(true)
                //.deleteCookies("JSESSIONID")
                //.permitAll();


        //CSRF 토큰
        http
                .csrf((csrf) -> csrf.disable());

        return http.build();
    }

    // 인증 관리자 관련 설정
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}