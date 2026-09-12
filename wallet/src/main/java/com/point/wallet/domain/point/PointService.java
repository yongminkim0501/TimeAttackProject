package com.point.wallet.domain.point;

import com.point.wallet.domain.point.entity.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 포인트 정책 정리
// 잔액은 음수 불가, 잔액 부족시 요청 실패
// 모든 거래는 남아야 함
// 내역의 합과 현재 잔액은 항상 일치 해야 함

@Service
public class PointService {
    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Transactional
    public void addPoint(Long pointId, Long amount){
        Point point = pointRepository.findById(pointId)
                        .orElseThrow();
        point.addAmount(amount);
        //기존 DB
        //amount = 1000
        //     ↓
        //findById()
        //     ↓
        //Point Entity
        //amount = 1000
        //     ↓
        //point.addAmount(500)
        //     ↓
        //Point Entity
        //amount = 1500
        //     ↓
        //Transaction 종료
        //     ↓
        //UPDATE 쿼리
        //     ↓
        //DB
        //amount = 1500
        // @Transactional 안에서 findById()로 가져온 Entity는 JPA가 관리하고 있어서
        // point.addAmount(amount); 로 값이 바뀌면 JPA가 감지 Dirty Checking
        //
    }

    @Transactional
    public void UpdatePoint(Long pointId, Long amount){
        Point point = pointRepository.findById(pointId)
                .orElseThrow();
        point.minusAmount(amount);
    }

    @Transactional
    public void getPoint(Long pointId){
        Point point = pointRepository.findById(pointId)
                .orElseThrow();
        Long result = point.getAmount();
    }

    @Transactional
    public void allHistory(Long pointId){
        Point point = pointRepository.findById(pointId)
                .orElseThrow();
        HistoryResponse history = point.getAllHistory();
    }
}
