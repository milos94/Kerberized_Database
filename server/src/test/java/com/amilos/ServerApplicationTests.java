package com.amilos;

import com.amilos.models.Transaction;
import com.amilos.models.User;
import com.amilos.services.TransactionService;
import com.amilos.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServerApplication.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class ServerApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionService transactionService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void repositroyTest(){
		List<User> userList = userService.findAll();
		userList.stream().forEach(System.out::println);
		assertNotNull(userList);
	}

	@Test
	public void loginTest(){
		final String uri="http://localhost:8080/login";
		RestTemplate restTemplate = new RestTemplate();
		byte[] result = restTemplate.postForObject(uri,1L,byte[].class);
		assertNotNull(result);
	}

	@Test
	public void transactionRepositoryTest(){
		try {
			List<Transaction> list = transactionService.findAll();
			assertNotNull(list);
			list.stream().forEach(System.out::println);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void transactionRepostirotyTest2(){
		try {
			List<Transaction> list = transactionService.findAllByUserId(1L);
			assertNotNull(list);
			list.stream().forEach(System.out::println);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
