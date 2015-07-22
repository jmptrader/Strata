/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.random;

import java.util.List;

/**
 * Generator of random numbers.
 */
public interface RandomNumberGenerator {

  double[] getVector(int dimension);

  List<double[]> getVectors(int dimension, int n);

}
