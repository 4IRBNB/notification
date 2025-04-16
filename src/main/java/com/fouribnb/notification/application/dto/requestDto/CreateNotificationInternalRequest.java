package com.fouribnb.notification.application.dto.requestDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateNotificationInternalRequest(
    UUID reservationId,
    Long userId,
    UUID lodgeId,
    LocalDateTime checkInDate,
    LocalDateTime checkOutDate,
    String reservationStatus

) {

}
