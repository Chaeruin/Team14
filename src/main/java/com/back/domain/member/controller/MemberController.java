package com.back.domain.member.controller;

import com.back.domain.member.dto.MemberDto;
import com.back.domain.member.dto.request.MemberJoinRequestDto;
import com.back.domain.member.dto.request.MemberLoginRequestDto;
import com.back.domain.member.dto.response.MemberLoginResponseDto;
import com.back.domain.member.service.MemberService;
import com.back.global.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "MemberController", description = "API 회원 컨트롤러")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "회원가입", description = "회원가입 API")
    @PostMapping
    public ResponseEntity<ApiResponse<MemberDto>> join(
            @Valid @RequestBody MemberJoinRequestDto reqBody
    ) {
        MemberDto memberDto = memberService.join(reqBody);

        // 성공 응답
        return ResponseEntity.ok(
                ApiResponse.success(
                        "%s님 환영합니다. 회원가입이 완료되었습니다.".formatted(memberDto.nickname()),
                        memberDto
                )
        );
    }

    @Operation(summary = "로그인", description = "로그인 API")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<MemberLoginResponseDto>> login(
            @Valid @RequestBody MemberLoginRequestDto reqBody
    ) {
        MemberLoginResponseDto memberLoginResponseDto = memberService.login(reqBody);

        // 성공 응답
        return ResponseEntity.ok(
                ApiResponse.success(
                        "%s님 환영합니다.".formatted(memberLoginResponseDto.memberDto().nickname()),
                        memberLoginResponseDto
                )
        );
    }

//    @Operation(summary = "로그아웃", description = "로그아웃 API")
//    @DeleteMapping("/logout")
//    public ResponseEntity<ApiResponse<String>> logout() {
//        rq.deleteCookie("apiKey");
//
//        // 성공 응답
//        return ResponseEntity.ok(
//                ApiResponse.success("로그아웃 되었습니다.")
//        );
//    }
}