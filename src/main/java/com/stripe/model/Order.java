// File generated from our OpenAPI spec
package com.stripe.model;

import com.stripe.google.custom.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.OrderCreateParams;
import com.stripe.param.OrderListParams;
import com.stripe.param.OrderPayParams;
import com.stripe.param.OrderRetrieveParams;
import com.stripe.param.OrderReturnOrderParams;
import com.stripe.param.OrderUpdateParams;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Order extends ApiResource implements HasId, MetadataStore<Order> {
  /**
   * A positive integer in the smallest currency unit (that is, 100 cents for $1.00, or 1 for ¥1,
   * Japanese Yen being a zero-decimal currency) representing the total amount for the order.
   */
  @SerializedName("amount")
  Long amount;

  /** The total amount that was returned to the customer. */
  @SerializedName("amount_returned")
  Long amountReturned;

  /** ID of the Connect Application that created the order. */
  @SerializedName("application")
  String application;

  /**
   * A fee in cents that will be applied to the order and transferred to the application owner’s
   * Stripe account. The request must be made with an OAuth key or the Stripe-Account header in
   * order to take an application fee. For more information, see the application fees documentation.
   */
  @SerializedName("application_fee")
  Long applicationFee;

  /**
   * The ID of the payment used to pay for the order. Present if the order status is {@code paid},
   * {@code fulfilled}, or {@code refunded}.
   */
  @SerializedName("charge")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Charge> charge;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /**
   * Three-letter <a href="https://www.iso.org/iso-4217-currency-codes.html">ISO currency code</a>,
   * in lowercase. Must be a <a href="https://stripe.com/docs/currencies">supported currency</a>.
   */
  @SerializedName("currency")
  String currency;

  /** The customer used for the order. */
  @SerializedName("customer")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Customer> customer;

  /** The email address of the customer placing the order. */
  @SerializedName("email")
  String email;

  /** External coupon code to load for this order. */
  @SerializedName("external_coupon_code")
  String externalCouponCode;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** List of items constituting the order. An order can have up to 25 items. */
  @SerializedName("items")
  List<OrderItem> items;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of <a href="https://stripe.com/docs/api/metadata">key-value pairs</a> that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code order}.
   */
  @SerializedName("object")
  String object;

  /** A list of returns that have taken place for this order. */
  @SerializedName("returns")
  OrderReturnCollection returns;

  /**
   * The shipping method that is currently selected for this order, if any. If present, it is equal
   * to one of the {@code id}s of shipping methods in the {@code shipping_methods} array. At order
   * creation time, if there are multiple shipping methods, Stripe will automatically selected the
   * first method.
   */
  @SerializedName("selected_shipping_method")
  String selectedShippingMethod;

  /** The shipping address for the order. Present if the order is for goods to be shipped. */
  @SerializedName("shipping")
  ShippingDetails shipping;

  /**
   * A list of supported shipping methods for this order. The desired shipping method can be
   * specified either by updating the order, or when paying it.
   */
  @SerializedName("shipping_methods")
  List<Order.ShippingMethod> shippingMethods;

  /**
   * Current order status. One of {@code created}, {@code paid}, {@code canceled}, {@code
   * fulfilled}, or {@code returned}. More details in the <a
   * href="https://stripe.com/docs/orders/guide#understanding-order-statuses">Orders Guide</a>.
   */
  @SerializedName("status")
  String status;

  /** The timestamps at which the order status was updated. */
  @SerializedName("status_transitions")
  StatusTransitions statusTransitions;

  /** Time at which the object was last updated. Measured in seconds since the Unix epoch. */
  @SerializedName("updated")
  Long updated;

  /** The user's order ID if it is different from the Stripe order ID. */
  @SerializedName("upstream_id")
  String upstreamId;

  /** Get ID of expandable {@code charge} object. */
  public String getCharge() {
    return (this.charge != null) ? this.charge.getId() : null;
  }

  public void setCharge(String id) {
    this.charge = ApiResource.setExpandableFieldId(id, this.charge);
  }

  /** Get expanded {@code charge}. */
  public Charge getChargeObject() {
    return (this.charge != null) ? this.charge.getExpanded() : null;
  }

  public void setChargeObject(Charge expandableObject) {
    this.charge = new ExpandableField<Charge>(expandableObject.getId(), expandableObject);
  }

  /** Get ID of expandable {@code customer} object. */
  public String getCustomer() {
    return (this.customer != null) ? this.customer.getId() : null;
  }

  public void setCustomer(String id) {
    this.customer = ApiResource.setExpandableFieldId(id, this.customer);
  }

  /** Get expanded {@code customer}. */
  public Customer getCustomerObject() {
    return (this.customer != null) ? this.customer.getExpanded() : null;
  }

  public void setCustomerObject(Customer expandableObject) {
    this.customer = new ExpandableField<Customer>(expandableObject.getId(), expandableObject);
  }

  /** Creates a new order object. */
  public static Order create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new order object. */
  public static Order create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/orders");
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Order.class, options);
  }

  /** Creates a new order object. */
  public static Order create(OrderCreateParams params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new order object. */
  public static Order create(OrderCreateParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/orders");
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Order.class, options);
  }

  /**
   * Returns a list of your orders. The orders are returned sorted by creation date, with the most
   * recently created orders appearing first.
   */
  public static OrderCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of your orders. The orders are returned sorted by creation date, with the most
   * recently created orders appearing first.
   */
  public static OrderCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/orders");
    return ApiResource.requestCollection(url, params, OrderCollection.class, options);
  }

  /**
   * Returns a list of your orders. The orders are returned sorted by creation date, with the most
   * recently created orders appearing first.
   */
  public static OrderCollection list(OrderListParams params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of your orders. The orders are returned sorted by creation date, with the most
   * recently created orders appearing first.
   */
  public static OrderCollection list(OrderListParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/orders");
    return ApiResource.requestCollection(url, params, OrderCollection.class, options);
  }

  /**
   * Retrieves the details of an existing order. Supply the unique order ID from either an order
   * creation request or the order list, and Stripe will return the corresponding order information.
   */
  public static Order retrieve(String id) throws StripeException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves the details of an existing order. Supply the unique order ID from either an order
   * creation request or the order list, and Stripe will return the corresponding order information.
   */
  public static Order retrieve(String id, RequestOptions options) throws StripeException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves the details of an existing order. Supply the unique order ID from either an order
   * creation request or the order list, and Stripe will return the corresponding order information.
   */
  public static Order retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(), String.format("/v1/orders/%s", ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Order.class, options);
  }

  /**
   * Retrieves the details of an existing order. Supply the unique order ID from either an order
   * creation request or the order list, and Stripe will return the corresponding order information.
   */
  public static Order retrieve(String id, OrderRetrieveParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(), String.format("/v1/orders/%s", ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Order.class, options);
  }

  /**
   * Updates the specific order by setting the values of the parameters passed. Any parameters not
   * provided will be left unchanged.
   */
  @Override
  public Order update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specific order by setting the values of the parameters passed. Any parameters not
   * provided will be left unchanged.
   */
  @Override
  public Order update(Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/orders/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Order.class, options);
  }

  /**
   * Updates the specific order by setting the values of the parameters passed. Any parameters not
   * provided will be left unchanged.
   */
  public Order update(OrderUpdateParams params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specific order by setting the values of the parameters passed. Any parameters not
   * provided will be left unchanged.
   */
  public Order update(OrderUpdateParams params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/orders/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Order.class, options);
  }

  /** Pay an order by providing a <code>source</code> to create a payment. */
  public Order pay() throws StripeException {
    return pay((Map<String, Object>) null, (RequestOptions) null);
  }

  /** Pay an order by providing a <code>source</code> to create a payment. */
  public Order pay(RequestOptions options) throws StripeException {
    return pay((Map<String, Object>) null, options);
  }

  /** Pay an order by providing a <code>source</code> to create a payment. */
  public Order pay(Map<String, Object> params) throws StripeException {
    return pay(params, (RequestOptions) null);
  }

  /** Pay an order by providing a <code>source</code> to create a payment. */
  public Order pay(Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/orders/%s/pay", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Order.class, options);
  }

  /** Pay an order by providing a <code>source</code> to create a payment. */
  public Order pay(OrderPayParams params) throws StripeException {
    return pay(params, (RequestOptions) null);
  }

  /** Pay an order by providing a <code>source</code> to create a payment. */
  public Order pay(OrderPayParams params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/orders/%s/pay", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Order.class, options);
  }

  /**
   * Return all or part of an order. The order must have a status of <code>paid</code> or <code>
   * fulfilled</code> before it can be returned. Once all items have been returned, the order will
   * become <code>canceled</code> or <code>returned</code> depending on which status the order
   * started in.
   */
  public OrderReturn returnOrder() throws StripeException {
    return returnOrder((Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Return all or part of an order. The order must have a status of <code>paid</code> or <code>
   * fulfilled</code> before it can be returned. Once all items have been returned, the order will
   * become <code>canceled</code> or <code>returned</code> depending on which status the order
   * started in.
   */
  public OrderReturn returnOrder(RequestOptions options) throws StripeException {
    return returnOrder((Map<String, Object>) null, options);
  }

  /**
   * Return all or part of an order. The order must have a status of <code>paid</code> or <code>
   * fulfilled</code> before it can be returned. Once all items have been returned, the order will
   * become <code>canceled</code> or <code>returned</code> depending on which status the order
   * started in.
   */
  public OrderReturn returnOrder(Map<String, Object> params) throws StripeException {
    return returnOrder(params, (RequestOptions) null);
  }

  /**
   * Return all or part of an order. The order must have a status of <code>paid</code> or <code>
   * fulfilled</code> before it can be returned. Once all items have been returned, the order will
   * become <code>canceled</code> or <code>returned</code> depending on which status the order
   * started in.
   */
  public OrderReturn returnOrder(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/orders/%s/returns", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, OrderReturn.class, options);
  }

  /**
   * Return all or part of an order. The order must have a status of <code>paid</code> or <code>
   * fulfilled</code> before it can be returned. Once all items have been returned, the order will
   * become <code>canceled</code> or <code>returned</code> depending on which status the order
   * started in.
   */
  public OrderReturn returnOrder(OrderReturnOrderParams params) throws StripeException {
    return returnOrder(params, (RequestOptions) null);
  }

  /**
   * Return all or part of an order. The order must have a status of <code>paid</code> or <code>
   * fulfilled</code> before it can be returned. Once all items have been returned, the order will
   * become <code>canceled</code> or <code>returned</code> depending on which status the order
   * started in.
   */
  public OrderReturn returnOrder(OrderReturnOrderParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/orders/%s/returns", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, OrderReturn.class, options);
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class ShippingMethod extends StripeObject implements HasId {
    /**
     * A positive integer in the smallest currency unit (that is, 100 cents for $1.00, or 1 for ¥1,
     * Japanese Yen being a zero-decimal currency) representing the total amount for the line item.
     */
    @SerializedName("amount")
    Long amount;

    /**
     * Three-letter <a href="https://www.iso.org/iso-4217-currency-codes.html">ISO currency
     * code</a>, in lowercase. Must be a <a href="https://stripe.com/docs/currencies">supported
     * currency</a>.
     */
    @SerializedName("currency")
    String currency;

    /**
     * The estimated delivery date for the given shipping method. Can be either a specific date or a
     * range.
     */
    @SerializedName("delivery_estimate")
    DeliveryEstimate deliveryEstimate;

    /** An arbitrary string attached to the object. Often useful for displaying to users. */
    @SerializedName("description")
    String description;

    /** Unique identifier for the object. */
    @Getter(onMethod_ = {@Override})
    @SerializedName("id")
    String id;

    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    public static class DeliveryEstimate extends StripeObject {
      /**
       * If {@code type} is {@code "exact"}, {@code date} will be the expected delivery date in the
       * format YYYY-MM-DD.
       */
      @SerializedName("date")
      String date;

      /**
       * If {@code type} is {@code "range"}, {@code earliest} will be be the earliest delivery date
       * in the format YYYY-MM-DD.
       */
      @SerializedName("earliest")
      String earliest;

      /**
       * If {@code type} is {@code "range"}, {@code latest} will be the latest delivery date in the
       * format YYYY-MM-DD.
       */
      @SerializedName("latest")
      String latest;

      /** The type of estimate. Must be either {@code "range"} or {@code "exact"}. */
      @SerializedName("type")
      String type;
    }
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class StatusTransitions extends StripeObject {
    /** The time that the order was canceled. */
    @SerializedName("canceled")
    Long canceled;

    /** The time that the order was fulfilled. */
    @SerializedName("fulfiled")
    Long fulfiled;

    /** The time that the order was paid. */
    @SerializedName("paid")
    Long paid;

    /** The time that the order was returned. */
    @SerializedName("returned")
    Long returned;
  }
}
