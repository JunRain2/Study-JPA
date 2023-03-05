package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");// 애플리케이션 로딩시점 딱 한번 만들어줌

        EntityManager em = emf.createEntityManager();// 일괄적인 행동을 할때마다 만들어 줘여함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("A");

            Member member1 = new Member();
            member1.setUsername("B");

            Member member2 = new Member();
            member2.setUsername("C");

            em.persist(member);
            em.persist(member1);
            em.persist(member2);

            tx.commit();
        } catch (Exception e) {

            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
