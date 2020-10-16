package com.test.jpaTest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Delivery {

    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;



    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    //oder - delivery의 연관관계의 주인
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //꼭
    private DeliveryStatus status; //Ready, comp , (다른 상태),

}
