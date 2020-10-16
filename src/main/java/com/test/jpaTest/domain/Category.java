package com.test.jpaTest.domain;

import com.test.jpaTest.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    @Column(name="category_id")
    private Long id;
    private String name;


    @ManyToMany
    @JoinTable(name = "category_item",
                joinColumns = @JoinColumn(name="category_id"),
                inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item> items = new ArrayList<>();

    //X to One = FetchType을 Lazy로 설정하지 않으면
    //한번에 모든 데이터를 다 불러와서 에러남
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //연관관계 메서드//
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }

}
