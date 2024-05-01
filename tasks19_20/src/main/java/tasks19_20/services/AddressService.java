package tasks19_20.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks19_20.objects.Address;
import tasks19_20.repository.AddressRepository;

import java.util.List;

@Service
@Slf4j
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(Address address) {
        log.info("add address" + address);
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
