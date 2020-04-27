package com.lijin.service;

import org.springframework.stereotype.Component;

@Component
public interface LikeService {
    Boolean isLike(Integer id);

    void addLike(Integer id);

    void cancelLike(Integer id);
}
