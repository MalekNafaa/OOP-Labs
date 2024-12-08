package DatabaseConnectionTesting;

import java.sql.*;

public class DatabaseConnectionTesting {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/final";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Malek20167";

    private Connection connection = null;

    public  DatabaseConnectionTesting() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllFromTable(String tableName) throws SQLException {
        PreparedStatement st = this.connection.prepareStatement("Select * from " + tableName);
        //st.setString(1,tableName);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("description"));
        }
    }

    public void getbyId(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM md_diets WHERE id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getString("id") + " ");
            System.out.print(rs.getString("name") + " ");
            System.out.print(rs.getString("description") + " ");
        }

    }
}