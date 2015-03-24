package com.cem.entity.support;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cem.entity.Department;
import com.cem.entity.GraphData;
import com.cem.entity.Product;
import com.cem.entity.Question;
import com.cem.entity.User;


@Transactional
public class Repository {

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session getSession(){
		return sessionFactory.getCurrentSession();
	}


	public User findUserByEmail(String email){
		return (User) getSession().createQuery("FROM "+User.class.getName()+" where email=:email")
				.setParameter("email", email)				
				.uniqueResult();
	}

	public User findUserById(Long id){
		return (User) getSession().createQuery("FROM "+User.class.getName()+" where id=:id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	public Question findQuestionById(Long id){
		return (Question) getSession().createQuery("FROM "+Question.class.getName()+" where id=:id")
				.setParameter("id", id)
				.uniqueResult();
	}	
	
	public Question findQuestionByQuestionAndUser(String question,User user){
		return (Question) getSession().createQuery("FROM "+Question.class.getName()+" where question LIKE :question AND user=:user")
				.setParameter("question", "%"+question+"%")
				.setParameter("user", user)
				.uniqueResult();
	}	
	
	public Department findDepartmentByName(String name){
		return (Department) getSession().createQuery("FROM "+Department.class.getName()+" where name=:name")
				.setParameter("name", name)
				.uniqueResult();
	}	
	
	public Product findProductByName(String name){
		return (Product) getSession().createQuery("FROM "+Product.class.getName()+" where lower(name)=lower(:name)")
				.setParameter("name", name)
				.uniqueResult();
	}	
	
	public List<Product> listProductByName(String name){
		return getSession().createQuery("FROM "+Product.class.getName()+" where lower(name) LIKE lower(:name)")
				.setParameter("name","%" +name+"%")
				.list();
	}
	
	public Product findProductById(Long id){
		return (Product) getSession().createQuery("FROM "+Product.class.getName()+" where id=:id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	public Department findDepartmentById(Long id){
		return (Department) getSession().createQuery("FROM "+Department.class.getName()+" where id=:id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	
	public List<User> listUsersByName(String name){
		return getSession().createQuery("FROM "+User.class.getName()+" where name=:name")
				.setParameter("name", name)
				.list();
	}

	public List<User> listUsers(){
		return  getSession().createQuery("FROM "+User.class.getName())				
				.list();
	}

	public List<User> listLatestUsers(){
		return  getSession().createQuery("FROM "+User.class.getName()+" where date > :date")
				.setParameter("date", new Date((new Date().getTime()-(1000*60*60*24*7))))
				.list();
	}
	
	public List<GraphData> listGraphData(){
		return getSession().createQuery("FROM "+GraphData.class.getName())
				.list();
	}

	public List<Question> listQuestionsByUser(User user){
		return getSession().createQuery("FROM "+Question.class.getName()+" p where p.user=:user")
				.setParameter("user", user)				
				.list();
	}
	
	
	public List<Question> listAllQuestions(){
		return getSession().createQuery("FROM "+Question.class.getName())				
				.list();
	}	
	
	public List<Product> listAllProducts(){
		return getSession().createQuery("FROM "+Product.class.getName())				
				.list();
	}
	
	public List<Department> listAllDepartments(){
		return getSession().createQuery("FROM "+Department.class.getName())				
				.list();
	}
	
//	public GraphData findGraphData(Date date, GraphType graphType){
//
//		Date startTime=DateTimeUtil.getStartOfDay(date);
//		Date endTime=DateTimeUtil.getLastHourDate(date);
//
//		return (GraphData) getSession().createQuery("FROM "+GraphData.class.getName()+" gd where gd.date > :startTime AND gd.date < :endTime AND gd.graphType=:graphType")
//				.setParameter("startTime", startTime)
//				.setParameter("endTime", endTime)
//				.setParameter("graphType", graphType)
//				.uniqueResult();
//	}

	/*public List<GraphData> listGraphData(GraphType graphType){	

		return getSession().createQuery("FROM "+GraphData.class.getName()+" where graphType=:graphType")				
				.setParameter("graphType", graphType)
				.list();
	}*/
}
