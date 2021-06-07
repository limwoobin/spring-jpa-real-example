package jpabook.jpashop.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {
    private final EntityManager em;

    public Test findTest(Long id) {
        return em.createQuery("select t From Test t where id = :id" , Test.class)
                .setParameter("id" , id)
                .getSingleResult();
    }

    public List<Test> findAll() {
        return em.createQuery("select t From Test t" , Test.class)
                .getResultList();
    }

    public void save(Test test) {
        em.persist(test);
    }
}
