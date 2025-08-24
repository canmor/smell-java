import java.util.List;

public class ScoreCalculator {
    
    public int calculateScore(Player player) {
        int score = 0;
        
        score += player.getLevel() * 100;
        score += player.getExperience() / 10;
        
        for (Equipment item : player.getEquipment()) {
            if (item.getType().equals("weapon")) {
                score += item.getAttack() * 2;
                if (item.getRarity().equals("legendary")) {
                    score += item.getAttack() * 0.5;
                }
                if (item.isEnchanted()) {
                    score += item.getEnchantmentLevel() * 50;
                }
            } else if (item.getType().equals("armor")) {
                score += item.getDefense() * 1.5;
                if (item.getRarity().equals("legendary")) {
                    score += item.getDefense() * 0.3;
                }
                if (item.hasSetBonus()) {
                    score += 200;
                }
            } else if (item.getType().equals("accessory")) {
                score += item.getMagicPower() * 3;
                if (item.hasSpecialEffect()) {
                    score += 150;
                }
            }
        }
        
        for (Skill skill : player.getSkills()) {
            if (skill.getLevel() > 5) {
                score += skill.getLevel() * skill.getMultiplier();
                if (skill.getType().equals("combat")) {
                    score += skill.getLevel() * 20;
                }
                if (skill.isMastered()) {
                    score += 500;
                }
            }
            if (skill.hasCombo()) {
                score += skill.getComboCount() * 25;
            }
        }
        
        int achievementBonus = 0;
        for (Achievement achievement : player.getAchievements()) {
            if (achievement.isCompleted()) {
                achievementBonus += achievement.getPoints();
                if (achievement.getDifficulty().equals("hard")) {
                    achievementBonus += achievement.getPoints() * 0.5;
                }
                if (achievement.isRare()) {
                    achievementBonus += 1000;
                }
            }
        }
        score += achievementBonus * 0.1;
        
        if (player.isVIP()) {
            score *= 1.5;
            if (player.getVipLevel() >= 5) {
                score += 2000;
            }
        }
        
        if (player.isInGuild()) {
            score += player.getGuild().getLevel() * 50;
            if (player.getGuild().hasActiveBonus()) {
                score *= 1.2;
            }
        }
        
        if (player.getPlayTime() > 1000) {
            score += (player.getPlayTime() - 1000) / 100 * 50;
        }
        
        int dailyBonus = 0;
        if (player.hasDailyLogin()) {
            dailyBonus += 100;
            if (player.getConsecutiveLoginDays() > 7) {
                dailyBonus += player.getConsecutiveLoginDays() * 10;
            }
        }
        score += dailyBonus;
        
        if (player.hasCompletedTutorial()) {
            score += 500;
        }
        
        if (player.getReferralCount() > 0) {
            score += player.getReferralCount() * 200;
        }
        
        return Math.max(score, 0);
    }
}
