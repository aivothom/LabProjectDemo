package NewGame

class Game1 {
  def createPlayer(input: Player): Unit = {
    var x = input.x
    var y = input.y
  }
  def food(input: Food, id: Int): Unit ={
    var x = input.x
    var y = input.y

  }
  def eatFood(input1: Player, input2: Food): Int ={
    if (input1.x == input2.x && input1.y == input2.y){
      input1.score += 1
    }
    input1.score
  }
}
