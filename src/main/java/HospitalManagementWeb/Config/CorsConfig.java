package HospitalManagementWeb.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

//    @Value("${frontend.url}")
//    private String frontendUrl;

    @Bean
    public WebMvcConfigurer webMvcConfigure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedOriginPatterns("https://hospitalmanagmentsystem.vercel.app/") // Specify the origin explicitly
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*") // Allow any headers
                        .allowCredentials(true); // Allow credentials (cookies, headers, etc.

            }
        };
    }
}
