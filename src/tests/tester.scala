package tests

import org.scalatest._
import NewGame.{Player, Food, Game}

class tester extends FunSuite{
  test("Functionality"){
    val food = Game.createFood(new Food)
    val player1 = Game.createPlayer(new Player)
    val player2 = Game.createPlayer(new Player)
    val foodTest = Game.eatFood(player1, food)
    val collisionTest = Game.playerCollide(player1, player2)

    assert(collisionTest == false)
    assert(player1.score == 0)
    assert(player1.x == 254)
    assert(player1.y == 404)
    assert(food.x == 348)
    assert(food.y == 314)

    food.x = 500
    food.y = 500
    player1.x = 500
    player1.y = 500
    val tester = Game.eatFood(player1, food)
    assert(player1.score == 1)

    player1.x = 100
    player1.y = 100
    player2.x = 100
    player2.y = 100
    val collisionTest2 = Game.playerCollide(player1, player2)
    assert(collisionTest2 == true)





  }
}
