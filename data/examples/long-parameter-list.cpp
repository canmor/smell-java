void createCharacter(
    std::string name,
    int level,
    int health,
    int mana,
    int strength,
    int agility,
    int intelligence,
    std::string className,
    std::string race,
    int experience,
    std::string weapon,
    std::string armor,
    bool isNPC
) {
    // 创建角色的逻辑
    Character character;
    character.setName(name);
    character.setLevel(level);
    character.setHealth(health);
    character.setMana(mana);
    character.setStrength(strength);
    character.setAgility(agility);
    character.setIntelligence(intelligence);
    character.setClassName(className);
    character.setRace(race);
    character.setExperience(experience);
    character.setWeapon(weapon);
    character.setArmor(armor);
    character.setIsNPC(isNPC);
}
