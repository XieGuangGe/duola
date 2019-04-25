package bean;

import java.util.List;




import com.pb.entity.User;

public interface UserStudentDao {

	// 获取组合查询的总记录数
	public int getTotalRecord(String name,int supers, String loginname);

	// 获取分页的数据集合
	public List<User> getStudentList(int pc, int ps, String name,int supers, String loginname);

}
