package com.ssafy.sowlmate.entity;

import com.ssafy.sowlmate.entity.type.LanguageType;
import com.ssafy.sowlmate.entity.type.LoginType;
import com.ssafy.sowlmate.entity.type.RegionType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long no;

    @Column(name = "id", unique = true)
    @NotNull private String id;
    @NotNull private String password;
    @NotNull private String nickname;
    @NotNull private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RegionType region; // 7대륙

    @Enumerated(EnumType.STRING)
    private LanguageType language;

    @Enumerated(EnumType.STRING)
    private LanguageType preferenceLanguage;

    @Column(nullable = true)
    private String profilePictureUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Interest> interests = new ArrayList<>();

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-DD/HH:mm:ss")
    private LocalDateTime enrollDate;

    @PrePersist
    public void enroll_date() {
        this.enrollDate = LocalDateTime.now();
    }

    @Enumerated(EnumType.ORDINAL)
    private LoginType loginType;

    // google auth
//    @Override
//    public Map<String, Object> getAttributes() {
//        return null;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    public User updateUser(User updateUser) {
//        this.setProfilePictureUrl(updateUser.profilePictureUrl);
//        return this;
//    }
}
