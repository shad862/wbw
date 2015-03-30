package controllers

import models.Word
import play.api.mvc.{Action, Controller}

/**
 * @author shad862
 */
object Words extends Controller{

  def list() = Action { implicit request =>
    Ok(views.html.words.list(Word.findAll))
  }

  def show(content: String) = Action { implicit  request =>
    Word.findByContent(content).map { word =>
      Ok(views.html.words.details(word))
    }.getOrElse(NotFound)
  }

  def newWord = Action { implicit  request =>
    Ok("newWord not implemented yet")
  }
}
