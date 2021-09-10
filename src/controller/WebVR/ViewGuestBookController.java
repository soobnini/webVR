package controller.WebVR;

import controller.Controller;
import model.GuestBookUser;
import model.GuestBook;
import model.User;
import model.dao.ExhibitionDAO;
import model.dao.GuestBookDAO;
import model.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewGuestBookController implements Controller {

	private GuestBookDAO gbDAO = new GuestBookDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int exhbID = Integer.parseInt(request.getParameter("ExhbId"));// �Ķ���ͷ� ���� ���̵� ��������,���ð������� ����

		List<GuestBookUser> GBUList = gbDAO.getGuestBookList(exhbID);//���� ���̵�� ����� ����Ʈ
		
		request.setAttribute("GBUList", GBUList);		// GBList������

		return "/webVR/Guestbook.jsp";
	}

}