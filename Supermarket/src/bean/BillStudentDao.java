package bean;

import java.util.List;

import com.pb.entity.Bill;


public interface BillStudentDao {
	//��ȡ��ϲ�ѯ���ܼ�¼��
		public int getTotalRecord(String name, int ispay);
		//��ȡ��ҳ�����ݼ���
		public List<Bill> getStudentList(int pc,int ps,String name, int ispay);
	

}
