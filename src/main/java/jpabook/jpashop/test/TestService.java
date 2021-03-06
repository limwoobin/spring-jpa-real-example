package jpabook.jpashop.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestService {
    private final TestRepository testRepository;

    @Transactional(readOnly = true)
    public Test test(Long id) {
        Test test = testRepository.findTest(id);
        for (Other other : test.getOthers()) {
            other.getOtherName();
        }
        return test;
    }

    public Test test2(Long id) {
        Test test = testRepository.findTest(id);
        for (Other other : test.getOthers()) {
            other.getOtherName();
        }
        return test;
    }

    @Transactional(readOnly = true)
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public List<Test> findAll2() {
        return testRepository.findAll();
    }

    public Test findOne(Long id) {
        return testRepository.findTest(id);
    }

    @Transactional
    public void insTest() {
        Test test = new Test();
        test.setName("test");
        testRepository.save(test);
    }
}
