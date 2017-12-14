package com.storm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.storm.Service.ChartService;
import com.storm.VO.GenreVO;

@Controller
//�� ��Ʈ�ѷ��� ���� ���ε�� ��Ʈ�ѷ� ��Ȱ�� �ϵ��� ����߹Ƿ�..
//���� ���ε� ��û�� ���� ������ �̸� ���� �־ ���� ���ʹ� ����� ���븸
//ó���ϵ��� ����.
@RequestMapping("/Chart")
public class ChartController {
	
	@Autowired
	private 	ChartService		chService;
	
	@RequestMapping("/ChartView")
	public ModelAndView ChartView(){

		ModelAndView	mv = new ModelAndView();
		ArrayList list = chService.GenreView();
		ArrayList lang = chService.LangView();
		
		ArrayList tag = chService.TagView();
		Gson gson = new Gson();
		String jtag = gson.toJson(tag);
		jtag=jtag.toLowerCase();
		
		mv.addObject("LANG",lang);
		mv.addObject("LIST", list);
		mv.addObject("TAG", jtag);
		
		mv.setViewName("Chart/ChartView");
		return mv;

	}
}
