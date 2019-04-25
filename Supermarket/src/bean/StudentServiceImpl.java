package bean;

import java.util.List;

import com.pb.entity.Supplier;

public class StudentServiceImpl implements StudentService {
	StudentDaoImpl dao = new StudentDaoImpl();

	@Override
	public int getTotalRecord(String name, String desc) {
		// TODO Auto-generated method stub
		return dao.getTotalRecord(name, desc);
	}

	@Override
	public List<Supplier> getStudentList(int pc, int ps, String name,
			String desc) {
		// TODO Auto-generated method stub
		return dao.getStudentList(pc, ps, name, desc);
	}

	@Override
	public PageBean getPageBean(int pc, int ps, String name, String desc) {
		// TODO Auto-generated method stub
		PageBean pb = new PageBean();
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(getTotalRecord(name, desc));
		
		pb.setBeanList(getStudentList(pc, ps, name, desc));
		return pb;
	}

}
