package models

import play.api.mvc.Result

/**
 * @author shad862
 */

/**
 * A word to learn with target language
 *
 * @param id
 * @param content
 * @param language
 * @param meaning
 */
case class Word(id: Long, content:String, language: String, meaning: String) {
  override def toString = "%s - %s".format(id, content)
}

object Word{
  def exists(word: String) ={
    findByContent(word).exists(words)
  }

  var words = Set(
    Word(0, "Cat", "en", "A domesticated subspecies, Felis silvestris catus, of feline animal, commonly kept as a house pet."),
    Word(1, "Tail", "en", "(anatomy) The caudal appendage of an animal that is attached to its posterior and near the anus.")
  )

  def findAll = words.toList

  def add(word: Word) {
    words = words + word
  }

  def findByContent(content: String) = words.find(_.content == content)
}
