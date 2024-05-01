package task18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task18.objects.Address;
import task18.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public List<Address> getAddressesByAddressText(String addressText) {
        return addressRepository.findAllByAddressText(addressText);
    }

    public List<Address> getAddressesByZipCode(String zipCode) {
        return addressRepository.findAllByZipCode(zipCode);
    }
}
