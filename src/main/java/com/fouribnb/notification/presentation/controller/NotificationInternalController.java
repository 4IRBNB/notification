package com.fouribnb.notification.presentation.controller;

import com.fouribnb.notification.application.dto.requestDto.CreateNotificationInternalRequest;
import com.fouribnb.notification.application.dto.responseDto.NotificationInternalResponse;
import com.fouribnb.notification.application.service.NotificationService;
import com.fouribnb.notification.presentation.dto.requestDto.CreateNotificationRequest;
import com.fouribnb.notification.presentation.dto.responseDto.NotificationResponse;
import com.fouribnb.notification.presentation.mapper.NotificationDtoMapper;
import com.fourirbnb.common.response.BaseResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/internal/notifications")
@RequiredArgsConstructor
public class NotificationInternalController {

    private final NotificationService notificationService;

    // [알림 생성]
    @PostMapping
    public BaseResponse<NotificationResponse> createNotification(
        @RequestBody CreateNotificationRequest request) {
        // CreateNotificationRequest = 예약 서비스에서 전송해주는 데이터 (dto를 infrastructure로 옮겨야 하는가?)
        CreateNotificationInternalRequest internalRequest = NotificationDtoMapper.toCreateInternalDto(
            request);
        NotificationInternalResponse internalResponse = notificationService.createNotification(
            internalRequest);

        return BaseResponse.SUCCESS(NotificationDtoMapper.toResponse(internalResponse), "알림 저장 성공");
    }

    // [알림 발송]
    @PostMapping("/send/{userId}")
    public BaseResponse<List<NotificationResponse>> sendNotification(@PathVariable Long userId) {
        List<NotificationInternalResponse> internalResponse = notificationService.sendNotification(
            userId);
        return BaseResponse.SUCCESS(NotificationDtoMapper.toResponseList(internalResponse),"알림 발송 성공");
    }

}
