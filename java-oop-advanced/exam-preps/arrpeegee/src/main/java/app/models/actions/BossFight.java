package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.Boss;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {
	
	@Override
	public String executeAction(List<Targetable> participants) {
		StringBuilder result = new StringBuilder();
		if (!(participants.get(0) instanceof Boss)){
			return "Invalid boss.";
		}
		
		if (participants.size() < 2) {
			return "There should be at least 1 participant for boss fight!";
		}
		List<Targetable> heroes = participants.stream().skip(1).collect(Collectors.toList());
		Targetable boss = participants.get(0);
		Targetable winner = null;
		int aliveHeros = heroes.size();
		
		while (boss.isAlive()) {
			if (aliveHeros == 0) {
				return "Boss has slain them all!";
			}
			
			for (Targetable hero : heroes) {
				if (!hero.isAlive()) {
					aliveHeros--;
					continue;
				}
				hero.attack(boss);
				if (!boss.isAlive()) {
					winner = hero;
					result.append("Boss has been slain by: ").append(System.lineSeparator());
					break;
				}
				boss.attack(hero);
			}
		}
		String winnerName = winner.getName();
		
		heroes.stream()
				.filter(Targetable::isAlive)
				.sorted(Comparator.comparing(Targetable::getName))
				.forEach(hero -> {
					if (!hero.getName().equals(winnerName)){
						hero.levelUp();
					}
					hero.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
					result.append(hero.toString()).append(System.lineSeparator());
				});
		String returnResult = result.toString();
		returnResult = returnResult.substring(0,returnResult.length()-1);
		return returnResult;
	}
}
