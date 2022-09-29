/*
 * Copyright (C) 2019 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.basics.date;

import java.io.Serializable;
import java.time.LocalDate;
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

/**
 * A holiday calendar implementation that links two other calendars.
 * <p>
 * This immutable implementation of {@link HolidayCalendar} stores two underlying calendars.
 * A date is a holiday if both calendars defines it as a holiday.
 */
@BeanDefinition(builderScope = "private", constructorScope = "package")
final class LinkedHolidayCalendar
    implements HolidayCalendar, ImmutableBean, Serializable {

  /**
   * The first underlying calendar.
   */
  @PropertyDefinition(validate = "notNull")
  private final HolidayCalendar calendar1;
  /**
   * The second underlying calendar.
   */
  @PropertyDefinition(validate = "notNull")
  private final HolidayCalendar calendar2;

  //-------------------------------------------------------------------------
  @Override
  public HolidayCalendarId getId() {
    return calendar1.getId().linkedWith(calendar2.getId());
  }

  @Override
  public boolean isHoliday(LocalDate date) {
    return calendar1.isHoliday(date) && calendar2.isHoliday(date);
  }

  @Override
  public String toString() {
    return "HolidayCalendar[" + getName() + ']';
  }

  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code LinkedHolidayCalendar}.
   * @return the meta-bean, not null
   */
  public static LinkedHolidayCalendar.Meta meta() {
    return LinkedHolidayCalendar.Meta.INSTANCE;
  }

  static {
    MetaBean.register(LinkedHolidayCalendar.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Creates an instance.
   * @param calendar1  the value of the property, not null
   * @param calendar2  the value of the property, not null
   */
  LinkedHolidayCalendar(
      HolidayCalendar calendar1,
      HolidayCalendar calendar2) {
    JodaBeanUtils.notNull(calendar1, "calendar1");
    JodaBeanUtils.notNull(calendar2, "calendar2");
    this.calendar1 = calendar1;
    this.calendar2 = calendar2;
  }

  @Override
  public LinkedHolidayCalendar.Meta metaBean() {
    return LinkedHolidayCalendar.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the first underlying calendar.
   * @return the value of the property, not null
   */
  public HolidayCalendar getCalendar1() {
    return calendar1;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the second underlying calendar.
   * @return the value of the property, not null
   */
  public HolidayCalendar getCalendar2() {
    return calendar2;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      LinkedHolidayCalendar other = (LinkedHolidayCalendar) obj;
      return JodaBeanUtils.equal(calendar1, other.calendar1) &&
          JodaBeanUtils.equal(calendar2, other.calendar2);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(calendar1);
    hash = hash * 31 + JodaBeanUtils.hashCode(calendar2);
    return hash;
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code LinkedHolidayCalendar}.
   */
  static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code calendar1} property.
     */
    private final MetaProperty<HolidayCalendar> calendar1 = DirectMetaProperty.ofImmutable(
        this, "calendar1", LinkedHolidayCalendar.class, HolidayCalendar.class);
    /**
     * The meta-property for the {@code calendar2} property.
     */
    private final MetaProperty<HolidayCalendar> calendar2 = DirectMetaProperty.ofImmutable(
        this, "calendar2", LinkedHolidayCalendar.class, HolidayCalendar.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "calendar1",
        "calendar2");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1233097549:  // calendar1
          return calendar1;
        case -1233097548:  // calendar2
          return calendar2;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends LinkedHolidayCalendar> builder() {
      return new LinkedHolidayCalendar.Builder();
    }

    @Override
    public Class<? extends LinkedHolidayCalendar> beanType() {
      return LinkedHolidayCalendar.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code calendar1} property.
     * @return the meta-property, not null
     */
    public MetaProperty<HolidayCalendar> calendar1() {
      return calendar1;
    }

    /**
     * The meta-property for the {@code calendar2} property.
     * @return the meta-property, not null
     */
    public MetaProperty<HolidayCalendar> calendar2() {
      return calendar2;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1233097549:  // calendar1
          return ((LinkedHolidayCalendar) bean).getCalendar1();
        case -1233097548:  // calendar2
          return ((LinkedHolidayCalendar) bean).getCalendar2();
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
   * The bean-builder for {@code LinkedHolidayCalendar}.
   */
  private static final class Builder extends DirectPrivateBeanBuilder<LinkedHolidayCalendar> {

    private HolidayCalendar calendar1;
    private HolidayCalendar calendar2;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1233097549:  // calendar1
          return calendar1;
        case -1233097548:  // calendar2
          return calendar2;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -1233097549:  // calendar1
          this.calendar1 = (HolidayCalendar) newValue;
          break;
        case -1233097548:  // calendar2
          this.calendar2 = (HolidayCalendar) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public LinkedHolidayCalendar build() {
      return new LinkedHolidayCalendar(
          calendar1,
          calendar2);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("LinkedHolidayCalendar.Builder{");
      buf.append("calendar1").append('=').append(JodaBeanUtils.toString(calendar1)).append(',').append(' ');
      buf.append("calendar2").append('=').append(JodaBeanUtils.toString(calendar2));
      buf.append('}');
      return buf.toString();
    }

  }

  //-------------------------- AUTOGENERATED END --------------------------
}
