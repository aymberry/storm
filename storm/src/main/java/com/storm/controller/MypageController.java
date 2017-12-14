package com.storm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.storm.util.PageUtil;
import com.storm.VO.CommuVO;
import com.storm.VO.MemberVO;
import com.storm.Service.CommuService;
import com.storm.Service.MypageService;

@Controller
public class MypageController {

	@Autowired
	public MypageService mService;
	@Autowired
	public CommuService CService;
	
	//마이페이지목록 보기 요청처리 함수
	@RequestMapping("Mypage/MypageList")
	public ModelAndView mypageList(@RequestParam(value="nowPage", defaultValue="1")
	int nowPage, HttpSession session, MemberVO mVO) {
		String email= (String)session.getAttribute("UID");
		System.out.println(email);
		if(email==null){
			ModelAndView mv = new ModelAndView();
			String dologin = "로그인하세요";
			mv.addObject("DOLOGIN", dologin);
			mv.setViewName("Login/LoginForm");
			return mv;
		}
		MemberVO vo= mService.getMember(email);
		PageUtil pInfo= new PageUtil(nowPage, 10);
		
		ArrayList list= mService.getMyCommuList(nowPage, pInfo, vo);
		ModelAndView mv = new ModelAndView();

		mv.addObject("VO", vo);
		mv.addObject("PINFO",pInfo);
		mv.addObject("LIST",list);
		mv.setViewName("Mypage/MypageList");
		System.out.println("컨트롤러 :mypageList: "+ email+"__" + vo.getNo());

		return mv;

	}
	
/*	//내커뮤니티목록 불러오기
	@RequestMapping("Mypage/MyCommuList")
	public ModelAndView myCommuList(@RequestParam(value="nowPage", defaultValue="1")
							int nowPage, HttpSession session, MemberVO mVO) {

		String email=(String)session.getAttribute("UID");
		mVO= mService.getMember(email);
		
		//int total= CService.getTotal();
		PageUtil pInfo= new PageUtil(nowPage, 10);
		
		ArrayList list= mService.getMyCommuList(nowPage, pInfo, mVO);
		
		ModelAndView	mv = new ModelAndView();
		mv.addObject("PINFO",pInfo);
		mv.addObject("LIST",list);
		mv.setViewName("Mypage/MyCommuList");
		System.out.println("컨트롤러: myCommuList: "+list);
		return mv;

	}*/
	
	
	//회원정보 수정폼
	@RequestMapping("Mypage/ModifyForm")
	public ModelAndView ModifyForm(HttpSession session) {

		String email= (String)session.getAttribute("UID");
		MemberVO vo= mService.getMember(email);

		ModelAndView mv = new ModelAndView();
		mv.addObject("VO", vo);
		mv.setViewName("Mypage/ModifyForm");
		System.out.println("컨트롤러 :ModifyForm: "+ email+"__" + vo.getNo());
		
		return mv; 
	}
	
	
	
	//회원정보 수정
	@RequestMapping("Mypage/ModifyProc")
	public ModelAndView ModifyProc(HttpSession session) {

		String email= (String)session.getAttribute("UID");
		MemberVO vo= mService.getMember(email);
		int count= mService.updateUT(vo.getNo());
		System.out.println("컨트롤러: ModifyProc: "+vo.getNo());
//		BigDecimal	temp	=	(BigDecimal) session.getAttribute("KEY");
//		int key= temp.intValue();
//		MemberVO vo= mService.ModifyProc(key);
		
		ModelAndView mv = new ModelAndView();

		mv.addObject("VO",vo);
		System.out.println("mv.EMAIL:\t"+mv.getModel().get("EMAIL"));
		System.out.println("mv.KEY:\t"+mv.getModel().get("KEY"));
		System.out.println("컨트롤러 :ModifyProc :"+"PW");
		mv.setViewName("Mypage/ModifyForm");
		return mv;
	}
	
	

	@RequestMapping("Mypage/CommuUnFollow")
	public ModelAndView commuFollow(CommuVO CVO,HttpServletRequest req,HttpSession session){
		
		System.out.println("컨트롤러: commuFollow: 시작");
		String whatdo=req.getParameter("whatdo");
		String no =  req.getParameter("data2");
		System.out.println(no);
		String noWPage =req.getParameter("nowpage");
		int nowPage = Integer.parseInt(noWPage);
		int communo =Integer.parseInt(no);
		
		int usrKey =Integer.parseInt(String.valueOf(session.getAttribute("KEY")));
		
		System.out.println("커뮤넘"+communo+"유저넘"+usrKey+"왓두"+whatdo);
		
		CVO.communo=communo;
		CVO.usrKey=usrKey;
		
		if(whatdo.equals("add")){
			System.out.println("팔로우 등록하기!!");
			CService.insertF(CVO);//맵테이블에 인서트
		}
		else{
			System.out.println("팔로우 업데이트 !!");
			System.out.println("실행버튼은?= "+whatdo);
			CService.updateF(whatdo,CVO);
			//Dao.updataIsshow(whatdo, communo, usrNo); 
		}
		RedirectView rv= 

				new RedirectView("../Mypage/MypageList.storm");

		ModelAndView mv=new ModelAndView();
		mv.addObject("communo", CVO.communo);
		mv.addObject("nowPage", CVO.nowPage);
		//req.setAttribute("communo", communo);
		//req.setAttribute("nowpage", nowPage);
		mv.setView(rv);
			return mv;
	}

}
