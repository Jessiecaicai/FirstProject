package hfutonline;

import hfutonline.entity.*;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;

import static sun.misc.Version.println;

@SpringBootApplication//(scanBasePackages = "hfutonline")
//@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication demo = new SpringApplication(Application.class);
//		Environment environment = demo.run(args).getEnvironment();
	}
}
