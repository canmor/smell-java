int calculateScore(Player player) {
    int score = 0;
    
    // 计算基础分数
    score += player.level * 100;
    score += player.experience / 10;
    
    // 计算装备加成
    for (auto& item : player.equipment) {
        if (item.type == "weapon") {
            score += item.attack * 2;
        } else if (item.type == "armor") {
            score += item.defense * 1.5;
        } else if (item.type == "accessory") {
            score += item.magic * 3;
        }
    }
    
    // 计算技能加成
    for (auto& skill : player.skills) {
        if (skill.level > 5) {
            score += skill.level * skill.multiplier;
        }
    }
    
    // 计算成就加成
    int achievementBonus = 0;
    for (auto& achievement : player.achievements) {
        if (achievement.isCompleted) {
            achievementBonus += achievement.points;
        }
    }
    score += achievementBonus * 0.1;
    
    // 应用特殊规则
    if (player.isVIP) {
        score *= 1.5;
    }
    
    return score;
}
