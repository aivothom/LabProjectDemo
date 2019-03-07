package NewGame

import play.api.libs.json.Json
import scalaj.http.Http

import scala.util.Random

class Game1 {
  def createPlayer(r: Random): Player = {
    val url = "https://uinames.com/api/?region=united+states"
    val response = Http(url).asString.body
    val parsed = Json.parse(response)
    val name = (parsed \ "name").as[String]
    var rx = r.nextInt(500)
    var ry = r.nextInt(500)
    new Player(rx, ry,  name)
  }

  def createFood(r: Random): Food = {
    var rx = r.nextInt(500)
    var ry = r.nextInt(500)
    new Food(rx, ry)
  }

  def playerCollide(input1: Player, input2: Player): Boolean = {
    var check = false
    if (input1.x == input2.x && input1.y == input2.y) {
      check = true
    }
    check
  }

  def eliminate(input1: Player, input2: Player): Player = {
    var survivor = input1
    var checker = playerCollide(input1, input2)
    if (checker == true) {
      if (input1.score > input2.score) {
        survivor = input1
      } else if (input1.score < input2.score) {
        survivor = input2
      }
    }
    survivor
  }

  def eatFood(input1: Player, input2: Food): Int = {
    if (input1.x == input2.x && input1.y == input2.y) {
      input1.score += 1
    }
    input1.score
  }
}
