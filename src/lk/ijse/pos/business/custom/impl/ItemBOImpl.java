package lk.ijse.pos.business.custom.impl;

import lk.ijse.pos.business.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.DAOTypes;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOTypes.ITEM);

    public List<ItemDTO> getAllItems() throws Exception {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            itemDAO.setSession(session);
            List<ItemDTO> collect = itemDAO.findAll().stream().map(item -> new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand())).collect(Collectors.toList());
            session.getTransaction().commit();
            return collect;
        }
        //        itemDAO.findAll().stream().map(new Function<Item, ItemDTO>() {
//            @Override
//            public ItemDTO apply(Item item) {
//                return new ItemDTO(item.getCode(), item.getDescription(),item.getUnitPrice(), item.getQtyOnHand());
//            }
//        }).collect(Collectors.toList());

    }

    public boolean saveItem(ItemDTO item) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            itemDAO.setSession(session);
            itemDAO.save(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            throw ex;
        }
    }

    public boolean updateItem(ItemDTO item) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            itemDAO.setSession(session);
            itemDAO.update(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            throw ex;
        }
    }

    public boolean deleteItem(String code) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            itemDAO.setSession(session);
            itemDAO.delete(code);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            throw ex;
        }
    }

}
