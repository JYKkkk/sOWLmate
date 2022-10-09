package com.ssafy.sowlmate.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class PhotoBooth {
    @Id @GeneratedValue
    private Long no;

    @NotNull
    private String userId;
    @NotNull
    private String pictureUrl;
}
