package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional  // 테스트가 끝나고 나면 롤백
class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(1, "this is jpa memo");

        //when
        memoRepository.save(memo);

        //then
        List<Memo> memoList = memoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
        //given
        Memo memo = new Memo(1, "this is jpa memo");

        //when
        memoRepository.save(memo);

        //then
        Optional<Memo> result = memoRepository.findById(1);
        assertEquals(result.get().getText(), "this is jpa memo");
    }
}