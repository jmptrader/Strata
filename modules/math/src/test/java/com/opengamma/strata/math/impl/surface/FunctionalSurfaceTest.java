/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.surface;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import com.opengamma.strata.collect.tuple.Pair;
import com.opengamma.strata.math.impl.function.Function2D;

/**
 * 
 */
public class FunctionalSurfaceTest {
  private static final Function2D<Double, Double> s_func = new Function2D<Double, Double>() {

    @Override
    public Double evaluate(Double x1, Double x2) {
      return x1 * x2;
    }
  };
  private static final FunctionalSurface<Double, Double> s_surface = new FunctionalSurface<>(s_func);

  @Test
  public void test() {
    double x = 2.1;
    double y = -6.7;
    assertEquals(x * y, s_surface.getZValue(x, y), 1e-15);
    assertEquals(x * y, s_surface.getZValue(Pair.of(x, y)), 1e-15);
  }

  @Test(expectedExceptions = UnsupportedOperationException.class)
  public void noXDataTest() {
    s_surface.getXData();
  }

  @Test(expectedExceptions = UnsupportedOperationException.class)
  public void noYDataTest() {
    s_surface.getYData();
  }

  @Test(expectedExceptions = UnsupportedOperationException.class)
  public void noZDataTest() {
    s_surface.getZData();
  }

  @Test(expectedExceptions = UnsupportedOperationException.class)
  public void noSizeTest() {
    s_surface.size();
  }

}
