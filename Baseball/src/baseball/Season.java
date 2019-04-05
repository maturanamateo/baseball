package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//https://www.baseball-reference.com/leagues/team_compare.cgi
//Taking WAR + 150 from 2018 to determine initial rankings

import baseball.Team;

public class Season {
	Team Yankees = new Team ("Yankees", Division.AL_EAST ,165.7, 1);
	Team Red_Sox = new Team ("Red Sox", Division.AL_EAST, 170.9, 2);
	Team Blue_Jays = new Team("Blue Jays", Division.AL_EAST, 138.2, 3);
	Team Orioles = new Team ("Orioles", Division.AL_EAST, 126.5, 4);
	Team Rays = new Team("Rays", Division.AL_EAST, 160.8, 5);
	Team White_Sox = new Team ("White Sox", Division.AL_CENTRAL,132.7, 6);
	Team Indians = new Team ("Indians", Division.AL_CENTRAL, 165.3, 7);
	Team Tigers = new Team ("Tigers", Division.AL_CENTRAL, 132.7, 8);
	Team Royals = new Team ("Royals" , Division.AL_CENTRAL, 133, 9);
	Team Twins = new Team ("Twins", Division.AL_CENTRAL,143.7, 10);
	Team Astros = new Team ("Astros", Division.AL_WEST, 172.1, 11);
	Team Angels = new Team ("Angels" , Division.AL_WEST, 150.3, 12);
	Team Athletics = new Team("Athletics", Division.AL_WEST,163.4, 13);
	Team Mariners = new Team("Mariners", Division.AL_WEST,151.1, 14);
	Team Rangers = new Team ("Rangers", Division.AL_WEST, 142.7, 15);
	Team Braves = new Team("Braves", Division.NL_EAST, 159.1, 16);
	Team Marlins = new Team("Marlins", Division.NL_EAST, 127.9, 17);
	Team Mets = new Team("Mets", Division.NL_EAST, 148.9, 18);
	Team Phillies = new Team ("Phillies", Division.NL_EAST, 147.1, 19);
	Team Nationals = new Team("Nationals", Division.NL_EAST, 158.2, 20);
	Team Cubs = new Team("Cubs", Division.NL_CENTRAL, 162.6, 21);
	Team Reds = new Team("Reds", Division.NL_CENTRAL, 140.5, 22);
	Team Brewers = new Team("Brewers", Division.NL_CENTRAL, 157.7, 23);
	Team Pirates = new Team ("Pirates", Division.NL_CENTRAL, 148.9, 24);
	Team Cardinals = new Team ("Cardinals", Division.NL_CENTRAL, 149.7, 25);
	Team Diamondbacks = new Team ("Diamondbacks", Division.NL_WEST, 152.4, 26);
	Team Rockies = new Team ("Rockies", Division.NL_WEST, 155.4, 27);
	Team Dodgers = new Team ("Dodgers", Division.NL_WEST, 167.2, 28);
	Team Padres = new Team ("Padres", Division.NL_WEST, 132.8, 29);
	Team Giants = new Team ("Giants", Division.NL_WEST, 139.8, 30);
	Team [] ALE = {Yankees, Red_Sox, Blue_Jays, Orioles, Rays};
	Team [] ALC = {White_Sox, Indians, Tigers, Royals, Twins};
	Team [] ALW = {Astros, Angels, Athletics, Mariners, Rangers};
	Team [] NLE = {Braves, Marlins, Mets, Phillies, Nationals};
	Team [] NLC = {Cubs, Reds, Brewers, Pirates, Cardinals};
	Team [] NLW = {Diamondbacks, Rockies, Dodgers, Padres, Giants};
	ArrayList <Team> postAL = new ArrayList<Team>();
	ArrayList <Team> postNL = new ArrayList<Team>();
	ArrayList <Team> winner = new ArrayList<Team>();
			
	public Season() {}
	
	//simulates 19 games against each team in division
	public void simulateDivision(Team [] a) {
		for (int div = 0; div < 4; div++) {
			for (int div2 = (div + 1); div2 < 5; div2++) {
				for (int ALEGAMES = 0; ALEGAMES < 19; ALEGAMES++) {
					a[div].compete(a[div2]);
				}
			}
		}
				
	}
	
	//next 6 methods simulate all Inter Division games
	public void simulateInterDivisionALEvALC() {
		Collections.shuffle(Arrays.asList(ALE));
		Collections.shuffle(Arrays.asList(ALC));
		for (int team1 = 0; team1 < 5; team1++) {
			for (int team2 = 0; team2 < 5; team2++) {
				for (int games = 0; games < 6;games++) {
					ALE[team1].compete(ALC[team2]);
				}
			}
			if (team1 < 2) {
				for (int add = 1; add < 4; add++) {
					ALE[team1].compete(ALC[team1 + add]);
				}
			}
			else if (team1 == 2) {
				ALE[team1].compete(ALC[team1+1]);
				ALE[team1].compete(ALC[team1+2]);
				ALE[team1].compete(ALC[team1-2]);
			}
			else if (team1 == 3) {
				ALE[team1].compete(ALC[team1+1]);
				ALE[team1].compete(ALC[team1-3]);
				ALE[team1].compete(ALC[team1-2]);
			}
			else {
				ALE[team1].compete(ALC[team1-4]);
				ALE[team1].compete(ALC[team1-3]);
				ALE[team1].compete(ALC[team1-2]);
			}
		}
	}

	public void simulateInterDivisionALEvALW() {
		Collections.shuffle(Arrays.asList(ALE));
		Collections.shuffle(Arrays.asList(ALW));
		for (int team1 = 0; team1 < 5; team1++) {
			for (int team2 = 0; team2 < 5; team2++) {
				for (int games = 0; games < 6;games++) {
					ALE[team1].compete(ALW[team2]);
				}
			}
			if (team1 < 2) {
				for (int add = 1; add < 4; add++) {
					ALE[team1].compete(ALW[team1 + add]);
				}
			}
			else if (team1 == 2) {
				ALE[team1].compete(ALW[team1+1]);
				ALE[team1].compete(ALW[team1+2]);
				ALE[team1].compete(ALW[team1-2]);
			}
			else if (team1 == 3) {
				ALE[team1].compete(ALW[team1+1]);
				ALE[team1].compete(ALW[team1-3]);
				ALE[team1].compete(ALW[team1-2]);
			}
			else {
				ALE[team1].compete(ALW[team1-4]);
				ALE[team1].compete(ALW[team1-3]);
				ALE[team1].compete(ALW[team1-2]);
			}
		}
	}
	
	public void simulateInterDivisionALCvALW() {
		Collections.shuffle(Arrays.asList(ALC));
		Collections.shuffle(Arrays.asList(ALW));
		for (int team1 = 0; team1 < 5; team1++) {
			for (int team2 = 0; team2 < 5; team2++) {
				for (int games = 0; games < 6;games++) {
					ALC[team1].compete(ALW[team2]);
				}
			}
			if (team1 < 2) {
				for (int add = 1; add < 4; add++) {
					ALC[team1].compete(ALW[team1 + add]);
				}
			}
			else if (team1 == 2) {
				ALC[team1].compete(ALW[team1+1]);
				ALC[team1].compete(ALW[team1+2]);
				ALC[team1].compete(ALW[team1-2]);
			}
			else if (team1 == 3) {
				ALC[team1].compete(ALW[team1+1]);
				ALC[team1].compete(ALW[team1-3]);
				ALC[team1].compete(ALW[team1-2]);
			}
			else {
				ALC[team1].compete(ALW[team1-4]);
				ALC[team1].compete(ALW[team1-3]);
				ALC[team1].compete(ALW[team1-2]);
			}
		}
	}
	
	public void simulateInterDivisionNLEvNLC() {
		Collections.shuffle(Arrays.asList(NLE));
		Collections.shuffle(Arrays.asList(NLC));
		for (int team1 = 0; team1 < 5; team1++) {
			for (int team2 = 0; team2 < 5; team2++) {
				for (int games = 0; games < 6;games++) {
					NLE[team1].compete(NLC[team2]);
				}
			}
			if (team1 < 2) {
				for (int add = 1; add < 4; add++) {
					NLE[team1].compete(NLC[team1 + add]);
				}
			}
			else if (team1 == 2) {
				NLE[team1].compete(NLC[team1+1]);
				NLE[team1].compete(NLC[team1+2]);
				NLE[team1].compete(NLC[team1-2]);
			}
			else if (team1 == 3) {
				NLE[team1].compete(NLC[team1+1]);
				NLE[team1].compete(NLC[team1-3]);
				NLE[team1].compete(NLC[team1-2]);
			}
			else {
				NLE[team1].compete(NLC[team1-4]);
				NLE[team1].compete(NLC[team1-3]);
				NLE[team1].compete(NLC[team1-2]);
			}
		}
	}
	
	public void simulateInterDivisionNLEvNLW() {
		Collections.shuffle(Arrays.asList(NLE));
		Collections.shuffle(Arrays.asList(NLW));
		for (int team1 = 0; team1 < 5; team1++) {
			for (int team2 = 0; team2 < 5; team2++) {
				for (int games = 0; games < 6;games++) {
					NLE[team1].compete(NLW[team2]);
				}
			}
			if (team1 < 2) {
				for (int add = 1; add < 4; add++) {
					NLE[team1].compete(NLW[team1 + add]);
				}
			}
			else if (team1 == 2) {
				NLE[team1].compete(NLW[team1+1]);
				NLE[team1].compete(NLW[team1+2]);
				NLE[team1].compete(NLW[team1-2]);
			}
			else if (team1 == 3) {
				NLE[team1].compete(NLW[team1+1]);
				NLE[team1].compete(NLW[team1-3]);
				NLE[team1].compete(NLW[team1-2]);
			}
			else {
				NLE[team1].compete(NLW[team1-4]);
				NLE[team1].compete(NLW[team1-3]);
				NLE[team1].compete(NLW[team1-2]);
			}
		}
	}
	
	public void simulateInterDivisionNLCvNLW() {
		Collections.shuffle(Arrays.asList(NLC));
		Collections.shuffle(Arrays.asList(NLW));
		for (int team1 = 0; team1 < 5; team1++) {
			for (int team2 = 0; team2 < 5; team2++) {
				for (int games = 0; games < 6;games++) {
					NLC[team1].compete(NLW[team2]);
				}
			}
			if (team1 < 2) {
				for (int add = 1; add < 4; add++) {
					NLC[team1].compete(NLW[team1 + add]);
				}
			}
			else if (team1 == 2) {
				NLC[team1].compete(NLW[team1+1]);
				NLC[team1].compete(NLW[team1+2]);
				NLC[team1].compete(NLW[team1-2]);
			}
			else if (team1 == 3) {
				NLC[team1].compete(NLW[team1+1]);
				NLC[team1].compete(NLW[team1-3]);
				NLC[team1].compete(NLW[team1-2]);
			}
			else {
				NLC[team1].compete(NLW[team1-4]);
				NLC[team1].compete(NLW[team1-3]);
				NLC[team1].compete(NLW[team1-2]);
			}
		}
	}
	
	//runs all inter division games
	public void simulateInterDivision() {
		simulateInterDivisionALEvALC();
		simulateInterDivisionALEvALW();
		simulateInterDivisionALCvALW();
		simulateInterDivisionNLEvNLC();
		simulateInterDivisionNLEvNLW();
		simulateInterDivisionNLCvNLW();
	}
	
	//inter league rival games
	public void playRivalsOdd4() {
		for (int games = 0; games < 4; games++) {
			Diamondbacks.compete(Astros);
			Orioles.compete(Nationals);
			Cubs.compete(White_Sox);
			Reds.compete(Indians);
			Tigers.compete(Pirates);
			Royals.compete(Cardinals);
			Angels.compete(Dodgers);
			Marlins.compete(Rays);
			Brewers.compete(Twins);
			Mets.compete(Yankees);
			Athletics.compete(Giants);
			Red_Sox.compete(Phillies);
			Blue_Jays.compete(Braves);
			Mariners.compete(Rockies);
			Rangers.compete(Padres);
		}
	}
	
	public void playRivalsEven4() {
		for (int games = 0; games < 4; games++) {
			Diamondbacks.compete(Astros);
			Orioles.compete(Nationals);
			Cubs.compete(White_Sox);
			Reds.compete(Indians);
			Tigers.compete(Pirates);
			Royals.compete(Cardinals);
			Angels.compete(Dodgers);
			Marlins.compete(Rays);
			Brewers.compete(Twins);
			Mets.compete(Yankees);
			Athletics.compete(Giants);
			Red_Sox.compete(Braves);
			Blue_Jays.compete(Phillies);
			Mariners.compete(Padres);
			Rangers.compete(Rockies);
		}
	}
	
	public void playRivalsOdd6() {
		for (int games = 0; games < 6; games++) {
			Diamondbacks.compete(Astros);
			Orioles.compete(Nationals);
			Cubs.compete(White_Sox);
			Reds.compete(Indians);
			Tigers.compete(Pirates);
			Royals.compete(Cardinals);
			Angels.compete(Dodgers);
			Marlins.compete(Rays);
			Brewers.compete(Twins);
			Mets.compete(Yankees);
			Athletics.compete(Giants);
			Red_Sox.compete(Phillies);
			Blue_Jays.compete(Braves);
			Mariners.compete(Rockies);
			Rangers.compete(Padres);
		}	
	}
	
	public void playRivalsEven6() {
		for (int games = 0; games < 6; games++) {
			Diamondbacks.compete(Astros);
			Orioles.compete(Nationals);
			Cubs.compete(White_Sox);
			Reds.compete(Indians);
			Tigers.compete(Pirates);
			Royals.compete(Cardinals);
			Angels.compete(Dodgers);
			Marlins.compete(Rays);
			Brewers.compete(Twins);
			Mets.compete(Yankees);
			Athletics.compete(Giants);
			Red_Sox.compete(Braves);
			Blue_Jays.compete(Phillies);
			Mariners.compete(Padres);
			Rangers.compete(Rockies);
		}
	}
	
	
	/* Orientation 1: NLE v ALC, NLC v ALW, NLW v ALE
	 * Orientation 2: NLE v ALW, NLC v ALE, NLW v ALC
	 * Orientation 3: NLE v ALE, NLC v ALC, NLW v ALW
	 * Odd # Years: Red Sox v Phillies, Blue Jays v Braves, Mariners v Rockies, Rangers v Padres
	 * Even # Years: Red Sox v Braves, Blue Jays v Phillies, Mariners v Padres, Rangers v Rockies
	*/
	
	public void interLeague(Team [] a, Team [] b) {
		Collections.shuffle(Arrays.asList(a));
		Collections.shuffle(Arrays.asList(b));
		for (int team1 = 0; team1 < 5; team1++) {
			for (int team2 = 0; team2 < 5; team2++) {
				for (int games = 0; games < 3; games++) {
					a[team1].compete(b[team2]);
				}
				if (team1 == team2) {
					a[team1].compete(b[team2]);
				}
			}
		}
	}
	
	public void orientation1() {
		interLeague(NLE,ALC);
		interLeague(NLC,ALW);
		interLeague(NLW,ALE);
	}
	
	public void orientation2() {
		interLeague(NLE,ALW);
		interLeague(NLC,ALE);
		interLeague(NLW,ALC);
	}
	
	//1 Odd 2019 + 6k
	public void simulateInterLeague1() {
		playRivalsOdd4();
		orientation1();
	}
	
	//1 Even 2022 + 6k
	public void simulateInterLeague2() {
		playRivalsEven4();
		orientation1();
	}
	
	//2 Odd 2023 + 6k
	public void simulateInterLeague3() {
		playRivalsOdd4();
		orientation2();
	}
	
	//2 Even 2020 + 6k
	public void simulateInterLeague4() {
		playRivalsEven4();
		orientation2();
	}
	
	//3 Odd 2021 + 6k
	public void simulateInterLeague5() {
		playRivalsOdd6();
		/* Yankees, Orioles, Red Sox, Rays, Blue Jays
		 * Mets, Nationals, Phillies, Marlins, Braves
		 * White Sox, Indians, Tigers, Royals, Twins
		 * Cubs, Reds, Pirates, Cardinals, Brewers
		 * Astros, Angels, Athletics, Mariners, Rangers
		 * Diamondbacks, Dodgers, Giants, Rockies, Padres
		 */
		for (int a = 0; a < 4; a++) {
			Yankees.compete(Nationals);
			Yankees.compete(Phillies);
			Orioles.compete(Phillies);
			Orioles.compete(Marlins);
			Red_Sox.compete(Marlins);
			Red_Sox.compete(Braves);
			Rays.compete(Braves);
			Rays.compete(Mets);
			Blue_Jays.compete(Mets);
			Blue_Jays.compete(Nationals);
			White_Sox.compete(Reds);
			White_Sox.compete(Pirates);
			Indians.compete(Pirates);
			Indians.compete(Cardinals);
			Tigers.compete(Cardinals);
			Tigers.compete(Brewers);
			Royals.compete(Brewers);
			Royals.compete(Cubs);
			Twins.compete(Cubs);
			Twins.compete(Reds);
			Astros.compete(Dodgers);
			Astros.compete(Giants);
			Angels.compete(Giants);
			Angels.compete(Rockies);
			Athletics.compete(Rockies);
			Athletics.compete(Padres);
			Mariners.compete(Padres);
			Mariners.compete(Diamondbacks);
			Rangers.compete(Diamondbacks);
			Rangers.compete(Dodgers);
		}
		for (int b = 0; b < 3; b++) {
			Yankees.compete(Marlins);
			Yankees.compete(Braves);
			Orioles.compete(Braves);
			Orioles.compete(Mets);
			Red_Sox.compete(Mets);
			Red_Sox.compete(Nationals);
			Rays.compete(Nationals);
			Rays.compete(Phillies);
			Blue_Jays.compete(Phillies);
			Blue_Jays.compete(Marlins);
			White_Sox.compete(Cardinals);
			White_Sox.compete(Brewers);
			Indians.compete(Brewers);
			Indians.compete(Cubs);
			Tigers.compete(Cubs);
			Tigers.compete(Reds);
			Royals.compete(Reds);
			Royals.compete(Pirates);
			Twins.compete(Pirates);
			Twins.compete(Cardinals);
			Astros.compete(Rockies);
			Astros.compete(Padres);
			Angels.compete(Padres);
			Angels.compete(Diamondbacks);
			Athletics.compete(Diamondbacks);
			Athletics.compete(Dodgers);
			Mariners.compete(Dodgers);
			Mariners.compete(Giants);
			Rangers.compete(Giants);
			Rangers.compete(Rockies);
		}
	}
	
	//3 Even 2024 + 6k
	public void simulateInterLeague6() {
		playRivalsEven6();
		/* Yankees, Orioles, Red Sox, Rays, Blue Jays
		 * Mets, Nationals, Braves, Marlins, Phillies
		 * White Sox, Indians, Tigers, Royals, Twins
		 * Cubs, Reds, Pirates, Cardinals, Brewers
		 * Astros, Angels, Athletics, Mariners, Rangers
		 * Diamondbacks, Dodgers, Giants, Padres, Rockies
		 */
		for (int a = 0; a < 4; a++) {
			Yankees.compete(Nationals);
			Yankees.compete(Braves);
			Orioles.compete(Braves);
			Orioles.compete(Marlins);
			Red_Sox.compete(Marlins);
			Red_Sox.compete(Phillies);
			Rays.compete(Phillies);
			Rays.compete(Mets);
			Blue_Jays.compete(Mets);
			Blue_Jays.compete(Nationals);
			White_Sox.compete(Reds);
			White_Sox.compete(Pirates);
			Indians.compete(Pirates);
			Indians.compete(Cardinals);
			Tigers.compete(Cardinals);
			Tigers.compete(Brewers);
			Royals.compete(Brewers);
			Royals.compete(Cubs);
			Twins.compete(Cubs);
			Twins.compete(Reds);
			Astros.compete(Dodgers);
			Astros.compete(Giants);
			Angels.compete(Giants);
			Angels.compete(Padres);
			Athletics.compete(Padres);
			Athletics.compete(Rockies);
			Mariners.compete(Rockies);
			Mariners.compete(Diamondbacks);
			Rangers.compete(Diamondbacks);
			Rangers.compete(Dodgers);
		}
		for (int b = 0; b < 3; b++) {
			Yankees.compete(Marlins);
			Yankees.compete(Phillies);
			Orioles.compete(Phillies);
			Orioles.compete(Mets);
			Red_Sox.compete(Mets);
			Red_Sox.compete(Nationals);
			Rays.compete(Nationals);
			Rays.compete(Braves);
			Blue_Jays.compete(Braves);
			Blue_Jays.compete(Marlins);
			White_Sox.compete(Cardinals);
			White_Sox.compete(Brewers);
			Indians.compete(Brewers);
			Indians.compete(Cubs);
			Tigers.compete(Cubs);
			Tigers.compete(Reds);
			Royals.compete(Reds);
			Royals.compete(Pirates);
			Twins.compete(Pirates);
			Twins.compete(Cardinals);
			Astros.compete(Padres);
			Astros.compete(Rockies);
			Angels.compete(Rockies);
			Angels.compete(Diamondbacks);
			Athletics.compete(Diamondbacks);
			Athletics.compete(Dodgers);
			Mariners.compete(Dodgers);
			Mariners.compete(Giants);
			Rangers.compete(Giants);
			Rangers.compete(Padres);
		}
	}
	
	public void printRecord(Team [] a) {
		Arrays.sort(a);
		for (int team = 0; team < 5; team++) {
			String temp = (a[team].name + ": " + a[team].wins + "-" + a[team].losses);	
			for (int i = temp.length(); i < 21; i++) {
				temp = temp + " ";
			}
			System.out.print(temp);
		}
		System.out.println();
	}
	
	public void printLeague() {
		Team [][] league = new Team [6][5];
		league[0] = ALE;
		league[1] = ALC;
		league[2] = ALW;
		league[3] = NLE;
		league[4] = NLC;
		league[5] = NLW;
		for (int a = 0; a < 6; a++) {
			Arrays.sort(league[a]);
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				String temp = (league[j][i].name + ": " + league[j][i].wins + "-" + league[j][i].losses);
				for (int k = temp.length(); k < 21; k++) {
					temp = temp + " ";
				}
				System.out.print(temp);
			}
			System.out.println();
		}
	}
	
	public void simulateLeague() {
		Team [][] league = new Team [6][5];
		league[0] = ALE;
		league[1] = ALC;
		league[2] = ALW;
		league[3] = NLE;
		league[4] = NLC;
		league[5] = NLW;
		for (int i = 0; i < 6; i++) {
			simulateDivision(league[i]);
		}
		simulateInterDivision();
		int random = (int)(Math.random()*6 +1);
		if (random == 1) {
			simulateInterLeague1();
		}
		else if (random==2) {
			simulateInterLeague2();
		}
		else if (random==3) {
			simulateInterLeague3();
		}
		else if (random==4) {
			simulateInterLeague4();
		}
		else if (random==5) {
			simulateInterLeague5();
		}
		else {
			simulateInterLeague6();
		}
				
	}
		
	public int runSeason() {
		simulateLeague();
		printLeague();
		System.out.println();
		getALPostseason();
		System.out.println();
		getNLPostseason();
		System.out.println();
		runPostseason();
		return winner.get(0).number;
	}

	public void getALPostseason(){
		Team [][] league = new Team [6][5];
		league[0] = ALE;
		league[1] = ALC;
		league[2] = ALW;
		league[3] = NLE;
		league[4] = NLC;
		league[5] = NLW;
		ArrayList <Team> place23 = new ArrayList<Team>();
		for (int a = 0; a < 3; a++) {
			Arrays.sort(league[a]);
			postAL.add((league[a])[0]);
			for (int b = 1; b < 3; b++) {
				place23.add((league[a])[b]);
			}
		}
		Collections.sort(postAL);
		while(place23.size() > 4) {
			int min = 0;
			int index = 0;
			for (int length = 0; length < place23.size(); length++) {
				if (place23.get(length).wins > min) {
					min = place23.get(length).wins;
					index = length;
				}
			}
			postAL.add(place23.get(index));
			place23.remove(index);
		}
		Team temp1 = postAL.get(1);
		Team temp2 = postAL.get(2);
		postAL.set(1,postAL.get(3));
		postAL.set(3, temp1);
		postAL.set(2, postAL.get(4));
		postAL.set(4, temp2);
		for (int d = 0; d < 5; d++) {
			System.out.println(postAL.get(d).name);
		}
	}
	
	public void getNLPostseason(){
		Team [][] league = new Team [6][5];
		league[0] = ALE;
		league[1] = ALC;
		league[2] = ALW;
		league[3] = NLE;
		league[4] = NLC;
		league[5] = NLW;
		ArrayList <Team> place23 = new ArrayList<Team>();
		for (int a = 3; a < 6; a++) {
			Arrays.sort(league[a]);
			postNL.add((league[a])[0]);
			for (int b = 1; b < 3; b++) {
				place23.add((league[a])[b]);
			}
		}
		Collections.sort(postNL);
		while(place23.size() > 4) {
			int min = 0;
			int index = 0;
			for (int length = 0; length < place23.size(); length++) {
				if (place23.get(length).wins > min) {
					min = place23.get(length).wins;
					index = length;
				}
			}
			postNL.add(place23.get(index));
			place23.remove(index);
		}
		Team temp1 = postNL.get(1);
		Team temp2 = postNL.get(2);
		postNL.set(1,postNL.get(3));
		postNL.set(3, temp1);
		postNL.set(2, postNL.get(4));
		postNL.set(4, temp2);
		for (int d = 0; d < 5; d++) {
			System.out.println(postNL.get(d).name);
		}
	}
	
	public void runWildCard() {
		for (int AL= 0; AL < postAL.size(); AL++) {
			postAL.get(AL).wins = 0;
		}
		for (int NL= 0; NL < postNL.size(); NL++) {
			postAL.get(NL).wins = 0;
		}
		System.out.println("AL Wild Card: " + postAL.get(1).name + " vs "  + postAL.get(2).name);
		postAL.get(1).compete(postAL.get(2));
		if (postAL.get(1).wins == 1) {
			postAL.remove(2);
		}
		else {
			postAL.remove(1);
		}
		System.out.println(postAL.get(1).name + " Win 1-0");
		System.out.println("NL Wild Card: " + postNL.get(1).name + " vs "  + postNL.get(2).name);
		postNL.get(1).compete(postAL.get(2));
		if (postNL.get(1).wins == 1) {
			postNL.remove(2);
		}
		else {
			postNL.remove(1);
		}
		System.out.println(postNL.get(1).name + " Win 1-0");
	}
	
	public void runDivisionSeries() {
		for (int AL= 0; AL < postAL.size(); AL++) {
			postAL.get(AL).wins = 0;
		}
		for (int NL= 0; NL < postNL.size(); NL++) {
			postNL.get(NL).wins = 0;
		}
		System.out.println("ALDS #1: " + postAL.get(0).name + " vs " + postAL.get(1).name);
		while(postAL.get(0).wins != 3 && postAL.get(1).wins !=3) {
			postAL.get(0).compete(postAL.get(1));
		}
		if (postAL.get(0).wins == 3) {
			System.out.println(postAL.get(0).name + " Win " + postAL.get(0).wins + "-" + postAL.get(1).wins);
			postAL.remove(1);
		}
		else {
			System.out.println(postAL.get(1).name + " Win " + postAL.get(1).wins + "-" + postAL.get(0).wins);
			postAL.remove(0);
		}
		System.out.println("ALDS #2: " + postAL.get(1).name + " vs " + postAL.get(2).name);
		while(postAL.get(1).wins != 3 && postAL.get(2).wins !=3) {
			postAL.get(1).compete(postAL.get(2));
		}
		if (postAL.get(1).wins == 3) {
			System.out.println(postAL.get(1).name + " Win " + postAL.get(1).wins + "-" + postAL.get(2).wins);
			postAL.remove(2);
		}
		else {
			System.out.println(postAL.get(2).name + " Win " + postAL.get(2).wins + "-" + postAL.get(1).wins);
			postAL.remove(1);
		}
		System.out.println("NLDS #1: " + postNL.get(0).name + " vs " + postNL.get(1).name);
		while(postNL.get(0).wins != 3 && postNL.get(1).wins !=3) {
			postNL.get(0).compete(postNL.get(1));
		}
		if (postNL.get(0).wins == 3) {
			System.out.println(postNL.get(0).name + " Win " + postNL.get(0).wins + "-" + postNL.get(1).wins);
			postNL.remove(1);
		}
		else {
			System.out.println(postNL.get(1).name + " Win " + postNL.get(1).wins + "-" + postNL.get(0).wins);
			postNL.remove(0);
		}
		System.out.println("NLDS #2: " + postNL.get(1).name + " vs " + postNL.get(2).name);
		while(postNL.get(1).wins != 3 && postNL.get(2).wins !=3) {
			postNL.get(1).compete(postNL.get(2));
		}
		if (postNL.get(1).wins == 3) {
			System.out.println(postNL.get(1).name + " Win " + postNL.get(1).wins + "-" + postNL.get(2).wins);
			postNL.remove(2);
		}
		else {
			System.out.println(postNL.get(2).name + " Win " + postNL.get(2).wins + "-" + postNL.get(1).wins);
			postNL.remove(1);
		}
	}
	
	public void runLeagueSeries() {
		for (int AL= 0; AL < postAL.size(); AL++) {
			postAL.get(AL).wins = 0;
		}
		for (int NL= 0; NL < postNL.size(); NL++) {
			postNL.get(NL).wins = 0;
		}
		System.out.println("ALCS: " + postAL.get(0).name + " vs " + postAL.get(1).name);
		while(postAL.get(0).wins != 4 && postAL.get(1).wins !=4) {
			postAL.get(0).compete(postAL.get(1));
		}
		if (postAL.get(0).wins == 4) {
			System.out.println(postAL.get(0).name + " Win " + postAL.get(0).wins + "-" + postAL.get(1).wins);
			postAL.remove(1);
		}
		else {
			System.out.println(postAL.get(1).name + " Win " + postAL.get(1).wins + "-" + postAL.get(0).wins);
			postAL.remove(0);
		}
		System.out.println("NLCS: " + postNL.get(0).name + " vs " + postNL.get(1).name);
		while(postNL.get(0).wins != 4 && postNL.get(1).wins !=4) {
			postNL.get(0).compete(postNL.get(1));
		}
		if (postNL.get(0).wins == 4) {
			System.out.println(postNL.get(0).name + " Win " + postNL.get(0).wins + "-" + postNL.get(1).wins);
			postNL.remove(1);
		}
		else {
			System.out.println(postNL.get(1).name + " Win " + postNL.get(1).wins + "-" + postNL.get(0).wins);
			postNL.remove(0);
		}
	}
	
	public void runWorldSeries() {
		for (int AL= 0; AL < postAL.size(); AL++) {
			postAL.get(AL).wins = 0;
		}
		for (int NL= 0; NL < postNL.size(); NL++) {
			postNL.get(NL).wins = 0;
		}
		System.out.println("World Series: " + postAL.get(0).name + " vs " + postNL.get(0).name);
		while(postAL.get(0).wins != 4 && postNL.get(0).wins !=4) {
			postAL.get(0).compete(postNL.get(0));
		}
		if (postAL.get(0).wins == 4) {
			System.out.println(postAL.get(0).name + " Win " + postAL.get(0).wins + "-" + postNL.get(0).wins);
			//postNL.remove(1);
			System.out.println();
			System.out.println(postAL.get(0).name + " Win the MLB Season!");
			winner.add(postAL.get(0));
		}
		else {
			System.out.println(postNL.get(0).name + " Win " + postNL.get(0).wins + "-" + postAL.get(0).wins);
			//postAL.remove(0);
			System.out.println();
			System.out.println(postNL.get(0).name + " Win the MLB Season!");
			winner.add(postNL.get(0));
		}
	}
	
	public void runPostseason() {
		runWildCard();
		System.out.println();
		runDivisionSeries();
		System.out.println();
		runLeagueSeries();
		System.out.println();
		runWorldSeries();
	}
}	

