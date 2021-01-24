package testgroup.javahttpwebserver;

import java.util.ArrayList;

/**
 * La classe che contiene i nominativi
 * @author Ginevra Lavacchi
 */
public class Elenco {
    private ArrayList<Nominativo> nominativi;

    public Elenco(ArrayList<Nominativo> n) {
        nominativi=n;
    }

    public ArrayList<Nominativo> getNominativi() {
        return nominativi;
    }

    public void setNominativi(ArrayList<Nominativo> nominativi) {
        this.nominativi = nominativi;
    }
    
}
