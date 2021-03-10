package com.devbaek.querydsl.repository;

import com.devbaek.querydsl.dto.MemberSearchCondition;
import com.devbaek.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> searchMember(MemberSearchCondition condition);
}
