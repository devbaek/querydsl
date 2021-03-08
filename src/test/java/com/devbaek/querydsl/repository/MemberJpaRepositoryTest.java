package com.devbaek.querydsl.repository;

import com.devbaek.querydsl.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    void basicTest() {
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);

        Optional<Member> findMember = memberJpaRepository.findById(member.getId());
        assertThat(findMember.get().getId()).isEqualTo(member.getId());

        List<Member> result1 = memberJpaRepository.findAll();
        assertThat(result1).containsExactly(member);

        List<Member> result2 = memberJpaRepository.findByUsername("member1");
        assertThat(result2).containsExactly(member);
    }

    @Test
    void basicQueryDslTest() {
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);


        List<Member> result1 = memberJpaRepository.findAll_queryDsl();
        assertThat(result1).containsExactly(member);

        List<Member> result2 = memberJpaRepository.findByUsername_queryDsl("member1");
        assertThat(result2).containsExactly(member);
    }


}