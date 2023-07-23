package com.instagram.clone.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_entity")
public class MemberEntity extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;



    // EAGER 타입은 엔티티를 로드할 때 즉시 관련된 컬렉션 데이터도 함께 로드하라는 의미
    @ElementCollection(fetch = FetchType.EAGER) // 컬렉션 타입을 갖고있음을 뜻함
    @Builder.Default // Default 하면 기본 빈 ArrayList가 roles 필드에 할당됨
    private List<String> roles = new ArrayList<>();
//    private List<String roles;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        Collection<GrantedAuthority> collect = new ArrayList<>();
//        collect.add(new SimpleGrantedAuthority(roles.get()));
//        return collect;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
