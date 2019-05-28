import lk.ijse.pos.business.BOFactory;
import lk.ijse.pos.business.BOTypes;
import lk.ijse.pos.business.custom.CustomerBO;
import lk.ijse.pos.dto.CustomerDTO;

import java.util.List;

public class CustomerBOTest {

    public static void main(String[] args) throws Exception {

        CustomerBO bo = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

        List<CustomerDTO> allCustomers = bo.getAllCustomers();

        for (CustomerDTO customer : allCustomers) {
            System.out.println(customer);
        }

    }

}
