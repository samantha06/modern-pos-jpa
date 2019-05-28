import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtilTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Customer c001 = session.get(Customer.class, "C001");

        System.out.println(c001);

        session.close();
        sessionFactory.close();

    }

}
