package com.sogou.bizqa.seleniumxuri.po;

public class PlanList {
	private String cpcPlanName;// 计划名称
	private String status;//状态
	private String Buget;//每日预算
	private String regions;//投放地区
	private String schedule;//投放时段
	private String mobilePriceRate;//移动出价比例
	private String clicks;//点击数
	private String cost;//消耗
	private String averages;//点击均价
	private String impression;//展示数
	private String ctr;//点击率
//	private String position;//转化次数（已下线）
	private String isUnionShow;//内容关联
	private String denyKey;//否定关键词
	private String dynamicIdea;//动态创意状态
//	private String knowledgeCubicPriceRate;//知立方出价比例
	
	public String getCpcPlanName() {
		return cpcPlanName;
	}
	public void setCpcPlanName(String cpcPlanName) {
		this.cpcPlanName = cpcPlanName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuget() {
		return Buget;
	}
	public void setBuget(String buget) {
		Buget = buget;
	}
	public String getRegions() {
		return regions;
	}
	public void setRegions(String regions) {
		this.regions = regions;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getMobilePriceRate() {
		return mobilePriceRate;
	}
	public void setMobilePriceRate(String mobilePriceRate) {
		this.mobilePriceRate = mobilePriceRate;
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
//	public String getPosition() {
//		return position;
//	}
//	public void setPosition(String position) {
//		this.position = position;
//	}
	public String getIsUnionShow() {
		return isUnionShow;
	}
	public void setIsUnionShow(String isUnionShow) {
		this.isUnionShow = isUnionShow;
	}
	public String getDenyKey() {
		return denyKey;
	}
	public void setDenyKey(String denyKey) {
		this.denyKey = denyKey;
	}
	public String getDynamicIdea() {
		return dynamicIdea;
	}
	public void setDynamicIdea(String dynamicIdea) {
		this.dynamicIdea = dynamicIdea;
	}
//	public String getKnowledgeCubicPriceRate() {
//		return knowledgeCubicPriceRate;
//	}
//	public void setKnowledgeCubicPriceRate(String knowledgeCubicPriceRate) {
//		this.knowledgeCubicPriceRate = knowledgeCubicPriceRate;
//	}

}
