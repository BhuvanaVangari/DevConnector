package com.dnb.DevConnector;
//
//import java.util.Optional;
//import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.dnb.DevConnector.dto.Education;
//import com.dnb.DevConnector.dto.Experience;
//import com.dnb.DevConnector.dto.Profile;
//import com.dnb.DevConnector.dto.User;
//import com.dnb.DevConnector.exceptions.IdNotFoundException;
//import com.dnb.DevConnector.service.EducationService;
//import com.dnb.DevConnector.service.ExperienceService;
//import com.dnb.DevConnector.service.ProfileService;
//import com.dnb.DevConnector.service.UserService;

@SpringBootApplication
public class DevConnectorApplication {

	public static void main(String[] args) {
		System.out.println("hello:)");
		SpringApplication.run(DevConnectorApplication.class, args);

//		ApplicationContext applicationContext = SpringApplication.run(DevConnectorApplication.class, args);
//
//		UserService userService = applicationContext.getBean(UserService.class);
//
//		ProfileService profileService = applicationContext.getBean(ProfileService.class);
//		
//		EducationService educationService = applicationContext.getBean(EducationService.class);
//		
//		ExperienceService experienceService = applicationContext.getBean(ExperienceService.class);
//
//		User user;
//
//		Profile profile;
//		
//		Education education;
//		
//		Experience experience;
//
//		try {
//			user = new User();
//			profile = new Profile();
//			education = new Education();
//			experience = new Experience();
//			
//			Scanner sc = new Scanner(System.in);
//
//			while (true) {
//				System.out.println(
//						"Enter your choice\n1)Create user\n2)Get user by email ID\n3)Delete user by email ID\n4)Get all users\n5)Create profile\n6)Get profile by profileUUID\n7)Delete profile by profileUUID\n8)Get all profiles\n9)Create education table\n10)Get education profile by education ID\n11)Delete education profile by education ID\n12)Get all education profiles\n13)Create experience table\n14)Get experience by experience ID\n15)Delete experience by experience ID\n16)Get all experiences\n17)Exit");
//				int ch = sc.nextInt();
//
//				switch (ch) {
//				case 1:
//					userService.createUser(user);
//					break;
//
//				case 2:
//					Optional<User> user1;
//					user1 = userService.getUserByEmailId("bhuvana.1905j2@gmail.com");
//					System.out.println(user1 != null);
//					break;
//
//				case 3:
//					userService.deleteUserByEmailId("bhuvana.1905j2@gmail.com");
//					break;
//
//				case 4:
//					userService.getAllUsers().forEach((name) -> System.out.println(name));
//					break;
//
//				case 5:
//					profile.setProfessionalStatus("Developer");
//					profile.setSkills("HTML,CSS,JS");
//					profileService.createProfile(profile);
//					break;
//
//				case 6:
//					System.out.println(profileService.getProfileById("f212958f-cc8c-4073-887a-42e7d083a865")); 
//					break;
//					
//				case 7:
//					profileService.deleteProfileById("f212958f-cc8c-4073-887a-42e7d083a865");
//					break;
//					
//				case 8:
//					profileService.getAllProfiles().forEach((name)->System.out.println(name));
//					break;
//					
//				case 9:
//					education.setDegree("B.Tech");
//					education.setSchool("CMRCET");
//					educationService.createEducationProfile(education);
//					break;
//					
//				case 10:
//					System.out.println(educationService.getEducationProfileById("11")!=null);
//					break;
//					
//				case 11:
//					educationService.deleteEducationById("11");
//					break;
//				
//				case 12:
//					educationService.getAllEducations().forEach((name)->System.out.println(name));
//					break;
//					
//				case 13:
//					experience.setJobTitle("Developer");
//					experience.setCompany("DnB");
//					experienceService.createExperience(experience);
//					break;
//					
//				case 14:
//					System.out.println(experienceService.getExperienceById("11")!=null);
//					break;
//				
//				case 15:
//					experienceService.deleteExperienceById("11");
//					break;
//				
//				case 16:
//					experienceService.getAllExperiences().forEach((name)->System.out.println(name));
//					break;
//					
//				case 17:
//					System.exit(0);
//
//				}
//			}
//		}  catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 

	}

}
