import java.sql.*;

public class RetrieveData {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "fardin35";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Retrieve
            String query = "select * from students";

            // query for retrieve
            ResultSet resultSet = statement.executeQuery(query);

            // Print the retrieved data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("ID: " + id
                        + ", Name: " + name
                        + ", Age: " + age
                        + ", Marks: " + marks);
            }

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}

// // Prepared statement for retieval query

// import java.sql.*;

// public class CRUD_operation {
//     private static final String url = "jdbc:mysql://localhost:3306/mydb";
//     private static final String username = "root";
//     private static final String password = "fardin35";

//     public static void main(String[] args) {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//         } catch (ClassNotFoundException e) {
//             System.out.println(e.getMessage());
//         }
//         try {
//             Connection connection = DriverManager.getConnection(url, username, password);

//             String query = "SELECT marks FROM students WHERE id = ?";

//             PreparedStatement preparedStatement = connection.prepareStatement(query);
//             preparedStatement.setInt(1, 1);

//             ResultSet resultSet = preparedStatement.executeQuery();
//             if (resultSet.next()) {
//                 System.out.println("Marks: " + resultSet.getDouble("marks"));
//             } else {
//                 System.out.println("Marks not found");
//             }

//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }
//     }
// }