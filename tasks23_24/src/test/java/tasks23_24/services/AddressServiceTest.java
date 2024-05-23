package tasks23_24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tasks23_24.objects.Address;
import tasks23_24.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
class AddressServiceTest {


        @Mock
        private AddressRepository addressRepository;

        @Mock
        private EmailService emailService;

        private AddressService addressService;

        @BeforeEach
        void setUp() {
            addressService = new AddressService(addressRepository, emailService);
        }

        @Test
        void addAddress() {
            Address address = new Address();
            address.setAddressText("123 Main St");
            address.setZipCode("12345");

            addressService.addAddress(address);

            Mockito.verify(emailService).sendEmail("temp_s_r@mail.ru", "add address", address.toString());
            Mockito.verify(addressRepository).save(address);
        }

        @Test
        void deleteAddress() {
            Long addressId = 1L;

            addressService.deleteAddress(addressId);

            Mockito.verify(addressRepository).deleteById(addressId);
        }

        @Test
        void getAddresses() {
            List<Address> addresses = new ArrayList<>();
            Address address1 = new Address();
            address1.setAddressText("123 Main St");
            address1.setZipCode("12345");
            Address address2 = new Address();
            address2.setAddressText("456 Elm St");
            address2.setZipCode("67890");
            addresses.add(address1);
            addresses.add(address2);

            Mockito.when(addressRepository.findAll()).thenReturn(addresses);

            List<Address> result = addressService.getAddresses();

            Assertions.assertEquals(addresses.size(), result.size());
            Assertions.assertEquals(addresses.get(0).getAddressText(), result.get(0).getAddressText());
            Assertions.assertEquals(addresses.get(1).getZipCode(), result.get(1).getZipCode());
        }

        @Test
        void getAddressesByAddressText() {
            String addressText = "123 Main St";
            List<Address> addresses = new ArrayList<>();
            Address address = new Address();
            address.setAddressText(addressText);
            address.setZipCode("12345");
            addresses.add(address);

            Mockito.when(addressRepository.findAllByAddressText(addressText)).thenReturn(addresses);

            List<Address> result = addressService.getAddressesByAddressText(addressText);

            Assertions.assertEquals(addresses.size(), result.size());
            Assertions.assertEquals(addresses.getFirst().getZipCode(), result.getFirst().getZipCode());
        }

        @Test
        void getAddressesByZipCode() {
            String zipCode = "12345";
            List<Address> addresses = new ArrayList<>();
            Address address = new Address();
            address.setAddressText("123 Main St");
            address.setZipCode(zipCode);
            addresses.add(address);

            Mockito.when(addressRepository.findAllByZipCode(zipCode)).thenReturn(addresses);

            List<Address> result = addressService.getAddressesByZipCode(zipCode);

            Assertions.assertEquals(addresses.size(), result.size());
            Assertions.assertEquals(addresses.getFirst().getAddressText(), result.getFirst().getAddressText());
        }
}
