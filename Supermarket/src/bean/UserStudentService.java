package bean;

import java.util.List;





import com.pb.entity.User;

public interface UserStudentService {
	// ��ȡ��ϲ�ѯ���ܼ�¼��
	public int getTotalRecord(String name,int supers, String loginname);

	// ��ȡ��ҳ�����ݼ���
	public List<User> getStudentList(int pc, int ps, String name,int supers, String loginname);

	// ��ȡpageBean
	public PageBean getPageBean(int pc, int ps, String name,int supers, String loginname);

}
