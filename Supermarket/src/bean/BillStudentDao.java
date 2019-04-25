package bean;

import java.util.List;

import com.pb.entity.Bill;


public interface BillStudentDao {
	//获取组合查询的总记录数
		public int getTotalRecord(String name, int ispay);
		//获取分页的数据集合
		public List<Bill> getStudentList(int pc,int ps,String name, int ispay);
	

}
