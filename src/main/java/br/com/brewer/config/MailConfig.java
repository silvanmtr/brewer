/**
 * 
 */
package br.com.brewer.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.com.brewer.mail.Mailer;

/**
 * @author Silvan de Jesus
 *
 */

@Configuration
@ComponentScan(basePackageClasses = Mailer.class)
@PropertySource({ "classpath:env/mail-${ambiente:local}.properties" })
@PropertySource(value = { "file://${HOME}/.brewer-mail.properties" }, ignoreResourceNotFound = true)

public class MailConfig {

	@Autowired
	private Environment env;

	@Bean
	public JavaMailSender mailSender(){
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.sendgrid.net");
		mailSender.setPort(587);
		mailSender.setUsername("silvandejesus");
		mailSender.setPassword("Si299792458");
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.debug", false);
		props.put("mail.smtp.connectiontimeout", 10000); // miliseconds

		mailSender.setJavaMailProperties(props);

		
		return mailSender;
		
	}
}
