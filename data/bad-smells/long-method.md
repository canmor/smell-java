---
slug: "long-method"
nameCn: "冗长函数"
nameEn: "Long Method"
category: "Bloaters"
description: "函数代码过长，难以阅读和维护。通常是多个职责未拆分的迹象。"
exampleFile: "long-method.cpp"
---

# 简介

当一个函数变得过长时，它往往承担了太多的职责。长函数难以理解、测试和维护。一般来说，如果一个函数超过20-30行，就应该考虑拆分。

## 识别要点

- 函数行数过多（通常超过20-30行）
- 函数承担多个职责
- 难以理解函数的整体逻辑
- 测试困难，需要考虑多种情况

## 重构建议

1. **提取方法**：将函数中的逻辑块提取为独立的方法
2. **分离职责**：确保每个函数只做一件事
3. **使用有意义的函数名**：让函数名清楚表达其功能

## 说明

这个函数承担了太多职责：计算基础分数、装备加成、技能加成和成就加成。应该拆分为多个小函数，每个函数负责一个特定的计算逻辑。
\`\`\`

```cpp file="data/examples/long-method.cpp"
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
