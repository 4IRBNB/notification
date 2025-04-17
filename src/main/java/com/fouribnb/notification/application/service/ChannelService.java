package com.fouribnb.notification.application.service;

import com.fouribnb.notification.infrastructure.dto.requestDto.ChannelRequest;
import com.fouribnb.notification.infrastructure.dto.responseDto.ChannelResponse;
import java.util.List;

public interface ChannelService {

    List<ChannelResponse> sendSlack(List<ChannelRequest> requests);
}
