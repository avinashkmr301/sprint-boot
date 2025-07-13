package com.avi.basic_jpa_query.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    private String email;
    private Integer level;
    @Column(name = "active")
    private boolean isActive;

    public User(String userName, LocalDate registrationDate, String email, Integer level, boolean isActive) {
        this.username = userName;
        this.registrationDate = registrationDate;
        this.email = email;
        this.level = level;
        this.isActive = isActive;
    }
}
