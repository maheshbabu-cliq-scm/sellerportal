package com.sellerportal;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sellerportal.ism.utils.EncryptDecrypt;

@SpringBootApplication
public class SellerportalApplication implements CommandLineRunner {

	@Autowired private ApplicationContext appContext;
	
	public static void main(String[] args) {
		SpringApplication.run(SellerportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beans = appContext.getBeanDefinitionNames();
		Arrays.sort(beans);
        for (String bean : beans) {
//            System.out.println(bean);
        }
	}
	
	@Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    }
	
	@Bean
    public Timestamp timestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
	
	@Bean
    public EncryptDecrypt encryptDecrypt() {
        return new EncryptDecrypt();
    }

}
