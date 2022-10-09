package com.ssafy.sowlmate.dto.request;

import com.ssafy.sowlmate.entity.Interest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class InterestRequestDto {
    private String userId;
    private Interest interest;
}
