// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.List;

public class InvoiceFinalizeInvoiceParams extends ApiRequestParams {
  /**
   * Controls whether Stripe will perform [automatic
   * collection](https://stripe.com/docs/billing/invoices/workflow/#auto_advance) of the invoice.
   * When `false`, the invoice's state will not automatically advance without an explicit action.
   */
  @SerializedName("auto_advance")
  Boolean autoAdvance;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  private InvoiceFinalizeInvoiceParams(Boolean autoAdvance, List<String> expand) {
    this.autoAdvance = autoAdvance;
    this.expand = expand;
  }

  public static Builder builder() {
    return new com.stripe.param.InvoiceFinalizeInvoiceParams.Builder();
  }

  public static class Builder {
    private Boolean autoAdvance;

    private List<String> expand;

    /** Finalize and obtain parameter instance from this builder. */
    public InvoiceFinalizeInvoiceParams build() {
      return new InvoiceFinalizeInvoiceParams(this.autoAdvance, this.expand);
    }

    /**
     * Controls whether Stripe will perform [automatic
     * collection](https://stripe.com/docs/billing/invoices/workflow/#auto_advance) of the invoice.
     * When `false`, the invoice's state will not automatically advance without an explicit action.
     */
    public Builder setAutoAdvance(Boolean autoAdvance) {
      this.autoAdvance = autoAdvance;
      return this;
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * InvoiceFinalizeInvoiceParams#expand} for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /**
     * Add all elements to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * InvoiceFinalizeInvoiceParams#expand} for the field documentation.
     */
    public Builder addAllExpand(List<String> elements) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.addAll(elements);
      return this;
    }
  }
}