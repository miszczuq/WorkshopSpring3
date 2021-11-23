package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.entity.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findFirstByCity(String city);
}
