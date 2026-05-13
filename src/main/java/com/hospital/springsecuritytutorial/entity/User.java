package com.hospital.springsecuritytutorial.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import jakarta.persistence.Id;

@Entity
@Data
@Builder
@Table(name = "app_user")
public class User  implements  UserDetails{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(unique = true)
    private String username;
    private String password;

    private String providerId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of();
    }



}
