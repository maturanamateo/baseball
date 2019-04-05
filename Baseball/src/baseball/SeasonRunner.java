package baseball;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SeasonRunner {
	public static void main(String[] args) {
		TeamWins yankeesWins = new TeamWins("Yankees");
		TeamWins redsoxWins = new TeamWins("Red Sox");
		TeamWins bluejaysWins = new TeamWins ("Blue Jays:");
		TeamWins oriolesWins = new TeamWins ("Orioles");
		TeamWins raysWins = new TeamWins ("Rays");
		TeamWins whitesoxWins = new TeamWins ("White Sox");
		TeamWins indiansWins = new TeamWins ("Indians");
		TeamWins tigersWins = new TeamWins ("Tigers");
		TeamWins royalsWins = new TeamWins ("Royals");
		TeamWins twinsWins = new TeamWins ("Twins");
		TeamWins astrosWins = new TeamWins ("Astros");
		TeamWins angelsWins = new TeamWins ("Angels");
		TeamWins athleticsWins = new TeamWins ("Athletics");
		TeamWins marinersWins = new TeamWins ("Mariners");
		TeamWins rangersWins = new TeamWins ("Rangers");
		TeamWins bravesWins = new TeamWins ("Braves");
		TeamWins marlinsWins = new TeamWins ("Marlins");
		TeamWins metsWins = new TeamWins ("Mets");
		TeamWins philliesWins = new TeamWins ("Phillies");
		TeamWins nationalsWins = new TeamWins ("Nationals");
		TeamWins cubsWins = new TeamWins ("Cubs");
		TeamWins redsWins = new TeamWins ("Reds");
		TeamWins brewersWins = new TeamWins ("Brewers");
		TeamWins piratesWins = new TeamWins ("Pirates");
		TeamWins cardinalsWins = new TeamWins ("Cardinals");
		TeamWins diamondbacksWins = new TeamWins ("Diamondbacks");
		TeamWins rockiesWins = new TeamWins ("Rockies");
		TeamWins dodgersWins = new TeamWins ("Dodgers");
		TeamWins padresWins = new TeamWins ("Padres");
		TeamWins giantsWins = new TeamWins ("Giants");
		TeamWins [] winCount = {yankeesWins, redsoxWins, bluejaysWins, oriolesWins, raysWins, whitesoxWins, indiansWins, tigersWins, 
				royalsWins,twinsWins, astrosWins, angelsWins, athleticsWins, marinersWins, rangersWins, bravesWins, marlinsWins, 
				metsWins, philliesWins, nationalsWins, cubsWins, redsWins, brewersWins, piratesWins, cardinalsWins, diamondbacksWins,
				rockiesWins, dodgersWins, padresWins, giantsWins
		};
		TeamWins[] winAL = {yankeesWins, redsoxWins, bluejaysWins, oriolesWins, raysWins, whitesoxWins, indiansWins, tigersWins, 
				royalsWins,twinsWins, astrosWins, angelsWins, athleticsWins, marinersWins, rangersWins};
		TeamWins[] winNL = {bravesWins, marlinsWins, metsWins, philliesWins, nationalsWins, cubsWins, redsWins, brewersWins, piratesWins, 
				cardinalsWins, diamondbacksWins, rockiesWins, dodgersWins, padresWins, giantsWins};
		double winsAL = 0;
		double winsNL = 0;
		double chanceAL = 0;
		double chanceNL = 0;
		
		System.out.println("Enter the # of seasons you would like to simulate");
		Scanner s = new Scanner(System.in);
		int numSeasons = s.nextInt();
		for (int seasons = 0; seasons < numSeasons; seasons++) {
			//System.out.println((seasons + 2019) + " MLB Season");
			Season a = new Season();
			int winner = a.runSeason();
			winCount[winner -1].wins++;
		}
		Collections.sort(Arrays.asList(winCount));
		for (int length = 0; length < winCount.length; length++) {
			System.out.println(winCount[length].name + " Wins: " + winCount[length].wins);
		}
		for (int length1 = 0; length1 < 15; length1++) {
			winsAL += winAL[length1].wins;	
			winsNL += winNL[length1].wins;
		}
		
		chanceAL = (winsAL/numSeasons)*100;
		chanceNL = (winsNL/numSeasons)*100;
		System.out.println("AL Wins: " + winsAL);
		System.out.println("NL Wins: " + winsNL);
		DecimalFormat d = new DecimalFormat();
		if (numSeasons > 499) {
			System.out.println("Chance AL Wins: " + d.format(chanceAL) + "%");
			System.out.println("Chance NL Wins: " + d.format(chanceNL) + "%");
		}
		s.close();
	}
}
	