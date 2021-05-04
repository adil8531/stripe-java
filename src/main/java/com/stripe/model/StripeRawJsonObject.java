package com.stripe.model;

import com.stripe.google.custom.gson.JsonObject;

/** Fallback class for when we do not recognize the object that we have received. */
public class StripeRawJsonObject extends StripeObject {
  JsonObject json;
}
