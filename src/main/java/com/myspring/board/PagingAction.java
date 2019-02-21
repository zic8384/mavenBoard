package com.myspring.board;

import org.springframework.stereotype.Component;

@Component("page")
public class PagingAction {
	   //페이징
	   public String paging(int count, int pageSize, int currentPage) {
	      
	      int pageCount=count/pageSize+(count%pageSize==0?0:1);
	      int pageBlock=3;
	      int startPage=((currentPage-1)/pageBlock)*pageBlock+1;
	      int endPage=startPage+pageBlock-1;
	      if(endPage>pageCount)endPage=pageCount;
	      StringBuffer sb = new StringBuffer();
	      if(count>0) {
	         if(startPage>pageBlock) { // 이전
	            sb.append("<a href=list?pageNum=");
	            sb.append((startPage-pageBlock));
	            sb.append(">[이전]</a>");
	         }
	         //페이지 수
	         for(int i=startPage;i<=endPage;i++) {
	            if(i==currentPage) {
	               sb.append("["+i+"]");
	            }else {
	            	sb.append("<a href=list?pageNum=");
		            sb.append(i);
		            sb.append(">["+i+"]</a>");
	            }
	         }
	         if(endPage<pageCount) { //다음
	        	 sb.append("<a href=list?pageNum=");
		         sb.append((startPage+pageBlock));
		         sb.append(">[다음]</a>");
	         }
	      }
	      
	      return sb.toString();
	      
	   }

}
