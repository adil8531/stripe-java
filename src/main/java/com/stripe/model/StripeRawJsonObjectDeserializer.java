package com.stripe.model;

import com.stripe.google.custom.gson.JsonDeserializationContext;
import com.stripe.google.custom.gson.JsonDeserializer;
import com.stripe.google.custom.gson.JsonElement;
import com.stripe.google.custom.gson.JsonParseException;
import java.lang.reflect.Type;

public class StripeRawJsonObjectDeserializer implements JsonDeserializer<StripeRawJsonObject> {
  /** Deserializes a JSON payload into a {@link StripeRawJsonObject} object. */
  @Override
  public StripeRawJsonObject deserialize(
      JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    StripeRawJsonObject object = new StripeRawJsonObject();
    object.json = json.getAsJsonObject();
    return object;
  }
}
