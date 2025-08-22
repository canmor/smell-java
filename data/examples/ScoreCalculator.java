import java.util.List;

public class ScoreCalculator {
    
    public int calculateScore(Player player) {
        int score = 0;
        
        // Calculate base score
        score += player.getLevel() * 100;
        score += player.getExperience() / 10;
        
        // Calculate equipment bonuses
        for (Equipment item : player.getEquipment()) {
            if ("weapon".equals(item.getType())) {
                score += item.getAttack() * 2;
            } else if ("armor".equals(item.getType())) {
                score += item.getDefense() * 1.5;
            } else if ("accessory".equals(item.getType())) {
                score += item.getMagic() * 3;
            }
        }
        
        // Calculate skill bonuses
        for (Skill skill : player.getSkills()) {
            if (skill.getLevel() > 5) {
                score += skill.getLevel() * skill.getMultiplier();
            }
        }
        
        // Calculate achievement bonuses
        int achievementBonus = 0;
        for (Achievement achievement : player.getAchievements()) {
            if (achievement.isCompleted()) {
                achievementBonus += achievement.getPoints();
            }
        }
        score += achievementBonus * 0.1;
        
        // Apply special rules
        if (player.isVIP()) {
            score *= 1.5;
        }
        
        // Apply time-based bonuses
        if (player.getPlayTime() > 1000) {
            score += 500;
        }
        
        // Apply guild bonuses
        if (player.getGuild() != null) {
            score += player.getGuild().getBonusPoints();
            if (player.getGuild().getRank().equals("Legendary")) {
                score *= 1.2;
            }
        }
        
        // Apply seasonal events bonus
        if (isSeasonalEventActive()) {
            score += calculateSeasonalBonus(player);
        }
        
        // Apply level milestone bonuses
        if (player.getLevel() >= 50) {
            score += 1000;
        }
        if (player.getLevel() >= 100) {
            score += 2000;
        }
        
        // Apply difficulty modifier
        String difficulty = player.getDifficulty();
        if ("hard".equals(difficulty)) {
            score *= 1.3;
        } else if ("nightmare".equals(difficulty)) {
            score *= 1.5;
        } else if ("hell".equals(difficulty)) {
            score *= 2.0;
        }
        
        // Ensure score is not negative
        if (score < 0) {
            score = 0;
        }
        
        return score;
    }
    
    private boolean isSeasonalEventActive() {
        // Check if seasonal event is currently active
        return true; // Simplified for example
    }
    
    private int calculateSeasonalBonus(Player player) {
        // Calculate seasonal event bonus
        return player.getLevel() * 10;
    }
}

// Supporting classes for demonstration
class Player {
    private int level;
    private int experience;
    private int playTime;
    private boolean isVIP;
    private String difficulty;
    private List<Equipment> equipment;
    private List<Skill> skills;
    private List<Achievement> achievements;
    private Guild guild;
    
    // Getters
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getPlayTime() { return playTime; }
    public boolean isVIP() { return isVIP; }
    public String getDifficulty() { return difficulty; }
    public List<Equipment> getEquipment() { return equipment; }
    public List<Skill> getSkills() { return skills; }
    public List<Achievement> getAchievements() { return achievements; }
    public Guild getGuild() { return guild; }
}

class Equipment {
    private String type;
    private int attack;
    private int defense;
    private int magic;
    
    public String getType() { return type; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getMagic() { return magic; }
}

class Skill {
    private int level;
    private double multiplier;
    
    public int getLevel() { return level; }
    public double getMultiplier() { return multiplier; }
}

class Achievement {
    private boolean completed;
    private int points;
    
    public boolean isCompleted() { return completed; }
    public int getPoints() { return points; }
}

class Guild {
    private String rank;
    private int bonusPoints;
    
    public String getRank() { return rank; }
    public int getBonusPoints() { return bonusPoints; }
}
