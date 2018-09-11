package test;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Comment;
import bean.CommentUserView;
import dao.CommentDao;
import dao.DatabaseDao;
import tools.PageInformation;

public class CommentDaoTest {

	static protected CommentDao commentDao;
	static protected PageInformation page;
	static protected DatabaseDao databaseDao;
	
	@BeforeClass
	static public void BeforeClass() throws Exception{
		commentDao = new CommentDao();
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
		
		List<CommentUserView> commentUserViews = commentDao.getOnePage(page, databaseDao);
		assertNotNull(commentUserViews);
	}

	@Test
	public void testPaise() throws Exception{
		int paise = commentDao.paise(23);
		assertEquals(paise, 1);
	}
	
	@Test
	public void testStair() throws Exception{
		int stair = commentDao.getStairByNewsId(33, databaseDao);
		assertEquals(stair, 1);
	}
	
	@Test
	public void testAddComment() throws Exception{
		Comment comment =new Comment();
		comment.setNewsId(29);
		comment.setUserId(30);
		comment.setContent("我爱您中国！");
		comment.setStair(1);
		int result = commentDao.addComment(comment, databaseDao);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void testGetById() throws Exception{
		Comment comment = commentDao.getById(37, databaseDao);
		assertNotNull(comment);
	}
	
	@Test
	public void testGetByIdFromView() throws Exception{
		CommentUserView commentUserView =commentDao.getByIdFromView(42, databaseDao);
		assertNotNull(commentUserView);
	}
	
}
