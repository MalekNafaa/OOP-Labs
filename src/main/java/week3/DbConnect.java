package week3;

import java.sql.*;
// POOR UNDERSTANDING BY MY SIDE // STUDY IT MORE
public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Malek20167";

    private Connection connection;

    public static void main(String[] args) throws SQLException {
        DbConnect db = new DbConnect();
        try {
//            db.getTasksById(1);
            db.updateTaskNameById(6,"sadg");
            db.getAllTasks();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getAllTasks() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM tasks"
        );
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getString("id") + " ");
            System.out.print(rs.getString("task_description")+ " ");
            System.out.print(rs.getString("task_status")+ " ");
            System.out.println();
        }
    }
    public void getTasksById(int taskId) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM tasks WHERE id = ?"
        );

        statement.setInt(1, taskId);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getString("id") + " ");
            System.out.print(rs.getString("task_description")+ " ");
            System.out.print(rs.getString("task_status")+ " ");
            System.out.println();
        }
    }
    public void updateTaskNameById(int taskId, String newName) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE tasks SET task_description = ? WHERE id = ?"
        );

        statement.setInt(2, taskId);
        statement.setString(1, newName);

        statement.executeUpdate();
    }
    public void insertTask(int taskId, String taskDes, String taskStatus) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO `tasks` VALUES (?,?,?)"
        );

        statement.setInt(1, taskId);
        statement.setString(2, taskDes);
        statement.setString(3, taskStatus);

        int rowsAffected = statement.executeUpdate();
        System.out.println("Inserted " + rowsAffected + " row(s) successfully.");

    }

}
