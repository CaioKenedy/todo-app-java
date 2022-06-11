

package main;

import java.sql.Connection;
import util.ConnectionFactory;


/**
 
 * @author caiok
 */
public class App {

    public static void main(String[] args) {
        
        Connection c = ConnectionFactory.getConnection();
    }
}
