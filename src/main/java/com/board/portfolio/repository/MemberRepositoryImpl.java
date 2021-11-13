package com.board.portfolio.repository;

import com.board.portfolio.domain.Member;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public Member findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email",Member.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<Member> AllMember() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
