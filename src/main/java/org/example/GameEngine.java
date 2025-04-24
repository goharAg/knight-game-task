package org.example;

public class GameEngine {
  private boolean isWinner = false;
  Knight k1, k2, k3, k4, k5, k6;

  public GameEngine() {

    k1 = new Knight("K" + 1);
    k2 = new Knight("K" + 2);
    k3 = new Knight("K" + 3);
    k4 = new Knight("K" + 4);
    k5 = new Knight("K" + 5);
    k6 = new Knight("K" + 6);

    k1.setNext(k2);
    k2.setNext(k3);
    k3.setNext(k4);
    k4.setNext(k5);
    k5.setNext(k6);
    k6.setNext(k1);

  }

  public void start() {
    Knight attacker = k1;

    System.out.println("Game started");
    while (!checkWinner()) {

      attacker.attack();
      if (attacker.getNext().isDead()) {
        removePlayer(attacker.getNext(), attacker);
        if (checkWinner()) {
          endGame(attacker);
          break;
        }
      }

      attacker = attacker.getNext();
    }

  }

  private void removePlayer(Knight deadKnight, Knight attacker) {
    System.out.printf("%s Dies\n", deadKnight.getName());

    if (!isLoop(deadKnight, attacker)) {
      attacker.setNext(deadKnight.getNext());
    } else {
      this.isWinner = true;
    }
  }

  private boolean isLoop(Knight deadKnight, Knight attacker) {
    return deadKnight.getNext() == attacker;
  }

  private void endGame(Knight winner) {
    this.isWinner = true;
    System.out.printf("%s wins the game\n", winner.getName());
  }

  private boolean checkWinner() {
    return isWinner;
  }

  public static void main(String[] args) {
    GameEngine game = new GameEngine();
    game.start();
  }

  //I kept the comments of discussion during the interview below.

  // when attack, check if the health is below 0 isDead()
  // remove the player from the list //(later just didn't use the list altogether)
  // in remove method you also change the next reference to the next of the dead knight
  // check for winner checkWinner ()  after removing a player {// checks if the list size is 1}


  // later by removing list logic, checkWinner logic changed to detecting a cycle

}
