package lk.ijse.dep.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-01-29
 **/
public class HibernateUtil {
    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");

}
