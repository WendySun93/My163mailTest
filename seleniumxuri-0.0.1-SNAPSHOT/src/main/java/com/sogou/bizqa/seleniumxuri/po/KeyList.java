/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.po;

/**
 * @author wangfan
 *
 */
public class KeyList {
	private String keyWord;//关键词
	private String cpcPlanName;//推广计划
	private String cpcGrpName;//推广组
	private String status;//状态
	private String isShow;//能否展现
	private String price;//出价
	private String cpcQuality;//计算机质量度
	private String mobileQuality;//移动质量度
	private String clicks;//点击数
	private String cost;//消耗
	private String averages;//点击均价
	private String impression;//展示数
	private String ctr;//点击率
//	private String position;//转化次数(已下线)
	private String matchType;//匹配方式
	private String visitUrl;//默认访问URL
	private String mobileVisitUrl;//移动访问URL
//	private String knowledgeCubicStatus;//知立方状态
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCpcQuality() {
		return cpcQuality;
	}
	public void setCpcQuality(String cpcQuality) {
		this.cpcQuality = cpcQuality;
	}
	public String getMobileQuality() {
		return mobileQuality;
	}
	public void setMobileQuality(String mobileQuality) {
		this.mobileQuality = mobileQuality;
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
	}*/
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public String getVisitUrl() {
		return visitUrl;
	}
	public void setVisitUrl(String visitUrl) {
		this.visitUrl = visitUrl;
	}
	public String getMobileVisitUrl() {
		return mobileVisitUrl;
	}
	public void setMobileVisitUrl(String mobileVisitUrl) {
		this.mobileVisitUrl = mobileVisitUrl;
	}
//	public String getKnowledgeCubicStatus() {
//		return knowledgeCubicStatus;
//	}
//	public void setKnowledgeCubicStatus(String knowledgeCubicStatus) {
//		this.knowledgeCubicStatus = knowledgeCubicStatus;
//	}
	
}
