import java.sql.*;
import java.util.ArrayList;

public class SendMessageDB {

    private static String url = "jdbc:mysql://localhost:3307/project?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "********";

    public static ArrayList<SendMessage> select() {

        ArrayList<SendMessage> mess = new ArrayList<SendMessage>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT message FROM messagetable ORDER BY RAND()" +
                        "LIMIT 1");
                while(resultSet.next()){

                    String message = resultSet.getString(1);
                    SendMessage mes = new SendMessage(message);
                    mess.add(mes);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return mess;
    }

    public static int insert(SendMessage message) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO messagetable (message) Values (?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, message.getMessage());

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
