//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()
//            .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//            );
//
//        return http.build();
//    }
//}

//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/employees/**").hasRole("ADMIN")
//                        .requestMatchers("/employees/attendance/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/attendance/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/student-marks/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/subjects/**").hasRole("ADMIN")
//                        .requestMatchers("/mark_attendance").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin().permitAll()
//                .and().logout().permitAll();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/employees/**").hasRole("ADMIN")
//                        .requestMatchers("/employees/attendance/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/attendance/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/student-marks/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/subjects/**").hasRole("ADMIN")
//                        .requestMatchers("/mark_attendance").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

//package com.magadhUniversity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/employees/**").hasRole("ADMIN")
//                        .requestMatchers("/employees/attendance/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/attendance/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/student-marks/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                        .requestMatchers("/subjects/**").hasRole("ADMIN")
//                        .requestMatchers("/mark_attendance").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/home") // Default landing page URL after login
//                .and()
//                .logout().permitAll();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

package com.magadhUniversity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // Allow access to static resources
                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "EMPLOYEE")
                        .requestMatchers("/employees/**").hasRole("ADMIN")
                        .requestMatchers("/employees/attendance/**").hasAnyRole("ADMIN", "EMPLOYEE")
                        .requestMatchers("/attendance/**").hasRole("EMPLOYEE")
                        .requestMatchers("/student-marks/**").hasAnyRole("ADMIN", "EMPLOYEE")
                        .requestMatchers("/subjects/**").hasRole("ADMIN")
                        .requestMatchers("/student/**").hasRole("STUDENT") // Access for students
                        .requestMatchers("/public/**").permitAll() // Allow public access to certain paths
                        // Project management routes
                        .requestMatchers("/projects/add", "/projects/approvedf").hasRole("STUDENT") // Students only
                        .requestMatchers("/projects/pending", "/projects/approved/").hasAnyRole("ADMIN", "EMPLOYEE") // Admin/Employee only

                        // Allow access to the student department selection page
                        .requestMatchers("/student/select-department", "/student/timetable/view").hasAnyRole("STUDENT", "EMPLOYEE", "ADMIN")
                        // Allow access to employee timetable management page
                        .requestMatchers("/employee/select-department", "/employee/timetable/manage", "/employee/timetable/add", "/employee/timetable/update", "/employee/timetable/delete",
                                "/employee/timetable/mark","/employee/timetable/see"    )
                        .hasRole("EMPLOYEE")
                        .requestMatchers("/mark_attendance").authenticated()
                        .anyRequest().authenticated()
                )
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/home") // Default landing page URL after login
//                .and()
//                .logout().permitAll();
//
//        return http.build();
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home") // Default landing page after login
                .successHandler((request, response, authentication) -> {
                    // Extract 'continue' parameter
                    String continueUrl = request.getParameter("continue");
                    if (continueUrl != null && !continueUrl.isEmpty()) {
                        response.sendRedirect(continueUrl); // Redirect to the intended page
                    } else {
                        response.sendRedirect("/home"); // Fallback to default home
                    }
                })
                .and()
                .logout().permitAll();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
