package com.myspring.board;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.myspring.model.BoardDTO;
import com.myspring.model.BoardService;
import com.myspring.model.CommentDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name="page")
	private PagingAction page;
	
	@Resource(name="bService")//Autowired와 같은 개념.. 이름으로 찾는다
	private BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//테스트
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	//글쓰기
	@RequestMapping(value="/writeForm", method=RequestMethod.POST)
	public String writeForm(BoardDTO dto) {
		bService.insert(dto);
		return "redirect:list";
	}
	
	//코멘트전체보기
	@RequestMapping("/clist")
	public String clist(Model model) {
		List<CommentDTO> clist = bService.clist();	
		model.addAttribute("clist",clist);				
		return "detail"; 
	}
	
	//코멘트글쓰기
		@RequestMapping("cinsert")
		public String cinsert(CommentDTO cto) {
			bService.cinsert(cto);
			return "detail";
		}
	
	//list
		@RequestMapping("list")
		public String list(Model model, String pageNum) {
			int pageSize=5;
			if(pageNum==null)pageNum="1";
			int currentPage = Integer.parseInt(pageNum);	
			
			int count = bService.getCount();		
			int startRow =(currentPage-1)*pageSize+1;
			int endRow = startRow+pageSize-1;
			if(endRow>count)endRow=count;
			HashMap<String,Integer> hm = new HashMap<String,Integer>();
			hm.put("startRow",startRow);
			hm.put("endRow",endRow);
			
			List<BoardDTO> userlist = bService.list(hm);
			String pageHtml = page.paging(count,pageSize,currentPage);
			model.addAttribute("userlist", userlist);
			model.addAttribute("count", count);
			model.addAttribute("pageHtml", pageHtml);
			return "list";
		}
	
	
	//detail
		@RequestMapping("detail")
		public String detail(Integer seq, Model model) {
			BoardDTO user = bService.findById(seq);
			model.addAttribute("user", user);	
			bService.hitcount(user, seq);
			return "detail";
		}
	
	//삭제
	@RequestMapping("delete")
	public String delete(Integer seq) {	
		bService.delete(seq);
		return "redirect:list";	
	}
	
	//수정
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(WebRequest dto) { //WebRequest는 spring에서 request 방식을 대신해서 사용
		BoardDTO bdto = new BoardDTO();
		bdto.setSeq(Integer.parseInt(dto.getParameter("seq")));
		bdto.setTitle(dto.getParameter("title"));
		bdto.setContent(dto.getParameter("content"));
		bdto.setWriter(dto.getParameter("writer"));					
		bService.update(bdto);		
		return "redirect:list";
	}
	
	//search
	@RequestMapping("search")
	public String list(String field, String word, Model model) {
		field = field == null?"":field.trim();
		word = word == null?"":word.trim();
			
		HashMap<String,String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
			
		List<BoardDTO> userlist = bService.getSearch(hm);
		model.addAttribute("userlist", userlist);
		return "list";
	}	

}
