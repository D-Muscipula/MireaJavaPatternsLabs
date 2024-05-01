package task15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task15.objects.Address;
import task15.services.AddressService;

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
        System.out.println(index);
        addressService.deleteAddress(index);
    }
}

