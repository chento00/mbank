package com.co.mobile_banking.api.user.web;

import lombok.Builder;
@Builder
public record UserDto(
         String name,
         String gender,
         String studentCardId,
         Boolean isStudent
) {
}
