import java.sql.*;
import java.util.Scanner;

public class CRUD_operation {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "fardin35";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Statement statement = connection.createStatement();
            String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                System.out.print("Enter marks: ");
                double marks = scanner.nextDouble();
                // String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f)", name, age, marks);
                // statement.addBatch(query);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setDouble(3, marks);
                preparedStatement.addBatch();

                System.out.print("Enter more data? (Y/N): ");
                char choice = scanner.next().charAt(0);
                if (choice == 'n' || choice == 'N') {
                    break;
                }
            }
            int[] arr = preparedStatement.executeBatch();
            // if (rowsAffected > 0) {
            //     System.out.println("Data updated successfully!");
            // } else {
            //     System.out.println("Failed to update data!");
            // }

            // PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setDouble(1, 99.3);
            // preparedStatement.setInt(2, 2);

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    System.out.println("Query - " + i + ": failed to execute..!");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}