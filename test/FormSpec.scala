import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner

import play.api.data._
import play.api.data.Forms._

import play.api.test._
import play.api.test.Helpers._


/**
 * @author shad
 */
@RunWith(classOf[JUnitRunner])
class FormSpec extends Specification{

  "User" should {

    "be retrieved by id" in {

      running(FakeApplication()) {

      }
    }

/*    "render index template" in {
      val html = views.html.index("Coco")

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain("Hello Coco")
    }*/
  }
}

case class UserData(name:String, age:Int)
