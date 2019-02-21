package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;





@Service("bService")
public class BoardService {
	@Resource(name="bDao") //Autowired랑 같다. Autowired 해놓으면 그냥 객체 이름으로 바로 찾고, Resource로해놓으면 지정한 서로 지정한 name으로 찾아간다
	private BoardDAOImpl bDao;
	String boardSql = "com.myspring.model.DAOXML"; //DBXML 을 찾아가는 용도다
	
	//insert
	public void insert(BoardDTO dto) {
		bDao.insert(boardSql+".insert",dto); //sqlid 넘어가는 값을 "insert"로 설정
	}
	
//	//list
//	public List<BoardDTO> list(){		
//		List<BoardDTO> dto = bDao.list(boardSql+".list"); //sqlid 만 인자 값으로 넘김
//		return dto;
//	}
	
	//list
	public List<BoardDTO> list(HashMap<String,Integer>hm){
		 return	bDao.getList(boardSql+".list", hm);	
	}
			
	//상세보기
	public BoardDTO findById(Integer seq) {
		BoardDTO dto=bDao.findById(boardSql+".detail", seq);
		return dto;
				
	}
	//삭제
	public void delete(Integer seq) {
		bDao.delete(boardSql+".delete", seq); 
	}
	
	//수정
	public void update(BoardDTO dto) {
		bDao.update(boardSql+".update", dto);
	}
	
	//count
	public int getCount() {
		return bDao.getCount(boardSql+".count");
	}

	//search
	public List<BoardDTO>getSearch(HashMap<String,String> hm) {
		return bDao.getSearch(boardSql+".search", hm);
	}
	
	//hitcount
	public void hitcount(BoardDTO dto, Integer seq) {
		bDao.hitcount(boardSql+".hitcount", dto, seq);
	}

	
	//insert
		public void cinsert(CommentDTO dto) {
			bDao.cinsert(boardSql+".cinsert",dto); //sqlid 넘어가는 값을 "cinsert"로 설정
		}
		
	//list
	public List<CommentDTO> clist(){		
		List<CommentDTO> dto = bDao.clist(boardSql+".clist"); //sqlid 만 인자 값으로 넘김
		return dto;
	}
}
