package DatabaseConnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class getDatabase {
    public static Connection getConnection() throws Exception{
        Connection connection = null;
        try{
            FileInputStream Fis = new FileInputStream("/Users/xtemper/Documents/UserDataBaseManagement/src/main/java/DatabaseConnection/Application.properties");
            Properties properties = new Properties();
            properties.load(Fis);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("user");
            String passWord = properties.getProperty("password");
            connection = DriverManager.getConnection(url,userName,passWord);
            System.out.println("Got Connection");
        }catch (Exception e ){
            System.out.println(e);
        }
        return connection;
    }
    public static void main(String[] args) throws Exception {
        getConnection();
    }

    public static void closeConnection(Connection connection , PreparedStatement statement) throws Exception{
        if(connection !=null)
            connection.close();
        if (statement != null)
            statement.close();
    }
}
