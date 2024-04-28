import java.sql.*;

public class InsertData {
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

            // Insert
            String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f)", "Safwan", 12, 95.5);

            // Update for insert, update, delete
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Excution successful!");
            } else {
                System.out.println("Escution failed!");
            }

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}



// // prepared statement query for insertion
 
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

//             String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";

//             PreparedStatement preparedStatement = connection.prepareStatement(query);
//             preparedStatement.setString(1, "Salman");
//             preparedStatement.setInt(2, 16);
//             preparedStatement.setDouble(3, 95.5);

//             int rowsAffected = preparedStatement.executeUpdate();

//             if (rowsAffected > 0) {
//                 System.out.println("Data retrieved successfully");
//             } else {
//                 System.out.println("Failed to retrieve data");
//             }

//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }
//     }
// }
