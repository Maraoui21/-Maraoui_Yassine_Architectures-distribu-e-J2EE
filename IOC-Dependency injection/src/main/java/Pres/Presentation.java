package Pres;

import Dao.DaoImpl;
import Metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("Resultats = "+metier.calcul());
    }
}
