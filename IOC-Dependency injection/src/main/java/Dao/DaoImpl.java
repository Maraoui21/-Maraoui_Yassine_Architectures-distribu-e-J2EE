package Dao;

import org.springframework.stereotype.Component;

@Component("dao1")
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("Database version");
        return Math.random()*40;
    }
}
