package DatabaseConnection;

import java.sql.*;

public class ReadData  {
    static Connection con = null;
    static Statement st = null;
    public static ResultSet Read(String sql) throws Exception {
        Connection con = getDatabase.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public static void main(String[] args) throws SQLException {
        try {
            ResultSet rs = Read("Select * from userLoginDetails");
            while (rs.next()){
                int id = rs.getInt("userId");
                String book = rs.getString("userName");
                String author = rs.getString("userPassword");
                System.out.format("%s, %s, %s", id, book, author);
                System.out.println();
                rs.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            con.close();
            st.close();

        }
    }
}
