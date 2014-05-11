package com.taotaoti.common;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback=false)
public class BaseTestCase  extends AbstractTransactionalJUnit4SpringContextTests{
	@Override
	public void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
		super.setDataSource(dataSource);
	}

//	@Before
//	public void mockLogin(){
//		Visitor user = new Visitor();
//		user.setLoginUserId(10);
//		ThreadContext.putSessionVisitor(user);
//	}
	
	/**
	 * 把一个bean的某个属性mock成mockTo类
	 * @param bean
	 * @param field
	 * @param mockTo
	 * @return
	 */
	public Object mock(Object bean, String sField, Object mockTo){

		//做对象的mock
		Field field = null;
		try{
			field = bean.getClass().getDeclaredField(sField);
		}catch(Exception e){
			try {
				field = bean.getClass().getField(sField);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		field.setAccessible(true);
		Object mocked = null;
		try {
			mocked = field.get(bean);
			field.set(bean, mockTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mocked;
	}
}
