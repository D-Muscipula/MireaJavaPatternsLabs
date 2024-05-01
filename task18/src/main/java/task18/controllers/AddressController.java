package task18.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task18.objects.Address;
import task18.services.AddressService;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping("/addresses")
    public void createAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }
/*
{
        "addressText": "Rand Avenue",
        "zipCode": "123"
    }
 */
    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressService.getAddresses();
    }

    @DeleteMapping("/addresses/{index}")
    public void deleteAddress(@PathVariable("index") long index) {
        addressService.deleteAddress(index);
    }

    @GetMapping("/addresses/by-address-text")
    public List<Address> getAddressesByAddressText(@RequestParam("addressText") String addressText) {
        return addressService.getAddressesByAddressText(addressText);
    }

    @GetMapping("/addresses/by-zip-code")
    public List<Address> getAddressesByZipCode(@RequestParam("zipCode") String zipCode) {
        return addressService.getAddressesByZipCode(zipCode);
    }

}

