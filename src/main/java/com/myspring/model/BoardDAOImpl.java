package com.myspring.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository("bDao")
public class BoardDAOImpl implements BoardDAO{


	@Autowired
	private SqlSession sqlMap;

	//글쓰기
	@Override
	public void insert(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid,dto); //sqlid에 "insert"가 담겨있음 service에서 이미 정해줌
		
	}
	
	//전체보기
	@Override
	public List<BoardDTO> list(String sqlid) {
		// TODO Auto-generated method stub
		List<BoardDTO> dto = sqlMap.selectList(sqlid);
		return dto;
	}
	
	//count 달린 전체보기
		public List<BoardDTO> getList(String sqlid, HashMap<String,Integer> hm) {
			// TODO Auto-generated method stub
			//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
			return sqlMap.selectList(sqlid, hm);			
	}
		
	//count	
	public int getCount(String sqlid) {
		//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		return sqlMap.selectOne(sqlid);
	}

	//수정
	@Override
	public void update(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.update(sqlid, dto);
		
	}
	//삭제
	@Override
	public void delete(String sqlid, Integer seq) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid, seq);
	}
	
	//상세보기
	@Override
	public BoardDTO findById(String sqlid, Integer seq) {
		// TODO Auto-generated method stub
		return sqlMap.selectOne(sqlid,seq);
	}
	
	//찾기	
	public List<BoardDTO> getSearch(String sqlid, HashMap<String,String> hm){	
		//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		return sqlMap.selectList(sqlid, hm);
	}
	
	//카운트
	public void hitcount(String sqlid, BoardDTO dto, Integer seq) {
		sqlMap.update(sqlid, dto);
	}

	//코멘트글쓰기
	@Override
	public void cinsert(String sqlid, CommentDTO cto) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid,cto); //sqlid에 "insert"가 담겨있음 service에서 이미 정해줌
			
	}
		
	//코멘트전체보기
	@Override
	public List<CommentDTO> clist(String sqlid) {
		// TODO Auto-generated method stub
		List<CommentDTO> cto = sqlMap.selectList(sqlid);
		return cto;
	}


}
