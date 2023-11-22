package com.example.demo4.member.Controller;

import com.example.demo4.member.Dto.MemberResponseDto;
import com.example.demo4.member.Repository.MemberRepository;
import com.example.demo4.member.Service.MemberService;
import com.example.demo4.member.entity.Member;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/{memberId}")
    private ResponseEntity get(@PathVariable Long memberId){
       MemberResponseDto memberResponseDto = memberService.get(memberId);
       return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }




}
