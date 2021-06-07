package jpabook.jpashop.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TestDTO {
    private Long id;
    private String name;
    private List<OtherDTO> otherDTOList;

    public TestDTO(Long id , String name , List<OtherDTO> otherDTOList) {
        this.id = id;
        this.name = name;
        this.otherDTOList = otherDTOList;
    }
}
