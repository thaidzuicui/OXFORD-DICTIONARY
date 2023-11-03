package src.dcnr;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    private static String url = "jdbc:mysql://localhost:3306/dictionary";
    private static String user = "root";
    private static String password = "AcmaDentuthiendg666";

    public DataBase() {
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

//    public void init() throws SQLException {
//        connect();
//
//        ArrayList<String> targets = getAll();
//
//        for (String word : targets) {
//            Trie.insert(word);
//        }
//    }


    public ArrayList<String> getAll() throws SQLException {
        connect();

        String query = "SELECT TARGET FROM DICTIONARY.DICTIONARY ORDER BY ID";

        ArrayList<String> wordList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String word = resultSet.getString("target");
                wordList.add(word);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    public static String getDefinition(String word) throws SQLException {
        connect();

        String query = "SELECT DEFINITION FROM DICTIONARY.DICTIONARY WHERE TARGET = ?";

        String def = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, word);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                def = resultSet.getString("definition");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return def;
    }
}


