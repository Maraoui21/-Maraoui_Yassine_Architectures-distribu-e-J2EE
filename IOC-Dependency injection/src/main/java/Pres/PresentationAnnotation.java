package Pres;

import Metier.IMetier;
import org.springframework.cache.annotation.SpringCacheAnnotationParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationAnnotation {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("Dao","Metier","ext");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
