package bean;

import java.util.List;

public class PageBean {
	private int pc;//当前页
	private int ps;//pagesize 每页显示记录数
	private int tr;//totalrecord 总记录数
	private int tp;//totalPage 总页数
	private List beanList;//数据集合
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
