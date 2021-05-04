package com.stripe.param.common;

import com.stripe.google.custom.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;

public enum EmptyParam implements ApiRequestParams.EnumParam {
  @SerializedName("")
  EMPTY("");
  private final String value;

  EmptyParam(String value) {
    this.value = value;
  }

  @Override
  public String getValue() {
    return this.value;
  }
}
