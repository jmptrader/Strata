/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutablePreBuild;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.analytics.financial.model.volatility.surface.StrikeType;
import com.opengamma.strata.basics.currency.CurrencyPair;
import com.opengamma.strata.collect.tuple.Pair;

/**
 * Surface node metadata for a surface node with a specific time to expiry and strike.
 */
@BeanDefinition(builderScope = "private")
public final class FxVolatilitySurfaceYearFractionNodeMetadata
    implements SurfaceParameterMetadata, ImmutableBean, Serializable {

  /**
   * The year fraction and strike of the surface node.
   * <p>
   * This is the time to expiry and strike that the node on the surface is defined as.
   * There is not necessarily a direct relationship with a date from an underlying instrument.
   */
  @PropertyDefinition(validate = "notNull", get = "private")
  private final Pair<Double, StrikeType> yearFractionAndStrike;

  @PropertyDefinition(validate = "notEmpty", overrideGet = true)
  private final String label;

  @PropertyDefinition(validate = "notNull")
  private final CurrencyPair currencyPair;

  //-------------------------------------------------------------------------
  /**
   * Creates node metadata using year fraction, strike and currency pair. 
   * 
   * @param yearFraction  the year fraction
   * @param strike  the strike
   * @param currencyPair  the currency pair
   * @return node metadata 
   */
  public static FxVolatilitySurfaceYearFractionNodeMetadata of(
      double yearFraction,
      StrikeType strike,
      CurrencyPair currencyPair) {
    Pair<Double, StrikeType> expiryAndStrike = Pair.of(yearFraction, strike);
    String label = Pair.of(yearFraction, strike.typeAndValue()).toString();
    return new FxVolatilitySurfaceYearFractionNodeMetadata(expiryAndStrike, label, currencyPair);
  }

  /**
   * Creates node using a pair (year fraction and strike), label and currency pair.  
   * 
   * @param expiryAndStrike  the pair of year fraction and strike 
   * @param label  the label to use
   * @param currencyPair  the currency pair
   * @return the metadata
   */
  public static FxVolatilitySurfaceYearFractionNodeMetadata of(
      Pair<Double, StrikeType> expiryAndStrike,
      String label,
      CurrencyPair currencyPair) {
    return new FxVolatilitySurfaceYearFractionNodeMetadata(expiryAndStrike, label, currencyPair);
  }

  @ImmutablePreBuild
  private static void preBuild(Builder builder) {
    if (builder.label == null && builder.yearFractionAndStrike != null) {
      builder.label = Pair.of(builder.yearFractionAndStrike.getFirst(),
          builder.yearFractionAndStrike.getSecond().typeAndValue())
          .toString();
    }
  }

  @Override
  public Pair<Double, StrikeType> getIdentifier() {
    return getYearFractionAndStrike();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code FxVolatilitySurfaceYearFractionNodeMetadata}.
   * @return the meta-bean, not null
   */
  public static FxVolatilitySurfaceYearFractionNodeMetadata.Meta meta() {
    return FxVolatilitySurfaceYearFractionNodeMetadata.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(FxVolatilitySurfaceYearFractionNodeMetadata.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private FxVolatilitySurfaceYearFractionNodeMetadata(
      Pair<Double, StrikeType> yearFractionAndStrike,
      String label,
      CurrencyPair currencyPair) {
    JodaBeanUtils.notNull(yearFractionAndStrike, "yearFractionAndStrike");
    JodaBeanUtils.notEmpty(label, "label");
    JodaBeanUtils.notNull(currencyPair, "currencyPair");
    this.yearFractionAndStrike = yearFractionAndStrike;
    this.label = label;
    this.currencyPair = currencyPair;
  }

  @Override
  public FxVolatilitySurfaceYearFractionNodeMetadata.Meta metaBean() {
    return FxVolatilitySurfaceYearFractionNodeMetadata.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the year fraction and strike of the surface node.
   * <p>
   * This is the time to expiry and strike that the node on the surface is defined as.
   * There is not necessarily a direct relationship with a date from an underlying instrument.
   * @return the value of the property, not null
   */
  private Pair<Double, StrikeType> getYearFractionAndStrike() {
    return yearFractionAndStrike;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the label.
   * @return the value of the property, not empty
   */
  @Override
  public String getLabel() {
    return label;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currencyPair.
   * @return the value of the property, not null
   */
  public CurrencyPair getCurrencyPair() {
    return currencyPair;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      FxVolatilitySurfaceYearFractionNodeMetadata other = (FxVolatilitySurfaceYearFractionNodeMetadata) obj;
      return JodaBeanUtils.equal(getYearFractionAndStrike(), other.getYearFractionAndStrike()) &&
          JodaBeanUtils.equal(getLabel(), other.getLabel()) &&
          JodaBeanUtils.equal(getCurrencyPair(), other.getCurrencyPair());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getYearFractionAndStrike());
    hash = hash * 31 + JodaBeanUtils.hashCode(getLabel());
    hash = hash * 31 + JodaBeanUtils.hashCode(getCurrencyPair());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("FxVolatilitySurfaceYearFractionNodeMetadata{");
    buf.append("yearFractionAndStrike").append('=').append(getYearFractionAndStrike()).append(',').append(' ');
    buf.append("label").append('=').append(getLabel()).append(',').append(' ');
    buf.append("currencyPair").append('=').append(JodaBeanUtils.toString(getCurrencyPair()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code FxVolatilitySurfaceYearFractionNodeMetadata}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code yearFractionAndStrike} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<Pair<Double, StrikeType>> yearFractionAndStrike = DirectMetaProperty.ofImmutable(
        this, "yearFractionAndStrike", FxVolatilitySurfaceYearFractionNodeMetadata.class, (Class) Pair.class);
    /**
     * The meta-property for the {@code label} property.
     */
    private final MetaProperty<String> label = DirectMetaProperty.ofImmutable(
        this, "label", FxVolatilitySurfaceYearFractionNodeMetadata.class, String.class);
    /**
     * The meta-property for the {@code currencyPair} property.
     */
    private final MetaProperty<CurrencyPair> currencyPair = DirectMetaProperty.ofImmutable(
        this, "currencyPair", FxVolatilitySurfaceYearFractionNodeMetadata.class, CurrencyPair.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "yearFractionAndStrike",
        "label",
        "currencyPair");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -63315510:  // yearFractionAndStrike
          return yearFractionAndStrike;
        case 102727412:  // label
          return label;
        case 1005147787:  // currencyPair
          return currencyPair;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends FxVolatilitySurfaceYearFractionNodeMetadata> builder() {
      return new FxVolatilitySurfaceYearFractionNodeMetadata.Builder();
    }

    @Override
    public Class<? extends FxVolatilitySurfaceYearFractionNodeMetadata> beanType() {
      return FxVolatilitySurfaceYearFractionNodeMetadata.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code yearFractionAndStrike} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Pair<Double, StrikeType>> yearFractionAndStrike() {
      return yearFractionAndStrike;
    }

    /**
     * The meta-property for the {@code label} property.
     * @return the meta-property, not null
     */
    public MetaProperty<String> label() {
      return label;
    }

    /**
     * The meta-property for the {@code currencyPair} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurrencyPair> currencyPair() {
      return currencyPair;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -63315510:  // yearFractionAndStrike
          return ((FxVolatilitySurfaceYearFractionNodeMetadata) bean).getYearFractionAndStrike();
        case 102727412:  // label
          return ((FxVolatilitySurfaceYearFractionNodeMetadata) bean).getLabel();
        case 1005147787:  // currencyPair
          return ((FxVolatilitySurfaceYearFractionNodeMetadata) bean).getCurrencyPair();
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
   * The bean-builder for {@code FxVolatilitySurfaceYearFractionNodeMetadata}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<FxVolatilitySurfaceYearFractionNodeMetadata> {

    private Pair<Double, StrikeType> yearFractionAndStrike;
    private String label;
    private CurrencyPair currencyPair;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -63315510:  // yearFractionAndStrike
          return yearFractionAndStrike;
        case 102727412:  // label
          return label;
        case 1005147787:  // currencyPair
          return currencyPair;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -63315510:  // yearFractionAndStrike
          this.yearFractionAndStrike = (Pair<Double, StrikeType>) newValue;
          break;
        case 102727412:  // label
          this.label = (String) newValue;
          break;
        case 1005147787:  // currencyPair
          this.currencyPair = (CurrencyPair) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public FxVolatilitySurfaceYearFractionNodeMetadata build() {
      preBuild(this);
      return new FxVolatilitySurfaceYearFractionNodeMetadata(
          yearFractionAndStrike,
          label,
          currencyPair);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("FxVolatilitySurfaceYearFractionNodeMetadata.Builder{");
      buf.append("yearFractionAndStrike").append('=').append(JodaBeanUtils.toString(yearFractionAndStrike)).append(',').append(' ');
      buf.append("label").append('=').append(JodaBeanUtils.toString(label)).append(',').append(' ');
      buf.append("currencyPair").append('=').append(JodaBeanUtils.toString(currencyPair));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}