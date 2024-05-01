package task15.services;

import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import task15.objects.Building;

import java.util.List;

@Service
public class BuildingService {
    private final SessionFactory sessionFactory;
    private Session session;

    public BuildingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public void addBuilding(Building building) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(building);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteBuilding(Long id) {
        Transaction transaction = session.beginTransaction();
        try {
            Building building = session.get(Building.class, id);
            if (building == null) {
                transaction.commit();
                return;
            }
            session.remove(building);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<Building> getBuildings() {
        return session.createQuery("select a from Building a", Building.class).getResultList();
    }
}
