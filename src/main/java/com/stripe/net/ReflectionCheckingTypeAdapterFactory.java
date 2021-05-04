package com.stripe.net;

import com.stripe.google.custom.gson.Gson;
import com.stripe.google.custom.gson.TypeAdapter;
import com.stripe.google.custom.gson.TypeAdapterFactory;
import com.stripe.google.custom.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.stripe.google.custom.gson.reflect.TypeToken;

/**
 * {@link TypeAdapterFactory} that checks that we don't use {@link ReflectiveTypeAdapterFactory}
 * accidentally for classes outside {@code com.stripe} packages. This usually happens when we forget
 * to mark a field {@code transient}.
 */
class ReflectionCheckingTypeAdapterFactory implements TypeAdapterFactory {
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (!type.getType().getTypeName().startsWith("com.stripe.")) {
      TypeAdapter<T> adapter = gson.getDelegateAdapter(this, type);
      if (adapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
        throw new IllegalArgumentException(
            "Refusing to create type reflection-based type adapter for external class: " + type);
      }
    }
    return null;
  }
}
