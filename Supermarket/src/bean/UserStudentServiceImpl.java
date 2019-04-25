package bean;

import java.util.List;

import com.pb.entity.User;

public class UserStudentServiceImpl implements UserStudentService {
	UserStudentDaoImpl dao = new UserStudentDaoImpl();

	@Override
	public int getTotalRecord(String name,int supers, String loginname) {
		// TODO Auto-generated method stub
		return dao.getTotalRecord(name,supers,loginname);
	}

	@Override
	public List<User> getStudentList(int pc, int ps, String name,int supers, String loginname) {
		// TODO Auto-generated method stub
		return dao.getStudentList(pc, ps, name,supers,loginname);
	}

	@Override
	public PageBean getPageBean(int pc, int ps, String name,int supers, String loginname ) {
		// TODO Auto-generated method stub
		PageBean pb = new PageBean();
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(getTotalRecord(name,supers,loginname));
		pb.setBeanList(getStudentList(pc, ps, name,supers,loginname));
		return pb;
	}

}
