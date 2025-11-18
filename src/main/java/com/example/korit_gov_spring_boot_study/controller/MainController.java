package com.example.korit_gov_spring_boot_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

//SSR => 즉 서버쪽에서 웹페이지를 렌더링해서 반환하는 방식
@Controller
public class MainController {

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
}
