package Entities;

public class Campaign {
	Integer id;
	String campaignDetail;
	Game game;

	Integer discountAmount;

	Double unitPriceAfterDiscount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCampaignDetail() {
		return campaignDetail;
	}
	public void setCampaignDetail(String campaignDetail) {
		this.campaignDetail = campaignDetail;
	}
	public Double getUnitPriceAfterDiscount() {
		return this.game.unitPrice - (this.game.getUnitPrice() / 100 *  this.discountAmount) ; 
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getDiscountAmount() {
		return this.discountAmount; 
	}
	
}
