package com.skni.workshopspring3;

import com.skni.workshopspring3.repo.AddressRepository;
import com.skni.workshopspring3.repo.PersonRepository;
import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Person;
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
	CommandLineRunner init(AddressRepository addressRepository, PersonRepository personRepository) {
		return (args) -> {
			List<Person> personList = personRepository.findAll();
			System.out.println(personList);
			List<Address> addressList = addressRepository.findAll();
			System.out.println(addressList);

			List<Person> maleInPoland = personRepository.findAllByGenderAndCountry(GenderEnum.MALE.name(), "Polska");
			System.out.println(maleInPoland);
		};
	}

}
