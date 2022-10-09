package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.User;

public interface InterestRepositoryCustom {
    int deleteByUserAndType(User user, InterestType title);
}
