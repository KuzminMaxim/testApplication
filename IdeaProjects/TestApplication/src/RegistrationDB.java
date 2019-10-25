import java.sql.*;
import java.util.ArrayList;

public class RegistrationDB {

    private static String url = "jdbc:mysql://localhost:3307/project?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "********";

    public static ArrayList<Registration> select() {

        ArrayList<Registration> User = new ArrayList<Registration>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT name, login, password FROM user");
                while(resultSet.next()){

                    String name = resultSet.getString(1);
                    String login = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    Registration user = new Registration(name, login, password);
                    User.add(user);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return User;
    }
    public static Registration selectOne(int id) {

        Registration reg = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM user WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int userId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String login = resultSet.getString(3);
                        String password = resultSet.getString(4);
                        reg = new Registration(userId, name, login, password);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return reg;
    }
    public static int insert(Registration reg) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO user (name, login, password) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, reg.getName());
                    preparedStatement.setString(2, reg.getLogin());
                    preparedStatement.setString(3, reg.getPassword());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
