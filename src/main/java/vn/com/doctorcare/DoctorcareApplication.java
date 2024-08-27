package vn.com.doctorcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import vn.com.doctorcare.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class DoctorcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorcareApplication.class, args);
	}

}
