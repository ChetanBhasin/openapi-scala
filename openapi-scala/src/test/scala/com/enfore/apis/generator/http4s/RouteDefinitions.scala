package com.enfore.apis.generator.http4s

import com.enfore.apis.repr.TypeRepr
import com.enfore.apis.repr.TypeRepr.ReqWithContentType.{POST, PUT}
import com.enfore.apis.repr.TypeRepr.{
  DeleteRequest,
  GetRequest,
  PathParameter,
  PrimitiveArray,
  PrimitiveInt,
  PrimitiveOption,
  PrimitiveString,
  PutOrPostRequest
}
import scala.collection.immutable.ListMap

object RouteDefinitions {
  lazy val `GET /contacts/individual` = GetRequest(
    "/contacts/individual",
    List.empty,
    Map.empty,
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")
      ))
  )

  lazy val `POST /contacts/individual` = PutOrPostRequest(
    "/contacts/individual",
    POST,
    List.empty,
    Map.empty,
    TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact"),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")))
  )

  lazy val `GET /contacts/individual/{contacts-id}` = GetRequest(
    "/contacts/individual/{contacts-id}",
    List(PathParameter("contacts-id")),
    Map.empty,
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")
      ))
  )

  lazy val `PUT /contacts/individual/{contacts-id}` = PutOrPostRequest(
    "/contacts/individual/{contacts-id}",
    PUT,
    List(PathParameter("contacts-id")),
    Map.empty,
    TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact"),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")))
  )

  lazy val `DELETE /contacts/individual/{contacts-id}` = DeleteRequest(
    "/contacts/individual/{contacts-id}",
    List(PathParameter("contacts-id")),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")))
  )

  lazy val `GET /contacts/organization/{contacts-id}/addresses` = GetRequest(
    "/contacts/organization/{contacts-id}/addresses",
    List(PathParameter("contacts-id")),
    Map.empty,
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `POST /contacts/organization/{contacts-id}/addresses` = PutOrPostRequest(
    "/contacts/organization/{contacts-id}/addresses",
    POST,
    List(PathParameter("contacts-id")),
    Map.empty,
    TypeRepr.Ref("#/components/schemas/Address", "Address"),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")))
  )

  lazy val `GET /contacts/organization/{contacts-id}/addresses/{address-id}` = GetRequest(
    "/contacts/organization/{contacts-id}/addresses/{address-id}",
    List(
      PathParameter("contacts-id"),
      PathParameter("address-id")
    ),
    Map.empty,
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `PUT /contacts/organization/{contacts-id}/addresses/{address-id}` = PutOrPostRequest(
    "/contacts/organization/{contacts-id}/addresses/{address-id}",
    PUT,
    List(
      PathParameter("contacts-id"),
      PathParameter("address-id")
    ),
    Map.empty,
    TypeRepr.Ref("#/components/schemas/Address", "Address"),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `DELETE /contacts/organization/{contacts-id}/addresses/{address-id}` = DeleteRequest(
    "/contacts/organization/{contacts-id}/addresses/{address-id}",
    List(
      PathParameter("contacts-id"),
      PathParameter("address-id")
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `GET /contacts/individual?query1&query2&optional1&optional2&list1&optional-list1` = GetRequest(
    "/contacts/individual",
    List.empty,
    ListMap(
      "query1"         -> PrimitiveString(None),
      "query2"         -> PrimitiveInt(None),
      "optional1"      -> PrimitiveOption(PrimitiveString(None)),
      "optional2"      -> PrimitiveOption(PrimitiveInt(None)),
      "list1"          -> PrimitiveArray(PrimitiveInt(None), None),
      "optional-list1" -> PrimitiveOption(PrimitiveArray(PrimitiveString(None), None))
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")
      ))
  )

  lazy val `POST /contacts/individual?query1&query2&optional1&optional2&list1&optional-list1` = PutOrPostRequest(
    "/contacts/individual",
    POST,
    List.empty,
    ListMap(
      "query1"         -> PrimitiveString(None),
      "query2"         -> PrimitiveInt(None),
      "optional1"      -> PrimitiveOption(PrimitiveString(None)),
      "optional2"      -> PrimitiveOption(PrimitiveInt(None)),
      "list1"          -> PrimitiveArray(PrimitiveInt(None), None),
      "optional-list1" -> PrimitiveOption(PrimitiveArray(PrimitiveString(None), None))
    ),
    TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact"),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")))
  )

  lazy val `GET /contacts/individual/{contacts-id}?optional1&optional2` = GetRequest(
    "/contacts/individual/{contacts-id}",
    List(PathParameter("contacts-id")),
    ListMap(
      "optional1" -> PrimitiveOption(PrimitiveString(None)),
      "optional2" -> PrimitiveOption(PrimitiveInt(None))
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")
      ))
  )

  lazy val `PUT /contacts/individual/{contacts-id}?optional1&optional2` = PutOrPostRequest(
    "/contacts/individual/{contacts-id}",
    PUT,
    List(PathParameter("contacts-id")),
    ListMap(
      "optional1" -> PrimitiveOption(PrimitiveString(None)),
      "optional2" -> PrimitiveOption(PrimitiveInt(None))
    ),
    TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact"),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")))
  )

  lazy val `DELETE /contacts/individual/{contacts-id}?optional1&optional2` = DeleteRequest(
    "/contacts/individual/{contacts-id}",
    List(PathParameter("contacts-id")),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")))
  )

  lazy val `GET /contacts/organization/{contacts-id}/addresses?query1&query2` = GetRequest(
    "/contacts/organization/{contacts-id}/addresses",
    List(PathParameter("contacts-id")),
    ListMap(
      "query1" -> PrimitiveString(None),
      "query2" -> PrimitiveInt(None)
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `POST /contacts/organization/{contacts-id}/addresses?query1&query2` = PutOrPostRequest(
    "/contacts/organization/{contacts-id}/addresses",
    POST,
    List(PathParameter("contacts-id")),
    ListMap(
      "query1" -> PrimitiveString(None),
      "query2" -> PrimitiveInt(None)
    ),
    TypeRepr.Ref("#/components/schemas/Address", "Address"),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")))
  )

  lazy val `GET /contacts/organization/{contacts-id}/addresses/{address-id}?list1&list2` = GetRequest(
    "/contacts/organization/{contacts-id}/addresses/{address-id}",
    List(
      PathParameter("contacts-id"),
      PathParameter("address-id")
    ),
    ListMap(
      "list1" -> PrimitiveArray(PrimitiveString(None), None),
      "list2" -> PrimitiveArray(PrimitiveInt(None), None)
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `PUT /contacts/organization/{contacts-id}/addresses/{address-id}?list1&list2` = PutOrPostRequest(
    "/contacts/organization/{contacts-id}/addresses/{address-id}",
    PUT,
    List(
      PathParameter("contacts-id"),
      PathParameter("address-id")
    ),
    ListMap(
      "list1" -> PrimitiveArray(PrimitiveString(None), None),
      "list2" -> PrimitiveArray(PrimitiveInt(None), None)
    ),
    TypeRepr.Ref("#/components/schemas/Address", "Address"),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `DELETE /contacts/organization/{contacts-id}/addresses/{address-id}?list1&list2` = DeleteRequest(
    "/contacts/organization/{contacts-id}/addresses/{address-id}",
    List(
      PathParameter("contacts-id"),
      PathParameter("address-id")
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/Address", "Address")
      ))
  )

  lazy val `GET /contacts/individual?optional-list1&optional-list2` = GetRequest(
    "/contacts/individual",
    List.empty,
    ListMap(
      "optional-list1" -> PrimitiveOption(PrimitiveArray(PrimitiveString(None), None)),
      "optional-list2" -> PrimitiveOption(PrimitiveArray(PrimitiveInt(None), None))
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")
      ))
  )

  lazy val `POST /contacts/individual?optionaoListl1&optional-list2` = PutOrPostRequest(
    "/contacts/individual",
    POST,
    List.empty,
    ListMap(
      "optional-list1" -> PrimitiveOption(PrimitiveArray(PrimitiveString(None), None)),
      "optional-list2" -> PrimitiveOption(PrimitiveArray(PrimitiveInt(None), None))
    ),
    TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact"),
    Some(Map("application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")))
  )

  lazy val `GET /contacts/individual/funny.,argument/type/?other:@funny&trait` = GetRequest(
    "/contacts/individual/{funny.,argument}/{type}",
    List(
      PathParameter("funny.,argument"),
      PathParameter("type")
    ),
    Map(
      "other:@funny" -> PrimitiveString(None),
      "trait"        -> PrimitiveString(None)
    ),
    Some(
      Map(
        "application/json" -> TypeRepr.Ref("#/components/schemas/IndividualContact", "IndividualContact")
      ))
  )
}