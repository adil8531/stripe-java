// File generated from our OpenAPI spec
package com.stripe.model;

import com.stripe.google.custom.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.OrderReturnListParams;
import com.stripe.param.OrderReturnRetrieveParams;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OrderReturn extends ApiResource implements HasId {
  /**
   * A positive integer in the smallest currency unit (that is, 100 cents for $1.00, or 1 for ¥1,
   * Japanese Yen being a zero-decimal currency) representing the total amount for the returned line
   * item.
   */
  @SerializedName("amount")
  Long amount;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /**
   * Three-letter <a href="https://www.iso.org/iso-4217-currency-codes.html">ISO currency code</a>,
   * in lowercase. Must be a <a href="https://stripe.com/docs/currencies">supported currency</a>.
   */
  @SerializedName("currency")
  String currency;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** The items included in this order return. */
  @SerializedName("items")
  List<OrderItem> items;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code order_return}.
   */
  @SerializedName("object")
  String object;

  /** The order that this return includes items from. */
  @SerializedName("order")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Order> order;

  /** The ID of the refund issued for this return. */
  @SerializedName("refund")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Refund> refund;

  /** Get ID of expandable {@code order} object. */
  public String getOrder() {
    return (this.order != null) ? this.order.getId() : null;
  }

  public void setOrder(String id) {
    this.order = ApiResource.setExpandableFieldId(id, this.order);
  }

  /** Get expanded {@code order}. */
  public Order getOrderObject() {
    return (this.order != null) ? this.order.getExpanded() : null;
  }

  public void setOrderObject(Order expandableObject) {
    this.order = new ExpandableField<Order>(expandableObject.getId(), expandableObject);
  }

  /** Get ID of expandable {@code refund} object. */
  public String getRefund() {
    return (this.refund != null) ? this.refund.getId() : null;
  }

  public void setRefund(String id) {
    this.refund = ApiResource.setExpandableFieldId(id, this.refund);
  }

  /** Get expanded {@code refund}. */
  public Refund getRefundObject() {
    return (this.refund != null) ? this.refund.getExpanded() : null;
  }

  public void setRefundObject(Refund expandableObject) {
    this.refund = new ExpandableField<Refund>(expandableObject.getId(), expandableObject);
  }

  /**
   * Returns a list of your order returns. The returns are returned sorted by creation date, with
   * the most recently created return appearing first.
   */
  public static OrderReturnCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of your order returns. The returns are returned sorted by creation date, with
   * the most recently created return appearing first.
   */
  public static OrderReturnCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/order_returns");
    return ApiResource.requestCollection(url, params, OrderReturnCollection.class, options);
  }

  /**
   * Returns a list of your order returns. The returns are returned sorted by creation date, with
   * the most recently created return appearing first.
   */
  public static OrderReturnCollection list(OrderReturnListParams params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of your order returns. The returns are returned sorted by creation date, with
   * the most recently created return appearing first.
   */
  public static OrderReturnCollection list(OrderReturnListParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/order_returns");
    return ApiResource.requestCollection(url, params, OrderReturnCollection.class, options);
  }

  /**
   * Retrieves the details of an existing order return. Supply the unique order ID from either an
   * order return creation request or the order return list, and Stripe will return the
   * corresponding order information.
   */
  public static OrderReturn retrieve(String id) throws StripeException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves the details of an existing order return. Supply the unique order ID from either an
   * order return creation request or the order return list, and Stripe will return the
   * corresponding order information.
   */
  public static OrderReturn retrieve(String id, RequestOptions options) throws StripeException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves the details of an existing order return. Supply the unique order ID from either an
   * order return creation request or the order return list, and Stripe will return the
   * corresponding order information.
   */
  public static OrderReturn retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/order_returns/%s", ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, OrderReturn.class, options);
  }

  /**
   * Retrieves the details of an existing order return. Supply the unique order ID from either an
   * order return creation request or the order return list, and Stripe will return the
   * corresponding order information.
   */
  public static OrderReturn retrieve(
      String id, OrderReturnRetrieveParams params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/order_returns/%s", ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, OrderReturn.class, options);
  }
}
