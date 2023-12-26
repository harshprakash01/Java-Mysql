package DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteAUser {
    static Connection connection = null;
    static PreparedStatement statement  = null;
    static int rowefected = 0;
    public static boolean delUser(int val) {
        try {
            String query = "DELETE FROM userLoginDetails WHERE userId= ?";
            connection = getDatabase.getConnection();
            statement = connection.prepareStatement(query);
            if(statement != null){
                statement.setInt(1,val);
                 rowefected = statement.executeUpdate();

            }
        }
        catch (Exception e ){System.out.println(e);}
        finally {
            try {getDatabase.closeConnection(connection,statement);
            if(rowefected == 1)
            return true;}
            catch (Exception e) {throw new RuntimeException(e);}
        }
        return false;
    }
}
