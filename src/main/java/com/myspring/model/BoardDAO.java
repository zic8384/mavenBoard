package com.myspring.model;

import java.util.List;

public interface BoardDAO {
	
	//글쓰기
	void insert(String sqlid, BoardDTO dto);
	
	//리스트
	List<BoardDTO> list(String sqlid);
	
	//수정
	void update(String sqlid, BoardDTO dto);
	
	//삭제
	void delete(String sqlid, Integer seq);
	
	//상세보기
	BoardDTO findById(String sqlid, Integer seq);
	
	//코멘트 글쓰기
	void cinsert(String sqlid, CommentDTO cto);
	
	//코멘트 리스트
	List<CommentDTO> clist(String sqlid);
}
