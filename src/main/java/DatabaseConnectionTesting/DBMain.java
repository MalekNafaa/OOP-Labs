package DatabaseConnectionTesting;


import java.sql.SQLException;

public class DBMain {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionTesting db =new DatabaseConnectionTesting();

        String md_diets="md_diets";
        db.getAllFromTable(md_diets);


    }
}
