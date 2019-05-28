package lk.ijse.pos.business.custom;

import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {

    public List<ItemDTO> getAllItems() throws Exception;

    public boolean saveItem(ItemDTO item) throws Exception;

    public boolean updateItem(ItemDTO item)throws Exception;

    public boolean deleteItem(String code) throws Exception;

}
