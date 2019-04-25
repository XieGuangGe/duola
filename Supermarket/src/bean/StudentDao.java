package bean;

import java.util.List;

import com.pb.entity.Supplier;

public interface StudentDao {

	
	//获取组合查询的总记录数
	public int getTotalRecord(String name, String desc);
	//获取分页的数据集合
	public List<Supplier> getStudentList(int pc,int ps,String name, String desc);
	
}
