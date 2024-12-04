
public class Game {
	private String gameName;
	private String consoleName;
	public Game() 
	{
		this.gameName = "none";
		this.consoleName = "none";
	}
	public Game(String game, String console) 
	{
		this.gameName = game;
		this.consoleName = console;
	}
	public String getGameName() 
	{
		return this.gameName;
	}
	public String getConsoleName() 
	{
		return this.consoleName;
	}
	public void setGameName(String game) 
	{
		if(game == null)
			this.gameName = "none";
		else
			this.gameName = game;
	}
	public void setConsoleName(String console) 
	{
		if(console == null)
			this.consoleName = "none";
		else
			this.consoleName = console;
	}

}
