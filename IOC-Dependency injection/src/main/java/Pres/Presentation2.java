package Pres;

import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(new File("Config.txt"));
            // Dao class
            String DaoClassName = scanner.nextLine();
            Class DaoC = Class.forName(DaoClassName);
            IDao dao = (IDao) DaoC.newInstance();
            // Metier class
            String MetierClassName = scanner.nextLine();
            Class MetierC = Class.forName(MetierClassName);
            IMetier Metier = (IMetier) MetierC.newInstance();
            Method method = MetierC.getMethod("setDao",IDao.class);
            method.invoke(Metier,dao);
            System.out.println("Resultat ====> "+Metier.calcul());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}