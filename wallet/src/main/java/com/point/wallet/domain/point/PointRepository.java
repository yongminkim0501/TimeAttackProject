package com.point.wallet.domain.point;

import com.point.wallet.domain.point.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PointRepository extends JpaRepository<Point, Long> {}
