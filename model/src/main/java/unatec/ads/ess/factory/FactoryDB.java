/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.factory;

/**
 *
 * @author emilianoeloi
 */
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/**
 *
 * @author vilmar
 */
public class FactoryDB {
   
    private static ConnectionSource connectionSource = null;
    private static String databaseUrl = "jdbc:mysql://localhost:3306/essdev";
    private static String userdb = "essuser";
    private static String passworddb = "essuser1";

    private FactoryDB(){

    }
    
    public synchronized static ConnectionSource getInstance() throws SQLException{
        if(connectionSource == null){
            connectionSource = new JdbcConnectionSource(databaseUrl);
            ((JdbcConnectionSource) connectionSource).setUsername(userdb);
            ((JdbcConnectionSource) connectionSource).setPassword(passworddb);
        }
        
        return connectionSource;
    }
}