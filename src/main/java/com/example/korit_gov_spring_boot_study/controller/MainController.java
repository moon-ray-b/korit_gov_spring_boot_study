package com.example.korit_gov_spring_boot_study.controller;

import com.example.korit_gov_spring_boot_study.dto.AddMemberReqDto;
import com.example.korit_gov_spring_boot_study.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
class UserDto{
    private int userId;
    private String username;
    private  int age;
}
//SSR => 즉 서버쪽에서 웹페이지를 렌더링해서 반환하는 방식
@Controller
public class MainController {
    private List<UserDto> users = new ArrayList<>();
    private MemberService memberService = MemberService.getInstance();

    public MainController() {
        memberService = MemberService.getInstance();
    }

    //동적인 요소가 없는 정적 웹페이지
    @GetMapping("/main")
    public String getMain() {

        return "main.html";
    }

    //SSR 동적을 추가하려면 Thymeleaf를 적용
    //서버에서 HTML을 렌더링할때, 자바 데이터를 끼워 넣을 수 있게 해주는 템플릿 엔진
    @GetMapping("/profile")
    public String getProfile(Model model) {
            model.addAttribute("username", "<b>배찬익</b>");
            model.addAttribute("isAdult", false);
            model.addAttribute("age", 23);

            Map<String, String> userList = new HashMap<>();
            userList.put("배찬익", "23");
            userList.put("배찬익익", "24");
            userList.put("배찬익익익", "25");
            userList.put("배찬익익익익", "26");
            model.addAttribute("userList", userList);
            return "profile.html";
    }

    @GetMapping("/search")
    public String getSearch(@RequestParam String keyword, @RequestParam String keyword2, Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("keyword2", keyword2);
        return "search.html";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam String name, @RequestParam int age, Model model) {
//        UserDto userDto = new UserDto(users.size() + 1, name, age);
//        users.add(userDto);
     if (memberService.isDuplicatedNmae(name)) {
        model.addAttribute("message", name + "중복된 이름입니다");
        return "result-page";
    }
        AddMemberReqDto addMemberReqDto = new AddMemberReqDto(name, age);
     memberService.addMember(addMemberReqDto);

        model.addAttribute("message", name + "님, 가입을 환영합니다.");
        return "result-page";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", memberService.getMemberAll());
        return "users";
    }
}
