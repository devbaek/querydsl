package com.devbaek.querydsl.controller;

import com.devbaek.querydsl.dto.MemberSearchCondition;
import com.devbaek.querydsl.dto.MemberTeamDto;
import com.devbaek.querydsl.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberContorller {

    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberJpaRepository.searchMember(condition);
    }
}
