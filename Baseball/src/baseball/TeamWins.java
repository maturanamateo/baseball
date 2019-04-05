package baseball;

public class TeamWins implements Comparable<TeamWins>{
	int wins = 0;
	String name;
	public TeamWins (String name) {
		this.name = name;
	}
	
	public int compareTo(TeamWins rival) {
		return rival.wins - this.wins;
	}
	
}
