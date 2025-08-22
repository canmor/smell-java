public class CharacterCreator {
    
    public void createCharacter(
        String name,
        int level,
        int health,
        int mana,
        int strength,
        int agility,
        int intelligence,
        String className,
        String race,
        int experience,
        String weapon,
        String armor,
        boolean isNPC
    ) {
        // Character creation logic
        Character character = new Character();
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
    
    // Another example with even more parameters
    public void createAdvancedCharacter(
        String name,
        int level,
        int health,
        int mana,
        int strength,
        int agility,
        int intelligence,
        int constitution,
        int wisdom,
        int charisma,
        String className,
        String race,
        String subrace,
        int experience,
        String primaryWeapon,
        String secondaryWeapon,
        String helmet,
        String armor,
        String boots,
        String gloves,
        String ring1,
        String ring2,
        String necklace,
        boolean isNPC,
        boolean isPlayer,
        String guild,
        int reputation,
        String difficulty,
        boolean hasMount,
        String mountType
    ) {
        // Even more complex character creation logic
        Character character = new Character();
        // Many setter calls...
        character.setName(name);
        character.setLevel(level);
        // ... and so on
    }
    
    // Example of calling the method - shows how unwieldy it becomes
    public void demonstrateUsage() {
        createCharacter(
            "Aragorn",           // name
            25,                  // level
            150,                 // health
            50,                  // mana
            18,                  // strength
            16,                  // agility
            14,                  // intelligence
            "Ranger",            // className
            "Human",             // race
            45000,               // experience
            "Longsword",         // weapon
            "Leather Armor",     // armor
            false                // isNPC
        );
        
        // Easy to mix up parameters of same type!
        createCharacter(
            "Legolas",
            20,
            14,    // Oops! Mixed up health and intelligence
            30,
            120,   // This should be health, not strength
            20,
            16,
            "Archer",
            "Elf",
            35000,
            "Elven Bow",
            "Elven Cloak",
            false
        );
    }
}

// Supporting class
class Character {
    private String name;
    private int level;
    private int health;
    private int mana;
    private int strength;
    private int agility;
    private int intelligence;
    private String className;
    private String race;
    private int experience;
    private String weapon;
    private String armor;
    private boolean isNPC;
    
    // Setters
    public void setName(String name) { this.name = name; }
    public void setLevel(int level) { this.level = level; }
    public void setHealth(int health) { this.health = health; }
    public void setMana(int mana) { this.mana = mana; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setClassName(String className) { this.className = className; }
    public void setRace(String race) { this.race = race; }
    public void setExperience(int experience) { this.experience = experience; }
    public void setWeapon(String weapon) { this.weapon = weapon; }
    public void setArmor(String armor) { this.armor = armor; }
    public void setIsNPC(boolean isNPC) { this.isNPC = isNPC; }
    
    // Getters
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHealth() { return health; }
    public int getMana() { return mana; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }
    public String getClassName() { return className; }
    public String getRace() { return race; }
    public int getExperience() { return experience; }
    public String getWeapon() { return weapon; }
    public String getArmor() { return armor; }
    public boolean isNPC() { return isNPC; }
}
