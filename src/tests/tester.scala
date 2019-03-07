package tests

import org.scalatest._
import NewGame.{Food, Game, Player}

import scala.util.Random

class tester extends FunSuite{
  test("Functionality"){
    var game = new Game
    var player1 = game.createPlayerAndRegister(new Random(1))
    var player2 = game.createPlayerAndRegister(new Random(1))
    var player3 = game.createPlayerAndRegister(new Random(2))
    var food1 = game.createAndRegisterFood(new Random(1))
    var food2 = game.createAndRegisterFood(new Random(1))

    assert(game.eatFood(player1, food1) == 1)
    assert(food1.worth == 0)
    assert(game.eatFood(player1, food1) == 1)
    assert(game.eatFood(player1, food2) == 2)
    assert(game.checkScore(player1, player2) == player1.name)

    assert(game.playerCollide(player1, player2))
    assert(game.playerCollide(player1, player3) == false)

    player1.score = 0
    assert(game.checkScore(player1, player2) == "Nothing")

    player1.x = 0
    assert(game.eatFood(player1, food1) == 0)
    assert(game.checkScore(player1, player2) == "No collision")

    player1.score = 10
    player2.score = 5
    player1.x = 15
    player1.y = 15
    player2.x = 15
    player2.y = 15
    var playGame = game.checkScore(player1, player2)
    assert(player1.score == 15)
    assert(player2.score == 0)












  }
}
