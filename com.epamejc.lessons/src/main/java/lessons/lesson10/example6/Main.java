package lessons.lesson10.example6;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    
    public static void main(String[] args) {
        PGConnectionPoolDataSource dataSource = new PGConnectionPoolDataSource();
        dataSource.setDatabaseName("COURSE");
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432);
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");
        
        Statement statement;
        try (Connection connection = dataSource.getConnection()) {
            statement = connection.createStatement();
            insertData(statement);
        } catch (SQLException e) {
            System.err.println("CANT CONNECT TO DATABASE");
        }
    }
    
    private static void insertData(Statement statement) throws SQLException {
        final String DROP_TABLE = "DROP TABLE account";
        final String CREATE_TABLE = "CREATE TABLE account(\n" +
                                    "   user_id serial PRIMARY KEY,\n" +
                                    "   username VARCHAR (50) UNIQUE NOT NULL,\n" +
                                    "   password VARCHAR (50) NOT NULL,\n" +
                                    "   email VARCHAR (355) UNIQUE,\n" +
                                    "   created_on TIMESTAMP,\n" +
                                    "   last_login TIMESTAMP\n" +
                                    ");";
        final String INSERT_DATA = "INSERT INTO account(user_id, username, password)" +
                                   "VALUES(1, 'hello', '12345768')";
        
        System.out.println("DROP TABLE");
        statement.execute(DROP_TABLE);
        System.out.println("CREATE TABLE");
        statement.execute(CREATE_TABLE);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("INSERT DATA");
        statement.execute(INSERT_DATA);
    }
    
}
