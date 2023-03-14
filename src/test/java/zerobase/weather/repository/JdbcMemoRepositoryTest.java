package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional  // 테스트가 끝나고 나면 롤백
class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(1, "this is new memo~ist");

        //when
        jdbcMemoRepository.save(newMemo);

        //then
        Optional<Memo> result = jdbcMemoRepository.findById(1);
        assertEquals(result.get().getText(), "this is new memo~ist");
    }

    @Test
    void findAllMemoTest() {
        //given
        List<Memo> memoList = jdbcMemoRepository.findAll();

        //when
        //then
        assertNotNull(memoList);
    }
}