package testgroup.javahttpwebserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * La classe  che gestisce la connessione al database
 * @author Ginevra Lavacchi
 */
public class InterrogazioneDB {
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private String url_db="jdbc:mysql://localhost:3306/scuolaMio?serverTimezone=Europe/Rome";
    private String query;
    private Connection conn;
    private ResultSet result;
    public InterrogazioneDB() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        conn=DriverManager.getConnection(url_db, "root", "root");
    }
    public void setQuery(String q){
        if(q.toUpperCase().startsWith("SELECT")){
            query=q;
        }
        else{
            query="select \"Formato della Query non valido\";";
        }
        if(!query.endsWith(";")){
            query+=";";
        }
    }
    public ResultSet eseguiQuery() throws SQLException{
        Statement stat=conn.createStatement();
        result=stat.executeQuery(query);
        return result;
    }
    public ResultSet eseguiQuery(String q) throws SQLException{
        setQuery(q);
        Statement stat=conn.createStatement();
        result=stat.executeQuery(query);
        return result;
    }
    public void chiudi() throws SQLException{
        conn.close();
    }

    public void setUrl_db(String url_db) {
        this.url_db = url_db;//inserire match regexp
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public String getUrl_db() {
        return url_db;
    }

    public String getQuery() {
        return query;
    }

    public Connection getConn() {
        return conn;
    }

    public ResultSet getResult() {
        return result;
    }
}
