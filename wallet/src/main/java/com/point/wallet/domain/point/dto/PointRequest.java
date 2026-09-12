package com.point.wallet.domain.point.dto;

public record PointRequest(
    String request_id,
    int amount,
    String description
){}
