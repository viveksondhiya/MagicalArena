package org.example;
public class Arena {
    private Player player1;
    private Player player2;
    private Dice dice;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.dice = new Dice();
    }

    public void fight() {
        Player attacker, defender;

        if (player1.getHealth() < player2.getHealth()) {
            attacker = player1;
            defender = player2;
        } else {
            attacker = player2;
            defender = player1;
        }

        while (player1.isAlive() && player2.isAlive()) {
            int attackRoll = dice.roll();
            int defenseRoll = dice.roll();

            int attackDamage = attacker.getAttack() * attackRoll;
            int defenseValue = defender.getStrength() * defenseRoll;

            int damage = Math.max(0, attackDamage - defenseValue);
            defender.reduceHealth(damage);

            System.out.println("Player with " + attacker.getHealth() + " health attacks " + "Player with " + defender.getHealth() + " health for " + damage + " damage!");

            // Swap roles for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (player1.isAlive()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}


