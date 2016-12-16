/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.po;

/**
 * @author wangfan
 *
 */
public class IdeaList {
	private String cpcIdeaTitle;//创意标题
	private String cpcPlanName;//计划名称
	private String cpcGrpName;//推广组名称
	private String status;//状态
	private String clicks;//点击数
	private String cost;//消耗
	private String averages;//点击均价
	private String impression;//展示数
	private String ctr;//点击率
//	private String position;//转化次数（已下线）
	public String getCpcIdeaTitle() {
		return cpcIdeaTitle;
	}
	public void setCpcIdeaTitle(String cpcIdeaTitle) {
		this.cpcIdeaTitle = cpcIdeaTitle;
	}
	public String getCpcPlanName() {
		return cpcPlanName;
	}
	public void setCpcPlanName(String cpcPlanName) {
		this.cpcPlanName = cpcPlanName;
	}
	public String getCpcGrpName() {
		return cpcGrpName;
	}
	public void setCpcGrpName(String cpcGrpName) {
		this.cpcGrpName = cpcGrpName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClicks() {
		return clicks;
	}
	public void setClicks(String clicks) {
		this.clicks = clicks;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getAverages() {
		return averages;
	}
	public void setAverages(String averages) {
		this.averages = averages;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getCtr() {
		return ctr;
	}
	public void setCtr(String ctr) {
		this.ctr = ctr;
	}
/*	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	*/
}
