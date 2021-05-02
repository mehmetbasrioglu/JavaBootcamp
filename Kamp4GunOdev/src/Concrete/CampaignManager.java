package Concrete;

import Abstract.CampaignService;
import Entities.Campaign;

public class CampaignManager implements CampaignService{

	@Override
	public void addCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		System.out.println(campaign.getCampaignDetail() + " -  Created New Campaign" );
		
		
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		System.out.println(campaign.getCampaignDetail() +  "  - Updated ");
		
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		System.out.println(campaign.getCampaignDetail() + " - Deleted");
		
	}
	
}
