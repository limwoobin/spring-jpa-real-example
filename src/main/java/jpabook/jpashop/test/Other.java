package jpabook.jpashop.test;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Other {

    @Id
    @GeneratedValue
    private Long id;

    private String otherName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;
}
