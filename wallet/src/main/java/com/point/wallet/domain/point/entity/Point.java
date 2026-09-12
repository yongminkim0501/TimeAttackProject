package com.point.wallet.domain.point.entity;

import jakarta.persistence.*;

@Entity
@Table(name="points")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requestId;
    private Long amount;
    protected Point(){
    }
    public Point(String requestId, Long amount) {
        this.requestId = requestId;
        this.amount = amount;
    }
    public Long getId() {
        return id;
    }
    public String getRequestId() {
        return requestId;
    }
    public void addAmount(Long amount) {
        this.amount += amount;
    }
    public boolean checkAmount(Long amount) {
        return amount <= this.amount;
    }
    public Long getAmount() {
        return amount;
    }
    public void minusAmount(Long amount) {
        if (this.amount < amount){
            throw new IllegalArgumentException("포인트가 부족합니다.");
        }
        this.amount -= amount;
    }
}
