package com.game.revenue;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
	
@Path("/revenuedetails")
public class GameResource {
    
	GameDatabase repo = new GameDatabase();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GameRevenue> getRevenueDetails() 
	{		
		System.out.println("Get Revenue values");		
		return repo.getRevenueDetails();
	}
	
	@GET
	@Path("winamount/{memberId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GameRevenue getWinAmount(@PathParam("memberId") int memberId,
			@QueryParam("byMonth") @DefaultValue("0") int byMonth,
			@QueryParam("byGameType") @DefaultValue("0") int byGameType) 
	{		
		System.out.println("Get Win Amount value");
		return repo.getWinAmount(memberId, byMonth, byGameType);
	}
	
	@GET
	@Path("wageramount/{memberId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GameRevenue getWagerAmount(@PathParam("memberId") int memberId,
			@QueryParam("byMonth") @DefaultValue("0") int byMonth,
			@QueryParam("byGameType") @DefaultValue("0") int byGameType)
	{		
		System.out.println("Get Wager Amount value");
		return repo.getWagerAmount(memberId, byMonth, byGameType);
	}
	
	@GET
	@Path("numberOfWagers/{memberId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GameRevenue getNumberOfWagers(@PathParam("memberId") int memberId,
			@QueryParam("byMonth") @DefaultValue("0") int byMonth,
			@QueryParam("byGameType") @DefaultValue("0") int byGameType)
	{		
		System.out.println("Get Number Of Wagers value");
		return repo.getNumberOfWagers(memberId, byMonth, byGameType);
	}
	
}
