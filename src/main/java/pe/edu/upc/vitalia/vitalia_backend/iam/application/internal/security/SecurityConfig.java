package pe.edu.upc.vitalia.vitalia_backend.iam.application.internal.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.*;

import java.util.List;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    // 👇 lista de rutas públicas para Swagger/OpenAPI y auth
    private static final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // 👇 Swagger y login públicos
                        .requestMatchers(SWAGGER_WHITELIST).permitAll()
                        .requestMatchers("/api/v1/auth/**").permitAll()

                        // 👇 tu protección por roles (ajústalo a lo que ya tenías)
                        .requestMatchers(HttpMethod.GET, "/api/v1/messages/**").hasAnyRole("DOCTOR","PATIENT","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/messages/**").hasAnyRole("DOCTOR","PATIENT","ADMIN")
                        .requestMatchers("/api/v1/conversations/**").hasAnyRole("DOCTOR","PATIENT","ADMIN")
                        .requestMatchers("/api/v1/appointments/**").hasAnyRole("DOCTOR","PATIENT","ADMIN")
                        .requestMatchers("/api/v1/schedules/**").hasAnyRole("DOCTOR","ADMIN")
                        .requestMatchers("/api/v1/doctors/**").hasAnyRole("ADMIN","DOCTOR")
                        .requestMatchers("/api/v1/patients/**").hasAnyRole("ADMIN","DOCTOR","PATIENT")

                        // cualquier otra requiere autenticación
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration ac) throws Exception {
        return ac.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        var config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*")); // ajusta en prod
        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","PATCH","OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization","Content-Type"));
        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
