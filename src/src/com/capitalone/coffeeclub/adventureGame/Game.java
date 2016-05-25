package com.capitalone.coffeeclub.adventureGame;

//Java utilites
import java.util.Scanner; // supports the scanner utility
import java.util.Random; // supports the random utility

public class Game {
    public static void main(String args[]) {
    
    // system objects
    // gets input from user
    Scanner in = new Scanner(System.in);
    
    // generates random number to provide variance for user options
    Random rand = new Random();
    
    // game variables
    String[] enemies = { "Smeagol", "Dragon", "Troll", "Wizard", "Talent Management"}; // enemies
    int maxEnemyHealth = 75; // enemy max health
    int enemyAttackDamage = 40; // enemy attack damage
    
    // player variables
    int health = 100; // player health
    int attackDamage = 35; // player attack damage
    int numHealthPotions = 3; //player number of health potions
    int healthPotionHealAmount = 25; // player health potion heal amount
    int healthPotionDropChance = 50; // 50% chance the enemy will drop a health potion
    
    boolean running = true; // the game will iterate until this is set to false
    
    System.out.println("Start Game");
    
    // start of game
    GAME:
    while(running) {
        System.out.println("__________________________________________________");
        
        // populates enemies
        int enemyHealth = 40 + rand.nextInt(41); // sets the enemy health between 0 and the max enemy health
        String enemy = enemies[rand.nextInt(enemies.length)]; // selects a random amount of enemies from the enemies array
        System.out.println("\t# " + enemy + " appeared! #\n"); // prints out which enemies are populated
        
        while(enemyHealth > 0) {
            System.out.println("\tYour HP:" + health);
            System.out.println("\t" + enemy + "'s HP:" + enemyHealth);
            System.out.println("\n\tWhat would you like to do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Drink health potion");
            System.out.println("\t3. Run away!");
            
            boolean isTalent = enemy.equals("Talent Management");
            String input = in.nextLine(); // grabs user input
            if(input.equals("1")) {
                int damageDealt = 10 + rand.nextInt(attackDamage); // generates a random number between 0 and attackDamage value
                int damageTaken = rand.nextInt(enemyAttackDamage); // generates a random number between 0 and enemyAttackDamage value
                
                if(isTalent) {
                    damageTaken = Integer.MAX_VALUE;
                }
                
                enemyHealth -= damageDealt; // subtracts the damageDealt value from the enemy Health
                health -= damageTaken; // subtracts the damageTaken value from the player health
                
                System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                System.out.println("\t> You recieve " + damageTaken + " in retaliation!");
                
                if(health < 1) {
                    System.out.println("\t> You have taken too much damage and are defeated!");
                    break;
                }
            }
            else if(input.equals("2")) {
                if(numHealthPotions > 0) {
                    health += healthPotionHealAmount; // add to health the amount the health potion heals for
                    numHealthPotions --; // subtracts the health potion from player inventory
                    System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount 
                                        + "." + "\t\n> You now have " + health + "HP." 
                                        + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                }
                else {
                    System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one.");
                }
            }
            else if (input.equals("3")) {
                if(isTalent){
                    System.out.println("Action Required: no running from " + enemy);
                    continue;
                }
                System.out.println("\tYou run away from the " + enemy + "!");
                continue GAME; // goes back to the start of the loop, breaks out of current loop and goes back to the start of the GAME loop
            }
            else {
                System.out.println("\t Invalid command. Please select options 1, 2 or 3.");
            }
        }
        
        if (health < 1) {
            System.out.println("You limp out of the dungeon, weak from battle.");
            break;
        }
        
        System.out.println("__________________________________________________");
        System.out.println(" # " + enemy + " was defeated! # "); // prints out the enemy that was defeated
        System.out.println(" # You have " + health + " HP left. #");
        if(rand.nextInt(100) < healthPotionDropChance) {
            numHealthPotions++;
            System.out.println(" # " + enemy + " dropped a health potion # ");
            System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
        }
        System.out.println("__________________________________________________");
        System.out.println("What would you like to do?");
        System.out.println("1. Continue fighting");
        System.out.println("2. Exit dungeon");
        
        String input =  in.nextLine();
        
        // player decides to continue the game or exit
        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command!");
            input = in.nextLine();
            
            if(input.equals("1")) {
                System.out.println("You are battle hardened. You continue on your adventure!");
            }
            else if(input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventures!");
                break;
            }
        }
            System.out.println("###################");
            System.out.println("Thanks for playing!");
            System.out.println("###################");
        }
    }
}