package org.choongang.schedulling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 정기적으로 하는 작업을 예약하는 클래스
 *  ex) 통계작업(자정에 총 매출 집계)
 */
@Slf4j
@Component
public class Stat {

    // @Scheduled(cron = "*/3 * * * * *")  // 3초마다
    // @Scheduled(cron = "0 1 * * * *")  // 새벽 1시마다
    // cron : 업데이트 예약 시간을 설정
    // @Scheduled(fixedDelay = 3000)  // 작업 완료 후 지연
    // @Scheduled(fixedRate = 3000)  // 작업 시간 포함 3초 마다 실행
    //@Scheduled(initialDelay = 3, timeUnit = TimeUnit.SECONDS)  // 작업 시작전 3초 대기
    public void orderStatProcess() {
        log.info("!주문 통계 진행 ..");
    }
}
