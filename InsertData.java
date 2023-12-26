package DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertData {
    public static boolean main(String mysqlQuery) throws Exception  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getDatabase.getConnection();
        preparedStatement = connection.prepareStatement(mysqlQuery);
        if(preparedStatement != null){
            int roweffected = preparedStatement.executeUpdate();
            if(roweffected != 0) {
                getDatabase.closeConnection(connection,preparedStatement);
                return true;
            }
        }
        getDatabase.closeConnection(connection,preparedStatement);
        return false;
    }


}
