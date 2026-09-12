package com.point.wallet.domain.point;

import com.point.wallet.domain.point.PointService;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class PointController {
    private final PointService pointService;

    public PointController(PointService pointService){
        this.pointService = pointService;
    }
    @PostMapping("/wallets/{userId}/charge")
    public void charge(@PathVariable Long userId, @RequestBody Point point){
        this.pointService...
    }

    @PostMapping("/wallets/{userId}/use")
    public void use(@PathVariable Long userId, @RequestBody Point point){

    }

    @GetMapping("/wallets/{userId}")
    public void get(@PathVariable Long userId){

    }

    @GetMapping("/wallets/{userId}/histories")
    public void getHistories(@PathVariable Long userId){

    }
}
