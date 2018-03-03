package Map集合;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录方法
 * @author Administrator
 *
 */
public class UserService {
    private Map<String,User> users = new HashMap<String,User>();
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
	public User login(String username,String password){
	/**
	 * 根据用户输入的用户名查询users
	 */
		User user = users.get(username);
		//查看map中是否有这个用户
		if(user == null){
			//抛出异常
			throw new RuntimeException("没有该用户！");
		}
		/**
		 * 若有该用户。那么就判断用户输入的密码和User对象中
		 * 保存的该用户密码是否一致
		 */
		if(!user.getPassword().equals(password)){
			throw new RuntimeException("密码输入错误！");
		}
		//用户名与密码都正确，就返回该用户信息
		return user;
	}
	public static void main(String[] args) {
		UserService service = new UserService();
		service.users.put("Xiloer", new User("Xiloer","1234"));
		service.users.put("Tom", new User("Tom","123456"));
		service.users.put("Killer", new User("Killer","002255"));
		/**
		 * 测试登录
		 */
		User user = service.login("Xiloer", "12344");
		System.out.println(user.getUsername()+"登录成功");
	}
}
