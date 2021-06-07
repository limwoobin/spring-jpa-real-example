package jpabook.jpashop.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    // Lazy 에서 하나만 조회하는 경우는 N + 1 발생 안한다
    @GetMapping("/test/{id}")
    public TestDTO test(@PathVariable Long id) {
        Test test = testService.test(id);
        System.out.println(test.getClass());
        System.out.println(test.getOthers().getClass());
        test.getOthers();

        return null;
    }


    @GetMapping("/test2/{id}")
    public TestDTO findOne(@PathVariable Long id) {
        Test test = testService.findOne(id);
        System.out.println(test.getClass());
        System.out.println(test.getOthers().getClass());
        test.getOthers().size();
        System.out.println(test.getOthers().size());
        return null;
    }

    // N + 1
    @GetMapping("/test")
    public List<TestDTO> test() {
        List<Test> tests = testService.findAll();
        for (Test test : tests) {
            System.out.println(test.getOthers().size());
        }

        return null;
    }
}
