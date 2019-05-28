import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.DAOTypes;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.QueryDAO;

public class QueryDAOTest {

    public static void main(String[] args) {

        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
        System.out.println(customerDAO);

        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
        System.out.println(queryDAO);

    }

}
