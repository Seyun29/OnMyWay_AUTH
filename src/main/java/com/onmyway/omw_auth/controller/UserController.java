package com.onmyway.omw_auth.controller;

import com.onmyway.omw_auth.domain.Favorites;
import com.onmyway.omw_auth.domain.History;
import com.onmyway.omw_auth.dto.request.AddFavoritesRequest;
import com.onmyway.omw_auth.dto.request.AddHistoryRequest;
import com.onmyway.omw_auth.dto.request.RegisterRequest;
import com.onmyway.omw_auth.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        //FIXME: exception handling (try-catch), validation (java.validation.valid), responseentity.ok().body(...)
        userService.register(registerRequest);
        return "success"; //FIXME: return 값 수정 필요, 예외처리
    }

//    @PostMapping("/login") //Filter layer에서 처리=> 필요 없음

    @GetMapping("/logout")
    public String logout() { //서버에서 구현 필요?
        userService.logout();
        return "Logout API TBU";
    }

    @GetMapping("/favorites")
    public List<Favorites> favorites(@RequestParam String username) { //TBU
        return userService.getFavorites(username);
    }

    @PostMapping("/favorites")
    public String addFavorites(@RequestBody AddFavoritesRequest addFavoritesRequest) {
        userService.addFavorites(addFavoritesRequest);
        return "addFavorites success"; //FIXME: TBU
    }

    @GetMapping("/history")
    public List<History> history(@RequestParam String username) { //TBU
        return userService.getHistory(username);
    }

    @PostMapping("/history")
    public String addHistory(@RequestBody AddHistoryRequest addHistoryRequest) {
        userService.addHistory(addHistoryRequest);
        return "addHistory success"; //FIXME: TBU
    }
}