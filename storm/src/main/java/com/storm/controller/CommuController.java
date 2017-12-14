package com.storm.controller;

import java.util.ArrayList; 
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.storm.Service.CommuService;
import com.storm.VO.CommuVO;
import com.storm.util.PageUtil;


@Controller
@RequestMapping("/Commu")
public class CommuController {
	
	@Autowired 
	private CommuService CService;
	
	
//커뮤니티 게시판 목록
	@RequestMapping("/CommuMain")
	public ModelAndView commumain
	(@RequestParam(value="nowPage",defaultValue="1")int nowPage, HttpSession session){
//	할일
//	파라메터 받기
//	데이터베이스에서 목록을 뽑는다.
//1.총 데이터 개수를 구해서 페이지 정보를 만든다.
		int total=CService.getcommuTotal();
		PageUtil pInfo=
				new PageUtil(nowPage,total);
//2.페이지 정보를 이요해서 그 페이지에 필요한 목록만 구한다.
		ArrayList list= CService.getCommuList(nowPage, pInfo);
//	뷰에 모델로 알려준다.
//	뷰를 부른다.
		String email= (String)session.getAttribute("UID");
		System.out.println(email);
		if(email==null){
			ModelAndView mv = new ModelAndView();
			String dologin = "로그인하세요";
			mv.addObject("DOLOGIN", dologin);
			mv.setViewName("Login/LoginForm");
			return mv;
		}
		ModelAndView mv=new ModelAndView();
//	모델을 입력한다.
//함수	addObject("키값",데이터);
		mv.addObject("PINFO",pInfo);
		mv.addObject("LIST",list);
		mv.setViewName("Commu/CommuMain");
		System.out.println("마지막은?"+mv);
		
		return mv;
	}
	
	//상세보기 요청을 처리할 컨트롤러 함수
	@RequestMapping("/CommuView")
	public ModelAndView commuView
	(CommuVO CVO,HttpSession session,
	@RequestParam(value="nowPage",defaultValue="1")int nowPage){
//		할일
//		파라메터 받기
//		데이터베이스에서 목록을 뽑는다.
	//1.총 데이터 개수를 구해서 페이지 정보를 만든다.
		
			int total=CService.getboardTotal();
			PageUtil pInfo=new PageUtil(nowPage,total);
	//2.페이지 정보를 이요해서 그 페이지에 필요한 목록만 구한다.
			ArrayList list= CService.getBlist(nowPage, pInfo,CVO);

			HashMap map=CService.commuView(CVO.communo);
			int usrKey;
			usrKey=Integer.parseInt(String.valueOf(session.getAttribute("KEY")));
			String whatshow="";
			System.out.println("유저키"+usrKey);
			CVO.usrKey=usrKey;
				whatshow=CService.selectshow(CVO);

	//뷰를 부른다.
			ModelAndView mv=new ModelAndView();
			mv.addObject("MAP",map);
			System.out.println(map);
			mv.addObject("SHOWLIST", whatshow);
			System.out.println("SHOWLIST= "+whatshow);
			mv.addObject("PINFO",pInfo);
			mv.addObject("BLIST",list);
		//요청설계를 할 때 nowPage는 컨트롤러가 필요해서 받은것이 아니고 다음을 위해서
		//릴레이 시킨 파라메터이므로 잊지말고 다음에 반드시 전달해야 한다.
			mv.addObject("nowPage", CVO.nowPage);
			mv.addObject("communo", CVO.communo);
			mv.setViewName("/Commu/CommuView");
			return mv;
	}
	
	
	@RequestMapping("/CommuFollow")
	public ModelAndView commuFollow(CommuVO CVO,HttpServletRequest req,HttpSession session){
		
		String whatdo=req.getParameter("whatdo");
		String no =  req.getParameter("data2");
		String noWPage =req.getParameter("nowpage");
		int nowPage = Integer.parseInt(noWPage);
		int communo =Integer.parseInt(no);

		int usrKey =Integer.parseInt(String.valueOf(session.getAttribute("KEY")));
		
		
		System.out.println("커뮤넘"+communo+"유저넘"+usrKey+"왓두"+whatdo);
		
		CVO.communo=communo;
		CVO.usrKey=usrKey;
		String whatshow="";
		if(whatdo.equals("add")){
			CService.insertF(CVO);//맵테이블에 인서트
			whatshow=CService.selectshow(CVO);
		}
		else{
			CService.updateF(whatdo,CVO);
			whatshow=CService.selectshow(CVO);
		}
		HashMap map=CService.commuView(CVO.communo);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("MAP",map);
		mv.addObject("communo", CVO.communo);
		mv.addObject("nowPage", CVO.nowPage);
		mv.addObject("SHOWLIST", whatshow);
		int total=CService.getboardTotal();
		PageUtil pInfo=new PageUtil(nowPage,total);
		ArrayList list= CService.getBlist(nowPage, pInfo,CVO);
		mv.addObject("BLIST",list);
		mv.setViewName("/Commu/CommuView");
		return mv;
	}

	
	@RequestMapping("/WriteCommu")
	public ModelAndView writeCommu(CommuVO CVO,HttpSession session){
		HashMap map=CService.commuView(CVO.communo);
		
		String usrId=(String.valueOf(session.getAttribute("UID")));
		CVO.usrId=usrId;
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("MAP",map);
		mv.addObject("LIST",CVO);
		System.out.println("WriteCommu MAP ="+map);
		System.out.println("WriteCommu CVO ="+CVO);
	//요청설계를 할 때 nowPage는 컨트롤러가 필요해서 받은것이 아니고 다음을 위해서
	//릴레이 시킨 파라메터 이므로 잊지말고 다음에 반드시 전달해야 한다.
		mv.addObject("nowPage", CVO.nowPage);
		mv.addObject("communo", CVO.communo);
		mv.setViewName("Commu/WriteCommu");
		return mv;
	}
	
	
	@RequestMapping("/WriteProc")
	public ModelAndView writeProc(HttpSession session,CommuVO CVO){
		String	id = (String) session.getAttribute("UID");
		CVO.usrId = id;
		//		디비에 입력하고
		int usrKey;
		usrKey=Integer.parseInt(String.valueOf(session.getAttribute("KEY")));
		CVO.usrKey=usrKey;
		CService.binsert(CVO);
		System.out.println("글쓴이 키값 :"+CVO.usrKey);
		System.out.println("글쓴이 ID : "+CVO.usrId);
		System.out.println("게시물 등록 커뮤니티 넘버 : "+CVO.communo);
		//		뷰를 부른다.
		RedirectView rv=
			new RedirectView("../Commu/CommuView.storm?communo="+CVO.communo+"&nowPage=1");
		ModelAndView mv =new ModelAndView();
		mv.addObject("WLIST", CVO);
		mv.setView(rv);
		return mv;
	}




	@RequestMapping("/BoardView")
	public ModelAndView boardview(int boardno, CommuVO CVO) {
		System.out.println("컨트롤러: boardview 시작");
	
		CVO= CService.getBoard(boardno);

		ModelAndView mv=new ModelAndView();
		mv.addObject("boardno", boardno);
		mv.addObject("CVO", CVO);
	//요청설계를 할 때 nowPage는 컨트롤러가 필요해서 받은것이 아니고 다음을 위해서
	//릴레이 시킨 파라메터이므로 잊지말고 다음에 반드시 전달해야 한다.
		mv.addObject("nowPage", CVO.nowPage);
		mv.setViewName("/Commu/BoardView");
		System.out.println("컨트롤러: boardview: "+boardno);
		return mv;
	}




/*
 * 커뮤니티 게시판 댓글 처리
 * 
 *  	
 */
	//댓글폼
	@RequestMapping("/ReviewDetailView")
	public ModelAndView ReviewDetailView(CommuVO CVO) { 

		ModelAndView	mv = new ModelAndView();
		mv.addObject("oriNo", CVO.oriNo);
		mv.addObject("nowPage", CVO.nowPage);
		mv.setViewName("Commu/CommureplyProc");
		System.out.println("컨트롤러: ReviewDetailView");
		return mv;
		
	}
	
	//댓글요청처리
		@RequestMapping("/CommureplyProc")
		public ModelAndView commureplyProc(CommuVO CVO, HttpSession session) {
			//유저키뽑기
			System.out.println("컨트롤러: commureplyProc 시작");
	/*		String	id = (String) session.getAttribute("UID");
			int usrKey= CService.getUserkey(id);
			System.out.println(usrKey);*/
			
			
			int usrKey= CVO.usrKey;
			int oriNo= CVO.oriNo;
			//유저키로 댓글인서트
			CService.insertReply(usrKey);
			System.out.println(oriNo);
			//오리넘버로 댓글데이터 가져오기
			CService.getReply(oriNo);
			
			RedirectView	rv = new RedirectView();
			rv.addStaticAttribute("nowPage", CVO.nowPage);
			rv.addStaticAttribute("oriNo", CVO.oriNo);
			rv.setUrl("../Commu/CommureplyProc");
			ModelAndView	mv = new ModelAndView();
			mv.setView(rv);
			System.out.println("컨트롤러: commureplyProc 끝");
			return mv;
		
		}
	
}	