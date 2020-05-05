package com.enfore.apis.ast

import com.enfore.apis.ast.ASTTranslationFunctions.PackageName
import com.enfore.apis.ast.SwaggerAST.{
  ComponentsObject,
  CoreASTRepr,
  MediaTypeObject,
  OperationObject,
  ParameterObject,
  ReferenceObject,
  RequestBodyObject,
  ResponseObject,
  SchemaObject,
  SchemaObjectType
}
import com.enfore.apis.ast.SwaggerAST.ParameterLocation.path
import com.enfore.apis.repr.ReqWithContentType.PUT
import com.enfore.apis.repr.TypeRepr.Ref
import com.enfore.apis.repr.{GetRequest, PathItemAggregation, PathParameter, RequestWithPayload}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ReadRoutesToInteropSpec extends AnyFlatSpec with Matchers {
  "readRoutesToInerop" should "be able to read multiple methods per route" in {
    val expected = Map(
      "_contacts_individual_{contact-id}" ->
        PathItemAggregation(
          "/contacts/individual/{contact-id}",
          List(
            GetRequest(
              "/contacts/individual/{contact-id}",
              Some("Load an IndividualContact by its identifier"),
              None,
              Some("dummyFunction"),
              List(PathParameter("contact-id")),
              Map(),
              Some(
                Map(
                  "application/vnd.enfore.contacts+json" -> Ref(
                    "#/components/schemas/IndividualContact",
                    "IndividualContact",
                    None
                  )
                )
              ),
              200
            ),
            RequestWithPayload(
              "/contacts/individual/{contact-id}",
              Some("Full update of an IndividualContact"),
              None,
              Some("dummyFunction"),
              PUT,
              List(PathParameter("contact-id")),
              Map(),
              Some(Ref("foo", "IndividualContact", None)),
              Some(
                Map(
                  "application/vnd.enfore.contacts+json" -> Ref(
                    "#/components/schemas/IndividualContact",
                    "IndividualContact",
                    None
                  )
                )
              ),
              Some(false),
              200
            )
          )
        )
    )

    val actual = ASTTranslationFunctions.readRoutesToInterop(ast)(PackageName("foo"))

    normalise(actual) should equal(normalise(expected))
  }

  private def normalise(in: Map[String, PathItemAggregation]): Map[String, PathItemAggregation] =
    in.mapValues { p =>
      p.copy(
        items = p.items.sortBy(_.toString) // Sort request types
      )
    }

  private lazy val ast = CoreASTRepr(
    ComponentsObject(
      Map(
        "Contact" -> SchemaObject(
          summary = None,
          description = Some("Base type for all contacts.\n"),
          Some(SchemaObjectType.`object`),
          Some(
            Map(
              "id" -> SchemaObject(
                description = Some(
                  "The technical identifier of the contact. Assigned by the enfore platform on creation of the contact and not changeable afterwards."
                ),
                `type` = Some(SchemaObjectType.string),
                properties = None,
                items = None,
                readOnly = Some(true),
                required = None
              ),
              "type" -> SchemaObject(None, None, Some(SchemaObjectType.string), None, None, None, None, None),
              "name" -> SchemaObject(
                None,
                Some(
                  "The name of the contact.\nFor individual contacts, this is the full name of the person, e.g., \"Barnabas Ludwig Johnson II Sr.\".\n" +
                    "For organization contacts, this is the \"common name\" of the organization. This may not necessarily be the registered business name, " +
                    "as that may either not exist or be too cumbersome to use.\n"
                ),
                Some(SchemaObjectType.string)
              )
            )
          ),
          None,
          None,
          None,
          None,
          Some(List("id", "type", "name"))
        ),
        "IndividualContact" -> SchemaObject(
          None,
          Some("Represents a human person.\n"),
          Some(SchemaObjectType.`object`),
          Some(
            Map(
              "name"        -> SchemaObject(`type` = Some(SchemaObjectType.string)),
              "dateOfBirth" -> SchemaObject(`type` = Some(SchemaObjectType.string)),
              "id"          -> SchemaObject(`type` = Some(SchemaObjectType.string)),
              "anniversary" -> SchemaObject(`type` = Some(SchemaObjectType.string)),
              "gender"      -> ReferenceObject("#/components/schemas/Gender", None)
            )
          )
        ),
        "Gender" -> SchemaObject(
          description = Some("The gender of a human person"),
          `type` = Some(SchemaObjectType.string),
          enum = Some(List("FEMALE", "MALE"))
        )
      )
    ),
    Some(
      Map(
        "/contacts/individual/{contact-id}" -> Map(
          "get" -> OperationObject(
            Some("Load an IndividualContact by its identifier"),
            None,
            Some("dummyFunction"),
            None,
            Map(
              200 -> ResponseObject(
                "foo desc",
                None,
                Some(
                  Map(
                    "application/vnd.enfore.contacts+json" -> MediaTypeObject(
                      Some(ReferenceObject("#/components/schemas/IndividualContact", None))
                    )
                  )
                )
              ),
              403 -> ResponseObject("", None, None),
              404 -> ResponseObject("", None, None)
            ),
            Some(
              List(
                ParameterObject(
                  "contact-id",
                  path,
                  Some(ReferenceObject("", None)),
                  Some("ID of the contact to load"),
                  None
                )
              )
            )
          ),
          "put" -> OperationObject(
            summary = Some("Full update of an IndividualContact"),
            description = None,
            Some("dummyFunction"),
            requestBody = Some(
              RequestBodyObject(
                None,
                Map(
                  "application/vnd.enfore.contacts+json" -> MediaTypeObject(
                    Some(ReferenceObject("#/components/schemas/IndividualContact", None))
                  )
                ),
                None
              )
            ),
            responses = Map(
              200 -> ResponseObject(
                "",
                None,
                Some(
                  Map(
                    "application/vnd.enfore.contacts+json" -> MediaTypeObject(
                      Some(ReferenceObject("#/components/schemas/IndividualContact", None))
                    )
                  )
                )
              ),
              400 -> ResponseObject("", None, None),
              403 -> ResponseObject("", None, None),
              404 -> ResponseObject("", None, None)
            ),
            parameters = Some(
              List(
                ParameterObject(
                  "contact-id",
                  path,
                  Some(ReferenceObject("", None)),
                  Some("ID of the contact to update"),
                  None
                )
              )
            )
          )
        )
      )
    )
  )
}
