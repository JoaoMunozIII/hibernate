import models.MainEntityModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DAO {
    static final Session session = Hibernate.getSessionFactory().openSession();

    public static void saveEntityDb(List<MainEntityModel> entityList){
        Transaction tx=null;
        try {
            if (session.isConnected()) {
                tx = session.beginTransaction();
                for (MainEntityModel entity : entityList) {
                    session.saveOrUpdate(entity);
                }
                session.flush();
                tx.commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
    }

    public static List<MainEntityModel> getEntityDb(){
        Session session = Hibernate.getSessionFactory().openSession();
        List<MainEntityModel> entityModel = session.createQuery("from MainEntityModel").list();
        session.close();
        return entityModel;
    }
}
