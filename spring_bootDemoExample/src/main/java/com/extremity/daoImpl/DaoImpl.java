/*package com.extremity.daoImpl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extremity.dao.DaoInterface;
import com.extremity.model.User;


@Transactional
@Repository
public class DaoImpl implements DaoInterface{

	@Autowired
	private SessionFactory sf;
	
	@PersistenceContext
	private EntityManager entityManager;
	


	
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("in dao..");
		System.out.println(user.getUid()+"  "+user.getName()+"   "+user.getAddress()+"   "+user.getPassword()+"   "+user.getUname());
		
		entityManager.persist(user);	
	}





	@Override
	public int loginCheck(User user) {
		
		int id=0;
		System.out.println("in dao........");
		System.out.println(user.getUname());
		System.out.println(user.getPassword());
		Query query=entityManager.createQuery("from User where uname='"+user.getUname()+"' and password='"+user.getPassword()+"'");
		System.out.println(query);
		
		List li=query.getResultList();
		Iterator itr=li.iterator();
		while(itr.hasNext())
		{
			id=1;
			User s1=(User)itr.next();
			System.out.println(s1.getName());
			System.out.println(s1.getPassword());
		}
			
		return id;
	}





	@Override
	public int deleteUser(User user) {
		
		System.out.println("in delete dao...");
		Query query=entityManager.createQuery("delete from User user where user.uid="+user.getUid()+"");
		int id=query.executeUpdate();
		return id;
	}





	@Override
	public List<User> displayAll(User user) {
		
		TypedQuery<User> query=entityManager.createQuery("select u from User u",User.class);
		List<User> userList=query.getResultList();
		return userList;
	}





	@Override
	public User editUser(User user) {
		System.out.println("in edit dao....");
		Query query=entityManager.createQuery("from User user where user.uid="+user.getUid()+"");
		List<User> list=query.getResultList();
		Iterator< User> itr=list.iterator();
		User u=null;
		while(itr.hasNext())
		{
			u=itr.next();
			System.out.println(u.getName());
			System.out.println(u.getUid());
		}
		return u;
	}





	@Override
	public int updateUser(User user) {
		System.out.println("in update dao...");
		Query query=entityManager.createQuery("Update User user set user.name='"+user.getName()+"',user.uname='"+user.getUname()+"',user.password='"+user.getPassword()+"',user.address='"+user.getAddress()+"' where user.uid="+user.getUid()+"");
		int id=query.executeUpdate();
		return id;
	}

	


	public int loginCheck(User user) {

	}

	public int deleteUser(User user) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("delete From User user where user.uid="+user.getUid()+"");
		int id=query.executeUpdate();
		tx.commit();
		session.close();
		
		return id;
		
	}

	public List<User> displayAll(User user) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		List<User> list=cr.list();
		tx.commit();
		session.close();
		
		return list;
	}

	@Override
	public User editUser(User user) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		//Query query=session.createQuery("select user.name,user.uname,user.password,user.address from User user where user.uid="+user.getUid()+"");
		//int id=query.executeUpdate();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("uid",user.getUid()));
		List<User> list=cr.list();
		User user1=null;
		Iterator<User> itr=list.iterator();
		while(itr.hasNext())
		{
			user1=itr.next();
			System.out.println("daoedit:-"+user1.getName());
		}
		tx.commit();
		session.close();
		
		return user1;
	}

	@Override
	public int updateUser(User user) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User user1=new User();
		Query query=session.createQuery("Update User user set user.name='"+user.getName()+"',user.uname='"+user.getUname()+"',user.password='"+user.getPassword()+"',user.address='"+user.getAddress()+"' where user.uid="+user.getUid()+"");
		System.out.println(query);
		int id=query.executeUpdate();
		
		tx.commit();
		session.close();
		
		return id;
	}

}
*/