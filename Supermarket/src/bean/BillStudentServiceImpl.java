package bean;

import java.util.List;

import com.pb.entity.Bill;

public class BillStudentServiceImpl implements BillStudentService {
	BillStudentDaoImpl dao = new BillStudentDaoImpl();

	@Override
	public int getTotalRecord(String name, int ispay) {
		// TODO Auto-generated method stub
		return dao.getTotalRecord(name, ispay);
	}

	@Override
	public List<Bill> getStudentList(int pc, int ps, String name, int ispay) {
		// TODO Auto-generated method stub
		return dao.getStudentList(pc, ps, name, ispay);
	}

	@Override
	public PageBean getPageBean(int pc, int ps, String name, int ispay) {
		// TODO Auto-generated method stub
		PageBean pb = new PageBean();
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(getTotalRecord(name, ispay));

		pb.setBeanList(getStudentList(pc, ps, name, ispay));
		return pb;
	}

}
