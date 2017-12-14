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
	
	
//Ŀ�´�Ƽ �Խ��� ���
	@RequestMapping("/CommuMain")
	public ModelAndView commumain
	(@RequestParam(value="nowPage",defaultValue="1")int nowPage, HttpSession session){
//	����
//	�Ķ���� �ޱ�
//	�����ͺ��̽����� ����� �̴´�.
//1.�� ������ ������ ���ؼ� ������ ������ �����.
		int total=CService.getcommuTotal();
		PageUtil pInfo=
				new PageUtil(nowPage,total);
//2.������ ������ �̿��ؼ� �� �������� �ʿ��� ��ϸ� ���Ѵ�.
		ArrayList list= CService.getCommuList(nowPage, pInfo);
//	�信 �𵨷� �˷��ش�.
//	�並 �θ���.
		String email= (String)session.getAttribute("UID");
		System.out.println(email);
		if(email==null){
			ModelAndView mv = new ModelAndView();
			String dologin = "�α����ϼ���";
			mv.addObject("DOLOGIN", dologin);
			mv.setViewName("Login/LoginForm");
			return mv;
		}
		ModelAndView mv=new ModelAndView();
//	���� �Է��Ѵ�.
//�Լ�	addObject("Ű��",������);
		mv.addObject("PINFO",pInfo);
		mv.addObject("LIST",list);
		mv.setViewName("Commu/CommuMain");
		System.out.println("��������?"+mv);
		
		return mv;
	}
	
	//�󼼺��� ��û�� ó���� ��Ʈ�ѷ� �Լ�
	@RequestMapping("/CommuView")
	public ModelAndView commuView
	(CommuVO CVO,HttpSession session,
	@RequestParam(value="nowPage",defaultValue="1")int nowPage){
//		����
//		�Ķ���� �ޱ�
//		�����ͺ��̽����� ����� �̴´�.
	//1.�� ������ ������ ���ؼ� ������ ������ �����.
		
			int total=CService.getboardTotal();
			PageUtil pInfo=new PageUtil(nowPage,total);
	//2.������ ������ �̿��ؼ� �� �������� �ʿ��� ��ϸ� ���Ѵ�.
			ArrayList list= CService.getBlist(nowPage, pInfo,CVO);

			HashMap map=CService.commuView(CVO.communo);
			int usrKey;
			usrKey=Integer.parseInt(String.valueOf(session.getAttribute("KEY")));
			String whatshow="";
			System.out.println("����Ű"+usrKey);
			CVO.usrKey=usrKey;
				whatshow=CService.selectshow(CVO);

	//�並 �θ���.
			ModelAndView mv=new ModelAndView();
			mv.addObject("MAP",map);
			System.out.println(map);
			mv.addObject("SHOWLIST", whatshow);
			System.out.println("SHOWLIST= "+whatshow);
			mv.addObject("PINFO",pInfo);
			mv.addObject("BLIST",list);
		//��û���踦 �� �� nowPage�� ��Ʈ�ѷ��� �ʿ��ؼ� �������� �ƴϰ� ������ ���ؼ�
		//������ ��Ų �Ķ�����̹Ƿ� �������� ������ �ݵ�� �����ؾ� �Ѵ�.
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
		
		
		System.out.println("Ŀ�³�"+communo+"������"+usrKey+"�ӵ�"+whatdo);
		
		CVO.communo=communo;
		CVO.usrKey=usrKey;
		String whatshow="";
		if(whatdo.equals("add")){
			CService.insertF(CVO);//�����̺� �μ�Ʈ
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
	//��û���踦 �� �� nowPage�� ��Ʈ�ѷ��� �ʿ��ؼ� �������� �ƴϰ� ������ ���ؼ�
	//������ ��Ų �Ķ���� �̹Ƿ� �������� ������ �ݵ�� �����ؾ� �Ѵ�.
		mv.addObject("nowPage", CVO.nowPage);
		mv.addObject("communo", CVO.communo);
		mv.setViewName("Commu/WriteCommu");
		return mv;
	}
	
	
	@RequestMapping("/WriteProc")
	public ModelAndView writeProc(HttpSession session,CommuVO CVO){
		String	id = (String) session.getAttribute("UID");
		CVO.usrId = id;
		//		��� �Է��ϰ�
		int usrKey;
		usrKey=Integer.parseInt(String.valueOf(session.getAttribute("KEY")));
		CVO.usrKey=usrKey;
		CService.binsert(CVO);
		System.out.println("�۾��� Ű�� :"+CVO.usrKey);
		System.out.println("�۾��� ID : "+CVO.usrId);
		System.out.println("�Խù� ��� Ŀ�´�Ƽ �ѹ� : "+CVO.communo);
		//		�並 �θ���.
		RedirectView rv=
			new RedirectView("../Commu/CommuView.storm?communo="+CVO.communo+"&nowPage=1");
		ModelAndView mv =new ModelAndView();
		mv.addObject("WLIST", CVO);
		mv.setView(rv);
		return mv;
	}




	@RequestMapping("/BoardView")
	public ModelAndView boardview(int boardno, CommuVO CVO) {
		System.out.println("��Ʈ�ѷ�: boardview ����");
	
		CVO= CService.getBoard(boardno);

		ModelAndView mv=new ModelAndView();
		mv.addObject("boardno", boardno);
		mv.addObject("CVO", CVO);
	//��û���踦 �� �� nowPage�� ��Ʈ�ѷ��� �ʿ��ؼ� �������� �ƴϰ� ������ ���ؼ�
	//������ ��Ų �Ķ�����̹Ƿ� �������� ������ �ݵ�� �����ؾ� �Ѵ�.
		mv.addObject("nowPage", CVO.nowPage);
		mv.setViewName("/Commu/BoardView");
		System.out.println("��Ʈ�ѷ�: boardview: "+boardno);
		return mv;
	}




/*
 * Ŀ�´�Ƽ �Խ��� ��� ó��
 * 
 *  	
 */
	//�����
	@RequestMapping("/ReviewDetailView")
	public ModelAndView ReviewDetailView(CommuVO CVO) { 

		ModelAndView	mv = new ModelAndView();
		mv.addObject("oriNo", CVO.oriNo);
		mv.addObject("nowPage", CVO.nowPage);
		mv.setViewName("Commu/CommureplyProc");
		System.out.println("��Ʈ�ѷ�: ReviewDetailView");
		return mv;
		
	}
	
	//��ۿ�ûó��
		@RequestMapping("/CommureplyProc")
		public ModelAndView commureplyProc(CommuVO CVO, HttpSession session) {
			//����Ű�̱�
			System.out.println("��Ʈ�ѷ�: commureplyProc ����");
	/*		String	id = (String) session.getAttribute("UID");
			int usrKey= CService.getUserkey(id);
			System.out.println(usrKey);*/
			
			
			int usrKey= CVO.usrKey;
			int oriNo= CVO.oriNo;
			//����Ű�� ����μ�Ʈ
			CService.insertReply(usrKey);
			System.out.println(oriNo);
			//�����ѹ��� ��۵����� ��������
			CService.getReply(oriNo);
			
			RedirectView	rv = new RedirectView();
			rv.addStaticAttribute("nowPage", CVO.nowPage);
			rv.addStaticAttribute("oriNo", CVO.oriNo);
			rv.setUrl("../Commu/CommureplyProc");
			ModelAndView	mv = new ModelAndView();
			mv.setView(rv);
			System.out.println("��Ʈ�ѷ�: commureplyProc ��");
			return mv;
		
		}
	
}	