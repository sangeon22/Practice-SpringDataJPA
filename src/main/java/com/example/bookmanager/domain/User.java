package com.example.bookmanager.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id //PK값
    @GeneratedValue(strategy=GenerationType.SEQUENCE) //숫자값이 순차적으로 올라가도록
    private  Long id;

    @NonNull
    private String name;

    @NonNull
    @Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(updatable = false) //(nullable = false) // NotNull 컬럼
    private LocalDateTime createdAt;

    @Column //(insertable = false) //insert시 아래 필드를 인서트x
    private LocalDateTime updatedAt;

    @Transient //영속성처리에서 제외 -> DB에 반영X
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
