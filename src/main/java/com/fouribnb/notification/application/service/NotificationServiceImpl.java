package com.fouribnb.notification.application.service;

import com.fouribnb.notification.application.dto.requestDto.CreateNotificationInternalRequest;
import com.fouribnb.notification.application.dto.responseDto.NotificationInternalResponse;
import com.fouribnb.notification.application.mapper.NotificationMapper;
import com.fouribnb.notification.domain.entity.Notification;
import com.fouribnb.notification.domain.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationInternalResponse createNotification(
        CreateNotificationInternalRequest request) {
        Notification notification = NotificationMapper.toEntity(request);
        Notification saved = notificationRepository.save(notification);
        log.info("DB 저장 : {}", saved);
        return NotificationMapper.toResponse(saved);
    }
}
