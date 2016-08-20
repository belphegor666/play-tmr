package controllers

import play.api._
import play.api.mvc._
import play.api.i18n._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.libs.json.Json
import play.api.Play.current

import java.util.{Properties, ArrayList}

import com.typesafe.config.{ConfigObject, ConfigValue, ConfigFactory, Config}

import org.cloudfoundry.reconfiguration.play._

import scala.concurrent.{ ExecutionContext, Future }

import javax.inject._

class PersonController @Inject() (val messagesApi: MessagesApi)
                                 (configuration: play.api.Configuration)
                                 (implicit ec: ExecutionContext) extends Controller with I18nSupport{


  /**
   * The index action.
   */
  def index = Action {
    //Ok(views.html.index(personForm))
    val props = System.getProperties()
    val keys = props.stringPropertyNames().toArray(new Array[String](0))
    props.list(System.out)
    
    //DEBUG
    //System.out.println(current.configuration.toString())
    val cc = new CloudConfig()
    cc.init

    Ok(views.html.index(props, keys))
  }
  
  def extra = Action {
    //Ok(views.html.index(personForm))
    val config = configuration.underlying
    //val keys = config.keys.toArray.asInstanceOf[Array[String]]
    val keys = new ArrayList[String]

    val it = config.entrySet.iterator
    while(it.hasNext()){
        keys.add(it.next().getKey)
    }
 
    //DEBUG
    //System.out.println(current.configuration.toString())

    Ok(views.html.extra(config, keys))
  }

}