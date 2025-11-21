package com.example.korit_gov_spring_boot_study.controller;

import com.example.korit_gov_spring_boot_study.dto.request.SigninReqDto;
import com.example.korit_gov_spring_boot_study.dto.request.SignupReqDto;
import com.example.korit_gov_spring_boot_study.dto.response.SigninRespDto;
import com.example.korit_gov_spring_boot_study.dto.response.SignupRespDto;
import com.example.korit_gov_spring_boot_study.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private UserService userService;

    public AuthController(){
        userService = UserService.getInstance();
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupRespDto> signup(@RequestBody SignupReqDto signupReqDto) {
        return ResponseEntity.ok(userService.signup(signupReqDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninRespDto> signin(@RequestBody SigninReqDto signinReqDto){
        return ResponseEntity.ok(userService.signin(signinReqDto));
    }

    /*
    * 파라미터가 없으면 400에러
    * 타입이 안맞거나
    * 이름이 불일치 할때
    *
    * 민감한 정보는 쓰지 않도록
    * */
//    @GetMapping("/get")
//    public String getUser(@RequestParam String userId) {
//        System.out.println("쿼리 파라미터로 들어온 값: " + userId);
//        return "쿼리 파라미터로 들어온 값" +userId;
//    }
//
//    @GetMapping("/get/name")
//    public String getUserName( @RequestParam(value = "name", defaultValue = "찬익") String username, @RequestParam(required = true) Integer age) {
//        return username + age;
//    }
    /*
    * value 을 통해 피라미드의 키 이름을 다르게 설정 가능
    * defaultValue = 통해 값을 넣지 않으을때 기본 설정값 가능
    * required false를 통해 필수가 아니게 설정 가능
    * 단 필수가 아닐떄 자료형이 wrapper class 자료형이다 한다(null이 들어와야 하기때문)
    * */

//    @PostMapping("/sigup")
//    public String signup(@RequestBody SignupReqDto signupReqDto) {
//        System.out.println(signupReqDto);
//        return  signupReqDto.getUsername() + "님 회원가입이 완료되었습니다";
//    }

    /*
    * @RequstBody
    * HTTP 요청의 바디에 들어 있는JSON데이터를 자바 객체(DTO)로 변환해서 주입해주는 어노테이션
    * 클라이언트가 json형식으로 데이터르 ㄹ보내면 서버에서 JSON을 파싱해 알아서 DTO에 대해서 매핑후 주입
    * 단, JSON데이터의 키와 객체의 멤버변수의 이름과 일치시켜야 한다.
    * */
//    @PostMapping("/signin")
//    public String signin(@RequestBody SigninReqDto signinReqDto) {
//        return  "로그인 성공: " + signinReqDto.getUsername() +"님 반갑습니다";
//    }

    /*
    * ResponseEntity
    * HTTP 응답 전체를 커스터마이징을 해서 응답할 수 있는 스프링 클래스
    * 상태코드, 응답바디, 응답헤더 등등
    * 200
    * 400
    * 401 => 인증 실패
    * 403 => 점근 권한 없
    * 404
    * 500
    * */
//    @PostMapping("/signup")
//    public ResponseEntity<SignupRespDto> signup(@RequestBody SignupReqDto signupReqDto) {
//        if (signupReqDto.getUsername() == null||signupReqDto.getUsername().trim().isEmpty()){
//            SignupRespDto signupRespDto = new SignupRespDto("failed", "username을 입력하세요");
//            return ResponseEntity.badRequest().body(signupRespDto);
//        }else if (signupReqDto.getPassword() == null||signupReqDto.getPassword().trim().isEmpty()){
//            SignupRespDto signupRespDto = new SignupRespDto("failed", "비밀번호를 입력하세요");
//        }
//        SignupRespDto signupRespDto = new SignupRespDto("success", "회원가입 성공");
//        return ResponseEntity.ok(signupRespDto);
//    }
    //실제 컨트롤 만들기


}
