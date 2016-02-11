package webapp.model;

public class RankedDivision {

	private String tier;
	private String division;
	
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "RankedDivision [tier=" + tier + ", division=" + division + "]";
	}
	
	
}
