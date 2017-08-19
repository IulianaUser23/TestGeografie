package Iuli.Quizz.Invatare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IulianaUser23 on 03.08.2017.
 */
public class AccesDB {

    public List <TaraContinent> listaCompleta() {
        //se conecteaza la baza de date si returneaza lista de tari si capitale
        List<TaraContinent> listaDinDB = new ArrayList();

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
            ResultSet rs = st.executeQuery("SELECT * FROM tara\n" +
                    "inner join continent on tara.idt = continent.idc\n");

            while (rs.next()) {
                TaraContinent geografie = new TaraContinent();
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

    public List<TaraContinent> listaPartiala(int continent) {
        List<TaraContinent> listaPartialaDB = new ArrayList();

        try {
            Class.forName("org.postgresql.Driver");
            final String URL = "jdbc:postgresql://54.93.65.5:5432/6IulianaUser23";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String listaContinente = "SELECT * FROM tara INNER JOIN continent ON tara.idt = continent.idc " +
                    "WHERE idc = ?";
            PreparedStatement st = conn.prepareStatement(listaContinente);
            st.setInt(1, continent);

            ResultSet ps = st.executeQuery();
            while (ps.next()) {
                TaraContinent listContinent = new TaraContinent();
                listContinent.setId(ps.getInt("id"));
                listContinent.setNumeTara(ps.getString("numetara"));
                listContinent.setCapitala(ps.getString("capitala"));
                listaPartialaDB.add(listContinent);}

            ps.close();
            st.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPartialaDB;
    }

    public List <TaraContinent> listaRaspunsuri() {

        List<TaraContinent> listaCuRaspunsuri = new ArrayList();

        try {
            Class.forName("org.postgresql.Driver");
            final String URL = "jdbc:postgresql://54.93.65.5:5432/6IulianaUser23";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT id, numetara, capitala FROM tara ORDER BY RANDOM() LIMIT 30");

            while (rs.next()) {
                TaraContinent raspunsuri = new TaraContinent();
                raspunsuri.setId(rs.getInt("id"));
                raspunsuri.setCapitala(rs.getString("capitala"));
                raspunsuri.setNumeTara(rs.getString("numetara"));
                listaCuRaspunsuri.add(raspunsuri);
            }
            rs.close();
            st.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCuRaspunsuri;
    }
  }
