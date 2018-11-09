package software;

import hardware.ConcertTicket;

public class SocialMedia {

	private String platform;
	
	public SocialMedia() {
		this.platform = "unknown";
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getPlatform() {
		return this.platform;
	}
	
	public void share(ConcertTicket ticket) {
		if (this.platform == "Facebook") {
			
		}
		else if(this.platform == "Twitter") {
			
		}
	}
}