package com.example.demo.shop.repository;

import com.example.demo.shop.domain.Member;
import com.example.demo.shop.domain.Order;
import com.example.demo.shop.domain.OrderSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew Han
 * @since 2019-10-05
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /*@PersistenceContext
    EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }*/

    /*public Order findOne(Long id) {
        return em.find(Order.class, id);
    }*/


    /*public List<Order> findAll(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);

        List<Predicate> criteria = new ArrayList<>();

        // 주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = cb.equal(o.get("status"), orderSearch.getOrderStatus());
            criteria.add(status);
        }

        // 회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            Join<Order, Member> m = o.join("member", JoinType.INNER);
            Predicate name = cb.like(m.get("name"), "%" +
                    orderSearch.getMemberName() + "%"
            );
            criteria.add(name);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }*/

    @Query("select o from Order o ")
    List<Order> findAll(OrderSearch orderSearch);
}
