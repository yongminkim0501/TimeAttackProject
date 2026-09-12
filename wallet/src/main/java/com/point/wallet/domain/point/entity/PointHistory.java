package com.point.wallet.domain.point.entity;
import com.point.wallet.domain.point.type.PointHistoryType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="point_history")
public class PointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pointId;

    private Long amount;

    @Enumerated(EnumType.STRING)

    private PointHistoryType type;
    private LocalDateTime createdAt;
    protected PointHistory() {

    }

    public PointHistory(
            Long pointId,
            Long amount,
            PointHistoryType type
    ) {
        this.pointId = pointId;
        this.amount = amount;
        this.type = type;
        this.createdAt = LocalDateTime.now();

    }
    public Long getId() {
        return id;
    }
    public Long getPointId() {
        return pointId;
    }
    public Long getAmount() {
        return amount;
    }
    public PointHistoryType getType() {
        return type;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
