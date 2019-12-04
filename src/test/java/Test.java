import dao.UserDao;

public class Test {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		System.out.println(userDao.queryByNameAndPwd("1", "1"));
	}
}
