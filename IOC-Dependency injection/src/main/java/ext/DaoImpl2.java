package ext;

import Dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("API VERSION");
        return Math.random()*40;
    }
}
