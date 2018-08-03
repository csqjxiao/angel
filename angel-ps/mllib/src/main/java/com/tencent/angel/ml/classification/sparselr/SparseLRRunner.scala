/*
 * Tencent is pleased to support the open source community by making Angel available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in 
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package com.tencent.angel.ml.classification.sparselr

import com.tencent.angel.ml.MLRunner
import com.tencent.angel.ml.conf.MLConf
import org.apache.hadoop.conf.Configuration


class SparseLRRunner extends MLRunner {
  /**
    * Training job to obtain a model
    */
  override
  def train(conf: Configuration): Unit = {
    conf.setBoolean(MLConf.ML_DATA_IS_NEGY, false)
    train(conf, new SparseLRModel(conf), classOf[SparseLRTrainTask])
  }

  /**
    * Incremental training job to obtain a model based on a trained model
    */
  override def incTrain(conf: Configuration): Unit = ???

  /**
    * Using a model to predict with unobserved samples
    */
  override def predict(conf: Configuration): Unit = {
    conf.setBoolean(MLConf.ML_DATA_IS_NEGY, false)
    predict(conf, new SparseLRModel(conf), classOf[SparseLRPredictTask])
  }
}
