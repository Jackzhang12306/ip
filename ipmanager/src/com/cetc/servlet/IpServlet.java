package com.cetc.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cetc.bean.IpBean;
import com.cetc.dao.IpDao;
import com.cetc.dao.IpDaoImp;

//@WebServlet(name = "IpServlet",urlPatterns = {"/input","/save"})
public class IpServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2979647306589693136L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		process(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response){
		String uri = request.getRequestURI();
		int lastindex = uri.lastIndexOf("/");
		String action = uri.substring(lastindex+1);
		if(action.equals("input")){
			//nothing to do
		}else if (action.equals("save")) {
			IpBean ipBean = new IpBean();
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(request.getCharacterEncoding());
			ipBean.setIp(request.getParameter("ip"));
			ipBean.setUsername(request.getParameter("username"));
			ipBean.setDecription(request.getParameter("description"));
			ipBean.setUsed(Integer.parseInt(request.getParameter("used")));
			
			//存储
			IpDao ipDao = new  IpDaoImp();
			ipDao.addIp(ipBean);
			System.out.println("tianjiachenggong");
			request.setAttribute("ipBean", ipBean);
		}else if (action.equals("query")) {
			IpDao ipDao = new  IpDaoImp();
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String username = request.getParameter("username");
			System.out.println(username);
			List<IpBean> list =null;
			if (username==null||username.isEmpty()) {
				 list = ipDao.queryAll();
			}else{
				list = ipDao.queryByName(username);
			}
			
			request.setAttribute("list", list);

		}/*else if (action.equals("list")) {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");// 页号
			int pageNo;
			if (!id.isEmpty()){
				pageNo = Integer.parseInt(id);
			}	else
				pageNo = 1;
			RequestDispatcher rd;
			MessageDao dao = new MessageDao();
			Pager<Message> pager = dao.getPager(pageNo, 5, "list?");
			request.setAttribute("pager", pager);
			rd = request.getRequestDispatcher("msgList.jsp");
			rd.forward(request, response);
		}*/
		
		String dispatchUrl = null;
		if(action.equals("input")){
			dispatchUrl = "/input.jsp";
		}else if (action.equals("save")) {
			dispatchUrl = "/top.jsp";
		}else if (action.equals("query")) {
			dispatchUrl = "/detail.jsp";
		}
		if(dispatchUrl != null){
			RequestDispatcher rdDispatcher=request.getRequestDispatcher(dispatchUrl);
			try {
				rdDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	
	
	
