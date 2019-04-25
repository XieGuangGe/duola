package bean;

import java.util.List;

public class PageBean {
	private int pc;//��ǰҳ
	private int ps;//pagesize ÿҳ��ʾ��¼��
	private int tr;//totalrecord �ܼ�¼��
	private int tp;//totalPage ��ҳ��
	private List beanList;//���ݼ���
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getTp() {
		tp = tr / ps;  
		return tr%ps==0?tp:tp+1;
	}
	public List getBeanList() {
		return beanList;
	}
	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}
	@Override
	public String toString() {
		return "PageBean [pc=" + pc + ", ps=" + ps + ", tr=" + tr + ", tp="
				+ tp + ", beanList=" + beanList + "]";
	}

}
