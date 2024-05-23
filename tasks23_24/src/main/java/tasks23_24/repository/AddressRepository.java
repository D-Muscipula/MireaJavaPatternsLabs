package tasks23_24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tasks23_24.objects.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByAddressText(String addressText);

    List<Address> findAllByZipCode(String zipCode);
}
