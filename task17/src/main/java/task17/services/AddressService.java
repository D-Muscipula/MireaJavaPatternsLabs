package task17.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import task17.objects.Address;

import java.util.Collections;
import java.util.List;

@Service
public class AddressService {
    private final SessionFactory sessionFactory;

    public AddressService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAddress(Address address) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(address);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAddress(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Address address = session.get(Address.class, id);
            if (address != null) {
                session.remove(address);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Address> getAddresses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select a from Address a", Address.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Address> getAddressesByAddressText(String addressText) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Address> query = builder.createQuery(Address.class);
            Root<Address> root = query.from(Address.class);
            query.select(root).where(builder.equal(root.get("addressText"), addressText));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Address> getAddressesByZipCode(String zipCode) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Address> query = builder.createQuery(Address.class);
            Root<Address> root = query.from(Address.class);
            query.select(root).where(builder.equal(root.get("zipCode"), zipCode));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
