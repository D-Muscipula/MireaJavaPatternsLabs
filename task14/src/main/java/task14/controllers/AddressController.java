package task14.controllers;

import org.springframework.web.bind.annotation.*;
import task14.objects.Address;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

    private final List<Address> addressList = new ArrayList<>();

    @PostMapping("/addresses")
    public void createAddress(@RequestBody Address address) {
        addressList.add(address);
    }
/*
{
        "addressText": "Rand Avenue",
        "zipCode": "123"
    }
 */
    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressList;
    }

    @DeleteMapping("/addresses/{index}")
    public void deleteAddress(@PathVariable("index") int index) {
        System.out.println(index);
        if (index >= 0 && index < addressList.size()) {
            addressList.remove(index);
        }
    }
}

