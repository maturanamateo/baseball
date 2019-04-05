package baseball;

public class Team implements Comparable<Team>  {
	int wins = 0;
	int losses = 0;
	int number;
	double ranking;
	String name;
    Division division;
	
	public Team (String name, Division division, double ranking, int number) {
		this.name = name;
		this.division = division;
		this.ranking = ranking;
		this.number = number;
	}
	
	public int compareTo(Team rival) {
		return rival.wins - this.wins;
	}
	
	public void compete(Team rival) {
		double result = (Math.random()*(this.ranking + rival.ranking));
		if (result < ranking ) {
			this.wins++;
			rival.losses++;
			this.ranking += .2;
			rival.ranking += -.2;
		}
		else {
			this.losses++;
			rival.wins++;
			this.ranking += -.2;
			rival.ranking +=.2;
		}
	}
	
	
}

