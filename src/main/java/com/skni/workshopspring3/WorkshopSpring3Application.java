package com.skni.workshopspring3;

import com.skni.workshopspring3.repo.AddressRepository;
import com.skni.workshopspring3.repo.PersonRepository;
import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Person;
import com.skni.workshopspring3.service.AddressService;
import com.skni.workshopspring3.service.PersonService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkshopSpring3Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpring3Application.class, args);
	}

	@Bean
	CommandLineRunner init(PersonService personService, AddressService addressService) {
		return (args) -> {
			Address address = addressService.addAddress("Niepodległości 162", "Warszawa", "Polska");

			Person person = personService.addPerson(
					"Adam",
					"Nowak",
					LocalDate.of(1996, 05,10),
					GenderEnum.MALE,
					address
			);

			System.out.println(person);

			System.out.println(personService.getAllPeople());
			System.out.println(personService.deletePersonById(person.getId()));
			System.out.println(personService.getAllPeople());
		};
	}

}
