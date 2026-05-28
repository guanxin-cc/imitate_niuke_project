package com.nowcoder.community;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommunityApplicationTests {

	@Autowired
	private UserMapper userMapper;

	// 1. 测试：根据 id 查询用户
	@Test
	public void testSelectById() {
		User user = userMapper.selectById(1);
		System.out.println("根据ID查询用户：" + user);
	}

	// 2. 测试：根据用户名查询用户
	@Test
	public void testSelectByName() {
		User user = userMapper.selectByName("zhangsan");
		System.out.println("根据用户名查询用户：" + user);
	}

	// 3. 测试：根据邮箱查询用户
	@Test
	public void testSelectByEmail() {
		User user = userMapper.selectByEmail("zhangsan@qq.com");
		System.out.println("根据邮箱查询用户：" + user);
	}

	// 4. 测试：插入用户（会自动回填 id）
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUsername("xioaxin");
		user.setPassword("123456"); // 实际项目里这里要加密
		user.setSalt("abc123");
		user.setEmail("xaioxin@qq.com");
		user.setType(0);
		user.setStatus(1);
		user.setCreateTime(new java.util.Date());

		int rows = userMapper.insertUser(user);
		System.out.println("插入影响行数：" + rows);
		System.out.println("插入后自动生成的ID：" + user.getId());
	}

	// 5. 测试：更新用户状态
	@Test
	public void testUpdateStatus() {
		int rows = userMapper.updateStatus(1, 1); // 把用户1的状态设为已激活
		System.out.println("更新状态影响行数：" + rows);
	}

	// 6. 测试：更新用户头像
	@Test
	public void testUpdateHeader() {
		int rows = userMapper.updateHeader(1, "https://example.com/new_head.jpg");
		System.out.println("更新头像影响行数：" + rows);
	}

	// 7. 测试：更新用户密码
	@Test
	public void testUpdatePassword() {
		int rows = userMapper.updatePassword(1, "new_password_hash");
		System.out.println("更新密码影响行数：" + rows);
	}
}