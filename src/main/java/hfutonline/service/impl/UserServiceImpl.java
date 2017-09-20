package hfutonline.service.impl;

import hfutonline.dao.UserDao;
import hfutonline.entity.User;
import hfutonline.exception.UserException;
import hfutonline.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public void login(User user) throws UserException {

		if (user == null) {
			throw new UserException("登录的参数异常");
		}

		// 登录的手机号
		String phoneNumber = user.getPhoneNumber();

		//id
		Integer id=user.getId();

		// 登录的密码
		String password = user.getPassword();

		if (password == null) {
			throw new UserException("密码为空");
		}
		
		//id不为空
		if (id != null) {
			User s = userDao.queryById(user.getId());
			// 用户不存在
			if (s == null) {
				throw new UserException("该用户不存在");
			} else {
				if (password.equals(s.getPassword())) {
					// 登录成功
				} else {
					// 密码错误
					throw new UserException("密码错误");
				}
			}
		} else {
			throw new UserException("id为空");
		}
		throw new UserException("success");
	}

	@Override
	public void register(User user) throws UserException {
		
		if (user == null) {
			throw new UserException("注册的参数有误");
		}
		
		try {
			int result = userDao.add(user);
			
			if (result == 1) {
				//注册成功
			} else if (result == 0) {
				//手机号已存在
				throw new UserException("手机号已存在");
			} else {
				//注册失败
				throw new UserException("注册失败");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new UserException("注册失败", e);
		}
		
	}

	@Override
	public List<User> listAll() throws UserException {
		try {
			List<User> list = userDao.listAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("查询学生列表失败", e);
		}
	}

	@Override
	public void addUser(User user) throws UserException {
		if (user == null) {
			throw new UserException("添加学生的参数有误");
		}
		
		try {
			int result = userDao.add(user);
			
			if (result == 1) {
				//添加成功
			} else if (result == 0) {
				//手机号已存在
				throw new UserException("手机号已存在");
			} else {
				//添加失败
				throw new UserException("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("添加失败", e);
		}
	}

	@Override
	public void deleteUser(Integer id) throws UserException {
		if (id == null) {
			throw new UserException("删除的参数有误");
		}
		
		try {
			int result = userDao.deleteById(id);
			if (result == 1) {
				//删除成功
			} else {
				//删除失败
				throw new UserException("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("删除失败", e);
		}
	}

	@Override
	public void updateUser(User user) throws UserException {
		
	}
	
	
	
}
