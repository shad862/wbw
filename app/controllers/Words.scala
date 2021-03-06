package controllers

import models.Word
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.Messages
import play.api.mvc.{Flash, Action, Controller}

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

  def newWord() = Action { implicit  request =>
    val form = wordForm
    wordForm.bind(Map("id"-> Word.findAll.size.toString))
    Ok(views.html.words.editWord(form))
  }

  private def isWordSet(word: String) ={
    Word.exists(word)
  }

  private def makeWordForm() = Form(
    mapping(
      "id" -> longNumber,
      "content" -> nonEmptyText,
      "language" -> nonEmptyText(2,2),
      "meaning" -> nonEmptyText(1,255)
    )(Word.apply)(Word.unapply)
  )

  private val wordForm = makeWordForm()

  def save = Action { implicit request =>
    val newWordForm = wordForm.bindFromRequest()
    newWordForm.fold(
      hasErrors = {form =>
        Redirect(routes.Words.newWord()).flashing(Flash(form.data) +
          ("error" -> Messages("validation.error")))
      },
      success = {newWord =>
        Word.add(newWord)
        val successMessage = ("success" -> Messages("words.new.success", newWord.content))
        Redirect(routes.Words.show(newWord.content)).flashing(successMessage)
      }
    )
  }

  def update(id: Long) = Action { implicit request =>
    Ok("Update not implemented yet")
  }
}
