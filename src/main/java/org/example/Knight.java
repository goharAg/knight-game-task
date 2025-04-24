package org.example;

import java.util.Random;

public class Knight {
  private final String name;

  private int healthPoints;

  private Knight next;

  public Knight(String name) {
    this.name = name;
    this.healthPoints = 100;
  }

  public String getName() {
    return name;
  }

  public Knight getNext() {
    return this.next;
  }

  public void setNext(Knight nextKnight) {
    this.next = nextKnight;
  }

  public void attack() {
    Random rand = new Random();
    int damage = rand.nextInt(6) + 1;
    if (!this.next.isDead()) {
      this.next.getAttacked(damage);

      System.out.printf("%s hits %s by %d damage points%n\n",
          this.name, this.next.getName(), damage
      );
    }

  }

  public boolean isDead() {
    return this.healthPoints <= 0;
  }

  public void getAttacked(int damage) {
    if (damage < 0 || damage > 6) {
      return;
    }

    this.healthPoints = this.healthPoints - damage;
  }

}
