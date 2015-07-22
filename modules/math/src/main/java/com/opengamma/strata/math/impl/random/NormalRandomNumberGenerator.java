/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.random;

import java.util.ArrayList;
import java.util.List;

import cern.jet.random.engine.RandomEngine;

import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.math.impl.statistics.distribution.NormalDistribution;
import com.opengamma.strata.math.impl.statistics.distribution.ProbabilityDistribution;

/**
 * Random number generator based on {@code ProbabilityDistribution}. 
 */
public class NormalRandomNumberGenerator implements RandomNumberGenerator {

  /**
   * The underlying distribution.
   */
  private final ProbabilityDistribution<Double> _normal;

  /**
   * Creates an instance.
   * 
   * @param mean  the mean
   * @param sigma  the sigma
   */
  public NormalRandomNumberGenerator(double mean, double sigma) {
    ArgChecker.notNegativeOrZero(sigma, "standard deviation");
    _normal = new NormalDistribution(mean, sigma);
  }

  /**
   * Creates an instance.
   * 
   * @param mean  the mean
   * @param sigma  the sigma
   * @param engine  the random number engine
   */
  public NormalRandomNumberGenerator(double mean, double sigma, RandomEngine engine) {
    ArgChecker.notNegativeOrZero(sigma, "standard deviation");
    ArgChecker.notNull(engine, "engine");
    _normal = new NormalDistribution(mean, sigma, engine);
  }

  //-------------------------------------------------------------------------
  @Override
  public double[] getVector(int dimension) {
    ArgChecker.notNegative(dimension, "dimension");
    double[] result = new double[dimension];
    for (int i = 0; i < dimension; i++) {
      result[i] = _normal.nextRandom();
    }
    return result;
  }

  @Override
  public List<double[]> getVectors(int dimension, int n) {
    if (dimension < 0) {
      throw new IllegalArgumentException("Dimension must be greater than zero");
    }
    if (n < 0) {
      throw new IllegalArgumentException("Number of values must be greater than zero");
    }
    List<double[]> result = new ArrayList<>(n);
    double[] x;
    for (int i = 0; i < n; i++) {
      x = new double[dimension];
      for (int j = 0; j < dimension; j++) {
        x[j] = _normal.nextRandom();
      }
      result.add(x);
    }
    return result;
  }

}
