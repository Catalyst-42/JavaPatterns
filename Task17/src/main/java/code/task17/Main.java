package code.task17;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class Main {
    // CriteriaApi
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Task17");
    public static EntityManager em = emf.createEntityManager();
    public static CriteriaBuilder builder = em.getCriteriaBuilder();

    public static <T> List<T> getSorted(Class<T> objectClass, String attribute, boolean asc) {
        em.getTransaction().begin();
        CriteriaQuery<T> CriteriaQuery = builder.createQuery(objectClass);
        Root<T> root = CriteriaQuery.from(objectClass);
        
        if (asc) {
            CriteriaQuery.select(root).orderBy(builder.asc(root.get(attribute)));
        } else {
            CriteriaQuery.select(root).orderBy(builder.desc(root.get(attribute)));
        }
        
        List<T> results = em.createQuery(CriteriaQuery).getResultList();
        em.getTransaction().commit();
        
        return results;
    }

    public static void main(String[] args) {
        System.out.println(
            "\033[32m" +
            "Carts, sorted by name (asc): " +
            getSorted(Cart.class, "name", true) +
            "\033[0m"
        );
        
        System.out.println(
            "\033[32m" +
            "Carts, sorted by id (asc): " +
            getSorted(Cart.class, "id", true) +
            "\033[0m"
        );

        System.out.println(
            "\033[32m" +
            "Items, sorted by id (desc): " +
            getSorted(Item.class, "id", false) +
            "\033[0m"
        );

        em.close();
        emf.close();
    }
}
