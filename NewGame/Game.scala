package NewGame

import javafx.scene.input.KeyCode


object Game {
  var foodList: Array[Int] = Array()
  var playerList: Array[Int] = Array()
  var id = 1
  var value = 1
  var r = new scala.util.Random

  def createPlayer(input: Player): Unit = {
    input.x = r.nextInt(500)
    input.y = r.nextInt(500)
    playerList = playerList :+ id
    id += 1
  }
  def createFood(input: Food): Unit ={
    input.x = r.nextInt(500)
    input.y = r.nextInt(500)
    foodList = foodList :+ value
    value += 1
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
    println(r.nextInt(100))
  }
}
