import entities.Info;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moles on 03.10.2016.
 *
 */
public class Runner {
    public static void main(String [] args)
    {
        List<Info> infoList;
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("postgres");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        //entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT e FROM Info e ");
        infoList=new ArrayList<Info>(query.getResultList());
        //entityManager.getTransaction().commit();
        entityManager.close();
        for (Info info:infoList){
            System.out.println(info.toString());
        }
    }
}
