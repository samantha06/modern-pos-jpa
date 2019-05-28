import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;

public class CustomerDAOTest {

    public static void main(String[] args) throws Exception {

//        CustomerDAO dao = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
        CustomerDAO dao = new CustomerDAOImpl();
        System.out.println(dao);

        int count = dao.count();

        System.out.println(count);

    }

}
