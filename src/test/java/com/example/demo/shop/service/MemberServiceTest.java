package com.example.demo.shop.service;

import com.example.demo.shop.domain.Member;
import com.example.demo.shop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrew Han
 * @since 2019-10-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {

        // given
        Member member = new Member();
        member.setName("andrew");

        // when
        Long saveId = memberService.join(member);

        // then
        Assert.assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복회원_예외() {

        //given
        Member member1 = new Member();
        member1.setName("andrew");

        Member member2 = new Member();
        member2.setName("andrew");


        // when
        memberService.join(member1);
        memberService.join(member2); // 예외 발생 지점

        // then
        Assert.fail("예외가 발생해야 한다");

    }
}