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
public class User {
    @Id //PK값
    @GeneratedValue //숫자값이 순차적으로 올라가도록
    private  Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
