package bean;

import java.util.List;



import com.pb.entity.Supplier;


public interface StudentService {

	// ��ȡ��ϲ�ѯ���ܼ�¼��
	public int getTotalRecord(String name, String desc);

	// ��ȡ��ҳ�����ݼ���
	public List<Supplier> getStudentList(int pc, int ps, String name,
			String desc);

	// ��ȡpageBean
	public PageBean getPageBean(int pc, int ps, String name, String desc);
}
