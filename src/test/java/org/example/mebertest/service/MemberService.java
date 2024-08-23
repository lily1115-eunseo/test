package org.example.mebertest.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.mebertest.dto.MemberSaveRequestDto;
import org.example.mebertest.dto.MemberSaveResponseDto;
import org.example.mebertest.dto.MemberSimpleResponseDto;
import org.example.mebertest.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
  public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDtoDto) {
        Member newMember = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getName());

        public List<MemberSimpleResponseDto> getMembers() {
            List<Member> members = memberRepository.findAll();

            List<MemberSimpleResponseDto> memberSimpleResponseDtos = new ArrayList<>();
            for(Member member : members) {
                memberSimpleResponseDtos.add(new MemberSimpleResponseDto(member.getId(), member.getName()));
            }
            return memberSimpleResponseDtos;
        }
}
