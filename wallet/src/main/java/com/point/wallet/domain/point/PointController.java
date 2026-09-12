package com.point.wallet.domain.point;

import com.point.wallet.domain.point.PointService;
import com.point.wallet.domain.point.dto.PointRequest;
import com.point.wallet.domain.point.dto.PointResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wallets")
public class PointController {
    private final PointService pointService;

    public PointController(PointService pointService){
        this.pointService = pointService;
    }
    @PostMapping("/{userId}/charge")
    public ResponseEntity<PointResponse>charge(
            @PathVariable Long userId,
            @RequestBody PointRequest pointRequest
    )
    {
        String result = pointService.addPoint(userId, pointRequest);
        PointResponse response =
                new PointResponse(result, true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}/use")
    public ResponseEntity<PointResponse> use(
            @PathVariable Long userId,
            @RequestBody PointRequest point
    ){
        PointResponse response = new PointResponse(requestId, true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<PointResponse> get(@PathVariable Long userId){
        PointResponse response = new PointResponse(requestId, true);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{userId}/histories")
    public ResponseEntity<HistoryResponse> getHistories(@PathVariable Long userId){
        HistoryResponse response = new HistoryResponse(requestId, true);
        return ResponseEntity.ok(response);
    }
}
