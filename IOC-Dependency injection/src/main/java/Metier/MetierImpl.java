package Metier;

import Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    @Autowired
    @Qualifier("dao2")
    private IDao dao;
    @Override
    public double calcul() {
        double tmp = dao.getData();
        return tmp*540/Math.cos(tmp*Math.PI);
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
//    public MetierImpl(IDao dao){
//        this.dao=dao;
//    }
}
