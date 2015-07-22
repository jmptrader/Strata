/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.curve;

import org.joda.convert.FromString;

import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.collect.named.Named;
import com.opengamma.strata.math.impl.function.Function;

/**
 * Given an array of curves, returns a function {@link Function} that will apply a spread operation to
 * each of the curves.
 */
public interface CurveSpreadFunction
    extends Function<DoublesCurve, Function<Double, Double>>, Named {

  /**
   * Obtains a {@code CurveSpreadFunction} from a unique name.
   * 
   * @param uniqueName  the unique name
   * @return the function
   * @throws IllegalArgumentException if the name is not known
   */
  @FromString
  public static CurveSpreadFunction of(String uniqueName) {
    ArgChecker.notNull(uniqueName, "uniqueName");
    switch (uniqueName) {
      case AddCurveSpreadFunction.NAME:
        return AddCurveSpreadFunction.INSTANCE;
      case SubtractCurveSpreadFunction.NAME:
        return SubtractCurveSpreadFunction.INSTANCE;
      case MultiplyCurveSpreadFunction.NAME:
        return MultiplyCurveSpreadFunction.INSTANCE;
      case DivideCurveSpreadFunction.NAME:
        return DivideCurveSpreadFunction.INSTANCE;
      default:
        throw new IllegalArgumentException("Unknown curve spread function: " + uniqueName);
    }
  }

}
