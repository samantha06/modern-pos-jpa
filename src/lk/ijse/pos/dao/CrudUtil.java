package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudUtil {

    public static <T> T execute(String sql, Object... params ) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1,params[i]);
        }

        return (sql.trim().startsWith("SELECT")) ?  (T) pstm.executeQuery(): (T) (Boolean)(pstm.executeUpdate()>0);
    }

}
