package tasks21.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tasks21.objects.Address;
import tasks21.repository.AddressRepository;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final EmailService emailService;

    public void addAddress(Address address) {
        log.info("add address" + address);
        emailService.sendEmail("temp_s_r@mail.ru", "add address", address.toString());
        addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        log.info("delete address" + id);
        addressRepository.deleteById(id);
    }

    public List<Address> getAddresses() {
        log.info("get addresses");
        return addressRepository.findAll();
    }

    public List<Address> getAddressesByAddressText(String addressText) {
        log.info("get address by address text " + addressText);
        return addressRepository.findAllByAddressText(addressText);
    }

    public List<Address> getAddressesByZipCode(String zipCode) {
        log.info("get address by zip code " + zipCode);
        return addressRepository.findAllByZipCode(zipCode);
    }
}
