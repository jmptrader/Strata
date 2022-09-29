/*
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.credit;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.impl.direct.DirectPrivateBeanBuilder;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.product.PortfolioItemInfo;
import com.opengamma.strata.product.PortfolioItemSummary;
import com.opengamma.strata.product.ProductType;
import com.opengamma.strata.product.Trade;
import com.opengamma.strata.product.TradeInfo;
import com.opengamma.strata.product.common.SummarizerUtils;

/**
 * A trade in a CDS index used for credit curve calibration. 
 * <p>
 * The CDS index trade and market quote are stored in this class.
 * {@link CdsIndexTrade} and {@code ResolvedCdsIndexTrade} should be used for pricing.
 */
@BeanDefinition(builderScope = "private")
public final class CdsIndexCalibrationTrade
    implements Trade, ImmutableBean, Serializable {

  /**
   * The underlying CDS index trade.
   */
  @PropertyDefinition(validate = "notNull")
  private final CdsIndexTrade underlyingTrade;
  /**
   * The CDS index quote.
   */
  @PropertyDefinition(validate = "notNull")
  private final CdsQuote quote;

  //-------------------------------------------------------------------------
  /**
   * Creates an instance.
   * 
   * @param trade  the trade
   * @param quote  the quote
   * @return the instance
   */
  public static CdsIndexCalibrationTrade of(CdsIndexTrade trade, CdsQuote quote) {
    return new CdsIndexCalibrationTrade(trade, quote);
  }

  @Override
  public TradeInfo getInfo() {
    return underlyingTrade.getInfo();
  }

  @Override
  public CdsIndexCalibrationTrade withInfo(PortfolioItemInfo info) {
    return new CdsIndexCalibrationTrade(underlyingTrade.withInfo(info), quote);
  }

  @Override
  public PortfolioItemSummary summarize() {
    String description = "CDS Index calibration trade";
    Currency currency = underlyingTrade.getProduct().getCurrency();
    return SummarizerUtils.summary(this, ProductType.CALIBRATION, description, currency);
  }

  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code CdsIndexCalibrationTrade}.
   * @return the meta-bean, not null
   */
  public static CdsIndexCalibrationTrade.Meta meta() {
    return CdsIndexCalibrationTrade.Meta.INSTANCE;
  }

  static {
    MetaBean.register(CdsIndexCalibrationTrade.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private CdsIndexCalibrationTrade(
      CdsIndexTrade underlyingTrade,
      CdsQuote quote) {
    JodaBeanUtils.notNull(underlyingTrade, "underlyingTrade");
    JodaBeanUtils.notNull(quote, "quote");
    this.underlyingTrade = underlyingTrade;
    this.quote = quote;
  }

  @Override
  public CdsIndexCalibrationTrade.Meta metaBean() {
    return CdsIndexCalibrationTrade.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying CDS index trade.
   * @return the value of the property, not null
   */
  public CdsIndexTrade getUnderlyingTrade() {
    return underlyingTrade;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the CDS index quote.
   * @return the value of the property, not null
   */
  public CdsQuote getQuote() {
    return quote;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CdsIndexCalibrationTrade other = (CdsIndexCalibrationTrade) obj;
      return JodaBeanUtils.equal(underlyingTrade, other.underlyingTrade) &&
          JodaBeanUtils.equal(quote, other.quote);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(underlyingTrade);
    hash = hash * 31 + JodaBeanUtils.hashCode(quote);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("CdsIndexCalibrationTrade{");
    buf.append("underlyingTrade").append('=').append(JodaBeanUtils.toString(underlyingTrade)).append(',').append(' ');
    buf.append("quote").append('=').append(JodaBeanUtils.toString(quote));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CdsIndexCalibrationTrade}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code underlyingTrade} property.
     */
    private final MetaProperty<CdsIndexTrade> underlyingTrade = DirectMetaProperty.ofImmutable(
        this, "underlyingTrade", CdsIndexCalibrationTrade.class, CdsIndexTrade.class);
    /**
     * The meta-property for the {@code quote} property.
     */
    private final MetaProperty<CdsQuote> quote = DirectMetaProperty.ofImmutable(
        this, "quote", CdsIndexCalibrationTrade.class, CdsQuote.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "underlyingTrade",
        "quote");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -823800825:  // underlyingTrade
          return underlyingTrade;
        case 107953788:  // quote
          return quote;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends CdsIndexCalibrationTrade> builder() {
      return new CdsIndexCalibrationTrade.Builder();
    }

    @Override
    public Class<? extends CdsIndexCalibrationTrade> beanType() {
      return CdsIndexCalibrationTrade.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code underlyingTrade} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CdsIndexTrade> underlyingTrade() {
      return underlyingTrade;
    }

    /**
     * The meta-property for the {@code quote} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CdsQuote> quote() {
      return quote;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -823800825:  // underlyingTrade
          return ((CdsIndexCalibrationTrade) bean).getUnderlyingTrade();
        case 107953788:  // quote
          return ((CdsIndexCalibrationTrade) bean).getQuote();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CdsIndexCalibrationTrade}.
   */
  private static final class Builder extends DirectPrivateBeanBuilder<CdsIndexCalibrationTrade> {

    private CdsIndexTrade underlyingTrade;
    private CdsQuote quote;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -823800825:  // underlyingTrade
          return underlyingTrade;
        case 107953788:  // quote
          return quote;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -823800825:  // underlyingTrade
          this.underlyingTrade = (CdsIndexTrade) newValue;
          break;
        case 107953788:  // quote
          this.quote = (CdsQuote) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public CdsIndexCalibrationTrade build() {
      return new CdsIndexCalibrationTrade(
          underlyingTrade,
          quote);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("CdsIndexCalibrationTrade.Builder{");
      buf.append("underlyingTrade").append('=').append(JodaBeanUtils.toString(underlyingTrade)).append(',').append(' ');
      buf.append("quote").append('=').append(JodaBeanUtils.toString(quote));
      buf.append('}');
      return buf.toString();
    }

  }

  //-------------------------- AUTOGENERATED END --------------------------

}
