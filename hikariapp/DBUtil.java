package hikariapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {

    private static final String USERNAME = "db.username";
    private static final String PASSWORD = "db.password";
    private static final String DATABASE_URL = "db.url";
    private static final String JDBC_DRIVER = "driver.class.name";

    private static Properties properties = null;
    private static HikariDataSource dataSource=null;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/hikariapp/databaseprops.properties"));

            dataSource = new HikariDataSource();
            dataSource.setDriverClassName(properties.getProperty(JDBC_DRIVER));

            dataSource.setJdbcUrl(properties.getProperty(DATABASE_URL));
            dataSource.setUsername(properties.getProperty(USERNAME));
            dataSource.setPassword(properties.getProperty(PASSWORD));

            dataSource.setMinimumIdle(100);
            dataSource.setMaximumPoolSize(500);
            dataSource.setAutoCommit(false);
            dataSource.setLoginTimeout(3);

        } catch (IOException | SQLException e) {
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
