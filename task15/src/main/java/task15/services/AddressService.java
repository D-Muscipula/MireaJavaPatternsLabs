package task15.services;

import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import task15.objects.Address;

import java.util.List;

@Service
public class AddressService {
    private final SessionFactory sessionFactory;
    private Session session;

    public AddressService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public void addAddress(Address address) {
        var transaction = session.beginTransaction();
        try {
            session.persist(address);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteAddress(Long id) {
        var transaction = session.beginTransaction();
        try {
           Address address = session.get(Address.class, id);
            if (address == null) {
                transaction.commit();
                return;
            }
            session.remove(address);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<Address> getAddresses() {
        return session.createQuery("select a from Address a", Address.class).getResultList();
    }
}
