package task16.services;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import task16.objects.Address;
import task16.objects.Building;
import task16.objects.BuildingDTO;

import java.util.Date;
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

    public void addBuilding(BuildingDTO building) {
        Transaction transaction = session.beginTransaction();
        try {
            Address address = session.get(Address.class, building.getAddressId());
            Building building1 = new Building();
            building1.setCreationDate(building.getCreationDate());
            building1.setAddress(address);
            building1.setType(building.getType());
            session.persist(building1);
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

    public Address getAddressByBuilding(Long buildingId) {
        return session.createQuery("from Building where id =:id", Building.class)
                .setParameter("id",buildingId)
                .getSingleResult().getAddress();
    }
    public List<Building> getBuildings() {
        return session.createQuery("select a from Building a", Building.class).getResultList();
    }

    public List<Building> getBuildingsByCreationDate(Date creationDate) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Building> query = builder.createQuery(Building.class);
            Root<Building> root = query.from(Building.class);
            query.select(root).where(builder.equal(root.get("creationDate"), creationDate.getTime()));
            return session.createQuery(query).getResultList();

    }

    public List<Building> getBuildingsByType(String type) {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> query = builder.createQuery(Building.class);
        Root<Building> root = query.from(Building.class);
        query.select(root).where(builder.equal(root.get("type"), type));
        return session.createQuery(query).getResultList();
    }

}
