package com.springboot.apiwebsite.service.impl;

import com.springboot.apiwebsite.entity.VerificationUserEntity;

public interface VerificationEmailServiceImpl {
 VerificationUserEntity getVerificationToken(String token);
}
