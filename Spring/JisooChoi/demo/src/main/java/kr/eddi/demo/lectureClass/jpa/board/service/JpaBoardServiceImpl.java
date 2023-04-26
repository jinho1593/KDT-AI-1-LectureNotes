package kr.eddi.demo.lectureClass.jpa.board.service;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaBoardServiceImpl implements JpaBoardService{
    // ※ 특정 요청이 들어오면 이를 처리하는 부분이 서비스이다.

    // implements ?
    // 부모 객체는 선언만 하며, 정의(내용)는 자식에서 오버라이딩 (재정의)해서 사용해야 한다.
    // 또한 implements 는 다중상속을 대신해준다.

    // 스마트한 데이터 검색을 할 수 있게 해주는 인터페이스 틀
    final private JpaBoardRepository boardRepository;
    // ※ boardRepository 를 new 하지 않아도 리텐션 런 타임이 붙어있는 경우가 있기 때문에 사용가능 (질문방 참고하기)

    @Override
    public List<JpaBoard> list(){
                               // ↓ .findAll ?
                               // ↓ 전체 레코드 불러오기, 정렬(sort), 페이징(pageable) 가능
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
                                            // ↑엔터티를 내림차순 정렬,   ↑ ID유형은 boardId이다.
    }

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    @Override
    public JpaBoard read(Long boardId) {                    // ↓findById는 id에 맞춰서 엔티티를 찾아준다/검색한다.
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
        // ↑Optional 은 값이 있을 때 구해주고, 없으면 null 이다.

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaBoard.get();
    }

    @Override
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        JpaBoard board = maybeJpaBoard.get();
        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());

        return boardRepository.save(board);
    }
}
