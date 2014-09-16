package com.duffiye.dao.impl.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.duffiye.dao.impl.UserDaoImpl;
import com.duffiye.entity.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class UserDaoImplTest {
	
	@Autowired
	UserDaoImpl userDao ;

	@Test
	public void testHello() {
		
		System.out.println(userDao);
		userDao.create(new User());
	}

}