package com.fouribnb.notification.application.service;

import com.fouribnb.notification.application.dto.requestDto.CreateNotificationInternalRequest;
import com.fouribnb.notification.application.dto.responseDto.NotificationInternalResponse;

public interface NotificationService {

    NotificationInternalResponse createNotification(CreateNotificationInternalRequest request);
}
