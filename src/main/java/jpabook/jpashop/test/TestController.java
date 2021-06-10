package jpabook.jpashop.test;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    // Lazy 에서 하나만 조회하는 경우는 N + 1 발생 안한다
    @GetMapping("/v1/test/{id}")
    public TestDTO test(@PathVariable Long id) {
        Test test = testService.test(id);
//        for (Other other : test.getOthers()) {
//            other.getOtherName();
//        }

        return null;
    }

    @GetMapping("/v2/test/{id}")
    public TestDTO test2(@PathVariable Long id) {
        Test test = testService.test2(id);
//        for (Other other : test.getOthers()) {
//            other.getOtherName();
//        }

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
    @GetMapping("/v1/test")
    public List<TestDTO> test() {
        List<Test> tests = testService.findAll();
        for (Test test : tests) {
            System.out.println(test.getOthers().size());
        }

        return null;
    }

    @GetMapping("/v2/test")
    public List<TestDTO> test2() {
        List<Test> tests = testService.findAll2();
        for (Test test : tests) {
            System.out.println(test.getOthers().size());
        }

        return null;
    }

    @PutMapping("/test/ins")
    public TestDTO testIns() {
        testService.insTest();
        return null;
    }
}
