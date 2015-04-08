import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._

/**
 * https://www.playframework.com/documentation/2.3.x/ScalaForms
 * https://www.playframework.com/documentation/2.3.x/ScalaActions
 * https://www.playframework.com/documentation/2.3.x/ScalaTestingWithSpecs2
 * https://gist.github.com/seratch/1414177
 * https://github.com/rktoomey/specs2-examples/blob/master/src/test/scala/prasinous/acceptance/FunctionalDemoSpec.scala
 * https://www.playframework.com/documentation/2.0/ScalaTest
 * https://www.playframework.com/documentation/2.1.0/ScalaFunctionalTest
 */

val m = mapping(
  "name" -> text.verifying(),
  "age"->number(min = 40, max = 100)
)(UserData.apply)(UserData.unapply)

Form(m).bind(Map(("name", "shad"),("age", "40"))).get

case class UserData(name:String, age:Int)



