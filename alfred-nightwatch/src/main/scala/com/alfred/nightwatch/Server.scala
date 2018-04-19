package com.alfred.nightwatch

import io.finch._
import io.finch.syntax._
import io.finch.circe._
import io.circe.generic.auto._
import com.twitter.logging.Logger
import com.twitter.util.{ Await }
import com.twitter.finagle.Http

import com.alfred.nightwatch.configuration.Configuration.{ HttpConfig }

object Server {

  val channel: Endpoint[String] = get("channel") {
    Ok("Hello, World!")
  }

  def main(): Unit = {
    val api = (channel)

    val server = Http
      .server
      .serve(s":${HttpConfig.port}", api.toServiceAs[Application.Json])

    Await.ready(server)
  }
}

