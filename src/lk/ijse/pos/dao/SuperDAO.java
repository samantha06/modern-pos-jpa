package lk.ijse.pos.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;

public interface SuperDAO {

    public void setEntityManager(EntityManager entityManager);

}
