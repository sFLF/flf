package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Comment;
import bean.CommentUserView;
import dao.DatabaseDao;
import service.CommentService;
import tools.PageInformation;

public class CommentServiceTest {

	static protected CommentService commentService;
	static protected PageInformation page;
	static protected DatabaseDao databaseDao;
	
	@BeforeClass
	static public void BeforeClass() throws Exception{
		commentService = new CommentService();
		page = new PageInformation();
		databaseDao = new DatabaseDao();
	}
	
	@AfterClass
	static public void AfterClass() throws Exception{
		databaseDao.close();
	}
	
	@Test
	public void testGetPage() throws Exception{
		//fail("Not yet implemented");
		List<CommentUserView> commentUserViews =commentService.getOnePage(page);
		assertNotNull(commentUserViews);
	}

	@Test
	public void testPaise() throws Exception{
		int paise = commentService.paise(23);
		assertEquals(paise, 1);
	}
	
	@Test
	public void testAddComment() throws Exception{
		Comment comment = new Comment();
		int result = commentService.addComment(comment);
		assertEquals(result, 2);
	}
	
	@Test
	public void testAddCommentToCom() throws Exception{
		Comment comment = new Comment();
		int result = commentService.addCommentToComment(comment);
		assertEquals(result, 4);
	}
}
