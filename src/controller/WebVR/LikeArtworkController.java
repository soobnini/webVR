package controller.WebVR;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Artwork;
import model.Likes;
import model.User;
import model.dao.ArtworkDAO;
import model.dao.LikesDAO;
import model.dao.UserDAO;
import controller.WebVR.user.UserSessionUtils;

public class LikeArtworkController implements Controller {
	
	private ArtworkDAO artworkDAO = new ArtworkDAO();
	private LikesDAO likesDAO = new LikesDAO();
	private UserDAO userDAO = new UserDAO();
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int artworkId = Integer.parseInt(request.getParameter("artworkId"));
		Artwork artwork = artworkDAO.findArtwork(artworkId);
		artworkDAO.updateView(artwork); // ��ȸ�� ����
		
// ���� �ּ� �κ��� �α��� ���� ���� �� �׽�Ʈ�ؾ��ϴ� �κ�
// ���� ���ƿ䰡 �ݿ����� X
/*		
		// �α����� �Ǿ��ִ��� Ȯ��
		HttpSession session = request.getSession();
		if (!UserSessionUtils.hasLogined(session)) { // �α��� �ȵǾ��ִ� �ִ� ���
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('�α����� ���ּ���')");
			out.println("</script>");
			out.flush();
        }
		
		int userId = Integer.parseInt(UserSessionUtils.getLoginUserId(session));
		User user = userDAO.findUser(userId);
		Likes like = likesDAO.findLikesByUserId(userId); // DB���� user�� artwork�� ���ƿ並 ���� ��� Ȯ��
		
		if (like == null) { // ���ƿ並 ���� ����� ���ٸ�
			artworkDAO.increaseLike(artwork); // artwork ���ƿ� ����
			likesDAO.create(user, artwork); // likes�� user�� �ش� artwork�� �����Ѵٴ� ������ ����
		}
		else { // ���ƿ並 ���� ����� �ִٸ�
			artworkDAO.decreaseLike(artwork); // artwork ���ƿ� ����
			likesDAO.remove(like.getLikeId()); // likes�� user�� �ش� artwork�� �����Ѵٴ� ������ ����
		}
*/		
		return "redirect:/WebVR/exhb/List/artwork?artworkId=" + artworkId;
	}
}