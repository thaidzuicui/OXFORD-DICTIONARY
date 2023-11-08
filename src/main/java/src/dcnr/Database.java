package src.dcnr;

import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static String url = "jdbc:mysql://localhost:3306/dictionary";
    private static String user = "root";
    private static String password = "123456789";

    public Database() throws SQLException {
        connect();

        ArrayList<Pair<String, String>> targets = getAll();

        for (Pair<String, String> word : targets) {
            Trie.insert(word.getKey(), word.getValue());
        }
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public ArrayList<Pair<String, String>> getAll() throws SQLException {
        connect();

        String query = "SELECT TARGET,DEFINITION FROM DICTIONARY.DICTIONARY";
        ArrayList<Pair<String, String>> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String word = resultSet.getString("target");
                String definition = resultSet.getString("definition");
                list.add(new Pair<>(word, definition));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getDefinition(String word) throws SQLException {
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


