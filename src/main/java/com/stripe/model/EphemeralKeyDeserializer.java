package com.stripe.model;

import com.stripe.google.custom.gson.FieldNamingPolicy;
import com.stripe.google.custom.gson.Gson;
import com.stripe.google.custom.gson.GsonBuilder;
import com.stripe.google.custom.gson.JsonDeserializationContext;
import com.stripe.google.custom.gson.JsonDeserializer;
import com.stripe.google.custom.gson.JsonElement;
import com.stripe.google.custom.gson.JsonParseException;
import java.lang.reflect.Type;

public class EphemeralKeyDeserializer implements JsonDeserializer<EphemeralKey> {
  /** Deserializes an ephemeral_key JSON payload into an {@link EphemeralKey} object. */
  @Override
  public EphemeralKey deserialize(
      JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    Gson gson =
        new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    EphemeralKey result = gson.fromJson(json, EphemeralKey.class);
    result.setRawJson(json.getAsJsonObject().toString());
    return result;
  }
}
