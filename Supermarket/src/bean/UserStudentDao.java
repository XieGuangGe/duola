package bean;

import java.util.List;




import com.pb.entity.User;

public interface UserStudentDao {

	// ��ȡ��ϲ�ѯ���ܼ�¼��
	public int getTotalRecord(String name,int supers, String loginname);

	// ��ȡ��ҳ�����ݼ���
	public List<User> getStudentList(int pc, int ps, String name,int supers, String loginname);

}
