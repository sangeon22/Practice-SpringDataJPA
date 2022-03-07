package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.Auditable;
import com.example.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@EntityListeners(value = {UserEntityListener.class})
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity implements Auditable {
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

//    @Column(updatable = false) //(nullable = false) // NotNull 컬럼
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @Column //(insertable = false) //insert시 아래 필드를 인서트x
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    @Transient //영속성처리에서 제외 -> DB에 반영X
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

 /*   @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
    */

/*

    @PostPersist
    public void postPersist(){
        System.out.println(">>> postPersist");
    }


    @PostUpdate
    public void postUpdate(){
        System.out.println(">>> postUpdate");
    }

    @PreRemove
    public void preRemove(){
        System.out.println(">>> preRemove");
    }

    @PostRemove
    public void postRemove(){
        System.out.println(">>> postRemove");
    }

    @PostLoad
    public void postLoad(){
        System.out.println(">>> postLoad");
    }
*/


}
