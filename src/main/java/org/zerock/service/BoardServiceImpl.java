package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
//@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	//글등록
	@Override
	public void register(BoardVO board) {
		log.info("register........" + board);
		mapper.insertSelectKey(board);
	}

	//글상세
	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	//글수정
	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1;
	}

	//글삭제
	@Override
	public boolean remove(Long bno) {

		return mapper.delete(bno) == 1;
	}
	
//	//목록
//	@Override
//	public List<BoardVO> getList() {
//
//		log.info("getList................");
//
//		return mapper.getList();
//	}
	
	//페이징 처리된 - 목록
	@Override
	public List<BoardVO> getList(Criteria cri){
		
		log.info("get List with critera" + cri);
		
		return mapper.getListWithPaging(cri);
	}

	//전체 데이터 개수
	@Override
	public int getTotal(Criteria cri) {
		
		 log.info("get total count");
		 
		 return mapper.getTotalCount(cri);
		 
	}
	
	

}






