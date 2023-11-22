package com.example.demo4.member.Service;

import com.example.demo4.member.Dto.MemberPostDto;
import com.example.demo4.member.Dto.MemberResponseDto;
import com.example.demo4.member.Repository.MemberRepository;
import com.example.demo4.member.entity.Member;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

//    @PostConstruct
//    public void post(){
//        Member member = new Member();
//        member.setAddress("Seoul");
//        member.setName("hong gildong");
//        memberRepository.save(member);
//
//    }

    public MemberResponseDto post(MemberPostDto memberPostDto) {

        Member member = new Member();
        member.setName(memberPostDto.getName());
        member.setAddress(memberPostDto.getAddress());
        return toResponseDto(member);

    }

    public MemberResponseDto toResponseDto(Member member){
        return new MemberResponseDto(member.getMemberId(), member.getName(), member.getAddress());
    }


    public MemberResponseDto get(Long memberId) {

        Member member = verifiedMember(memberId);
        return toResponseDto(member);

    }

    public Member verifiedMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(
                () -> new RuntimeException());
        return member;
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }
}
