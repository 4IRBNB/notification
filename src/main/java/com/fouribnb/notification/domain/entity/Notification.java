package com.fouribnb.notification.domain.entity;

import com.fouribnb.notification.domain.enums.Type;
import com.fourirbnb.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@ToString
@Table(name = "p_notification")
@DynamicUpdate
@SQLRestriction("deleted_at IS NULL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "notification_id")
    private UUID notificationId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "reservation_id")
    private UUID reservationId;

    @Column(name = "message")
    private String message;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "is_success")
    private boolean isSuccess;

    @Builder
    public Notification(UUID notificationId,Long userId, UUID reservationId, String message, Type type) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.reservationId = reservationId;
        this.message = message;
        this.type = type;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

}
