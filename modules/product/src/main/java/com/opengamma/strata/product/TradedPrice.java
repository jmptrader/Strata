/*
 * Copyright (C) 2018 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.time.LocalDate;

import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.TypedMetaBean;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

/**
 * The traded price of a security-based trade.
 * <p>
 * When a trade in a security occurs there is an agreed price and trade date.
 * This class combines these two pieces of information.
 * <p>
 * Once the trade has occurred, end of day processing typically aggregates the trades into positions.
 * As a position combines multiple trades at different prices, the information in this class does not apply.
 * 
 * <h4>Price</h4>
 * Strata uses <i>decimal prices</i> in the trade model, pricers and market data.
 * See the individual security types for more details.
 */
@BeanDefinition(style = "light")
public final class TradedPrice
    implements ImmutableBean, Serializable {

  /**
   * The trade date.
   * <p>
   * The date that the trade occurred.
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate tradeDate;
  /**
   * The price at which the trade was agreed.
   * <p>
   * See the security type for more details on the meaning of the price.
   */
  @PropertyDefinition
  private final double price;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from the trade date and price.
   * 
   * @param tradeDate  the trade date
   * @param price  the price at which the trade was agreed
   * @return the settlement information
   */
  public static TradedPrice of(LocalDate tradeDate, double price) {
    return new TradedPrice(tradeDate, price);
  }

  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code TradedPrice}.
   */
  private static final TypedMetaBean<TradedPrice> META_BEAN =
      LightMetaBean.of(
          TradedPrice.class,
          MethodHandles.lookup(),
          new String[] {
              "tradeDate",
              "price"},
          new Object[0]);

  /**
   * The meta-bean for {@code TradedPrice}.
   * @return the meta-bean, not null
   */
  public static TypedMetaBean<TradedPrice> meta() {
    return META_BEAN;
  }

  static {
    MetaBean.register(META_BEAN);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private TradedPrice(
      LocalDate tradeDate,
      double price) {
    JodaBeanUtils.notNull(tradeDate, "tradeDate");
    this.tradeDate = tradeDate;
    this.price = price;
  }

  @Override
  public TypedMetaBean<TradedPrice> metaBean() {
    return META_BEAN;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the trade date.
   * <p>
   * The date that the trade occurred.
   * @return the value of the property, not null
   */
  public LocalDate getTradeDate() {
    return tradeDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the price at which the trade was agreed.
   * <p>
   * See the security type for more details on the meaning of the price.
   * @return the value of the property
   */
  public double getPrice() {
    return price;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      TradedPrice other = (TradedPrice) obj;
      return JodaBeanUtils.equal(tradeDate, other.tradeDate) &&
          JodaBeanUtils.equal(price, other.price);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(tradeDate);
    hash = hash * 31 + JodaBeanUtils.hashCode(price);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("TradedPrice{");
    buf.append("tradeDate").append('=').append(JodaBeanUtils.toString(tradeDate)).append(',').append(' ');
    buf.append("price").append('=').append(JodaBeanUtils.toString(price));
    buf.append('}');
    return buf.toString();
  }

  //-------------------------- AUTOGENERATED END --------------------------
}