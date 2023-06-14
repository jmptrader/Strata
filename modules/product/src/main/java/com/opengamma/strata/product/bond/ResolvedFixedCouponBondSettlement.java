/*
 * Copyright (C) 2018 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.bond;

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

import com.opengamma.strata.collect.ArgChecker;

/**
 * The settlement details of a fixed coupon bond trade.
 * <p>
 * When a trade in a fixed coupon bond occurs there is an agreed settlement process.
 * This class captures details of that process for the purpose of pricing.
 * <p>
 * Once the trade has settled, end of day processing typically aggregates the trades into positions.
 * As a position combines multiple trades at different prices, the information in this class does not apply.
 * 
 * <h4>Price</h4>
 * Strata uses <i>decimal prices</i> for bonds in the trade model, pricers and market data.
 * For example, a price of 99.32% is represented in Strata by 0.9932.
 */
@BeanDefinition(style = "light")
public final class ResolvedFixedCouponBondSettlement
    implements ImmutableBean, Serializable {

  /**
   * The settlement date.
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate settlementDate;
  /**
   * The <i>clean</i> price at which the bond was traded.
   * <p>
   * The "clean" price excludes any accrued interest.
   * <p>
   * Strata uses <i>decimal prices</i> for bonds in the trade model, pricers and market data.
   * For example, a price of 99.32% is represented in Strata by 0.9932.
   */
  @PropertyDefinition(validate = "ArgChecker.notNegative")
  private final double price;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from the settlement date and price.
   * 
   * @param settlementDate  the settlement date
   * @param price  the price at which the trade was agreed
   * @return the settlement information
   */
  public static ResolvedFixedCouponBondSettlement of(LocalDate settlementDate, double price) {
    return new ResolvedFixedCouponBondSettlement(settlementDate, price);
  }

  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code ResolvedFixedCouponBondSettlement}.
   */
  private static final TypedMetaBean<ResolvedFixedCouponBondSettlement> META_BEAN =
      LightMetaBean.of(
          ResolvedFixedCouponBondSettlement.class,
          MethodHandles.lookup(),
          new String[] {
              "settlementDate",
              "price"},
          new Object[0]);

  /**
   * The meta-bean for {@code ResolvedFixedCouponBondSettlement}.
   * @return the meta-bean, not null
   */
  public static TypedMetaBean<ResolvedFixedCouponBondSettlement> meta() {
    return META_BEAN;
  }

  static {
    MetaBean.register(META_BEAN);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private ResolvedFixedCouponBondSettlement(
      LocalDate settlementDate,
      double price) {
    JodaBeanUtils.notNull(settlementDate, "settlementDate");
    ArgChecker.notNegative(price, "price");
    this.settlementDate = settlementDate;
    this.price = price;
  }

  @Override
  public TypedMetaBean<ResolvedFixedCouponBondSettlement> metaBean() {
    return META_BEAN;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the settlement date.
   * @return the value of the property, not null
   */
  public LocalDate getSettlementDate() {
    return settlementDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the <i>clean</i> price at which the bond was traded.
   * <p>
   * The "clean" price excludes any accrued interest.
   * <p>
   * Strata uses <i>decimal prices</i> for bonds in the trade model, pricers and market data.
   * For example, a price of 99.32% is represented in Strata by 0.9932.
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
      ResolvedFixedCouponBondSettlement other = (ResolvedFixedCouponBondSettlement) obj;
      return JodaBeanUtils.equal(settlementDate, other.settlementDate) &&
          JodaBeanUtils.equal(price, other.price);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(settlementDate);
    hash = hash * 31 + JodaBeanUtils.hashCode(price);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("ResolvedFixedCouponBondSettlement{");
    buf.append("settlementDate").append('=').append(JodaBeanUtils.toString(settlementDate)).append(',').append(' ');
    buf.append("price").append('=').append(JodaBeanUtils.toString(price));
    buf.append('}');
    return buf.toString();
  }

  //-------------------------- AUTOGENERATED END --------------------------
}