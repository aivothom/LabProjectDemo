package NewGame

import java.security.KeyStore.TrustedCertificateEntry

import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState
import javafx.scene.input.KeyCode


object Game {
  var foodList: List[Int] = List.empty[Int]
  var playerList: List[Int] = List.empty[Int]
  var id = 1
  var value = 1
  val r = new scala.util.Random(1)

  def createPlayer(input: Player): Player = {
    var newx = r.nextInt(500)
    var newy = r.nextInt(500)
    input.x += newx
    input.y += newy
    playerList = playerList :+ id
    id += 1
    return input
  }
  def createFood(input: Food): Food = {
    var newx = r.nextInt(500)
    var newy = r.nextInt(500)
    input.x = 1 + r.nextInt(500)
    input.y = 1 + r.nextInt(500)
    foodList = foodList :+ value
    value += 1
    return input
  }
  def playerCollide(input1: Player, input2: Player): Boolean ={
    var check = false
    if (input1.x == input2.x && input1.y == input2.y){
      check = true
    }
    check
  }
  def eatFood(input1: Player, input2: Food): Int ={
    if (input1.x == input2.x && input1.y == input2.y){
      input1.score += 1
    }
    input1.score
  }
  def movement(keyCode: KeyCode): Unit ={
    keyCode.getName match {
      case "W" => println("Pressed")
      case "A" => println("Pressed")
      case "S" => println("Pressed")
      case "D" => println("Pressed")
      case _ => println(keyCode.getName + " pressed with no action")
    }
  }
  def main(args: Array[String]): Unit = {
    var food = createFood(new Food)
    var player = createPlayer(new Player)
    var player2 = createPlayer(new Player)
    eatFood(player, food)
    eatFood(player, food)
    println(player.x, player.y)
    println(food.x, food.y)
    println(player2.x, player2.y)
  }
}
