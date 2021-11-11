package com.hoangminh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        // Tạo ra user trong bộ nhớ
//        // lưu ý, chỉ sử dụng cách này để minh họa
//        // Còn thực tế chúng ta sẽ kiểm tra user trong csdl
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(
//                User.withDefaultPasswordEncoder() // Sử dụng mã hóa password đơn giản
//                        .username("minh")
//                        .password("minh")
//                        .roles("USER") // phân quyền là người dùng.
//                        .build()
//        );
//        return manager;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
//                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
//                .and()
//                .formLogin() // Cho phép người dùng xác thực bằng form login
//                .defaultSuccessUrl("/hello")
//                .permitAll() // Tất cả đều được truy cập vào địa chỉ này
//                .and()
//                .logout() // Cho phép logout
//                .permitAll();
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                return null;
            }
            return Optional.of(authentication.getName());
        }
    }
}
