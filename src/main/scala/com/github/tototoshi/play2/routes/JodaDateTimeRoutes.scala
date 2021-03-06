/*
 * Copyright 2012 Toshiyuki Takahashi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.tototoshi.play2.routes

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.net.URLEncoder
import play.api.mvc._

trait JodaDateTimeRoutes { self: JodaDateTimeFormat =>

  implicit object queryStringDateTimeBinder extends QueryStringBindable.Parsing[DateTime](
    dateString => DateTimeFormat.forPattern(dateTimeFormat).parseDateTime(dateString),
    _.toString(dateTimeFormat),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.DateTime: %s".format(key, e.getMessage)
  )

  implicit object pathDateTimeBinder extends PathBindable.Parsing[DateTime](
    dateString => DateTimeFormat.forPattern(dateTimeFormat).parseDateTime(dateString),
    _.toString(dateTimeFormat),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.DateTime: %s".format(key, e.getMessage)
  )

}

object JodaDateTimeRoutes extends JodaDateTimeRoutes
  with DefaultJodaDateTimeFormat
