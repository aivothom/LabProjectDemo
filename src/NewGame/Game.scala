package NewGame

import java.security.KeyStore.TrustedCertificateEntry

import javafx.scene.input.KeyCode
import play.api.libs.json.Json
import scalaj.http.Http

import scala.util.Random


class Game {
  var playerList: List[String] = List.empty[String]
  var foodList: List[Food] = List.empty[Food]

  def createPlayerAndRegister(r: Random): Player = {
    val url = "https://uinames.com/api/?region=united+states"
    val response = Http(url).asString.body
    val parsed = Json.parse(response)
    val name = (parsed \ "name").as[String]
    var rx = r.nextInt(500)
    var ry = r.nextInt(500)
    var player = new Player(rx, ry, name)
    player
  }

  def createAndRegisterFood(r: Random): Food = {
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

  def checkScore(input1: Player, input2: Player): String = {
    var survivor = input1.name
    var checker = playerCollide(input1, input2)
    if (checker == true) {
      if (input1.score > input2.score) {
        input1.score += input2.score
        input2.score = 0
        survivor = input1.name
      } else if (input1.score < input2.score) {
        input2.score += input1.score
        input1.score = 0
        survivor = input2.name
      } else if (input1.score == input2.score){
        survivor = "Nothing"
      }
    } else if(checker == false){
      survivor = "No collision"
    }
    survivor
  }

  def eatFood(input1: Player, input2: Food): Int = {
    if (input1.x == input2.x && input1.y == input2.y) {
      input1.score = input1.score + input2.worth
      input2.worth = 0
    }
    input1.score
  }
}

