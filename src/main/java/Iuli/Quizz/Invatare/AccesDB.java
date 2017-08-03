package Iuli.Quizz.Invatare;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.String;

/**
 * Created by IulianaUser23 on 03.08.2017.
 */
public class AccesDB {
    public List<DeInvatat> listaCompleta() {
//se conecteaza la baza de date si returneaza lista de tari si capitale
        List<DeInvatat> listaDinDB = new ArrayList();
        try {
            Class.forName("org.postgresql.Driver");
//Parametrii de conexiune la DB
            final String URL = "jdbc:postgresql://54.93.65.5:5432/6IulianaUser23";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";
//obtinere conexiune
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//declaratie
            Statement st = conn.createStatement();

//executa declaratie
            ResultSet rs = st.executeQuery("SELECT * from tara\n" +
                    "inner join continent on tara.idt = continent.idc\n");

            String item;
            while (rs.next()) {
                DeInvatat geografie = new DeInvatat();
                geografie.setId(rs.getInt("id"));
                geografie.setNumeTara(rs.getString("numetara"));
                geografie.setCapitala(rs.getString("capitala"));
                geografie.setContinent(rs.getString("numecontinent"));

                listaDinDB.add(geografie);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDinDB;
    }
}