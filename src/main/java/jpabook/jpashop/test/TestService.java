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
        return testRepository.findTest(id);
    }

    @Transactional(readOnly = true)
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public Test findOne(Long id) {
        return testRepository.findTest(id);
    }
}
