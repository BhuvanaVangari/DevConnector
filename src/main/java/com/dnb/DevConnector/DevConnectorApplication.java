package com.dnb.DevConnector;

import java.util.Optional;
import java.util.Scanner;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.exceptions.InvalidEmailIdException;
import com.dnb.DevConnector.exceptions.InvalidPasswordException;
import com.dnb.DevConnector.service.UserService;

@SpringBootApplication
public class DevConnectorApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DevConnectorApplication.class, args);

		UserService userService = applicationContext.getBean(UserService.class);

		User user;

		try {
			user = new User("Bhuvana", "bhuvana.1905j2@gmail.com", "Password@123");
			Scanner sc = new Scanner(System.in);

			while (true) {
				System.out.println(
						"Enter your choice\n1)Create user\n2)Get user by email ID\n3)Delete user by email ID\n4)Get all users\n5)Exit");
				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					userService.createUser(user);
					break;

				case 2:
					Optional<User> user1;
					user1 = userService.getUserByEmailId("bhuvana.1905j2@gmail.com");
					System.out.println(user1 != null);
					break;

				case 3:
					userService.deleteUserByEmailId("bhuvana.1905j2@gmail.com");
					break;
					
				case 4:
					userService.getAllUsers().forEach((name)->System.out.println(name));
					break;
				
				case 5:
					System.exit(0);

				}
			}
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
