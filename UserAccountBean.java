package IHM;

import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;


public class UserAccountBean {

//jar du connector mysql a connecter sur le site de mysql et à importer le package dans le classpath
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//Url de notre base
    static final String DB_URL = "jdbc:mysql://localhost:3306/ludo?autoReconnect=true&useSSL=false";
//Username pour acceder à la base
    static final String DB_USER = "ludo";
//mot de passe
    static final String DB_PASSWORD = "mdp";
//objet d'accés à la base
    private JdbcRowSet jdbcRowSet = null;

//Constructeur
    public UserAccountBean() throws ClassNotFoundException {
        try {
//Charger le driver
            Class.forName(JDBC_DRIVER);
            jdbcRowSet = new JdbcRowSetImpl();
            jdbcRowSet.setUrl(DB_URL);
            jdbcRowSet.setUsername(DB_USER);
            jdbcRowSet.setPassword(DB_PASSWORD);
//Charger toutes les données de la base
            jdbcRowSet.setCommand("SELECT * FROM useraccount");
            jdbcRowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//Fonction de creation d'un nouvel utilisateur
    public UserAccount create(UserAccount user) {
        try {
//deplacement a la ligne d'insertion
            jdbcRowSet.moveToInsertRow();
            jdbcRowSet.updateInt("id", user.getId());
            jdbcRowSet.updateString("ndc", user.getNdc());
            jdbcRowSet.updateString("mdp", user.getMdp());
//inserer l'enregistrement
            jdbcRowSet.insertRow();
//se deplacer sur l'enregistrement inserer
            jdbcRowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                jdbcRowSet.rollback();
                user = null;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return user;
    }

//Mise à jours d'un enregistrement
    public UserAccount update(UserAccount user) {
        try {
            jdbcRowSet.updateString("ndc", user.getNdc());
            jdbcRowSet.updateString("mdp", user.getMdp());
            jdbcRowSet.updateRow();
            jdbcRowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                jdbcRowSet.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
            e.printStackTrace();
        }
        return user;
    }

//supression d'un enregistrement
    public void delete() {
        try {
            jdbcRowSet.moveToCurrentRow();
            jdbcRowSet.deleteRow();
        } catch (SQLException e) {
            try {
                jdbcRowSet.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

//deplacement sur le premier enregistrement
    public UserAccount moveFirst() {
        UserAccount user = new UserAccount();
        try {
            jdbcRowSet.first();
            user.setId(jdbcRowSet.getInt("id"));
            user.setNdc(jdbcRowSet.getString("nom de compte"));
            user.setMdp(jdbcRowSet.getString("mot de passe"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

//deplacement sur le dernier enregistrement
    public UserAccount moveLast() {
        UserAccount user = new UserAccount();
        try {
            jdbcRowSet.last();
            user.setId(jdbcRowSet.getInt("id"));
            user.setNdc(jdbcRowSet.getString("nom de compte"));
            user.setMdp(jdbcRowSet.getString("mot de passe"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

//deplacement sur l'enregistrement suivant
    public UserAccount moveNext() {
        UserAccount user = new UserAccount();
        try {
            if (jdbcRowSet.next() == false) {
                jdbcRowSet.previous();
            }
            user.setId(jdbcRowSet.getInt("id"));
            user.setNdc(jdbcRowSet.getString("nom de compte"));
            user.setMdp(jdbcRowSet.getString("mot de passe"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

//deplacement sur l'enregistrement precedent
    public UserAccount movePrevious() {
        UserAccount user = new UserAccount();
        try {
            if (jdbcRowSet.previous() == false) {
                jdbcRowSet.next();
            }
            user.setId(jdbcRowSet.getInt("id"));
            user.setNdc(jdbcRowSet.getString("nom de compte"));
            user.setMdp(jdbcRowSet.getString("mot de passe"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

//charger les informations de l'enregistrement courant
    public UserAccount getCurrent() {
        UserAccount user = new UserAccount();
        try {
            jdbcRowSet.moveToCurrentRow();
            user.setId(jdbcRowSet.getInt("id"));
            user.setNdc(jdbcRowSet.getString("nom de compte"));
            user.setMdp(jdbcRowSet.getString("mot de passe"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
