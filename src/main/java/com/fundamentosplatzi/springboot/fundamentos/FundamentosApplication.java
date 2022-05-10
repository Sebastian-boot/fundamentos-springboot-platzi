package com.fundamentosplatzi.springboot.fundamentos;

import ch.qos.logback.classic.Logger;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean2practice.*;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependecy;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependecy componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private ToPractice toPractice;
	private MySubtract mySubtract;
	private MySubtractWithDependency mySubtractWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(@Qualifier("componentThreeImplement") ComponentDependecy componentDependecy,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  ToPractice toPractice,
								  MySubtractWithDependency mySubtractWithDependency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository,
								  UserService userService){
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.toPractice = toPractice;
		this.mySubtractWithDependency = mySubtractWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejmeplosAnteriores();
		saveUserInDB();
		//getInformationJpqlFromUser();
		saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional() {
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional1@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1, test2, test3, test4);

		try {
			userService.saveTransactional(users);
		}catch (Exception e) {
			LOGGER.error("Esta es una excpeción dentro del metodo Transactional: "+e);
		}

		userService.getAllUsers().stream()
				.forEach(user -> LOGGER.info("Usuario traidos desde el transactional: "+user));
	}

	private void getInformationJpqlFromUser(){
		/*LOGGER.info("Usuario con el metodo findByUserEmail: " +
				userRepository.findByEmail("marco@domain.com")
						.orElseThrow(() -> new RuntimeException("No se encontró el Usuario")));

		userRepository.findAndSort("user", Sort.by("Id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort: "+user));

		userRepository.findByName("John").stream().
				forEach(user -> LOGGER.info("Usuario con Query Method: " + user));
*/
		LOGGER.info("Usuario encontrado por nombre y Email" +
				userRepository.findByEmailAndName("daniela@domain.com","daniela")
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

		userRepository.findByNameLike("%e%").stream()
				.forEach(user -> LOGGER.info("Usuarios con LIKE: " + user));

		//LOGGER.info(" El usuario a partir del named parameter "
				//+userRepository.getAllByBirthDayAndEmail(LocalDate.of(2021, 9, 8),"daniela@domain.com")
				//.orElseThrow(() -> new RuntimeException("No se encontró el usuario a partir del named parameter")));

	}

	private void saveUserInDB(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
		User user10 = new User("user10", "user10@domain.com", LocalDate.of(2021, 3, 21));
		User user11 = new User("user11", "user11@domain.com", LocalDate.of(2021, 11, 30));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11);
		userRepository.saveAll(list);
	}

	public void ejmeplosAnteriores(){
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWhitDependency();
		toPractice.message();
		mySubtractWithDependency.printDepdendency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getMail() +" - "+ userPojo.getPassword() + " - "+ String.valueOf(userPojo.getAge()));
		try {
			//error
			int value = 10/0;
			LOGGER.debug("Mi valor :"+value);
		}catch (Exception e){
			LOGGER.error("esto es un error al dividir por cero"+ e.getMessage());
		}
	}

}
