package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");// 애플리케이션 로딩시점 딱 한번 만들어줌

        EntityManager em = emf.createEntityManager();// 일괄적인 행동을 할때마다 만들어 줘여함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");

            team.getMembers().add(member);

            tx.commit();
        } catch (Exception e) {

            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
