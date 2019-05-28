package lk.ijse.pos.dao;

import lk.ijse.pos.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudDAOImpl<T extends SuperEntity, ID extends Serializable> implements CrudDAO<T,ID>{

    protected Session session;
    private Class<T> entity;


    public CrudDAOImpl(){
        entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(T entity) throws Exception {
        session.save(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        session.merge(entity);
    }

    @Override
    public void delete(ID entityId) throws Exception {
        session.delete(session.load(entity, entityId));
    }

    @Override
    public List<T> findAll() throws Exception {
        return session.createQuery("FROM " + entity.getName()).list();
    }

    @Override
    public T find(ID entityId) throws Exception {
        return session.find(entity,entityId);
    }
}
