package integrasjonsTest;

import database.DBKey;
import database.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class DBTest {
    private static Connection connection;
    private static Database database;


    public static void DBConnection() throws Exception{
        DBKey key = new DBKey();
        database = new Database (key);
        connection = database.startDatabase();

    }

    @BeforeAll
    public static void setUpDBC() throws Exception{
        DBConnection();
    }
    @AfterAll
    public static void demolish() throws Exception{
        database.avsluttDB();
    }

    


    public ArrayList<String> hentKolonnerDB() throws Exception {
        ArrayList<String> kolonneListe = new ArrayList<>();
        Statement statement = connection.createStatement();

        ResultSet kolonneReultatDB = statement.executeQuery("SELECT DISTINCT COLUMN_NAME \n" +
                "FROM information_schema.columns\n" +
                "where TABLE_NAME in ('rute', 'kjoretoy', 'stoppested', 'stoppested_has_rute');");
        while (kolonneReultatDB.next()){
            kolonneListe.add(kolonneReultatDB.getString(1));
        }
        return  kolonneListe;


    }

    public ArrayList<String> hentTabellerDB() throws Exception{
        ResultSet tabeller;
        ArrayList<String> tabellListe = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            tabeller = statement.executeQuery("show tables from se");
        }catch (SQLException e){
            throw new Exception(e.getMessage());
        }
        while(tabeller.next()){
            String tabell = tabeller.getString(1);
            tabellListe.add(tabell);

        }
        return tabellListe;
    }

    @Test
    public void tilkoblingTest() throws Exception{
        Boolean ConnectionNotNullchecker = (connection != null);
        Assertions.assertTrue(ConnectionNotNullchecker);

    }

    @Test
    public void strukturDBTest() throws Exception{
        ArrayList<String> kolonner = hentKolonnerDB();
        ArrayList<String> tabeller = hentTabellerDB();



        ArrayList<String> tabellSjekk = new ArrayList<>(Arrays.asList("kjoretoy", "rute", "stoppested", "stoppested_has_rute", "rute_view"));
        ArrayList<String> kolonneSjekk = new ArrayList<>(Arrays.asList("kjoretoy_id", "kjoretoy_navn", "stoppested_id", "rekkefolge", "rute_id", "rute_navn", "rute", "sted_navn"));

        //Sjekker tabller
        for(int i = 0; i <5; i++){
            String sjekkTabellNavn = tabellSjekk.get(i);
            Boolean tabellerInnneholder = tabeller.contains(sjekkTabellNavn);
            Assertions.assertTrue(tabellerInnneholder);
        }
        //Sjekker kolonner
        for(int i = 0; i <5; i++){
            String sjekkKolonneNavn = kolonneSjekk.get(i);
            Boolean kolonnerInnneholder = kolonner.contains(sjekkKolonneNavn);
            Assertions.assertTrue(kolonnerInnneholder);
        }


    }






}
