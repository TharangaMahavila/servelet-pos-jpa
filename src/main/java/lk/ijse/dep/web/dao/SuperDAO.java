package lk.ijse.dep.web.dao;

import javax.persistence.EntityManager;
import java.sql.Connection;

public interface SuperDAO {

    public abstract void setEntityManager(EntityManager entityManager) throws Exception;

}
