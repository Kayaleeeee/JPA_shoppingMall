package com.test.jpaTest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private  Address address;


    //연관관계의 거울 : mappedBy로 받아줌
    //collection을 field에서 초기화 ; null문제에서 안전
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
