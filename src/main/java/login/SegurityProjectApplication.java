package login;


import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



import org.springframework.boot.autoconfigure.SpringBootApplication;

@Configuration  
@Import({ SecurityConfig.class })
@SpringBootApplication
public class SegurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegurityProjectApplication.class, args);
	}

}